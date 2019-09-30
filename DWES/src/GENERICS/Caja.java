package GENERICS;

import java.util.ArrayList;
import java.util.List;


public class Caja<E extends String> {
	
	List <String> lista = new ArrayList<String>();

	
	private E object;
	Caja(){
		this.object=null;
	}
	
	public int tamany() {
		return this.object.length();
		
	}
	public E getCaja() {
		return this.object;
	}


}
