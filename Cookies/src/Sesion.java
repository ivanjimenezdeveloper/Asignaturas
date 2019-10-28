

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter out;
	private String user;
	private String passwd;
	
	private final String USERFINAL = "ricardo";
	private final String PASSWDFINAL = "milos";
    /**
     * Default constructor. 
     */
    public Sesion() {
            }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		
		out.append("<html>")
		.append("<body><h1>HOLA USUARIO DESCONOCIDO</h1>")
		.append("<form method='POST' action='Sesion'>")
		.append("<p>USUARIO</p><input type='text' name='usuario'>")
		.append("<p>CONTRASENIA</p><input type='text' name='passwd'> ")
		.append("<button>DALE</button>")
		.append("</form>")
		.append("</body></html>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	user = request.getParameter("usuario");
	passwd = request.getParameter("passwd");
	out.flush();

	if(!user.equals(user) && !passwd.equals(passwd)) {
		
		
		out.append("<html>")
		.append("<body><h1>HOLA USUARIO DESCONOCIDO</h1>")
		.append("<form method='POST' action='Sesion'>")
		.append("<p>USUARIO</p><input type='text' name='usuario'>")
		.append("<p>CONTRASENIA</p><input type='text' name='passwd'>")
		.append("<button>DALE</button>")
		.append("USUARIO NO ENCONTRADO")
		.append("</form>")
		.append("</body></html>");
		
		
	}else {
		out.append("<html>")
		.append("<body><h1>HOLA USUARIO DESCONOCIDO</h1>")
		.append("<form method='POST' action='Sesion'>")
		.append("<p>USUARIO</p><input type='text' name='usuario'>")
		.append("<p>CONTRASENIA</p><input type='text' name='passwd'> ")
		.append("<button>DALE</button>")
		.append("FUNCIONA")
		.append("</form>")
		.append("</body></html>");
	}
	
	}

}
