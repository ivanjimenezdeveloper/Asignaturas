package vista.footer;

import java.io.PrintWriter;


public class Footer {

	public static void mostrar(PrintWriter out) {
		String html = "<div class=\"footer\">\n"
				+ "<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + "</div>\n";

		out.append(html);
	};
}
