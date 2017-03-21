package demo.java.lang.Thread;

public class VolatileTest {
	private static  boolean isStoped = false;

	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					isStoped = !isStoped;
				}

			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				while (true) {
					if (isStoped != isStoped) {
						System.err.println("isStoped not equals!");
					}
				}
			}
		}.start();
	}

}
