package com.example.demo.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	// 定义每过3秒执行任务
//    @Scheduled(fixedRate = 1000)
//	@Scheduled(cron = "0 0/1 * * * ?")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
