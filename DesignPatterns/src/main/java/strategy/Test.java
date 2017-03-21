package strategy;

/**
 * 策略模式测试
 * 
 * @author Yu Yufeng
 *
 */
public class Test {
	public static void main(String[] args) {
		Context context;
		context = new Context(new StrategyA());
		context.operate();

		context.setStrategy(new StrategyB());
		context.operate();
	}

}
/**
 * 运行结果
 *  StrategyA.operate()
 *	StrategyB.operate()
 */
