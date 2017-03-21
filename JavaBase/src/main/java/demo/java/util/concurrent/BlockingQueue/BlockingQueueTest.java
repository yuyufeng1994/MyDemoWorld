package demo.java.util.concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		// 初始化队列长度只有3的队列
		final BlockingQueue<String> blockingque = new ArrayBlockingQueue<String>(3);
		
		Thread Putter = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i < 10; i++) {
					try {
						blockingque.put("货物" + i);
						System.out.println("成功往队列中放入货物" + i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		Putter.start();
		Thread taker = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						// 取得时间延长，模拟取得时间远大于放入时间
						Thread.sleep(3000);
						String cargo = blockingque.take();
						System.out.println("取出货物： " + cargo);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		taker.start();

	}

}
