package demo.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuyufeng on 2017/5/26.
 */
public class Test {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.countDown();
        System.out.println(countDownLatch);
        try {
            countDownLatch.await(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
