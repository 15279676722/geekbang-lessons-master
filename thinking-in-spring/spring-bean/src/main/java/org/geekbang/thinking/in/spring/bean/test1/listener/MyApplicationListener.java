package org.geekbang.thinking.in.spring.bean.test1.listener;

import org.geekbang.thinking.in.spring.bean.test1.event.MyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<MyEvent> {
    @Override
    @Async
    public void onApplicationEvent(MyEvent event) {
        System.out.println("receive event "+ event.getSource());
    }
}
