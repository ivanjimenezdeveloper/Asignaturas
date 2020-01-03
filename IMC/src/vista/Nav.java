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
	+ "            </div>\n" +"<ul>"
			+ "<li><a href='Main'>HOME</a></li>"
			+ "<li><a href='MisCalculos'>Mis calculos</a></li>"
			+ "</ul>" +"        </div>\n</div>";

		out.append(html);
	};
	/**
	 * Muestra el navegador para los usuarios no logeados
	 * @param out printwriter que sirve para mostrar
	 */
	public static void mostrarNologged(PrintWriter out) {
		String html = "            <div class=\"tab\">\n" 
	+ "            </div>\n" +"<ul>"
			+ "<li><a href='Main'>HOME</a></li>"
			+ "</ul>" +"        </div>\n</div>";

		out.append(html);
	};
	
}
