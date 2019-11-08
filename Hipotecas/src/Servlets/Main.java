package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Main.class);	


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
		logger.debug("nose");
		try {
			out = response.getWriter();
		} catch (IOException e1) {

			logger.warn(e1.getMessage());
			logger.debug(e1.getMessage());
			logger.debug("prueba");
			
		}
		boolean logged = false;
		String user = "";
		
		//Crea la sesion
		HttpSession sesion = request.getSession(true);

		//Coge el atributo de la sesion usuario
		user = (String) sesion.getAttribute("usuario");

		//En caso de que el usuario recogido no este vacio significara que hay alguien logged
		//por lo que se cambiara el boolean logged a true y mostrare el html
		//para usuarios loggeds
		if (user != null && !user.contentEquals("")) {
			logged = true;
		}
//en caso de no estar logged redirige a el html para usuarios no logged
		if (logged == true) {
			
			out.print(HtmlLogged(user));

		} else {
			try {
				response.sendRedirect("MainNoLogged.html");
			} catch (IOException e) {
				logger.warn(e.getMessage());
				logger.debug(e.getMessage());
				logger.debug("prueba2");
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Devuelve el html del usuario loggeado
	 * @param usr
	 * @return
	 */
	protected String HtmlLogged(String usr) {
		//Html del usuario logged
		String html = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Main Hipotecas</title>\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"Hipotecas.css\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div class=\"nav\">\r\n" + 
				" <div class=\"logo\"><a href='Main'>HOME</a></div>\r\n" + 
				"<div class='dropdown'><button class='dropbtn'><p>"+usr+"</p></button>"
						+ "<div class='dropdown-content'>"
						+ "<a href='LogOut'>LogOut</a>"
						+ "<a href='MostrarSimulaciones'>Simulaciones</a>"
						+ "</div>"
						+ "</div></div>"+
				"<div class=\"main\">\r\n" + 
				"\r\n" + 
				"<div class=\"formulario\">\r\n" + 
				"\r\n" + 
				"<form method=\"GET\" action=\"MostrarTabla\">\r\n" + 
				"\r\n" + 
				"<div><p>Cap</p><input type=\"number\" name='cap'></div>\r\n" + 
				"<div><p>Int</p><input type=\"number\" name='int'></div>\r\n" + 
				"<div><p>Meses</p><input type=\"number\" name='meses'></div>\r\n" 
				+"<div><p>Cuadro Amortizado</p><input type=\"checkbox\" name=\"amortizado\"></div>"+
				"\r\n" + 
				"<div> <input type=\"submit\" value='Calcular'></div>\r\n" + 
				"\r\n" + 
				"</form>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		return html;
	}

}
