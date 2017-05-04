package demo.java.util.concurrent.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuyufeng on 2017/5/4.
 * 执行器服务 ExecutorService
 * java.util.concurrent.ExecutorService 接口表示一个异步执行机制，使我们能够在后台执行任务。因此一个 ExecutorService 很类似于一个线程池。实际上，存在于 java.util.concurrent 包里的 ExecutorService 实现就是一个线程池实现。
 * execute(Runnable) 方法要求一个 java.lang.Runnable 对象，然后对它进行异步执行。
 */
public class TestExecute {
    public static void main(String[] args) {
        //        使用 newFixedThreadPool() 工厂方法创建一个 ExecutorService。这里创建了一个十个线程执行任务的线程池。
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        executorService.shutdown();
    }
}
