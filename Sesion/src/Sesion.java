
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter out;


	/**
	 * Default constructor.
	 */
	public Sesion() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		out = response.getWriter();
		boolean logged = false;
		String user = "";

		HttpSession sesion = request.getSession(true);
		
		user = (String) sesion.getAttribute("usuario");
		
		if(user != null && !user.equals("")) {
			
			logged = true;

		}
		
//
//		if (ck != null) {
//			for (int i = 0; i < ck.length; i++) {
//
//				if (ck[i].getName().contentEquals("usuario")) {
//					logged = true;
//					user = ck[i].getValue();
//
//				}
//
//			}
//		}

		if (logged == true) {
			out.append("<html>")
					.append("<body><h1>HOLA USUARIO " + user + "</h1>")
					.append("<form method='GET' action='UsuarioLogOut'>")
					.append("<input type='submit' value='Log Out'>")
					.append("</form>")
					.append("</body></html>");

		} else {
			out.append("<html>")
					.append("<body><h1>HOLA USUARIO DESCONOCIDO</h1>")
					.append("<form method='GET' action='UsuarioLog'>")
					.append("<input type='submit' value='Log In'>")
					.append("</form>")
					.append("</body></html>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		user = request.getParameter("usuario");
//		passwd = request.getParameter("passwd");
//		out.flush();
//
//		if (!user.equals(user) && !passwd.equals(passwd)) {
//
//			out.append("<html>").append("<body><h1>HOLA USUARIO DESCONOCIDO</h1>")
//					.append("<form method='POST' action='Sesion'>")
//					.append("<p>USUARIO</p><input type='text' name='usuario'>")
//					.append("<p>CONTRASENIA</p><input type='text' name='passwd'>").append("<button>DALE</button>")
//					.append("USUARIO NO ENCONTRADO").append("</form>").append("</body></html>");
//
//		} else {
//			out.append("<html>").append("<body><h1>HOLA USUARIO DESCONOCIDO</h1>")
//					.append("<form method='POST' action='Sesion'>")
//					.append("<p>USUARIO</p><input type='text' name='usuario'>")
//					.append("<p>CONTRASENIA</p><input type='text' name='passwd'> ").append("<button>DALE</button>")
//					.append("FUNCIONA").append("</form>").append("</body></html>");
//		}

	}

}
