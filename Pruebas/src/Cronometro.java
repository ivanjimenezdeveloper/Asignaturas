
public class Cronometro {

	public static void main(String[] args) {
		int sec=0;
		int min=0;
		while(min<2) {
			long start = System.currentTimeMillis();
			
			for(long contadorMili=0; contadorMili < 1000; ) {
				long end = System.currentTimeMillis();
				contadorMili = end-start;
			}
			sec++;
			
			if(sec == 60) {
				min++;
				sec =0;
			}

			System.out.println(min + ":"+ sec);
			
			
		}
	}

}
