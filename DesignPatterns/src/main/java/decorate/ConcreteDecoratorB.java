package decorate;

/**
 * <p>
 * 装饰器的具体实现对象，向组件对象添加职责，operationFirst()，operationLast()为前后需要添加的功能。
 * 具体的装饰器类ConcreteDecoratorB代码相似，不在给出。
 * </p>
 * 
 * @author Yu Yufeng
 *
 */
public class ConcreteDecoratorB extends Decorator {
	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	// 在调用父类的operation方法之前需要执行的操作
	private void operationFirst() {
		System.out.println("ConcreteDecoratorB.operationFirst()");
	}

	// 在调用父类的operation方法之后需要执行的操作
	private void operationLast() {
		System.out.println("ConcreteDecoratorB.operationLast()");
	}

	// 调用父类的方法，可以在调用前后执行一些附加动作
	public void operation() {
		operationFirst(); // 添加的功能
		super.operation(); // 这里可以选择性的调用父类的方法，如果不调用则相当于完全改写了方法，实现了新的功能
		operationLast(); // 添加的功能
	}
}