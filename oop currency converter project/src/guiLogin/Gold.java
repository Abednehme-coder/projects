package guiLogin;

public class Gold extends Ores{
	private double toDollar;
	private double toGold;
	
	public double getToDollar() {
		return toDollar;
	}

	public double getToGold() {
		return toGold;
	}

	public void setToGold(double toGold) {
		this.toGold = toGold;
	}

	public void setToDollar(double toDollar) {
		this.toDollar = toDollar;
	}

	public double getTotoGold() {
		return toGold;
	}

	

	public Gold(double toDollar, double toGold) {
		super();
		this.toDollar = toDollar;
		this.toGold = toGold;
	}

	@Override
	protected double to_Dollar() {
		return getToDollar();
	}

	@Override
	protected double to_Ore() {
		
		return getTotoGold();
	}

}
