package vista.container;

import java.io.PrintWriter;
/**
 * Muestra el html de los calculos
 * @author HIBAN
 *
 */
public class Calculo {

	/**
	 * Muestra el calculo 
	 * @param out printwriter que sirve para mostrar
	 * @param calculo resultado de la operacion
	 */
	public static void mostrar(PrintWriter out, Double calculo) {
		String html = "	<div class=\"container\">\n" + "		<h1>" + calculo + "</h1>\n" + "\n" + "	</div>";
//pinta el html
		out.append(html);
	};

}
