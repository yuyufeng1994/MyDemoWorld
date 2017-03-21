package state;

/**
 * 状态模式测试
 * 
 * @author Yu Yufeng
 *
 */
public class Test {
	public static void main(String[] args) {
		// 创建状态
		State state = new ConcreteStateB();
		// 创建环境
		Context context = new Context();
		// 将状态设置到环境中
		context.setState(state);
		// 请求
		context.request("test");
	}
}
