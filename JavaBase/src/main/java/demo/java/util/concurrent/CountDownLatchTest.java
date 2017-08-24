package demo.java.util.concurrent;


import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 只有当完成了job1 和 job2 作业后,才执行job3
 * Created by yuyufeng on 2017/8/24.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2); //因为job1 job2共两个线程,所以计数2
        new Job("job1", 3000, countDownLatch).start();
        new Job("job2", 5000, countDownLatch).start();
        countDownLatch.await();
        System.out.println("do job3...");
        System.out.println("耗时 " + (System.currentTimeMillis() - beginTime));
    }
}

class Job extends Thread {
    String jobName;
    long time = 0;
    CountDownLatch countDownLatch;

    public Job(String jobName, long time, CountDownLatch countDownLatch) {
        this.time = time;
        this.jobName = jobName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(jobName + "startDoSomeThing... " + new Date());
        doJob(time);
        System.out.println(jobName + "DoneJob " + new Date());

        //最好放在finally中
        countDownLatch.countDown();
    }

    private void doJob(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


/**
 * 执行结果:
 * job1startDoSomeThing... Thu Aug 24 09:17:01 CST 2017
 * job2startDoSomeThing... Thu Aug 24 09:17:01 CST 2017
 * job1DoneJob Thu Aug 24 09:17:04 CST 2017
 * job2DoneJob Thu Aug 24 09:17:06 CST 2017
 * do job3...
 * 耗时 5055
 */
