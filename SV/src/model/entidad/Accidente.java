package model.entidad;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Accidente {
	private Integer id,id_distrito,id_tipo_accidente;
	private String expediente, direccion, tipo_vehiculo, tipo_persona, sexo, lesividad;
	private Date fecha;
	


	public Accidente(Integer id, Integer id_distrito, Integer id_tipo_accidente, String expediente, String direccion,
			String tipo_vehiculo, String tipo_persona, String sexo, String lesividad, Date fecha) {
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

	public Accidente() {
		super();
	}

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

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public String getTipo_persona() {
		return tipo_persona;
	}

	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
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
