package decorate;

/**
 * 具体实现组件对象接口的对象
 * 
 * @author Yu Yufeng
 *
 */
public class ConcreteComponent extends Component {
	public void operation() {
		// 相应的功能处理
		System.out.println("ConcreteComponent.operation()");
	}
}
