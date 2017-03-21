package demo.java.lang.Thread;

/**
 * 
 * @author Yu Yufeng 创建一个子线程，完成1-100之间的自然数的输出，同样的主线程执行相同操作
 */
//1.创建继承于子类的Thread的子类
class SubThread extends Thread {
//2.重写Thread的run()方法
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

}

public class TestThread {
	public static void main(String[] args) {
		//3.创建一个子类对象
		SubThread st = new SubThread();
		SubThread st2 = new SubThread();
		//4.调用线程的start()，启动此线程，调用相应的run()方法
		//5.一个线程只能执行一次start()
		st.start();
		st2.start();
		
	}
}
