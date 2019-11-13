package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Main() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean logged = false;
		String user = "";
		
		
		/**
		 * Creamos la sesion
		 */
		HttpSession sesion = request.getSession(true);
		
		/**
		 * Coge el atributo usuario de la sesion
		 */
		user = (String) sesion.getAttribute("user");
		
		/**
		 * Si encuentra hay algo que se guarde en user significa que
		 * hay un usuario Logged
		 */
		if(user != null && !user.contentEquals("")) {
			logged = true;
		}
		
		if(logged) {
			
			response.getWriter()
			.print(mostrarLogged(user));			
		}else {
			
			response.sendRedirect("MainNoLogged.html");
		}
		
		

	}
	
	
	public String mostrarLogged(String user) {
		
		String html = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"    <head>\n" + 
				"        <title>Gameland</title>\n" + 
				"        <meta charset=\"UTF-8\">\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"        <link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\"/>\n" + 
				"\n" + 
				"    </head>\n" + 
				"    <body>\n" + 
				"        <div class=\"nav\">\n" + 
				"            <div class=\"header\">  \n" + 
				"                <div class=\"logoHeader\"></div><h1>Gameland</h1>\n" + 
				"                <div class=\"nodoInvisibleHeader\"></div>\n" + 
				"                <div class=\"usuario\">\n" + 
				"                    <div>\n" + 
				"                        <p class=\"nombreUsuario\">"+user+"</p> <a class=\"fotoUsuario\">imagen</a>\n" + 
				"                    </div>\n" + 
				"                    <div>            \n" + 
				"                        <a href=\"Logout\">Log Out</a> <p>" + 
				"                    </div>\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"            <div class=\"tab\">\n" + 
				"                <ul>\n" + 
				"                    <li><a href=\"Main\">SEARCH</a></li>\n" + 
				"                    <li><a href=\"#\">TOP Games</a></li>\n" + 
				"                    <li><a href=\"#\">By Genre</a></li>\n" + 
				"                    <li> |</li>\n" + 
				"                    <li><a href=\"#\">By Platform</a></li>\n" + 
				"                </ul>\n" + 
				"            </div>\n" + 
				"        </div>\n" + 
				"        <div class=\"container\">\n" + 
				"            <div class=\"logoMain\"></div>\n" + 
				"            <p>Gameland</p>\n" + 
				"            <form>\n" + 
				"                <input type=\"text\" placeholder=\"Buscar\"/>\n" + 
				"                <input type=\"submit\" value=\"Buscar\"/>\n" + 
				"            </form>\n" + 
				"        </div>\n" + 
				"        <div class=\"footer\">\n" + 
				"            <p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + 
				"        </div>\n" + 
				"    </body>\n" + 
				"</html>";
		
		return html;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
