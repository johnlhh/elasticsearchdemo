package com.huamo.appservice.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by luohh on 2016/10/24.
 */
@Component
public class DataImportTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void testTask(){
        System.out.println("hello world");
    }


}
