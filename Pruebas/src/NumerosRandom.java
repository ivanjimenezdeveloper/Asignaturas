import java.util.Random;

public class NumerosRandom {

	public static void main(String[] args) {
		Random r = new Random();
		Double numero = (r.nextDouble()*(100 - 0)+ 100);
		System.out.println(numero);
		
		Random su = new Random();
		
		Double numeroRandom = (su.nextInt(100- 0) +0.95);
		
		System.out.println(numeroRandom);
	}

}
