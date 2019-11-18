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

	/**
	 * Contexto server
	 *  <Resource name="jdbc/GAMELAND" auth="Container"
            type="javax.sql.DataSource" maxActive="100" maxIdle="30"
            maxWait="10000" username="gamelandIvan" password="Ageofempires2"
            driverClassName="com.mysql.cj.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/GAMELAND?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"/>
	 */
	
	/**
	 * Muestra la pagina de busqueda 
	 */
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
		
		/**
		 * Si esta logged muestra la pagina para usuarios loggeados y si no la busqueda normal
		 */
		if(logged) {
			
			response.getWriter()
			.print(mostrarLogged(user));			
		}else {
			
			response.sendRedirect("MainNoLogged.html");
		}
		
		

	}
	
	/**
	 * Devuelve el string del html personalizado para el usuario
	 * @param user Nick de usuario
	 * @return html personalizado de busqueda
	 */
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
				"            <form method=\"GET\" action=\"MostrarBusqueda\">\n" + 
				"                <input type=\"text\" placeholder=\"Buscar\" name=\"busqueda\"/>\n" + 
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
	



}
