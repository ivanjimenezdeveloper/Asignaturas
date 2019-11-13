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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = request.getParameter("error");

		if (error != null) {
			response.sendRedirect("LoginERROR.html");

		} else {
			response.sendRedirect("Login.html");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		boolean encontrado = false;

		encontrado = query.Mantenimiento.UsuarioLogin(user, pass);

		if (encontrado == true) {
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("user", user);
			sesion.setAttribute("pass", pass);

			response.sendRedirect("Main");

		} else {
			response.sendRedirect("Login?error=1");
		}

	}

}
