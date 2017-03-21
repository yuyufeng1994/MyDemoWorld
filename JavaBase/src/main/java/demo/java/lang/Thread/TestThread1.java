package demo.java.lang.Thread;

/**
 * 
 * @author Yu Yufeng   
 * Thread的常用方法， 
 * 1.start():启动线程并执行相应的run()方法，
 * 2.run():子线程要执行的代码放入run()方法中 ，
 * 3.currentThread():静态的，调用当前的线程，
 * 4.getName():得到此线程名字， 
 * 5.setName():设置此线程名字 ，
 * 6.yield():调用此方法的线程释放当前cpu的执行权，
 * 7.jion()：在A线程中调用B线程的join()方法，表示，当执行到此方法，A线程停止执行，直到B线程执行完毕，A线程接着jion()之后的代码执行，
 * 8.isAlive()：判断当前线程是否还存活，  
 * 9.sleep(long l):显式的让当前线程睡眠l毫秒，
 * 10.线程通信：wait() notify() notifyall()
 * 11.设置线程的优先级 getPriority()  setPriority(int newPriority)
 * 	
 */
class SubThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getPriority() + " :" + i);
//			try {
//				Thread.currentThread().sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}

public class TestThread1 {
	public static void main(String[] args) {
		SubThread1 st1 = new SubThread1();
		st1.setName("子线程1");
		st1.setPriority(Thread.MAX_PRIORITY);//10
		st1.start();
		
		
		Thread.currentThread().setName("======主线程========");
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+": "+Thread.currentThread().getPriority() + " :" + i);
			
//			if (i % 10 == 0) {
//				Thread.currentThread().yield();
//			}
//			if(i  == 20){
//				try {
//					st1.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(st1.isAlive());
	

	}
}
