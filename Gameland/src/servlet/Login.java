package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	/**
	 * Comprueba si hay errores y redirige al html correspondiente
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Si encuentra algun error redirige al formulario de login con error en caso
		 * contrario al login normal
		 */
		String error = request.getParameter("error");

		if (error != null) {
			response.sendRedirect("LoginERROR.html");

		} else {
			response.sendRedirect("Login.html");

		}
	}

	/**
	 * Actualiza el usuario y pasa a ponerlo logged
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Coge los parametros de usuario y contraseña

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		boolean encontrado = false;

		// Comprueba si existe esa combinacion de usuario y contraseña

		encontrado = query.Mantenimiento.UsuarioLogin(user, pass);

		/*
		 * Si existe el usuario entonces guarda en la sesion el nombre de usuario y
		 * contraseña y redirige al main
		 */
		
		if (encontrado == true) {
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("user", user);
			sesion.setAttribute("pass", pass);

			response.sendRedirect("Main");

		}

		// En caso de no encontrar al usuario recarga la pagina con un error

		else {
			response.sendRedirect("Login?error=1");
		}

	}

}
