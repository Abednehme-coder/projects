package guiLogin;

public class LL extends Currency {
	private double toDollar;
	private double toLL;
	private double toEuro;
	
	
	public double getToDollar() {
		return toDollar;
	}

	public void setToDollar(double toDollar) {
		this.toDollar = toDollar;
	}

	public double getToLL() {
		return toLL;
	}

	
	public double getToEuro() {
		return toEuro;
	}

	public void setToEuro(double toEuro) {
		this.toEuro = toEuro;
	}


	public LL(double toLL, double toDollar, double toEuro) {
		super();
		this.toDollar = toDollar;
		this.toLL = toLL;
		this.toEuro = toEuro;
	}
	
	@Override
	protected double to_Dollar() {
		
		return getToDollar();
	}

	@Override
	protected double to_LL() {
	
		return getToLL();
	}

	@Override
	protected double to_Euro() {
		
		return getToEuro();
	}

}
