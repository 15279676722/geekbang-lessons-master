package org.geekbang.thinking.in.spring.bean.test1.schedule;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedule  {
    @Scheduled(cron="0/5 * *  * * ? ")
    public void test(){
        System.out.println("test MySchedule");
    }
}
