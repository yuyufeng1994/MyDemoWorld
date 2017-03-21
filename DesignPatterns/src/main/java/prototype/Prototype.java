package prototype;

/**
 * 
 * @author Yu Yufeng
 * <p>浅克隆</p>
 * <p>
 * 深拷贝与浅拷贝。Object类的clone方法只会拷贝对象中的基本的数据类型，
 * 对于数组、容器对象、引用对象等都不会拷贝，这就是浅拷贝。
 * 如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另行拷贝。
 * </p>
 */
public class Prototype implements Cloneable {
	public Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}