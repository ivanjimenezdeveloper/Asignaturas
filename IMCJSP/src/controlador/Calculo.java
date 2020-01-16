package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.ejb.CalculoEJB;
import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.ejb.VerificacionEJB;
import model.entidad.Usuario;
import vista.Cabecera;
import vista.Footer;
import vista.Nav;

@WebServlet("/Calculo")
/**
 * Hace las operaciones para mostrar los calculos
 * 
 * @author HIBAN
 *
 */
public class Calculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(Calculo.class);

	/**
	 * EJB para trabajar con usuarios
	 */
	@EJB
	UsuarioEJB userEJB;

	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	Sesiones sesionEJB;

	@EJB
	CalculoEJB calculoEJB;

	@EJB
	VerificacionEJB verificacionEJB;

	/**
	 * Muestra el calculo
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		boolean ver = false;
		// Obtenemos el usuario de la sesion si existe
		Usuario user = sesionEJB.usuarioLogeado(sesion);

		Double peso = 0.0;
		Double estatura = 0.0;
		String guardar = null;

		// recibe los parametros
		try {
			estatura = Double.parseDouble(request.getParameter("estatura"));
			peso = Double.parseDouble(request.getParameter("peso"));
			guardar = request.getParameter("guardar");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		// calcula el IMC
		Double resultado = calculoEJB.calcularIMC(peso, estatura);
		if(user != null) {
			 ver = verificacionEJB.usuarioVerificado(user);

		}
		
		//Muestra el html
		if(user != null && ver == false) {
			
			response.sendRedirect("Main");

			
		}
		else 
		if (user != null) {
			if (guardar == null) {
				calculoEJB.guardarCalculo(peso, estatura.intValue(), user);
			}
			Cabecera.mostrarLogged(response.getWriter(), user);

			Nav.mostrar(response.getWriter());
			vista.container.Calculo.mostrar(response.getWriter(), resultado);
			Footer.mostrar(response.getWriter());
		} else {
			Cabecera.mostrarNoLogged(response.getWriter());
			Nav.mostrar(response.getWriter());
			vista.container.Calculo.mostrar(response.getWriter(), resultado);
			Footer.mostrar(response.getWriter());
		}

	}

}
