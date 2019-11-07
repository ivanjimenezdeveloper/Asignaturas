
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int meses;
		double capital;
		double interes;
		double operacionCouta1, operacionCouta2;
		int mes =0;
		DecimalFormat df2 = new DecimalFormat("#.##");

		ArrayList<Tabla> tbArr = new ArrayList<Tabla>();
		PrintWriter out = response.getWriter();
		
		String html1 = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"ISO-8859-1\">\n" + 
				"<title>Tabla hipoteca</title>\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"Hipotecas.css\">\n" + 
				"\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"\n" + 
				"	<div class=\"nav\">\n" + 
				"		<div class=\"logo\">\n" + 
				"			<p>logo</p>\n" + 
				"		</div>\n" + 
				"		<div class=\"logSingOut\">\n" + 
				"			<p>\n" + 
				"				<a href=\"LogIn\">LogIn</a> | <a href=\"FormularioRegister.html\">Register</a>\n" + 
				"			</p>\n" + 
				"		</div>\n" + 
				"	</div>\n" + 
				"\n" + 
				"	<div class=\"main\">\n" + 
				"\n" + 
				"		<table>\n" + 
				"			<thead>\n" + 
				"<td>Mes</td><td>Capital pendiente anterior</td>\n" + 
				"<td>Couta a Pagar</td>\n" + 
				"<td>Parte de la couta que es amortización</td>\n" + 
				"<td>Parte de la couta que es interés</td>\n" + 
				"<td>Capital pendiente posterior</td>\n" + 
				"\n" + 
				"			</thead>\n" + 
				"			<tbody>";
		out.append(html1);
		// PRUEBAS
//		capital = 200000;
//		meses = 60;
//		interes = 3;
		
		//Coge los parametros para realizar la tabla
		capital = Double.parseDouble(request.getParameter("cap"));
		interes = Double.parseDouble(request.getParameter("int"));
		meses = Integer.parseInt(request.getParameter("meses"));
		
		// Guarda las operaciones de la couta para una facil lectura
		operacionCouta1 = 1 - Math.pow((1 + (interes / 100 / 12)), -meses);
		operacionCouta2 = interes / 100 / 12;

		//Calcula la couta que pagara cada mes
		double couta = capital / (operacionCouta1 / operacionCouta2);
		
		tbArr = Tabla.calcularTabla(meses, capital, interes);
		
		for (Tabla tabla : tbArr) {
			mes++;
			out.append("<tr>")
			.append("<td>"+ mes+"</td>")
			.append("<td>" + df2.format(tabla.getCapitalPenAnt()) + "</td>")
			.append("<td>" + df2.format(couta) + "</td>")
			.append("<td>" + df2.format(tabla.getCoutaAmortizada()) + "</td>")
			.append("<td>" + df2.format(tabla.getCoutaInteres()) + "</td>")
			.append("<td>" + df2.format(tabla.getCapitalPenPos()) + "</td>")
			.append("</tr>");
			
		}
		
		out.append("</tbody>\n" + 
				"\n" + 
				"		</table>\n" + 
				"\n" + 
				"		<a href=\"Main\">Volver</a>\n" + 
				"	</div>\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>");
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
