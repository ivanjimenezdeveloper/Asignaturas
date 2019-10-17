
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class potencia
 */
@WebServlet("/potencia")
public class potencia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public potencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter wr = response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("potencia.html");
		rs.include(request, response);
		String numero = request.getParameter("numero");
		String elevar = request.getParameter("elevar");
		if (numero != null) {

			try {
				int respuesta = Integer.valueOf(numero);
				int elevando = Integer.valueOf(elevar);
				
				wr.append("<p>" + (int)Math.pow(respuesta, elevando ) + "</p>");

			} catch (Exception e) {
				
				wr.append("<form name=\"numerosForm\" method=\"get\" action=\"potencia\">\n" + 
						"	<p>Inserta un numero</p>\n" + 
						"	<input type=\"submit\" value=\"dale\">");

			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
