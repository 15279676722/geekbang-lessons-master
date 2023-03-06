package org.geekbang.thinking.in.spring.bean.test1;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan({"org.geekbang.thinking.in.spring.bean.test1.event","org.geekbang.thinking.in.spring.bean.test1.listener"})
public class EventAnnotationConfig {


}
