package guiLogin;

public class Oil extends Ores{
	private double toDollar;
	private double toOil;
	
	public double getToDollar() {
		return toDollar;
	}

	public void setToDollar(double toDollar) {
		this.toDollar = toDollar;
	}

	public double getToOil() {
		return toOil;
	}

	public void setToOil(double toOil) {
		this.toOil = toOil;
	}

	public double getTotoOil() {
		return toOil;
	}

	

	public Oil(double toDollar, double toOil) {
		super();
		this.toDollar = toDollar;
		this.toOil = toOil;
	}

	@Override
	protected double to_Dollar() {
		return getToDollar();
	}

	@Override
	protected double to_Ore() {
		
		return getTotoOil();
	}

}
