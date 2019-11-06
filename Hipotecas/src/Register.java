
import java.io.IOException;
import java.sql.SQLException;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = request.getParameter("error");

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
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
//		String img = request.getParameter("img");

		boolean correcto = false;

		try {
			correcto = CRUD.registroUsuario(nombre, usuario, password, "prueba");

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (correcto == true) {
			response.sendRedirect("LogIn");

		}else {
			response.sendRedirect("Register?error=1");
		}

	}

}
