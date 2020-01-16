package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.ejb.VerificacionEJB;
import vista.Cabecera;
import vista.Footer;
import vista.Nav;
import vista.container.Verificado;

/**
 * Verifica al usuario
 * @author HIBAN
 *
 */
@WebServlet("/Verificar")
public class Verificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Verificar.class);
	@EJB
	VerificacionEJB verificacionEJB;
	/**
	 * Verifica al usuario
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = -1;
		try {
			codigo = Integer.parseInt(request.getParameter("ver"));
			
			if (verificacionEJB.verificar(codigo) == true) {
				Cabecera.mostrarNoLogged(response.getWriter());
				Nav.mostrar(response.getWriter());
				Verificado.mostrar(response.getWriter());
				Footer.mostrar(response.getWriter());
				
			}else {
				response.sendRedirect("Main");
			}


		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}


}
