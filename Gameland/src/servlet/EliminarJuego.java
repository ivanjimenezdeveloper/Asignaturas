package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EliminarJuego
 */
@WebServlet("/EliminarJuego")
public class EliminarJuego extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EliminarJuego() {
		super();
	}

	/**
	 * Elimina el juego con la id dada
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("idjuego"));
		} catch (Exception e) {
			// Logger
		}

		// Si la id es 0 o menor no hace la eliminacion
		if (id > 0) {

			query.Mantenimiento.borrarJuego(id);
			response.sendRedirect("GameManagement");
		} else {
			response.sendRedirect("GameManagement");
		}

	}

}
