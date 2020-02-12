package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tipos {
	private int id;
	private String nombre;
	public Tipos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Tipos() {
		super();
	}
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
