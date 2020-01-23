package model.entidad.dao.mapper;

import org.apache.ibatis.annotations.Param;

public interface VerificacionMapper {
	
	public void crearVerificacion(@Param("idusuario") int idUsuario, @Param("codigo") int codigo,
			@Param("verificacion") int verificado );
	
	public boolean existeCodigo(@Param("codigo") int codigo);
	
	
	public void borrarVerificacionesExistentes(@Param("idUsuario") int id);
	
	public int usuarioVerificado(@Param("idUsuario") int id);

}
