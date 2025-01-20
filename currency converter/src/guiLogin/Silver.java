package guiLogin;

public class Silver extends Ores{
	private double toDollar;
	private double toSilver;
	
	public double getToDollar() {
		return toDollar;
	}

	public void setToSilver(double toSilver) {
		this.toSilver = toSilver;
	}

	public void setToDollar(double toDollar) {
		this.toDollar = toDollar;
	}

	public double getToSilver() {
		return toSilver;
	}

	

	public Silver(double toDollar, double toSilver) {
		super();
		this.toDollar = toDollar;
		this.toSilver = toSilver;
	}

	@Override
	protected double to_Dollar() {
		return getToDollar();
	}

	@Override
	protected double to_Ore() {
		
		return getToSilver();
	}

}
