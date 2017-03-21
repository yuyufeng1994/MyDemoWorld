package demo.java.lang.Thread;

//创建多线程的方式二
/**
 * 对比继承的方式vs实现的方式
 * 1.联系：Thread implements Runnable
 * 2.哪个方式好？实现的方式优于继承的方式，避免java单继承局限性，如果多个线程要操作同一份资源更适合使用实现的方式
 * @author Yu Yufeng
 *
 */
class PrintNum1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " :" + i);
			}
		}
	}

}

public class TestThread3 {
	public static void main(String[] args) {
		PrintNum1 p = new PrintNum1();
		Thread t1 = new Thread(p);
		t1.start();
		
		//再创建一个线程
		Thread t2 = new Thread(p);
		t2.start();
	}

}
