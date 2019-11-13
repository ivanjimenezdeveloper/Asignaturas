package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	/**
	 * Redirige al formulario correspondiente dependiedo de si ha habido errores o no
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Recoge el parametro error
		 */
		String error = request.getParameter("error");

		/**
		 * Si hay un error redirige al formulario con error en caso contrario redirige
		 * al formulario normal
		 * 
		 */
		if (error != null) {

			response.sendRedirect("RegisterERROR.html");

		} else {
			response.sendRedirect("Register.html");

		}
	}

	/**
	 * Registra al usuario
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean existe = false;
		/**
		 * Recoge los parametros
		 */
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
		String img = request.getParameter("img");

		/**
		 * Comprueba si ya existe un usuario con ese nombre
		 */
		existe = query.Mantenimiento.UsuarioExiste(user);

		/**
		 * Si existe el usuario o no ha rellenado algun campo recarga la pagina con un error
		 * en caso contrario continua con el registro
		 */
		if (user.length() == 0 || pass.length() == 0 || nombre.length() == 0 || existe == true) {
			response.sendRedirect("Register?error=1");
		} else {
			boolean correcto = false;

			/**
			 * Registra al usuario comprobando si ha podido hacer el registro
			 */
			correcto = query.CRUD.registroUsuario(nombre, user, pass, img);

			/**
			 * Si ha podido registrarlo Redirige al login y si no recarga la pagina con un error
			 */
			if (correcto == false) {
				response.sendRedirect("Register?error=1");

			} else {
				response.sendRedirect("Login");
			}
		}

	}

}
