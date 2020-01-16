
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExemplePropietats
 */
@WebServlet("/ExemplePropietats")
public class ExemplePropietats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Mètode que implementa la cridada get del servlet.
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Properties properties = new Properties();

		response.setContentType("text/html");

		out.println("<html><body>");

		try {
			// Carreguem l'arxiu de propietats
			String fitxer = getServletContext().getRealPath("/fitxero.properties");
			properties.load(new FileInputStream(fitxer));

			out.println("<u><h2> Propietat : Valor </h2></u>");

			// Mostrem totes les propietats de l'arxiu
			for (String key : properties.stringPropertyNames()) {
				out.println("<h3>" + key + " : " + properties.getProperty(key) + "</h3>");
			}

		} catch (IOException e) {
			out.println("<h1> S'ha produït un error al llegir el fitxer de propietats </h1>");
			out.println("<h2>" + e.getMessage() + "</h2>");
		}

		out.println("</body></html>");
	}
}
