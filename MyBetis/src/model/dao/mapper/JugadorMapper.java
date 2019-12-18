package model.dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import model.entidad.*;

public interface JugadorMapper {
 
	/**
	 * Obtiene un usuario existente o null en caso contrario.
	 * @param user Nombre de usuario a buscar.
	 * @param pass Password del usuario a buscar.
	 * @return Un usuario si existe en base de datos o null en caso contrario.
	 */
	public Jugador existeUsuario(@Param("nombre") String nombre);
 
	/**
	 * Obtiene una lista de todos los usuarios.
	 * @return Una lista de usuarios existentes.
	 */
	public ArrayList<Jugador> getJugadores();
	
	/**
	 * Inserta un usuario en base de datos.
	 * @param usuario El usuario a insertar.
	 */
	public void insertJugador(Jugador usuario);
	
	/**
	 * Actualiza los datos de un usuario
	 * @param usuario Los datos del ususario a actualizar
	 */
	public void updateJugador(Jugador usuario);
	
	/**
	 * Elimina un usuario en base de datos
	 * @param id El identificador del usuario
	 */
	public void deleteJugador(@Param("id") Integer id);

	/**
	 * Obtiene un usuario de base de datos
	 * @param identificador El identificador del usuario
	 * @return El usuario
	 */
	public Jugador getJugador(@Param("id") Integer id);
}