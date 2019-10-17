package pruebas;
import java.util.HashMap;
public class Hashmap {

	public static void main(String[] args) {
		//como recorrer un hashtable
		
		HashMap<Integer, String> ht = new HashMap<Integer, String>();
		
		
		for(Integer i : ht.keySet()) {
			String s = ht.get(i);
			//s tiene el valor
		}
	}

}
