package Actividad1T1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import Actividad1T1.Producto;

public class Paginable<T extends Producto> {
	/**
	 * Productos por pagina
	 */
	private int productoPagina = 3;

	private List<T> l;

	/*
	 * Defino el tipo de lista que voy a usar
	 */
	public Paginable() {
		l = new ArrayList<T>();
	}
	
	/**
	 * Metodo para añadir productos
	 * @param producto producto a añadir
	 */
	public void add(T producto) {
		l.add(producto);
	}
	
	public void remove(T producto) {
		
		l.remove(productoPagina);
		
	}
	
	public boolean contains(T Producto) {
		
		
		return l.contains(Producto);
	}
	
	public int size() {
		
	
		
		return l.size();
		
	}
	
	public int getTotal() {
		
		return l.size()/productoPagina +  (l.size()%productoPagina != 0? 1 : 0);
		
	}
	
	public void mostrar() {
		
		for(Producto p : l) {
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Valor: " + p.getPrecio());
		}
	}
	
	public int getPage(int index) {
		if(index > l.size()) {
			
			return -1;
			
		}else {
			
			return index//conseguir el total de paginas y redondear hacia arriba 
			
		}
	}
	
	
	/**
	 * 
	 * 
	 * 		metodos 
	 * 
	 * 
	 * 
	 * getPage(int index)
	 * 
	 * 
	 *
	 */
}
