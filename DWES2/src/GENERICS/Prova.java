package GENERICS;
import GENERICS.Caja;
public class Prova {
	public static void main(String[] args) {
	    Caja<Integer> c1 = new Caja<Integer>();
	    
	    Caja<String> c2 = new Caja<String>();
	    
	    c1.setCaja(27);
	    c2.setCaja("Bomba!");
	    
	    System.out.println(c1.getCaja());
	    System.out.println(c2.getCaja());
		
	}

    
    

	 


	    

	}

