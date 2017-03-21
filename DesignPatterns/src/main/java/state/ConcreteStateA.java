package state;

/**
 * 具体状态类
 * @author Yu Yufeng
 *
 */
public class ConcreteStateA implements State {

	@Override
	public void handle(String sampleParameter) {

		System.out.println("ConcreteStateA handle ：" + sampleParameter);
	}

}
