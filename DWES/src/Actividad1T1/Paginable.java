package Actividad1T1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
	
	/**
	 * Borra un producto en la lista
	 * @param producto producto a borrar
	 */
	
	public void remove(T producto) {
		
		l.remove(productoPagina);
		
	}
	
	/**
	 *  Boolean que detecta si existe o no el producto
	 * @param Producto producto a comprobar su existencia
	 * @return devuelve el valor boolean
	 */
	
	public boolean contains(T Producto) {
		
		
		return l.contains(Producto);
	}
	
	
	/**
	 * Metodo para conocer el tamaño de la lista
	 * @return devuelve el valor int del tamaño de la lista
	 */
	
	public int size() {
		
		return l.size();
		
	}
	
	
	/**
	 * Encuentra la cantidad de paginas que tiene la lista segun
	 * los productos por pagina y el tamaño de la misma
	 * @return devuelve la cantidad de paginas totales en la lista
	 */
	
	public int getTotal() {
		
		return l.size()/productoPagina +  (l.size()%productoPagina != 0? 1 : 0);
		
	}

	
//	public void getPage(int index) {
//
//		int indiceInicial = index*productoPagina-productoPagina;
//		int indiceFinal = index*productoPagina;
//		if(index > this.getTotal() || index <= 0 ) {
//			
//			System.out.println("Excede el numero de páginas totales"
//					+ " o es un numero menor o igual a 0");
//			
//		}else {
//			
//			for(int i =indiceInicial; i < indiceFinal; i++) {
//				if(i == l.size()) {
//					break;
//				}
//				System.out.println("Nombre: " + l.get(i).getNombre());
//				System.out.println("Precio: " +	l.get(i).getPrecio());
//				System.out.println(i);
//				
//			}
//			
//		}
//		
//		
//	}
	
	public ArrayList<T> getPage(int index) {

		ArrayList<T> objetos = new ArrayList<T>();
		int indiceInicial = index*productoPagina-productoPagina;
		int indiceFinal = index*productoPagina;
		if(index > this.getTotal() || index <= 0 ) {
			
			System.out.println("Excede el numero de páginas totales"
					+ " o es un numero menor o igual a 0");
			
		}else {
			
			for(int i =indiceInicial; i < indiceFinal; i++) {
				if(i == l.size()) {
					break;
				}
				System.out.println("Nombre: " + l.get(i).getNombre());
				System.out.println("Precio: " +	l.get(i).getPrecio());
//				System.out.println(i);
				
				objetos.add(l.get(i));
				
			}
			
		}
		return objetos;
		
		
	}
	
	
	
	/**
	 * 
	 * Collections.sort(l);
	 * 		metodos 
	 * 
	 * 
	 * 
	 * getPage(int index)
	 * Ordenar la lista
	 * metodo para segun un objeto conseguir la pagina
	 *
	 */
}
