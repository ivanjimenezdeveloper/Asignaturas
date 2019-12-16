package model.entidad;

import java.util.Date;

public class Calculo_Imc {
	private Calculo_ImcKey id;
	private UsuarioKey idUsuario;
	private Double peso;
	private Integer estatura;
	private Date fecha;

	public Calculo_Imc() {

	}

	public Calculo_Imc(Calculo_ImcKey id, UsuarioKey idUsuario, Double peso, Integer estatura, Date fecha) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.peso = peso;
		this.estatura = estatura;
		this.fecha = fecha;
	}

	public Calculo_ImcKey getId() {
		return id;
	}

	public void setId(Calculo_ImcKey id) {
		this.id = id;
	}

	public UsuarioKey getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UsuarioKey idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getEstatura() {
		return estatura;
	}

	public void setEstatura(Integer estatura) {
		this.estatura = estatura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
