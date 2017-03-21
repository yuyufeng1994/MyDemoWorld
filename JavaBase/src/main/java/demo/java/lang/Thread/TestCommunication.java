package demo.java.lang.Thread;

/**
 * 线程通信 使用两个线程打印1-100，线程1，线程2交替打印
 * 
 * @author Yu Yufeng
 *
 */
// wait(); ：一旦一个线程执行到wait()，就释放当前的锁
// notify(); notifyAll();：唤醒wait的一个或所有线程
class PrintNums implements Runnable {
	int num = 1;

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				notify();
				if (num <= 100) {
					System.out.println(Thread.currentThread().getName() + ": " + num);
					num++;
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}

public class TestCommunication {
	public static void main(String[] args) {
		PrintNums p = new PrintNums();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		t1.setName("甲");
		t2.setName("乙");
		t1.start();
		t2.start();

	}
}
