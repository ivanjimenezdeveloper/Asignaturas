package Actividad1T1;

public class Producto<T> implements Comparable<T> {
	private	Integer id;
	private Double precio;
	private String nombre;

//Constructor
	public Producto(int id, double precio, String nombre) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
		
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

	@Override
	public int compareTo(T arg0) {
		
		
		
		
		return 0;
	}

}
