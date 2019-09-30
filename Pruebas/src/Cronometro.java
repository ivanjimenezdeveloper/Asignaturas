import java.lang.Object;
import java.util.ArrayList;
public class Cronometro {

	public static void main(String[] args) {
		int sec=40;
		int min=1;
		int milis=0000;
		ArrayList<Integer> tiempo = new ArrayList<Integer>();
		
		tiempo.add(min);
		tiempo.add(sec);
		tiempo.add(milis);
		
		while(min<2) {
			long start = System.currentTimeMillis();
			
			for(long contadorMili=0; contadorMili < 1000; ) {
				long end = System.currentTimeMillis();
				contadorMili = end-start;
				milis = (int) contadorMili;
				
				System.out.println(min + ":"+ sec + ":" + contadorMili);
			}
			sec++;
			
			if(sec == 60) {
				min++;
				sec =0;
			}

			System.out.println(min + ":"+ sec + ":" + 0000 );

			//System.out.println(tiempo.get(min) + ":"+ tiempo.get(sec) + ":" + tiempo.get(milis));
			
			
		}
	}

}
