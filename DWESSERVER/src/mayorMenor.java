
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class mayorMenor
 */
@WebServlet("/mayorMenor")
public class mayorMenor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Random r;
	public static int objetivo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mayorMenor() {
		super();
		// TODO Auto-generated constructor stub
		mayorMenor.inicializarNumero();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String numero = request.getParameter("numero");
		if (numero == null || numero == "") {
			out.append(("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
					+ "<title>Insert title here</title>" + "\n" + "</head>\n" + "<body>\n"
					+ "<form name=\"numerosForm\" method=\"get\" action=\"mayorMenor\">\n"
					+ "	<p>Adivina el numero</p>\n" + "	<input type=\"number\" value=\"0\" name=\"numero\"/>\n"
					+ "	<input type=\"submit\" value=\"dale\">\n" + "</form>\n" + "</body>\n" + "</html>"));
			out.append("" + objetivo);

		} else {
			out.append(("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
					+ "<title>Insert title here</title>" + "\n" + "</head>\n" + "<body>\n"
					+ "<form name=\"numerosForm\" method=\"get\" action=\"mayorMenor\">\n"
					+ "	<p>Adivina el numero</p>\n" + "	<input type=\"number\" value=\"0\" name=\"numero\"/>\n"
					+ "	<input type=\"submit\" value=\"dale\">\n" + "</form>\n" + "</body>\n" + "</html>"));


			numero = request.getParameter("numero");

			int respuesta = this.comparacion(Integer.valueOf(numero));

			if (respuesta == 1) {
				out.append("menor");
			} else if (respuesta == 0) {
				out.append("mayor");

			} else if (respuesta == -1) {

				out.append("<p>asertaste</p> <img src=\"thompson01.jpg\">");

				mayorMenor.inicializarNumero();


			}

		}

//		this.comparacion(Integer.valueOf(numero));

	}

	public int comparacion(int numero) {

		if (objetivo < numero) {
			return 1;
		} else if (numero < objetivo) {
			return 0;
		} else {
			return -1;
		}

	}

	public static void inicializarNumero() {
		r = new Random();
		objetivo = r.nextInt(10 - 0);
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
