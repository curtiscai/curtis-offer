package com.curtis.offer.base.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author curtis.cai
 * @desc
 * @date 2023-03-27
 * @email curtis.cai@outlook.com
 * @reference
 */
public class ThreadCreate2Test implements Runnable{

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadCreate2Test.class);

    @Override
    public void run() {
        LOGGER.info("   Begin Task With {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Complete Task {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
    }

    public static void main(String[] args) {
        LOGGER.info("   Begin Task With {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
        ThreadCreate2Test threadCreate2Test = new ThreadCreate2Test();
        Thread thread = new Thread(threadCreate2Test);
        thread.start();
        LOGGER.info("Complete Task {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
    }
}
