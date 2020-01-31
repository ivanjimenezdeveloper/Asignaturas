package model.entidad.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.entidad.Equipo;

public interface EquipoMapper {
	public ArrayList<Equipo> busquedaPorJugador(@Param("id") Integer id);

}
