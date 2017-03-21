package demo.java.lang.Thread;

/**
 * 两个线程一个输出奇数，一个输出偶数
 * 
 * @author Yu Yufeng
 *
 */
class SubThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " :" + i);
			}
		}
	}

}

public class TestThread2 {
	public static void main(String[] args) {
		SubThread2 st2 = new SubThread2();

		st2.start();

		// 使用匿名内部类创建

		new Thread() {
			public void run() {
				for (int i = 0; i <= 100; i++) {
					if (i % 2 != 0) {
						System.out.println(Thread.currentThread().getName() + " :" + i);
					}
				}
			};
		}.start();

	}
}
