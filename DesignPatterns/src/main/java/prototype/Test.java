package prototype;

/**
 * 原型模式测试
 * 
 * @author Yu Yufeng
 *
 */
public class Test {
	public static void main(String[] args) {
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
			clonecp.show();
		}
	}
}
