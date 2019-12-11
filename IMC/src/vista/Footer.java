package vista;

import java.io.PrintWriter;

/**
 * Clase que tiene el codigo html de los diferentes footers
 * 
 * @author horabaixa
 *
 */
public class Footer {

	/**
	 * Muestra el footer
	 * 
	 * @param out printwriter para pintar el footer
	 */
	public static void mostrar(PrintWriter out) {
		String html = "<div class=\"footer\">\n" + "<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n"
				+ "</div>\n";
//pinta el html
		out.append(html);
	};
}
