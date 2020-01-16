package model.entidad.dao.mapper;

import model.entidad.Usuario;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;


public interface UsuarioMapper {

	public Usuario existeUsuario(@Param("correo") String correo, @Param("pass") String pass);
	
	public boolean existeUsuario2(@Param("correo") String correo);
	
	public void registrarUsuario(Usuario user);
	
	public void borrarUsuario(@Param("id") Integer id);

	public ArrayList<Usuario> busquedaGeneral();
}
