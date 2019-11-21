package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Valoracion
 */
@WebServlet("/Valoracion")
public class Valoracion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Valoracion() {
		super();

	}

	/**
	 * Guarda la valoracion y al acabar devuelve a la pagina principal
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = "";
		int id = 0, valor = -1, idUsuario = -1;
		HttpSession sesion = request.getSession(true);

		try {
			valor = Integer.parseInt(request.getParameter("valor"));
			user = (String) sesion.getAttribute("user");
			id = (int) sesion.getAttribute("idJuego");
			idUsuario = query.Mantenimiento.idUsuario(user);

		} catch (Exception e) {
		}

		query.Mantenimiento.idUsuario(user);
		query.Valoracion.valorarJuego(idUsuario, id, valor);
		
		response.sendRedirect("Main");

	}



}
