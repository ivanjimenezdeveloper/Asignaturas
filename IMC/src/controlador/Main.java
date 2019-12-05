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
