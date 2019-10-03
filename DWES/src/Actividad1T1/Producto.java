package Actividad1T1;

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
	public int compareTo(Producto e) {
//Este metodo me compara los precios de los productos
		if (this.precio > e.getPrecio()) {

			return 1;

		} else if (this.precio < e.getPrecio()) {
			
			return 0;
			
		}

		return -1;
	}

}
