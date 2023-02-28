package org.geekbang.thinking.in.spring.bean.test1.autowired;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface MyAutowired {
}
