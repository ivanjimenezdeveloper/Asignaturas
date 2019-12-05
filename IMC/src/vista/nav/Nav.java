package vista.nav;

import java.io.PrintWriter;

public class Nav {
	public static void mostrar(PrintWriter out) {
		String html = "            <div class=\"tab\">\n"
				+ "                <ul>\n" + "                    <li><a href=\"Main\">SEARCH</a></li>\n"
				+ "                    <li><a href=\"\">TOP Games</a></li>\n"
				+ "                    <li><a href=\"MostarPorGenero\">By Genre</a></li>\n"
				+ "                    <li> |</li>\n"
				+ "                    <li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n"
				+ "                </ul>\n" + "            </div>\n" + "        </div>\n</div>";

		out.append(html);
	};
}
