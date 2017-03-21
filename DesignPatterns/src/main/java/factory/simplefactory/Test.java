package factory.simplefactory;

import java.io.IOException;

/**
 * 简单工厂测试
 * 
 * @author Yu Yufeng
 *
 */
public class Test {
	public static void main(String[] args) throws IOException {
		// 我今天坐奔驰
		Car car = CarFactory.createCar("benz");
		car.setName("benz");
		// 司机开着奔驰出发
		car.drive();
	}
}
