package vista.container;

import java.io.PrintWriter;
/**
 * Clase que tiene el codigo html de las diferentes Containers
 * @author horabaixa
 *
 */
public class Principal {
	
	/**
	 * Muestra el container del calculo
	 * @param out printwriter que sirve para mostrar
	 * 
	 */
	public static void mostrar(PrintWriter out) {
		String html = "<div class=\"container\">\n" + 
				"<div class=\"logoMain\"></div>\n" + 
				"<p>IMC</p>\n" + 
				"<form method=\"GET\" action=\"Calculo\">\n" + 
				"	<div >\n" + 
				"		<div>\n" + 
				"			<p>Estatura (cm): </p><input type=\"number\"  name=\"estatura\" />\n" + 
				"		</div>\n" + 
				"		<div>\n" + 
				"			<p>Peso:</p> <input type=\"number\" name=\"peso\" />\n" + 
				"		</div>\n" + 
				"		<div>\n" + 
				"			<input type=\"submit\" value=\"Calcular\" />\n" + 
				"		</div>\n" + 
				"	</div>\n" + 
				"</form>\n" + 
				"</div>";
//pinta el html
		out.append(html);
	};
	

	
}
