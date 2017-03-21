package factory.simplefactory;

/**
 * 抽象产品  
 * @author Yu Yufeng
 *
 */
public abstract class Car {
	private String name;

	public abstract void drive();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
