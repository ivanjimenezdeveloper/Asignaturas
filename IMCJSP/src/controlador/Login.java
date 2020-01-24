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


@WebServlet("/Login")
/**
 * Logea al usuario
 * @author HIBAN
 *
 */
public class Login extends HttpServlet {
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

	/**
	 * Logea al usuario si es correcto o deslogea
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);

		Usuario user = new Usuario();
		String error = request.getParameter("error");
		String logout = request.getParameter("logout");
		user = sesionEJB.usuarioLogeado(sesion);
		
		
		if (logout != null) {
			sesionEJB.logoutUsuario(sesion);
			response.sendRedirect("Main");
		} else {
			if (error != null) {
				response.sendRedirect("LoginERROR.jsp");
			} else {
				if (user != null) {
					response.sendRedirect("Main");
				} else {
					response.sendRedirect("Login.jsp");
				}
			}
		}

	}

	/**
	 * hace las operaciones de login
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Coge los parametros de usuario y password
		String usuario = request.getParameter("user");
		String pass = request.getParameter("pass");

		Usuario user = new Usuario();
		HttpSession sesion = request.getSession(true);

		user = sesionEJB.usuarioLogeado(sesion);

		if (user == null) {
			user = userEJB.existeUsuario(usuario, pass);

			if (user == null || user.getCorreo() == null) {
				response.sendRedirect("Login?error=1");
			} else {

				sesionEJB.loginUsuario(sesion, user);
				response.sendRedirect("Main");
			}
		} else {
			response.sendRedirect("Main");
		}

	}

}
