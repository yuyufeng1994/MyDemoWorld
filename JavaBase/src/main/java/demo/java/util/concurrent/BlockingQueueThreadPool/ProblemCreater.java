package demo.java.util.concurrent.BlockingQueueThreadPool;

import java.util.Random;

public class ProblemCreater {
	public static void main(String[] args) throws Exception {
		// 初始化线程池
		ThreadPool threadPool = new ThreadPool();

		// 生成者不断产生任务
		for (int i = 1; i < 10; i++) {

			// 定义一个新的任务
			Runnable task = new Runnable() {
				public void run() {
					Random random = new Random();
					// 随机一个数字模拟需要解决的时间
					int randomTime = Math.abs(random.nextInt()) % 20;
					// System.out.println("这个任务需要解决时间为："+randomTime);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			// 将问题插入到线程池任务队列中
			threadPool.insertTask(task);
			System.out.println("插入新的任务" + i);
		}
	}
}
