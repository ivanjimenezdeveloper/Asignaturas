package model.entidad;

public class Equipo {
	private int id;
	private String nombre;
	private int anyi;
	private int anyf;
	private int idJugador;

	public Equipo(int id, String nombre, int anyoi, int anyof, int idJugador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anyi = anyoi;
		this.anyf = anyof;
		this.idJugador = idJugador;
	}
	public Equipo() {
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
	public int getAnyi() {
		return anyi;
	}
	public void setAnyi(int anyi) {
		this.anyi = anyi;
	}
	public int getAnyf() {
		return anyf;
	}
	public void setAnyf(int anyf) {
		this.anyf = anyf;
	}
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	
	

	

}
