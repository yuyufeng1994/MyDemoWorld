package demo.java.lambda;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuyufeng on 2017/5/11.
 */
public class AnonymousUse  {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        }).start();



        new Thread(() -> System.out.println("Hello World!")).start();
//        TimeUnit.SECONDS.sleep(10);//休息十秒   时间转换
    }
}
