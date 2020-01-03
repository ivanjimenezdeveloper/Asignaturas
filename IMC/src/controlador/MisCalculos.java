package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.CalculoEJB;
import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.entidad.Calculo_Imc;
import model.entidad.Usuario;
import vista.Cabecera;
import vista.Footer;
import vista.Nav;

@WebServlet("/MisCalculos")
/**
 * Consigue y muestra los calculos del usuario
 * @author HIBAN
 *
 */
public class MisCalculos extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	
	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	CalculoEJB calculoEJB;

	/**
	 * Consigue la array de calculos y la muestra
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		// Obtenemos el usuario de la sesion si existe
		Usuario user = sesionEJB.usuarioLogeado(sesion);
		
		if (user != null) {
			ArrayList<Calculo_Imc> arrCalc = new ArrayList<Calculo_Imc>();
			
			arrCalc = calculoEJB.getCalculosUsuario(user);
			
			Cabecera.mostrarLogged(response.getWriter(), user);
			Nav.mostrar(response.getWriter());
			vista.container.MisCalculos.mostrar(response.getWriter(), arrCalc);
			Footer.mostrar(response.getWriter());

		}else {
			response.sendRedirect("MainNoLogged.html");
		}
		
	}


}
