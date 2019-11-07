
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoge el parametro error
		String error = request.getParameter("error");
		PrintWriter out;

		// Si hay un error redirige al formulario con error en caso contrario redirige
		// al formulario normal
		if (error != null) {

			response.sendRedirect("FormularioLogInERROR.html");

		} else {
			response.sendRedirect("FormularioLogIn.html");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoge el usuario y la contraseña
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		boolean encontrado = false;
		try {
			// Recoge el valor dado de la querie para saber si existe el usuario
			encontrado = Queries.hipotecaContains(usuario, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// En caso de encontrar un usuario con su contraseña guarda los atributos y reenvia al main
		// en caso contrario vuelve al servlet con un error
		if (usuario != null && password != null && encontrado == true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			session.setAttribute("password", password);

			response.sendRedirect("Main");
		} else {
			response.sendRedirect("LogIn?error=1");
		}

	}

}
