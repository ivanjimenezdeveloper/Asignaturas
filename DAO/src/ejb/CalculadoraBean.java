package ejb;

import javax.ejb.Stateless;

@Stateless
public class CalculadoraBean {

	public int suma(int a,int b) {
		
		return a+b;
	}
	
	public int resta(int a,int b) {
		
		return a-b;
	}
	
	public int multiplicacion(int a,int b) {
		
		return a*b;
	}
	
	public int division(int a,int b) {
		
		return a/b;
	}
	
	public double raiz(double a) {
		
		return Math.sqrt(a);
	}
	
}
