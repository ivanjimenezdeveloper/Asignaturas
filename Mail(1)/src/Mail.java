
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mail")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Envío de correo </h1>");
		out.println("<form method=\"post\" action=\"Mail\">");
		out.println("<label for=\"para\" >Para:</label>");
		out.println("<input type=\"text\" value='tribot@iessonferrer.net' name=\"para\" />");
		out.println("<br />");
		out.println("<label for=\"asunto\">Asunto:</label>");
		out.println("<input type=\"text\" name=\"asunto\" />");
		out.println("<br />");
		out.println("<label for=\"mensaje\">Mensaje:</label>");
		out.println("<textarea rows=\"4\" cols=\"50\" name=\"mensaje\" /> </textarea>");
		out.println("<br />");
		out.println("<input type=\"submit\" value=\"Enviar\" />");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String para = request.getParameter("para");
		String asunto = request.getParameter("asunto");
		String mensaje = request.getParameter("mensaje");

		if ((para != null) && (asunto != null) && (mensaje != null)) {
			// Creamos un objeto de oficina de correos
			MailOffice m = new MailOffice("smtp.gmail.com", 587, "basiliscoxalligator@gmail.com", "Ageofempires2");
			
			// Els correus de gmail s'han d'habilitar https://myaccount.google.com/lesssecureapps
	
			String remitente = "basiliscoxalligator@gmail.com";
					
			// Enviamos el correo
			m.sendMail(para, remitente, asunto, mensaje, this.getServletContext().getRealPath("/patata23.jpg"));
		}
		
		response.sendRedirect("index.html");
	}

}
