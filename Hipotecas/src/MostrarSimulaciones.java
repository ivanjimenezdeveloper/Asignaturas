
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
		// en caso de no estar logged redirige al main
		if (logged == true) {

			mostrarSimulaciones(response, user);

		} else {
			response.sendRedirect("Main");

		}

	}
/**
 * Muestra las simulaciones segun el nombre de usuario
 * @param response
 * @param user
 * @throws IOException
 */
	protected void mostrarSimulaciones(HttpServletResponse response, String user) throws IOException {

		PrintWriter out = response.getWriter();
		
		int idUsuario;
		//Arraylist donde guardo los objetos hipotecas que mostrare en la simulacion
		ArrayList<Hipoteca> hp = new ArrayList<Hipoteca>();

		//Primera parte del html
		out.append("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Main Hipotecas</title>\r\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href='Hipotecas.css'>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<div class=\"nav\">\r\n" + "		<div class=\"logo\">\r\n" + "			<p>logo</p>\r\n"
				+ "		</div>\r\n" + "		<div class='dropdown'>\r\n"
				+ "			<button class='dropbtn'>"+user+"</button>\r\n" + "\r\n"
				+ "			<div class='dropdown-content'>\r\n" + "				<a href='LogOut'>LogOut</a>\r\n"
				+ "			</div>\r\n" + "\r\n" + "			<div class='dropdown-content'>\r\n"
				+ "				<a href='MostarSimulaciones'>Simulaciones</a>\r\n" + "			</div>\r\n"
				+ "		</div>\r\n" + "	</div>\r\n" + "	<div class=\"main\">");

		try {
			//Busca la id del usuario y la guarda en la variable idUsuario
			idUsuario = Queries.UsuarioID(user);

			//Segun la id recibida crea la array con sus simulaciones de hipotecas
			//y las guarda en una array
			hp = Queries.querySimulaciones(idUsuario);

			//Por cada hipoteca guardada en la array creara un div que mostrara 
			// En un div
			for (Hipoteca hipoteca : hp) {
				
				//Variables que guardan los valores de las actuales hipotecas
				double capital = hipoteca.getCapital();
				double interes = hipoteca.getIntereses();
				int mes = (int) hipoteca.getMeses();
				String cuadroAmortizado = (hipoteca.getCuadroAmortizado() == 1)? "Si":"No";
				String cuadroAmortizadoReenvio = (hipoteca.getCuadroAmortizado() == 1)? "Si":null;
				
				//Div que escribe en el html con los datos
				out.append("<div class=\"simulacion\">")
						.append("<p>Capital: " + capital + "</p>")
						.append("<p>Interes: " + interes + "</p>")
						.append("<p>Meses: " + mes + "</p>")
						.append("<p> Cuadro amortizacion: " +cuadroAmortizado+"</p>")
						.append("<a href='MostrarTabla?cap=" + capital + "&int=" + interes
								+ "&meses=" + mes +  "&amortizado="+cuadroAmortizadoReenvio+"&saveQuery= no\"'>Ver</a>")
						.append("</div>");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
