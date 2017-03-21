package factory.simplefactory;

/**
 * 简单工厂
 * 
 * @author Yu Yufeng
 *
 */
public class CarFactory {
	public static Car createCar(String car) {
		Car c = null;
		if ("Benz".equalsIgnoreCase(car))
			c = new Benz();
		else if ("Bmw".equalsIgnoreCase(car))
			c = new Bmw();
		return c;
	}
}