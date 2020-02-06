package model.entidad;

public class Estadisticas {
	private Integer id;
	private Integer idJugador;
	private Integer puntos;
	private Integer partidosJugados;
	private Integer triples;
	private Integer tirosLibres;
	private Integer tirosCampo;
	public Estadisticas(Integer id, Integer idJugador, Integer puntos, Integer partidosJugados, Integer triples,
			Integer tirosLibres, Integer tirosCampo) {
		super();
		this.id = id;
		this.idJugador = idJugador;
		this.puntos = puntos;
		this.partidosJugados = partidosJugados;
		this.triples = triples;
		this.tirosLibres = tirosLibres;
		this.tirosCampo = tirosCampo;
	}
	public Estadisticas() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	public Integer getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(Integer partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	public Integer getTriples() {
		return triples;
	}
	public void setTriples(Integer triples) {
		this.triples = triples;
	}
	public Integer getTirosLibres() {
		return tirosLibres;
	}
	public void setTirosLibres(Integer tirosLibres) {
		this.tirosLibres = tirosLibres;
	}
	public Integer getTirosCampo() {
		return tirosCampo;
	}
	public void setTirosCampo(Integer tirosCampo) {
		this.tirosCampo = tirosCampo;
	}

	
	
	
	
}
