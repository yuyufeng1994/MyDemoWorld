package demo.java.lang.Thread;
/**
 * 处理线程安全问题 synchronized
 * 产生原因：由于一个线程在操作共享数据的过程中，为执行完毕的情况下，另外的线程参与进来，共享数据存在安全问题
 * 如何解决：必须让一个线程操作共享数据完毕以后，其它线程才有机会参与共享操作
 * java如何实现线程的安全，线程的同步机智：
 * 方式1.同步代码块 
 * synchronized(同步监视器){
 *	//需要被同步的代码快（即为操作共享数据的代码）
 * }
 * 1.共享数据：多个线程操作的同一个数据（变量）
 * 2.同步监视器：由一个对象来充当。哪个线程获取此监视器，谁就执行大括号里面的代码。熟称锁
 * 要求：所有线程必须共用同一把锁,在继承的方式中慎用
 * 方式2.同步方法
 * @author Yu Yufeng
 *
 */
class Window2 implements Runnable {
	int ticket = 100;//共享数据
	//Object obj = new Object();
	@Override
	public  void run() {
	//public synchronized void run() {//同步方法
		while (true) {
			//操作共享数据的代码
			synchronized(this){
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket--);
				}else{
					break;
				}
			}
		}
	}

}

public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
		Thread t1 = new Thread(w);
		Thread t2= new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}