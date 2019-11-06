
public class Hipoteca {

	private double meses, intereses;
	
	double capital;

	public Hipoteca(double meses, double intereses, double capital) {
		super();
		this.meses = meses;
		this.intereses = intereses;
		this.capital = capital;
	}

	
	public Hipoteca() {
		super();
	}


	public double getMeses() {
		return meses;
	}

	public void setMeses(double meses) {
		this.meses = meses;
	}

	public double getIntereses() {
		return intereses;
	}

	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	


}
