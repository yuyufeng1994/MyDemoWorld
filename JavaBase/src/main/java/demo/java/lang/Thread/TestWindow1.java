package demo.java.lang.Thread;

class Window1 implements Runnable {
	int ticket = 100;

	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket--);
			} else {
				break;
			}
		}
	}

}

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w = new Window1();
		Thread t1 = new Thread(w);
		Thread t2= new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}