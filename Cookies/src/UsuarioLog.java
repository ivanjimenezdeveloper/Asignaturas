
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioLog
 */
@WebServlet("/UsuarioLog")
public class UsuarioLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioLog() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = request.getParameter("error");
		PrintWriter out;
		
		response.setContentType("text/html");
		
		out = response.getWriter();
		
		out.append("<form method='POST' action='UsuarioLog'>")
		.append("<p>USUARIO</p>")
		.append("<input type='text' name='usuario'>")
		.append("<p>Contrasenia</p>")
		.append("<input type='password' name='pass'>")
		.append("<input type='submit' value='Log In'>")
		.append("</form>");
		
		if(error != null) {
			out.append("<p>ERROR KRITICO</p>");
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
	
	if(usuario != null && password != null && usuario.equals("ivan")) {
		Cookie c = new Cookie("usuario", usuario);
		response.addCookie(c);
		response.sendRedirect("Sesion");
	}else {
		response.sendRedirect("UsuarioLog?error=1");
	}
	
	
	
	}

}
