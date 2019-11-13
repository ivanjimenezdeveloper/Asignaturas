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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoge el parametro error
		String error = request.getParameter("error");

		// Si hay un error redirige al formulario con error en caso contrario redirige
		// al formulario normal
		if (error != null) {

			response.sendRedirect("RegisterERROR.html");

		} else {
			response.sendRedirect("Register.html");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean existe = false;
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
		String img = request.getParameter("img");

		existe = query.Mantenimiento.UsuarioExiste(user);

		if (user.length() == 0 || pass.length() == 0 || nombre.length() == 0 || existe == true) {
			response.sendRedirect("Register?error=1");
		} else {
			boolean correcto = false;

			correcto = query.CRUD.registroUsuario(nombre, user, pass, img);

			if (correcto == false) {
				response.sendRedirect("Register?error=1");

			} else {
				response.sendRedirect("Login");
			}
		}

	}

}
