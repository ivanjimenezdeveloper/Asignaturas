package model.entidad.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Tipos;

public interface AccidentesMapper {

	public ArrayList<Accidente> busquedaGeneral();

	public Tipos TipoPorId(@Param("id") int id);

	public Accidente getAccidente(@Param("id") int id);

	public Distritos distritoPorId(@Param("id") int id);

	public ArrayList<Estadisticas> getEstadisticas();

	public ArrayList<Accidente> busquedaAccidente(@Param("tipo") String tipo, @Param("fecha") String fecha);

	public ArrayList<Accidente> busquedaAccidenteDespues(@Param("tipo") String tipo, @Param("fecha") String fecha);

	public ArrayList<Tipos> getTipos();

	public ArrayList<Distritos> busquedaGeneralDistritos();

	public ArrayList<Tipos> busquedaGeneralTipos();

}
