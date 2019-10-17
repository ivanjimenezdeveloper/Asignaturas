package password;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HowSecureIsMyPassword
 */
@WebServlet("/HowSecureIsMyPassword")
public class HowSecureIsMyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HowSecureIsMyPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		/**
		 * Cojo los valores para conocer la herramienta de procesado que usare y la
		 * contraseña que usa
		 */
		String herramienta = request.getParameter("herramienta");
		String password = request.getParameter("pass");

		/**
		 * Primera parte del html guardada en un String para usarla mas tarde
		 */
		String html = "<!DOCTYPE html>\n" + "<!--\n"
				+ "To change this license header, choose License Headers in Project Properties.\n"
				+ "To change this template file, choose Tools | Templates\n" + "and open the template in the editor.\n"
				+ "-->\n" + "<html>\n" + "    <head>\n" + "        <title>THE CONTRASENYA</title>\n"
				+ "        <meta charset=\"UTF-8\">\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "        <link rel=\"stylesheet\" type=\"text/css\" href=\"password.css\"/>\n" + "    </head>\n"
				+ "    <body>\n" + "        <div>\n"
				+ "            <form name=\"numerosForm\" method=\"get\" action=\"HowSecureIsMyPassword\">\n"
				+ "                <h1>HOW SECURE IS MY PASSWORD</h1>"
				+ "                <select class=\"contrasena\" name=\"herramienta\">\n"
				+ "                    <option value=\"1\">CPU</option>\n"
				+ "                    <option value=\"2\">GPU</option>\n"
				+ "                    <option value=\"3\">GRID</option>\n" + "                </select>\n"
				+ "                <input class=\"contrasena\" placeholder=\"ENTER PASSWORD\" type=\"password\" name=\"pass\"/>";

	/**
	 * 
	 * Compruebo que ni la password sea null, ni este vacia. Tambien compruebo que
	 * se haya seleccionado la herramienta. En caso de que no se haya introducido
	 * bien vuelvo a poner el html. Tras tener la herramienta y la contraseña
	 * correcta compruebo que ninguna de las contraseñas mas usadas coincida con la
	 * escrita, en caso positivo redirige a un articulo sobre contraseñas
	 * 
	 */
		if (herramienta == null || herramienta == "" || password == null || password == "") {

			out.println(html);

		} else if (password.equals("123456") || password.equals("123456789") || password.equals("qwerty")
				|| password.equals("password") || password.equals("111111") || password.equals("12345678")
				|| password.equals("abc123") || password.equals("1234567") || password.equals("password1")
				|| password.equals("12345")) {
			response.sendRedirect(
					"https://edition.cnn.com/2019/04/22/uk/most-common-passwords-scli-gbr-intl/index.html");

		} else {
			
	/**
	 * Cojo los valores para conocer la herramienta de procesado que usare y 
	 * la contraseña que usa.
	 */
			
			herramienta = request.getParameter("herramienta");
			
			password = request.getParameter("pass");
			
	/**
	 * Tras recibir los valores vuelvo a mostrar el html y procedo a llamar 
	 * 		 * al metodo que calculara lo que tardaremos en conseguir la contraseña
	 * 			 * mostrandolo en un <p>
	 */
			
			out.println(html);
			
			out.println("<p class=\"contrasena\">"
					+ this.calcularTiempo(password.length(), Integer.valueOf(herramienta)) + "</p>");
		}

		out.println("                <input type=\"submit\" class=\"contrasena\"/>\n" + "            </form>\n"
				+ "        </div>\n" + "    </body>\n" + "</html>\n" + "");

	}

	/**
	 * Segun el tamaño de la contraseña y la herramienta hare los calculos necesarios devolviendo
	 * un string donde muestre los años, meses, semanas, dias, horas, minutos y segundos que 
	 * tardaremos en conseguir la contraseña.
	 * @param numero tamaño de la contraseña
	 * @param herramienta valor integer para seleccionar la herramienta de calculo
	 * @return
	 */
	public String calcularTiempo(int numero, int herramienta) {
		long tamanio = (long) Math.pow(256, numero);

		long anyo = 0, meses = 0, semanas = 0, dias = 0, horas = 0, minutos = 0, segundos = 0;

		if (herramienta == 1) {

			tamanio = tamanio / 1000;

		} else if (herramienta == 2) {

			tamanio = tamanio / 12000;

		} else if (herramienta == 3) {

			tamanio = tamanio / 1500000;

		}

		if (tamanio < 1) {

			return "instantaneo";

		}

		if (tamanio >= 31536000) {

			anyo = tamanio / 31536000;
			tamanio = tamanio % 31536000;

		}
		if (tamanio >= 2592000) {

			meses = tamanio / 2592000;
			tamanio = tamanio % 2592000;

		}
		if (tamanio >= 604800) {

			semanas = tamanio / 604800;
			tamanio = tamanio % 604800;

		}
		if (tamanio >= 86400) {

			dias = tamanio / 86400;
			tamanio = tamanio % 86400;

		}
		if (tamanio >= 3600) {

			horas = tamanio / 3600;
			tamanio = tamanio % 3600;

		}
		if (tamanio >= 60) {

			minutos = tamanio / 60;
			tamanio = tamanio % 60;

		}
		if (tamanio < 60) {

			segundos = tamanio;

		}

		return anyo + " anos " + meses + " meses " + semanas + " semanas " + dias + " dias " + horas + " horas "
				+ minutos + " minutos " + segundos + " segundos";

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
