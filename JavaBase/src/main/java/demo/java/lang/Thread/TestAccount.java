package demo.java.lang.Thread;

/**
 * 银行有一个账户 有两个储户分别向一个账户存3000元，每次存1000，存三次，每次存完打印账单。
 * 
 * @author Yu Yufeng
 *
 */
class Account {
	double balance;// 余额

	public Account() {

	}

	public synchronized void deposit(double amt) {
		balance += amt;
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + balance);
	}
}

class Customer extends Thread {
	Account account;

	public Customer(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			account.deposit(1000);
		}
	}

}

public class TestAccount {
	public static void main(String[] args) {
		Account acct = new Account();
		Customer c1 = new Customer(acct);
		Customer c2 = new Customer(acct);
		c1.setName("甲");
		c2.setName("乙");
		c1.start();
		c2.start();
	}
}
