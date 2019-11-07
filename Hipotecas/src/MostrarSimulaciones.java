
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MostrarSimulaciones
 */
@WebServlet("/MostrarSimulaciones")
public class MostrarSimulaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarSimulaciones() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		boolean logged = false;
		String user = "";

		// Crea la sesion
		HttpSession sesion = request.getSession(true);

		// Coge el atributo de la sesion usuario
		user = (String) sesion.getAttribute("usuario");

		// En caso de que el usuario recogido no este vacio significara que hay alguien
		// logged
		// por lo que se cambiara el boolean logged a true y mostrare el html
		// para usuarios loggeds
		if (user != null && !user.contentEquals("")) {
			logged = true;
		}
//en caso de no estar logged redirige a el html para usuarios no logged
		if (logged == true) {

		} else {
			response.sendRedirect("MainNoLogged.html");

		}

	}

	
	protected void mostrarSimulaciones() {
		
	}
}
