package demo.java.lang.Thread;

/**
 * 
 * 方式2.同步方法
 * 将操作共享数据的方法声明为synchronized，即此方法为同步方法，能够保证当其中一个线程执行此方法时，其它线程在外等待，知道此线程执行完此方法
 * 同步方法的锁：当前对象
 * @author Yu Yufeng
 *
 */
class Window4 implements Runnable {
	int ticket = 100;// 共享数据
	// Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			show();
			if (ticket <= 0) {
				break;
			}
		}

	}

	public synchronized void show() {

		// 操作共享数据的代码
		if (ticket > 0) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket--);
		}
	}

}

public class TestWindow4 {
	public static void main(String[] args) {
		Window4 w = new Window4();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		t1.start();
		t2.start();
		t3.start();

	}
}