package demo.java.util.DateTest;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 对日期类的一些操作
 * 
 * @author Yu Yufeng
 *
 */
public class DateUse {
	@Test
	public void test() {
		System.out.println("DateUse.test()");
	}
	
	/**
	 * 日期格式
	 */
	@Test
	public void testFormate() {
		Date date = new Date();
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = f.format(date);
		System.out.println(dateStr);
	}

	/**
	 * 对时间的加减
	 */
	@Test
	public void testDateModify() {
		Date date = new Date();
		Calendar cNow = Calendar.getInstance();
		cNow.setTime(date);
		System.out.println(cNow);
		cNow.add(Calendar.DATE, -1);
		Date now = cNow.getTime();
		System.out.println(now);

	}

	/**
	 * 得到一天的时间 0~24
	 */
	@Test
	public void testGetOneDay() {
		Date date = new Date();//当前一天
		Date res;
		Calendar cNow = Calendar.getInstance();
		cNow.setTime(date);
		res = cNow.getTime();
		cNow.set(Calendar.HOUR_OF_DAY, 0);
		cNow.set(Calendar.SECOND, 0);
		cNow.set(Calendar.MINUTE, 0);
		cNow.set(Calendar.MILLISECOND, 0);
		res = cNow.getTime();
		System.out.println(res);
		cNow.add(Calendar.DATE, -1);
		res = cNow.getTime();
		System.out.println(res);

	}/**
	 * 得到一天之前七天
	 */
	@Test
	public void testGet7DaysBefore() {
		Date date = new Date();//当前一天
		Date res;
		Calendar cNow = Calendar.getInstance();
		cNow.setTime(date);
		res = cNow.getTime();
		cNow.set(Calendar.HOUR_OF_DAY, 0);
		cNow.set(Calendar.SECOND, 0);
		cNow.set(Calendar.MINUTE, 0);
		cNow.set(Calendar.MILLISECOND, 0);
		res = cNow.getTime();
		for(int i=0;i<7;i++){
			cNow.add(Calendar.DATE, -1);
			res = cNow.getTime();
			System.out.println(res);
		}
		

	}
}
