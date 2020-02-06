package model.entidad.dao.mapper;

import org.apache.ibatis.annotations.Param;

import model.entidad.Estadisticas;

public interface EstadisticasMapper {
	
	public Estadisticas estadisticasJugador(@Param("id") Integer id);
	public void cambiarEstadisticas(@Param("puntos") Integer puntos,
			@Param("partidosJ") Integer partidosJugados,
			@Param("tirosCampo") Integer tirosCampo,
			@Param("triples") Integer triples,
			@Param("tirosLibres") Integer tirosLibres,
			@Param("id") Integer id);
}
