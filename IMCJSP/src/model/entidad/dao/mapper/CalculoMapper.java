package model.entidad.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.entidad.Calculo_Imc;

public interface CalculoMapper {
	public void guardarCalculo(@Param("id") int id, @Param("peso") Double peso, @Param("estatura") Integer estatura, @Param("fecha") String fecha);
		
	public ArrayList<Calculo_Imc> getCalculosUsuario(@Param("key") Integer key);


}
