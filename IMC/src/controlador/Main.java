package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.entidad.Usuario;
import vista.*;
import vista.container.Principal;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * EJB para trabajar con usuarios
	 */
	@EJB
	UsuarioEJB userEJB;

	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	Sesiones sesionEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * TENER UN TOMEE VERSION 9 <Resource name="jdbc/IMC" auth="Container"
		 * type="javax.sql.DataSource" maxActive="100" maxIdle="30" maxWait="10000"
		 * username="imcivan" password= "Ageofempires2"
		 * driverClassName="com.mysql.cj.jdbc.Driver" url=
		 * "jdbc:mysql://localhost:3306/IMC?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC&amp;useSSL=FALSE"
		 * />
		 */

		HttpSession sesion = request.getSession(true);

		// Obtenemos el usuario de la sesion si existe
		Usuario user = sesionEJB.usuarioLogeado(sesion);
		if (user != null) {
			Cabecera.mostrarLogged(response.getWriter(), user);
			Nav.mostrar(response.getWriter());
			Principal.mostrar(response.getWriter());
			Footer.mostrar(response.getWriter());

		}else {
			response.sendRedirect("MainNoLogged.html");
		}


	}

}
