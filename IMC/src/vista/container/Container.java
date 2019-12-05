package vista.container;

import java.io.PrintWriter;

public class Container {
	public static void mostrar(PrintWriter out) {
		String html = "<div class=\"container\">\n" + 
				"<div class=\"logoMain\"></div>\n" + 
				"<p>IMC</p>\n" + 
				"<form method=\"GET\" action=\"calcularIMC\">\n" + 
				"	<div >\n" + 
				"		<div>\n" + 
				"			<p>Estatura: </p><input type=\"number\" placeholder=\"Buscar\" name=\"estatura\" />\n" + 
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

		out.append(html);
	};
}
