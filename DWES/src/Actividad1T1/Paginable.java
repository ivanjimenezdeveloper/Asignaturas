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
		
	}
	
	public Producto contains(int index) {
		
		return null;
	}
	
	public void mostrar() {
		
		for(Producto p : l) {
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Valor: " + p.getPrecio());
		}
	}
	
	
	/**
	 * int productoPagina
	 * 
	 * 		metodos 
	 * add
	 * remove
	 * contains
	 * getPage(int index)
	 * int getTotal()
	 * size
	 *
	 */
}
