
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase que sirve de ejemplo para pasar parámetros de un servlet a un jsp
 * @author daw
 *
 */
@WebServlet("/Entrada")
public class Entrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Método que implementa el GET del servlet
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtengo un dispatcher hacia el jsp
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Mostra.jsp");

		// Genero un objeto de tipo string
		String nombre = "Jacinto Benavente";

		// Añado el objeto a la petición
		request.setAttribute("nombre", nombre);

		// Hago un forward al jsp con el objeto ya dentro de la petición
		rs.forward(request, response);
	}
}
