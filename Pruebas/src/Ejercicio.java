
public class Ejercicio {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i =1; i<100001; i++) {

			
			System.out.println("hola "+ i +" Rambo");
			System.out.println();
		}
		long end = System.currentTimeMillis();
		
		System.out.println((end-start));
	}

}
