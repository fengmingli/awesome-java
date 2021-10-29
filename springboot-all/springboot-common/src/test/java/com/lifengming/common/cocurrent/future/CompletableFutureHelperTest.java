package com.lifengming.common.cocurrent.future;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lifengming
 * @date 2020.06.12
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompletableFutureHelperTest {

    @Autowired
    private CompletableFutureHelper completableFutureHelper;

    @Test
    public void testGet() {

        try {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "lfm";}, completableFutureHelper.getTaskExecutor());

            //1s超时
            String s = future.get(1L, TimeUnit.SECONDS);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println("lifengming");
            log.error("error", e);
        }
    }
}
