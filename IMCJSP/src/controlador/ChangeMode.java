package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Cambia el atributo para el modo nocturno o modo light
 * @author HIBAN
 *
 */
@WebServlet("/ChangeMode")
public class ChangeMode extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);
		String color = (String) sesion.getAttribute("color");

		// Si el color es nulo sera el predeterminado (luz) asi que cambiara a oscuro
		if (color == null) {
			sesion.setAttribute("color", "d");

		} else {

			if (color.equals("") || color.equals("l")) {
				sesion.setAttribute("color", "d");
			} else {
				sesion.setAttribute("color", "l");

			}
		}

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Main");
		rs.forward(request, response);

	}

}
