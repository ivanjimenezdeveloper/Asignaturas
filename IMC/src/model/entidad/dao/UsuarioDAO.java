package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Conexion;
import model.entidad.Usuario;
import model.entidad.UsuarioKey;

public class UsuarioDAO {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;

	/**
	 * Busca todos los usuarios
	 * 
	 * @return Arraylist de usuarios
	 */
	public ArrayList<Usuario> busquedaGeneral() {

		/*
		 * Arraylist que devuelve la arraylist de usuarios set
		 */
		ArrayList<Usuario> usArr = new ArrayList<Usuario>();
		Usuario us = new Usuario();
		UsuarioKey usKey = new UsuarioKey();

		// Se crea la conexion con la base de datos

		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

//			  Query que busca a todos los usuarios

			String query = "SELECT * FROM USUARIO";
			ps = cn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

//				  Guarda los parametros 

				usKey.setKey(rs.getInt("ID"));
				us.setKey(usKey);
				us.setNombre(rs.getString("NOMBRE"));
				us.setCorreo(rs.getString("CORREO"));
				us.setPass(rs.getString("PASS"));

				// Guarda el objeto game en la array

				usArr.add(us);

				// Reinicia el objeto game

				us = new model.entidad.Usuario();

			}

		} catch (SQLException e) {
			// Logger

			e.printStackTrace();
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				// Logger
				e.printStackTrace();

			}

		}

		return usArr;

	}

	/**
	 * Comprueba la exitencia del usuario en combinacion con su password
	 * 
	 * @param user Correo a comprobar
	 * @param pass Password a comprobar
	 * @return Usuario completo encontrado
	 */
	public Usuario existeUsuario(String user, String pass) {

		Usuario us = new Usuario();
		UsuarioKey usKey = new UsuarioKey();

		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

//			  Query que busca al usuario con determinado correo y contraseña

			String query = "SELECT * FROM USUARIO WHERE CORREO = ? AND PASS = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			while (rs.next()) {
				usKey.setKey(rs.getInt("ID"));

				us.setKey(usKey);
				us.setCorreo(rs.getString("CORREO"));
				us.setNombre(rs.getString("NOMBRE"));
				us.setPass(rs.getString("PASS"));
			}

		} catch (Exception e) {
			// TODO: LOGGER
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				// TODO LOGGER
				e.printStackTrace();
			}

		}
		return us;

	}

	/**
	 * Comprueba si existe el correo marcado en la base de datos
	 * 
	 * @param user Correo a comprobar
	 * @return boolean que determina la existencia del correo en la base de datos
	 */
	public boolean existeUsuario(String user) {

		boolean existe = false;
		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

//			  Query que busca al usuario con determinado correo y contraseña

			String query = "SELECT * FROM USUARIO WHERE CORREO = ? ";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();

			while (rs.next()) {

				existe = true;
			}

		} catch (Exception e) {
			// TODO: LOGGER
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				// TODO LOGGER
				e.printStackTrace();
			}

		}
		return existe;

	}

}
