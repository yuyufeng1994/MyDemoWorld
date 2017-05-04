package demo.java.util.concurrent.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * Created by yuyufeng on 2017/5/4.
 */
public class TestScheduledExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //首先一个内置 5 个线程的 ScheduledExecutorService 被创建。之后一个 Callable 接口的匿名类示例被创建然后传递给 schedule() 方法。后边的俩参数定义了 Callable 将在 5 秒钟之后被执行。
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);

        ScheduledFuture scheduledFuture =
                scheduledExecutorService.schedule(new Callable() {
                                                      public Object call() throws Exception {
                                                          System.out.println("Executed!");
                                                          return "Called!";
                                                      }
                                                  },
                        5,
                        TimeUnit.SECONDS);

        System.out.println("result = " + scheduledFuture.get());

        scheduledExecutorService.shutdown();

    }
}
