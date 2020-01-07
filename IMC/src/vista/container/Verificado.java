package vista.container;

import java.io.PrintWriter;

public class Verificado {
	
	public static void mostrar(PrintWriter out) {
		
		String html = "<div class='container'> "
				+ "<h1>VERIFICADO CON EXITO</h1>"
				+ "</div>";
		out.append(html);

	}

}
