package demo.java.util.concurrent.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuyufeng on 2017/5/4.
 */
public class TestMy {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.shutdown();
    }
}

class Task implements  Runnable{
    private int no;

    public Task(int no) {
        this.no = no;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("============ "+this.no);
            try {
                Thread.currentThread().sleep(100*no);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}