
import java.io.IOException;
import java.io.PrintWriter;

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
	private PrintWriter out;


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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		out = response.getWriter();
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
			response.sendRedirect("MainNoLogged.html");

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
				" <div class=\"logo\"><p>logo</p></div>\r\n" + 
				"<div class='dropdown'><button class='dropbtn'>"+usr+"</button>"
						+ "<div class='dropdown-content'><a href='LogOut'>LogOut</a></div>"
						+ "<div class='dropdown-content'><a href='MostarSimulaciones'>Simulaciones</a></div></div></div>"+
				"<div class=\"main\">\r\n" + 
				"\r\n" + 
				"<div class=\"formulario\">\r\n" + 
				"\r\n" + 
				"<form method=\"GET\" action=\"MostrarTabla\">\r\n" + 
				"\r\n" + 
				"<div><p>Cap</p><input type=\"number\" name='cap'></div>\r\n" + 
				"<div><p>Int</p><input type=\"number\" name='int'></div>\r\n" + 
				"<div><p>Meses</p><input type=\"number\" name='meses'></div>\r\n" + 
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
