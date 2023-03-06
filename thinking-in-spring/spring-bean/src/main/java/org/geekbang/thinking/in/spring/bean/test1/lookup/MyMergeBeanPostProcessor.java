package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.geekbang.thinking.in.spring.bean.test1.annotation.MysqlResource;
import org.springframework.aop.TargetSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

@Component
public class MyMergeBeanPostProcessor implements MergedBeanDefinitionPostProcessor, SmartInstantiationAwareBeanPostProcessor, PriorityOrdered, ApplicationContextAware {


    private ApplicationContext applicationContext;
    private JdbcTemplate jdbcTemplate;

    private final Map<String, List<MysqlResourceElement>> currElements = new HashMap<>();

    private final Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(4);

    public MyMergeBeanPostProcessor() {
        autowiredAnnotationTypes.add(MysqlResource.class);
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        print(beanName);
        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        print(beanName);

        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        print(beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }

    /**
     * 解析 @MysqlResource
     */
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        print(beanName);
        List<MysqlResourceElement> elements = new ArrayList<>();

        do {
            ReflectionUtils.doWithLocalFields(beanType, field -> {
                MergedAnnotation<?> ann = findAutowiredAnnotation(field);
                if (ann != null) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        return;
                    }
                    AnnotationAttributes annotationAttributes = ann.asMap(mergedAnnotation -> new AnnotationAttributes(mergedAnnotation.getType()));

                    String tableName = annotationAttributes.getString("tableName");
                    String[] ids = annotationAttributes.getStringArray("ids");

                    elements.add(new MysqlResourceElement(field, tableName, new ArrayList<>(Arrays.asList(ids)),jdbcTemplate));
                }
            });
            beanType = beanType.getSuperclass();
        }
        while (beanType != null && beanType != Object.class);
        if (elements.size() > 0) {
            currElements.put(beanName, elements);
        }
    }



    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        print(beanName);
        //注入mysql数据
        if (currElements.containsKey(beanName)) {
            List<MysqlResourceElement> injectedElements = currElements.get(beanName);
            injectedElements.forEach(item -> {
                try {
                     item.inject(bean,beanName,pvs);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    private MergedAnnotation<?> findAutowiredAnnotation(AccessibleObject ao) {
        MergedAnnotations annotations = MergedAnnotations.from(ao);
        for (Class<? extends Annotation> type : this.autowiredAnnotationTypes) {
            MergedAnnotation<?> annotation = annotations.get(type);
            if (annotation.isPresent()) {
                return annotation;
            }
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        print(beanName);
        return MergedBeanDefinitionPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        print(beanName);
        return MergedBeanDefinitionPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        print(beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        print(beanName);
        return true;
    }


    public static void print(String beanName, int level) {
        if (Objects.equals(beanName, "lookUpBean") || Objects.equals(beanName, "")) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[level];
            System.out.println(stackTraceElement.getMethodName());
        }
    }

    public static void print(String beanName) {
        print(beanName, 3);
    }

    public static void print() {
        print("", 3);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
    }
}
