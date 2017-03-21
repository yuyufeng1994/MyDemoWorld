package command.example;

//开机命令
public class CommandOn implements Command {
	private Tv myTv;

	public CommandOn(Tv tv) {
		myTv = tv;
	}

	public void execute() {
		myTv.turnOn();
	}
}