package vista.container;

import java.io.PrintWriter;

public class Calculo {
	

	public static void mostrar(PrintWriter out, Double calculo) {
		String html = "	<div class=\"container\">\n" + 
				"		<h1>"+calculo+"</h1>\n" + 
				"\n" + 
				"	</div>";
//pinta el html
		out.append(html);
	};

}
