package demo.java.util.Random;

import org.junit.Test;

import java.util.Random;

public class RandomUse {
	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			String myno = "051701190000040";
			String mynob = myno.substring(6, 8);
			String mynoa = myno.substring(10, myno.length());
			String prefix = new Random().nextInt(9999-1000+1)+1000+"";
			myno = prefix + mynob + mynoa;
			System.out.println(myno);
			
			/*myno = "051701190000040";
	        mynob = myno.substring(2, 8);
	        mynoa = myno.substring(10, myno.length());
	        myno = mynob + mynoa;
			System.out.println(myno);*/
		}
	}

	/**
	 * 从数组中获取随即数
	 */
	@Test
	public void testGetFromArray() {
		Random random = new Random();
		String[] array = new String[] { "aaa", "bbb", "ccc" };
		for (int i = 0; i < 10; i++) {
			int res = random.nextInt(array.length);
			System.out.println(array[res]);
		}
	}

	@Test
	public void testRadom4Dig() {
		for (int i = 0; i < 100; i++) {
			Random random = new Random();
			System.out.println(random.nextInt(9999));
		}

	}
}
