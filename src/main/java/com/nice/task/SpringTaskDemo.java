package com.nice.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 基于Spring自带的
 * @author ningh
 */
@Component
public class SpringTaskDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringTaskDemo.class);

    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        Thread.sleep(3000);
        LOGGER.info("scheduled1 每1秒执行一次:{}", LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
        Thread.sleep(3000);
        LOGGER.info("scheduled2 每1秒执行一次:{}",LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        Thread.sleep(5000);
        LOGGER.info("scheduled3 上次执行完毕后隔3秒继续执行: {}",LocalDateTime.now());
    }

}
