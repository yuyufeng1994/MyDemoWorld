package demo.java.lang.Thread;

/**
 * 死锁问题,处理线程同步时容易出现
 * 都在等待对方释放
 * @author Yu Yufeng
 *
 */

public class TestDeadLock {
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				synchronized (sb1) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sb1.append("A");
					synchronized (sb2) {
						sb2.append("B");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				synchronized (sb2) {
					sb1.append("C");
					synchronized (sb1) {
						sb2.append("D");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			};
		}.start();
	}
}
