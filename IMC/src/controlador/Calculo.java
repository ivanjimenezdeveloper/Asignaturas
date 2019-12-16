package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.CalculoEJB;
import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.entidad.Usuario;
import vista.Cabecera;
import vista.Footer;
import vista.Nav;

/**
 * Servlet implementation class Calculo
 */
@WebServlet("/Calculo")
public class Calculo extends HttpServlet {
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

	@EJB
	CalculoEJB calculoEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		// Obtenemos el usuario de la sesion si existe
		Usuario user = sesionEJB.usuarioLogeado(sesion);

		Double peso = 0.0;
		Double estatura = 0.0;
		String guardar = null;
		try {
			estatura = Double.parseDouble(request.getParameter("estatura"));
			peso = Double.parseDouble(request.getParameter("peso"));
			guardar = request.getParameter("guardar");

		} catch (Exception e) {
			// TODO: handle exception
		}

		Double resultado = calculoEJB.calcularIMC(peso, estatura);

		if (user != null) {
			Cabecera.mostrarLogged(response.getWriter(), user);
			if (!guardar.equals("n")) {
				calculoEJB.guardarCalculo(peso, estatura.intValue(), user);
			}
		} else {
			Cabecera.mostrarNoLogged(response.getWriter());
		}

		Nav.mostrar(response.getWriter());
		vista.container.Calculo.mostrar(response.getWriter(), resultado);
		Footer.mostrar(response.getWriter());

	}

}
