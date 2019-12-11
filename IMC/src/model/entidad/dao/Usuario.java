package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Conexion;

public class Usuario {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;


	/**
	 * Busca todos los usuarios
	 * @return Arraylist de usuarios
	 */
	public static ArrayList<model.entidad.Usuario> busquedaGeneral() {

		/*
		 * Arraylist que devuelve la arraylist de usuarios
		 * set
		 */
		ArrayList<model.entidad.Usuario> usArr = new ArrayList<model.entidad.Usuario>();
		model.entidad.Usuario us = new model.entidad.Usuario();
		model.entidad.UsuarioKey usKey = new model.entidad.UsuarioKey();

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

}
