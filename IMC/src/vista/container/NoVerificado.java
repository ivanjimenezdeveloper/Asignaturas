package vista.container;

import java.io.PrintWriter;

public class NoVerificado {
	public static void mostrar(PrintWriter out) {
		
		String html = "<div class='container'> "
				+ "<h1>NO ESTAS VERIFICADO</h1>"
				+ "<h2>TE HEMOS ENVIADO OTRO CODIGO DE VERIFICACION </h2>"
				+ "</div>";
		out.append(html);

	}
}
