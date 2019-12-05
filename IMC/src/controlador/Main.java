package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vista.cabecera.*;
import vista.container.Container;
import vista.footer.Footer;
import vista.nav.Nav;
import model.entidad.usuario.Usuario;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * TENER UN TOMEE VERSION 9
		 * <Resource name="jdbc/IMC" auth="Container" type="javax.sql.DataSource"
		 * maxActive="100" maxIdle="30" maxWait="10000" username="imcivan" password=
		 * "Ageofempires2" driverClassName="com.mysql.cj.jdbc.Driver" url=
		 * "jdbc:mysql://localhost:3306/IMC?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC&amp;useSSL=FALSE"
		 * />
		 */
		Usuario us = new Usuario();
		us.setCorreo("EL CORREO");
		Cabecera.mostrarLogged(response.getWriter(), us);
		Nav.mostrar(response.getWriter());
		Container.mostrar(response.getWriter());
		Footer.mostrar(response.getWriter());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
