package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.ejb.UsuariosEJB;
import aplicacion.modelo.pojo.Usuario;
import aplicacion.vista.PaginaPrincipal;

/**
 * Clase que gestiona la pagina principal de la aplicación
 * @author daw
 *
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *  EJB para trabajar con usuarios
	 */
	@EJB
	UsuariosEJB usuariosEJB;
	
	/**
	 *  EJB para trabajar con sesiones
	 */
	@EJB
	SesionesEJB sesionesEJB;

	/**
	 * Método que trata las peticiones GET que llegan al servlet.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		// Intentamos obtener el usuario de la sesión
		Usuario usuario = sesionesEJB.usuarioLogeado(session);
		
		// Generamos la página para el usuario y la mostramos
		response.setContentType("text/html; charset=UTF-8");
		PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
		paginaPrincipal.muestra(response.getWriter(), usuariosEJB.getUsuarios(), usuario);
	}
}