package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.ControlEJB;
import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.ejb.VerificacionEJB;
import model.entidad.Usuario;

/**
 * Servlet para borrar la cuenta
 * @author HIBAN
 *
 */
@WebServlet("/BorrarCuenta")
public class BorrarCuenta extends HttpServlet {
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
	VerificacionEJB verificacionEJB;
	
	@EJB
	ControlEJB controlEJB;

	/**
	 * borra la cuenta
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ver = false;

		HttpSession sesion = request.getSession(true);

		// Obtenemos el usuario de la sesion si existe
		Usuario user = sesionEJB.usuarioLogeado(sesion);
		if (user != null) {
			ver = verificacionEJB.usuarioVerificado(user);

		}

		if (user != null && ver == false) {

			response.sendRedirect("Main");

		} else if (user != null) {
			userEJB.borrarUsuario(user);
			controlEJB.insertarBaja();

			response.sendRedirect("Login?logout=1");


		} else {
			response.sendRedirect("MainNoLogged.jsp");
		}
	}

}
