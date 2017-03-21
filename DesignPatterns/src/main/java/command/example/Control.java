package command.example;

//可以看作是遥控器吧
public class Control {
	private Command onCommand;
	Command offCommand;
	Command changeChannel;

	public Control(Command on, Command off, Command channel) {
		onCommand = on;
		offCommand = off;
		changeChannel = channel;
	}

	public void turnOn() {
		onCommand.execute();
	}

	public void turnOff() {
		offCommand.execute();
	}

	public void changeChannel() {
		changeChannel.execute();
	}
}
