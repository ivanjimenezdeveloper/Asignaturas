import java.text.DecimalFormat;
import java.util.ArrayList;

public class Tabla {

	private double coutaTabla, coutaAmortizada, coutaInteres, capitalPenAnt, capitalPenPos;

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

	public static void main(String[] args) {
		calcularTabla(1, 2.0, 3);
	}

	public static void calcularTabla(int meses, double capital, int intereses) {

		ArrayList<Tabla> tbArr = new ArrayList<Tabla>();
		Hipoteca hp = new Hipoteca();
		Tabla tabla = new Tabla();
		double capitalTabla;
		double mesesTabla, interesesTabla;
		double operacionCouta1, operacionCouta2;

		// pruebas

		hp.setCapital(200000.00);
		hp.setIntereses(3);
		hp.setMeses(60);

		capitalTabla = hp.getCapital();
		mesesTabla = hp.getMeses();
		interesesTabla = hp.getIntereses();
		operacionCouta1 = 1 - Math.pow((1 + (interesesTabla / 100 / 12)), -mesesTabla);
		operacionCouta2 = interesesTabla / 100 / 12;

		tabla.setCoutaTabla(capitalTabla / (operacionCouta1 / operacionCouta2));
		
		tabla.setCapitalPenPos(capitalTabla);
		
		
		for(int i = 0; i<mesesTabla;i++) {
			
			tabla.setCapitalPenAnt(tabla.getCapitalPenPos());
			
			tabla.setCoutaInteres(
					tabla.getCapitalPenAnt()*(interesesTabla/100/12)
					);
			
			tabla.setCoutaAmortizada(
					tabla.getCoutaTabla()-tabla.getCoutaInteres()
					);
			

			
			tabla.setCapitalPenPos(
					tabla.getCapitalPenAnt()-tabla.getCoutaAmortizada()
					);
			
			tbArr.add(tabla);
			
			double t = tabla.getCapitalPenPos();
			
			tabla = new Tabla();

			tabla.setCoutaTabla(capitalTabla / (operacionCouta1 / operacionCouta2));
			
			tabla.setCapitalPenPos(t);
		}
		

		System.out.println("TABLA");
		System.out.println(tbArr.toString());
		System.out.println("\n========================================\n");
		

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

	@Override
	public String toString() {

		DecimalFormat df2 = new DecimalFormat("#.##");
		
	return "[Capital pendiente anterior: "+ df2.format(capitalPenAnt)
			+ "\nCouta a pagar: "+ df2.format(coutaTabla)+
			"\nCuota amortizada: "+df2.format(coutaAmortizada)+
			"\nCouta interes: "+ df2.format(coutaInteres)+
			"\nCapital pendiente posterior: "+ Math.round(capitalPenPos*100d)/100d +
			 "]\n\n";
	}
	
	

}
