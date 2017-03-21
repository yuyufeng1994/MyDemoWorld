package factory.simplefactory;

/**
 * 具体产品
 * 
 * @author Yu Yufeng
 *
 */
public class Benz extends Car {
	public void drive() {
		System.out.println(this.getName() + "---go");
	}
}
