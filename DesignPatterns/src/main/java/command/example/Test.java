package command.example;

/**
 * 模拟对电视机的操作有开机、关机、换台命令
 * 
 * @author Yu Yufeng
 *
 */
public class Test {
	public static void main(String[] args) {
		// 命令接收者
		Tv myTv = new Tv();
		// 开机命令
		CommandOn on = new CommandOn(myTv);
		// 关机命令
		CommandOff off = new CommandOff(myTv);
		// 频道切换命令
		CommandChange channel = new CommandChange(myTv, 2);
		// 命令控制对象
		Control control = new Control(on, off, channel);
		// 开机
		control.turnOn();
		// 换频道
		control.changeChannel();
		// 关机
		control.turnOff();
	}
}
