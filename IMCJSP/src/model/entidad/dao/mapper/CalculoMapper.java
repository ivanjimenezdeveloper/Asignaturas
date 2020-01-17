package model.entidad.dao.mapper;

import org.apache.ibatis.annotations.Param;

public interface CalculoMapper {
	public void guardarCalculo(@Param("id") int id, @Param("peso") Double peso, @Param("estatura") Integer estatura, @Param("fecha") String fecha);
}
