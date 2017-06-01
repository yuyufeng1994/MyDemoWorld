package demo.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuyufeng on 2017/5/26.
 */
public class Test {
    static int in =1;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 11; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("Asynchronous task"+in++);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println("Asynchronous task"+in++);
                }
            });
//            executorService.shutdown();
        }

        executorService.shutdown();
    }
}
