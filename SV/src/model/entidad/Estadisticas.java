package model.entidad;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estadisticas {
	private String distrito, tipo;
	private Integer cantidad;
	/**
	 * Constructro de estadisticas
	 * @param distrito nombre del distrito
	 * @param tipo Nombre de tipo
	 * @param cantidad Cantidad de accidentes
	 */
	public Estadisticas(String distrito, String tipo, Integer cantidad) {
		super();
		this.distrito = distrito;
		this.tipo = tipo;
		this.cantidad = cantidad;
	}
	/**
	 * Constructor vacio
	 */
	public Estadisticas() {
		super();
	}
	
	//Getters y setters
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
