package vista.nav;

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
		String html = "            <div class=\"tab\">\n" + "                <ul>\n"
				+ "                    <li><a href=\"Main\">INICIO</a></li>\n"
				+ "                    <li><a href=\"\">TOP Games</a></li>\n"
				+ "                    <li><a href=\"MostarPorGenero\">By Genre</a></li>\n"
				+ "                    <li> |</li>\n"
				+ "                    <li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n"
				+ "                </ul>\n" + "            </div>\n" + "        </div>\n</div>";

		out.append(html);
	};
}
