package command.example;

//关机命令
public class CommandOff implements Command {
	private Tv myTv;

	public CommandOff(Tv tv) {
		myTv = tv;
	}

	public void execute() {
		myTv.turnOff();
	}
}
