package demo.java.lang.Thread;

public class VolatileTest2 {
	volatile static int in = 0;
//	 static int in = 0;
	public static void main(String[] args) throws InterruptedException {
		for (int n = 0; n < 10; n++) {
			new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						in++;
						System.out.println(Thread.currentThread().getName() + " " + in);
					}
				}
			}.start();
		}
	}
	
}
