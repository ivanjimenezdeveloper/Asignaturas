package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
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

			response.sendRedirect("FormularioRegisterERROR.html");

		} else {
			response.sendRedirect("FormularioRegister.html");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean existe = false;
		// Recoge los parametros para hacer el registro

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
//		String img = request.getParameter("img");

		try {

			existe = Queries.UsuarioExiste(usuario);
		} catch (SQLException e1) {
		}

		if (usuario.length() == 0 || password.length() == 0 || nombre.length() == 0 || existe == true) {
			response.sendRedirect("Register?error=1");
		} else {

			boolean correcto = false;

			try {
				correcto = CRUD.registroUsuario(nombre, usuario, password, "prueba");

			} catch (SQLException e) {

				e.printStackTrace();
			}

			// Si se registra correctamente redirige al log y en caso contrario recarga la
			// pagina con un error
			if (correcto == true) {
				response.sendRedirect("LogIn");

			} else {
				response.sendRedirect("Register?error=1");
			}

		}

	}

}
