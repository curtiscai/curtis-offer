package com.curtis.offer.base.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @author curtis.cai
 * @desc
 * @date 2023-03-27
 * @email curtis.cai@outlook.com
 * @reference
 */
public class ThreadCreate3Test implements Callable<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadCreate3Test.class);

    @Override
    public String call() throws Exception {
        LOGGER.info("   Begin Task With {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Complete Task {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
        return "hello";
    }


    public static void main(String[] args) {
        LOGGER.info("   Begin Task With {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());
        ThreadCreate3Test threadCreate3Test = new ThreadCreate3Test();
        FutureTask<String> futureTask = new FutureTask<>(threadCreate3Test);

        Thread thread = new Thread(futureTask);
        thread.start();
        LOGGER.info("Complete Task {} In {}", Thread.currentThread().getName(), LocalTime.now().toString());

        try {
            String result = futureTask.get(10, TimeUnit.SECONDS);
            LOGGER.info("The result is {}", result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
