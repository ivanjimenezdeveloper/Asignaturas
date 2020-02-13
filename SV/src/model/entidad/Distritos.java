package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Distritos {
	private int id;
	private String nombre;
	/**
	 * Constructor
	 * @param id id del distrito
	 * @param nombre nombre del distrito
	 */
	public Distritos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	/**
	 * Constructor vacio
	 */
	public Distritos() {
		super();
	}
	
	//Getters y setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
