package org.geekbang.thinking.in.spring.bean.test1.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MysqlResource {
    /**
     * 要注入的表名
     * */
    String tableName() default "";
    /**
     * 要注入的数据ID
     * */
    String[] ids();
}
