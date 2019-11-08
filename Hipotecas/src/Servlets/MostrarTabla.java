package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MostrarTabla
 */
@WebServlet("/MostrarTabla")
public class MostrarTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarTabla() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int meses = 0;
		double capital = 0;
		double interes = 0;
		String amortizacion = null;
		int cuadroAmortizado = 0;

		boolean logged = false;
		String user = "";
		try {
			capital = Double.parseDouble(request.getParameter("cap"));
			interes = Double.parseDouble(request.getParameter("int"));
			meses = Integer.parseInt(request.getParameter("meses"));
			amortizacion = request.getParameter("amortizado");
		} catch (Exception e) {

		}

		if (capital <= 0 | interes < 0 | meses < 1) {
			response.sendRedirect("Main");
		} else {
			if (amortizacion != null) {
				cuadroAmortizado = 1;
			}

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

				if (request.getParameter("saveQuery") == null) {

					try {
						// Guardo la simulacion creada por el usuario
						CRUD.insertarSimulacion(user, capital, (int) interes, meses, cuadroAmortizado);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// Si esta logged llevara al html para usuarios loggeados y en caso contrario al
			// html de usuarios anonimos
			if (logged == true) {

				mostrarLogged(request, response, user);

			} else {
				mostrarNoLogged(request, response);

			}

		}

	}

	/**
	 * Muestra la tabla para usuarios loggeados
	 * 
	 * @param request
	 * @param response
	 * @param usr      Nombre de usuario loggeado
	 * @throws IOException
	 */
	protected void mostrarLogged(HttpServletRequest request, HttpServletResponse response, String usr)
			throws IOException {

		int meses = 0;
		double capital = 0;
		double interes = 0;
		double operacionCouta1, operacionCouta2;
		int mes = 0;
		String amortizacion = null;
		String esconderAmortizacion = "";

		DecimalFormat df2 = new DecimalFormat("#.##");

		ArrayList<Tabla> tbArr = new ArrayList<Tabla>();
		PrintWriter out = response.getWriter();

		// Coge los parametros para realizar la tabla
		try {
			capital = Double.parseDouble(request.getParameter("cap"));
			interes = Double.parseDouble(request.getParameter("int"));
			meses = Integer.parseInt(request.getParameter("meses"));
			amortizacion = request.getParameter("amortizado");
		} catch (Exception e) {
		}

		if (capital <= 0 | interes < 0 | meses < 1) {
			response.sendRedirect("Main");
		} else {
			if (amortizacion == null) {
				esconderAmortizacion = "style=\"display: none;\"";
			}

			String html1 = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"ISO-8859-1\">\n"
					+ "<title>Tabla hipoteca</title>\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Hipotecas.css\">\n" + "\n" + "</head>\n"
					+ "<body>\n" + "\n" + "<div class=\"nav\">\r\n" + " <div class=\"logo\">"
							+ "<a href='Main'>HOME</a>"
							+ "</div>\r\n"
					+ "<div class='dropdown'><button class='dropbtn'>" + usr + "</button>"
					+ "<div class='dropdown-content'><a href='LogOut'>LogOut</a></div></div></div>"
					+ "	<div class=\"main\">\n" + "\n" + "		<table>\n" + "			<thead>\n"
					+ "<td>Mes</td><td>Capital pendiente anterior</td>\n" + "<td>Couta a Pagar</td>\n" + "<td "
					+ esconderAmortizacion + " >Parte de la couta que es amortizaci�n</td>\n"
					+ "<td>Parte de la couta que es inter�s</td>\n" + "<td>Capital pendiente posterior</td>\n" + "\n"
					+ "			</thead>\n" + "			<tbody>";
			out.append(html1);

			// Guarda las operaciones de la couta para una facil lectura
			operacionCouta1 = 1 - Math.pow((1 + (interes / 100 / 12)), -meses);
			operacionCouta2 = interes / 100 / 12;

			// Calcula la couta que pagara cada mes
			double couta = capital / (operacionCouta1 / operacionCouta2);

			tbArr = Tabla.calcularTabla(meses, capital, interes);

			for (Tabla tabla : tbArr) {
				mes++;
				out.append("<tr>").append("<td>" + mes + "</td>")
						.append("<td>" + df2.format(tabla.getCapitalPenAnt()) + "</td>")
						.append("<td>" + df2.format(couta) + "</td>")
						.append("<td " + esconderAmortizacion + " >" + df2.format(tabla.getCoutaAmortizada()) + "</td>")
						.append("<td>" + df2.format(tabla.getCoutaInteres()) + "</td>")
						.append("<td>" + df2.format(tabla.getCapitalPenPos()) + "</td>").append("</tr>");

			}

			out.append("</tbody>\n" + "\n" + "		</table>\n" + "\n" + "		<a href=\"Main\">Volver</a>\n"
					+ "	</div>\n" + "\n" + "\n" + "</body>\n" + "</html>");
		}

	}

	/**
	 * Muestra la tabla para usuarios no loggeados
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void mostrarNoLogged(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int meses = 0;
		double capital = 0;
		double interes = 0;
		double operacionCouta1, operacionCouta2;
		int mes = 0;
		String amortizacion = null;
		String esconderAmortizacion = "";
		DecimalFormat df2 = new DecimalFormat("#.##");

		ArrayList<Tabla> tbArr = new ArrayList<Tabla>();
		PrintWriter out = response.getWriter();

		// Coge los parametros para realizar la tabla

		try {
			capital = Double.parseDouble(request.getParameter("cap"));
			interes = Double.parseDouble(request.getParameter("int"));
			meses = Integer.parseInt(request.getParameter("meses"));
			amortizacion = request.getParameter("amortizado");
		} catch (Exception e) {
		}

		if (capital <= 0 | interes < 0 | meses < 1) {
			response.sendRedirect("Main");
		} else {

			if (amortizacion == null) {
				esconderAmortizacion = "style=\"display: none;\"";
			}

			String html1 = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"ISO-8859-1\">\n"
					+ "<title>Tabla hipoteca</title>\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"Hipotecas.css\">\n" + "\n" + "</head>\n"
					+ "<body>\n" + "\n" + "	<div class=\"nav\">\n" + "		<div class=\"logo\">\n"
					+ "<a href='Main'>HOME</a>"
					+ "		</div>\n" + "		<div class=\"logSingOut\">\n"
					+ "			<p>\n"
					+ "				<a href=\"LogIn\">LogIn</a> | <a href=\"FormularioRegister.html\">Register</a>\n"
					+ "			</p>\n" + "		</div>\n" + "	</div>\n" + "\n" + "	<div class=\"main\">\n" + "\n"
					+ "		<table>\n" + "			<thead>\n" + "<td>Mes</td><td>Capital pendiente anterior</td>\n"
					+ "<td>Couta a Pagar</td>\n" + "<td" + esconderAmortizacion
					+ ">Parte de la couta que es amortizaci�n</td>\n" + "<td>Parte de la couta que es inter�s</td>\n"
					+ "<td>Capital pendiente posterior</td>\n" + "\n" + "			</thead>\n" + "			<tbody>";

			out.append(html1);

			// Guarda las operaciones de la couta para una facil lectura
			operacionCouta1 = 1 - Math.pow((1 + (interes / 100 / 12)), -meses);
			operacionCouta2 = interes / 100 / 12;

			// Calcula la couta que pagara cada mes
			double couta = capital / (operacionCouta1 / operacionCouta2);

			// Guarda en una array de tablas (rows) lo calculado en el metodo
			tbArr = Tabla.calcularTabla(meses, capital, interes);

			// Se dibuja cada row de la tabla
			for (Tabla tabla : tbArr) {
				mes++;
				out.append("<tr>").append("<td>" + mes + "</td>")
						.append("<td>" + df2.format(tabla.getCapitalPenAnt()) + "</td>")
						.append("<td>" + df2.format(couta) + "</td>")
						.append("<td " + esconderAmortizacion + " >" + df2.format(tabla.getCoutaAmortizada()) + "</td>")
						.append("<td>" + df2.format(tabla.getCoutaInteres()) + "</td>")
						.append("<td>" + df2.format(tabla.getCapitalPenPos()) + "</td>").append("</tr>");

			}

			out.append("</tbody>\n" + "\n" + "		</table>\n" + "\n" + "		<a href=\"Main\">Volver</a>\n"
					+ "	</div>\n" + "\n" + "\n" + "</body>\n" + "</html>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
