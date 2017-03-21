package strategy;

/**
 * 环境类（Context)
 * @author Yu Yufeng
 *
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void operate() {
		this.strategy.operate();
	}
}
