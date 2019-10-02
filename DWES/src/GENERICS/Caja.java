package GENERICS;

import java.util.ArrayList;
import java.util.List;


public class Caja<E> {

	
	private E object;
	
	Caja(){
		this.object=null;
	}
	
//	public int tamany() {
//		return this.object.length();
//		
//	}
	
	public void setCaja(E object) {
		this.object = object;
	}
	
	public E getCaja() {
		return object;
	}


}
