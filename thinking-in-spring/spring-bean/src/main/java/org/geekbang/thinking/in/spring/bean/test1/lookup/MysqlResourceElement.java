package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.geekbang.thinking.in.spring.bean.test1.annotation.TableName;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.context.ApplicationContextException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class MysqlResourceElement extends InjectionMetadata.InjectedElement {

    private JdbcTemplate jdbcTemplate;
    private String tableName;
    private List<String> ids;
    private Field field;
    private String idsStr;

    public MysqlResourceElement(Field field, String tableName, List<String> ids,JdbcTemplate jdbcTemplate) {
        super(field, null);
        if(jdbcTemplate==null){
            throw new ApplicationContextException("jdbcTemplate is not null");
        }
        this.ids = ids;
        this.tableName = tableName;
        this.field = field;
        this.jdbcTemplate = jdbcTemplate;
        StringJoiner stringJoiner = new StringJoiner(",");
        ids.forEach(stringJoiner::add);
        idsStr = stringJoiner.toString();
    }


    @Override
    protected Object getResourceToInject(Object target, String requestingBeanName) {
        Class<?> type = getType();
        List<?> objects = jdbcTemplate.query(getSql(), new BeanPropertyRowMapper<>(type));
        if (CollectionUtils.isEmpty(objects)) {
            return null;
        }
        Class<?> fieldType = field.getType();
        if (fieldType.isArray()) {
            return objects.toArray();
        } else if (Collection.class.isAssignableFrom(fieldType)) {
            return objects;
        }
        return objects.get(0);
    }

    @Override
    protected void inject(Object target, String requestingBeanName, PropertyValues pvs) throws Throwable {
        super.inject(target, requestingBeanName, pvs);
    }


    public Class<?> getType() {
        Class<?> type = field.getType();
        if (Collection.class.isAssignableFrom(type)) {
            ParameterizedType pt = (ParameterizedType) field.getGenericType();
            type = (Class<?>) pt.getActualTypeArguments()[0];
        } else if (type.isArray()) {
            type = ((Class) field.getGenericType()).getComponentType();
        }

        if (type.isAnnotationPresent(TableName.class)) {
            tableName = type.getAnnotation(TableName.class).value();
        }
        return type;
    }

    public String getSql() {
        return "select * from " + tableName + " where id in (" + idsStr + ") ";
    }
}
