package Actividad2T1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import Actividad2T1.Producto;

public class Paginable<T extends Producto> {
	/**
	 * Productos por pagina
	 */
	private int productoPagina = 3;

	private Map<Integer, T> l;

	/**
	 * Creo una lista para poder ordenar y paginar
	 */
	private List<T> lista;
	/*
	 * Defino el tipo de lista que voy a usar
	 */

	public Paginable() {
		l = new Hashtable<Integer, T>();

		lista = new ArrayList<T>();

	}

	/**
	 * Vacia la arraylist y la rellena
	 */
	private void paginar() {
		lista.clear();
		l.forEach((k, v) -> {
			lista.add(v);
		});
	}

	/**
	 * Metodo para añadir productos
	 * 
	 * @param producto producto a añadir
	 */

	public void add(T producto) {
		l.put(producto.getId(), producto);
	}

	/**
	 * Segun el indice dado recibe el objeto buscado
	 * 
	 * @param indice
	 * @return Producto con el indice correspondiente
	 */

	public Producto get(int indice) {

		return lista.get(indice);

	}

	/**
	 * Borra un producto en la lista
	 * 
	 * @param producto producto a borrar
	 */

	public void remove(T producto) {

		l.remove(producto);

	}

	/**
	 * Boolean que detecta si existe o no el producto
	 * 
	 * @param Producto producto a comprobar su existencia
	 * @return devuelve el valor boolean
	 */

	public boolean contains(T Producto) {

		return l.containsValue(Producto);
	}

	/**
	 * Metodo para conocer el tamaño de la lista
	 * 
	 * @return devuelve el valor int del tamaño de la lista
	 */

	public int size() {

		return l.size();

	}

	/**
	 * Encuentra la cantidad de paginas que tiene la lista segun los productos por
	 * pagina y el tamaño de la misma
	 * 
	 * @return devuelve la cantidad de paginas totales en la lista
	 */

	public int getTotal() {

		return l.size() / productoPagina + (l.size() % productoPagina != 0 ? 1 : 0);

	}

	/**
	 * Segun el metodo comparable de Producto ordenara la lista
	 */

	public void ordenar() {

		Collections.sort(lista);

	}

	/**
	 * Devuelve la array de la pagina en la que se encuentra el indice
	 * 
	 * @param pagina Pagina
	 * @return Array devuelta
	 */

	public ArrayList<T> getPage(int index) {

		paginar();

		ArrayList<T> objetos = new ArrayList<T>();
		int indiceInicial = index * productoPagina - productoPagina;
		int indiceFinal = index * productoPagina;
		if (index > this.getTotal() || index <= 0) {

			return null;

		} else {

			for (int i = indiceInicial; i < indiceFinal; i++) {
				if (i == l.size()) {
					break;
				}

				objetos.add(lista.get(i));

			}

		}
		return objetos;

	}

	/**
	 * Devuelve la pagina en la que se encuentra el producto
	 * 
	 * @param e producto a buscar
	 * @return numero de pagina
	 */

	public int getPage(Producto e) {

		paginar();

		for (int indice = 0; indice < l.size(); indice++) {

			if (lista.get(indice).equals(e)) {
				indice++;
				double x = (double) indice / (double) productoPagina;

				return (int) Math.ceil(x);
			}

		}

		return -1;

	}

}
