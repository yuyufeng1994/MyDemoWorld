package demo.java.lang.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

		static AtomicInteger ai = new AtomicInteger(1);
//		 static int in = 0;
		public static void main(String[] args) throws InterruptedException {
			for (int n = 0; n < 10; n++) {
				new Thread() {
					@Override
					public void run() {
						for (int i = 0; i < 100000; i++) {
							System.out.println(Thread.currentThread().getName() + " " + ai.getAndIncrement());
						}
					}
				}.start();
			}
		}


}
