package Actividad1T1;

import java.util.ArrayList;

public class Producto implements Comparable<Producto> {
	private Integer id;
	private Double precio;
	private String nombre;

//Constructor
	public Producto(Integer id, Double precio, String nombre) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;

	}
	
	public static void mostrarArray(ArrayList<Producto> lista) {
		for(Producto p : lista) {
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Precio: " +	p.getPrecio());
		}
	}

//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que compara los productos segun su precio
	 */
	@Override
	public int compareTo(Producto e) {

		if (this.precio > e.getPrecio()) {

			return 1;

		} else if (this.precio < e.getPrecio()) {
			
			return 0;
			
		}

		return -1;
	}

}
