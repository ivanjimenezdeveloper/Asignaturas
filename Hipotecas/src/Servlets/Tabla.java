package Servlets;
import java.util.ArrayList;

public class Tabla {

	private double coutaTabla, coutaAmortizada, coutaInteres, capitalPenAnt, capitalPenPos;

	/*
	 * Constructor con los valores necesarios para cada row de la tabla
	 */
	public Tabla(double coutaTabla, double coutaAmortizada, double coutaInteres, double capitalPenAnt,
			double capitalPenPos) {
		super();
		this.coutaTabla = coutaTabla;
		this.coutaAmortizada = coutaAmortizada;
		this.coutaInteres = coutaInteres;
		this.capitalPenAnt = capitalPenAnt;
		this.capitalPenPos = capitalPenPos;
	}

	public Tabla() {
		super();
	}

	/**
	 * Hace los calculos de la tabla y devuelve una arraylist con cada row
	 * @param meses Meses que dura el pago
	 * @param capital Capital prestado
	 * @param intereses Intereses aplicados al pago
	 * @return Arraylist con las rows de la tabla
	 */
	public static ArrayList<Tabla> calcularTabla(int meses, double capital, double intereses) {

		ArrayList<Tabla> tbArr = new ArrayList<Tabla>();
		Hipoteca hp = new Hipoteca();
		Tabla tabla = new Tabla();
		double capitalTabla;
		double mesesTabla, interesesTabla;
		double operacionCouta1, operacionCouta2;

		// Recoge los datos dados y los guarda en un objeto hipoteca

		hp.setCapital(capital);
		hp.setIntereses(intereses);
		hp.setMeses(meses);

		// Guarda los valores de la hipoteca en unas variables
		capitalTabla = hp.getCapital();
		mesesTabla = hp.getMeses();
		interesesTabla = hp.getIntereses();

		// Guarda las operaciones de la couta para una facil lectura
		operacionCouta1 = 1 - Math.pow((1 + (interesesTabla / 100 / 12)), -mesesTabla);
		operacionCouta2 = interesesTabla / 100 / 12;

		// Calcula la couta que pagara cada mes
		tabla.setCoutaTabla(capitalTabla / (operacionCouta1 / operacionCouta2));

		// Guarda la capital pendiente posterior en la tabla
		tabla.setCapitalPenPos(capitalTabla);

		// Se crean las rows y se guardan en una array segun los meses dados y se hacen
		// los calculos
		for (int i = 0; i < mesesTabla; i++) {

			tabla.setCapitalPenAnt(tabla.getCapitalPenPos());

			tabla.setCoutaInteres(tabla.getCapitalPenAnt() * (interesesTabla / 100 / 12));

			tabla.setCoutaAmortizada(tabla.getCoutaTabla() - tabla.getCoutaInteres());

			tabla.setCapitalPenPos(tabla.getCapitalPenAnt() - tabla.getCoutaAmortizada());

			
			// Guarda esta row en una array de objetos tabla
			tbArr.add(tabla);

			// Variable que guarda la capital pendiente posterior para usarla en la
			// siguiente
			double t = tabla.getCapitalPenPos();

			// Reinicia el objeto tabla para poder guardarlo en la array
			tabla = new Tabla();

			// Guarda la couta en la nueva tabla
			tabla.setCoutaTabla(capitalTabla / (operacionCouta1 / operacionCouta2));

			// Guarda la capital pendiente posterior dada la anterior variable
			tabla.setCapitalPenPos(t);
		}

		return tbArr;

	}

	public double getCoutaTabla() {
		return coutaTabla;
	}

	public void setCoutaTabla(double coutaTabla) {
		this.coutaTabla = coutaTabla;
	}

	public double getCoutaAmortizada() {
		return coutaAmortizada;
	}

	public void setCoutaAmortizada(double coutaAmortizada) {
		this.coutaAmortizada = coutaAmortizada;
	}

	public double getCoutaInteres() {
		return coutaInteres;
	}

	public void setCoutaInteres(double coutaInteres) {
		this.coutaInteres = coutaInteres;
	}

	public double getCapitalPenAnt() {
		return capitalPenAnt;
	}

	public void setCapitalPenAnt(double capitalPenAnt) {
		this.capitalPenAnt = capitalPenAnt;
	}

	public double getCapitalPenPos() {
		return capitalPenPos;
	}

	public void setCapitalPenPos(double capitalPenPos) {
		this.capitalPenPos = capitalPenPos;
	}

}
