package model.entidad;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Accidente {
	private Integer id,id_distrito,id_tipo_accidente, tipo_vehiculo, tipo_persona;
	private String expediente, direccion,  sexo, lesividad;
	private Date fecha;
	

	/**
	 * Constructor de accidentes
	 * @param id id del accidente
	 * @param id_distrito id del distrito
	 * @param id_tipo_accidente id del tipo de accidente
	 * @param expediente numero de expediente
	 * @param direccion direccion donde ocurrio el accidente
	 * @param tipo_vehiculo id del tipo de vehiculo
	 * @param tipo_persona id de tipo de persona
	 * @param sexo id tipo de sexo
	 * @param lesividad lesividad
	 * @param fecha fecha del accidente
	 */
	public Accidente(Integer id, Integer id_distrito, Integer id_tipo_accidente, String expediente, String direccion,
			Integer tipo_vehiculo, Integer tipo_persona, String sexo, String lesividad, Date fecha) {
		super();
		this.id = id;
		this.id_distrito = id_distrito;
		this.id_tipo_accidente = id_tipo_accidente;
		this.expediente = expediente;
		this.direccion = direccion;
		this.tipo_vehiculo = tipo_vehiculo;
		this.tipo_persona = tipo_persona;
		this.sexo = sexo;
		this.lesividad = lesividad;
		this.fecha = fecha;
	}

	/**
	 * Constructor vacio
	 */
	public Accidente() {
		super();
	}
	
	//Getters y setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(Integer id_distrito) {
		this.id_distrito = id_distrito;
	}

	public Integer getId_tipo_accidente() {
		return id_tipo_accidente;
	}

	public void setId_tipo_accidente(Integer id_tipo_accidente) {
		this.id_tipo_accidente = id_tipo_accidente;
	}

	public Integer getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(Integer tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public Integer getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(Integer tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLesividad() {
		return lesividad;
	}

	public void setLesividad(String lesividad) {
		this.lesividad = lesividad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
	
}
