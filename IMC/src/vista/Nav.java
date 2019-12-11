package vista;

import java.io.PrintWriter;

/**
 * Clase que tiene el codigo html de los diferentes navegadores
 * 
 * @author horabaixa
 *
 */
public class Nav {
	/**
	 * Muestra el navegador estandar
	 * 
	 * @param out printwriter para pintar el navegador
	 */
	public static void mostrar(PrintWriter out) {
		String html = "            <div class=\"tab\">\n" 
	+ "            </div>\n" + "        </div>\n</div>";

		out.append(html);
	};
}
