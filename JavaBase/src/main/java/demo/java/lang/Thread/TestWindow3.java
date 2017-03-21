package demo.java.lang.Thread;

/**
 * 模拟火车站售票窗口，开启三个窗口售票，总票数为100张, 
 * //存在线程安全问题，使用同步代码块，无法使用同步方法
 * 
 * @author Yu Yufeng
 *
 */
class Window3 extends Thread {
	static int ticket = 100;
	static Object obj = new Object();

	@Override
	public void run() {
		// synchronized (this) {//注意这样不行，对象锁不唯一
		while (true) {
			synchronized (obj) {
				// show();
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket--);
				}
				if (ticket <= 0) {
					break;
				}
			}
		}
	}

	public synchronized void show() { // this充当锁 无法使用同步方法！！
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

public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		w1.start();
		w2.start();
		w3.start();
	}
}
