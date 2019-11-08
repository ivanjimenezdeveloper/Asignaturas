package Servlets;

public class Hipoteca {
	
	// Objeto hipoteca que guarda los meses, intereses, capital y si se ve el cuadro
	// de amortizacion o no usados para la tabla
	private double meses, intereses;
	
	private double capital;

	
	private int cuadroAmortizado;
	public Hipoteca(double meses, double intereses, double capital, int cuadroAmortizado) {
		super();
		this.meses = meses;
		this.intereses = intereses;
		this.capital = capital;
		this.cuadroAmortizado = cuadroAmortizado;
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


	public int getCuadroAmortizado() {
		return cuadroAmortizado;
	}


	public void setCuadroAmortizado(int cuadroAmortizado) {
		this.cuadroAmortizado = cuadroAmortizado;
	}

	
	


}
