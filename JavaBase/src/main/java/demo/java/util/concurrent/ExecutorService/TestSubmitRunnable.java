package demo.java.util.concurrent.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yuyufeng on 2017/5/4.
 * submit(Runnable) 方法也要求一个 Runnable 实现类，但它返回一个 Future 对象。这个 Future 对象可以用来检查 Runnable 是否已经执行完毕。
 * 以下是 ExecutorService submit() 示例：
 */
public class TestSubmitRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Asynchronous task end");
            }
        });

        future.get();  //returns null if the task has finished correctly.
        System.out.println(future.get());
        executorService.shutdown();


        /*
        * 使用完 ExecutorService 之后你应该将其关闭，以使其中的线程不再运行。
        * 比如，如果你的应用是通过一个 main() 方法启动的，之后 main 方法退出了你的应用，如果你的应用有一个活动的 ExexutorService 它将还会保持运行。ExecutorService 里的活动线程阻止了 JVM 的关闭。
        * 要终止 ExecutorService 里的线程你需要调用 ExecutorService 的 shutdown() 方法。ExecutorService 并不会立即关闭，但它将不再接受新的任务，而且一旦所有线程都完成了当前任务的时候，ExecutorService 将会关闭。在 shutdown() 被调用之前所有提交给 ExecutorService 的任务都被执行。
        * 如果你想要立即关闭 ExecutorService，你可以调用 shutdownNow() 方法。这样会立即尝试停止所有执行中的任务，并忽略掉那些已提交但尚未开始处理的任务。无法担保执行任务的正确执行。可能它们被停止了，也可能已经执行结束。
        * */
    }
}
