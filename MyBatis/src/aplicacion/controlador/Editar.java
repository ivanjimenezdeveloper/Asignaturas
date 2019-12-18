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
import aplicacion.vista.PaginaEditar;

/**
 * Servlet implementation class Editar
 */
@WebServlet("/Editar")
public class Editar extends HttpServlet {
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
		String id = request.getParameter("id");
		
		// Intentamos obtener el usuario de la sesión
		Usuario usuarioLogeado = sesionesEJB.usuarioLogeado(session);
		
		if(usuarioLogeado == null) {
			// Si no está logeado lo enviamos a Login
			response.sendRedirect("Login");
		}
		else {
			// obtenemos el usuario de base de datos
			Integer identificador = Integer.valueOf(id);
			Usuario usuario = usuariosEJB.getUsuario(identificador);
						
			// Mostramos la página para crear un usuario
			response.setContentType("text/html; charset=UTF-8");
			PaginaEditar paginaEditar = new PaginaEditar();
			paginaEditar.muestra(response.getWriter(), usuario);
		}
	}
	
	/**
	 * Método que trata las peticiones POST que llegan al servlet.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		HttpSession session = request.getSession(false);
		
		// Intentamos obtener el usuario de la sesión
		Usuario usuarioLogeado = sesionesEJB.usuarioLogeado(session);
		
		if(usuarioLogeado == null) {
			// Si no está logeado lo enviamos a Login
			response.sendRedirect("Login");
		}
		else {
			try {
				if((nombre != null) && (id != null) && (usuario !=null) && (password != null)) {
					// Si nos dan información de un usuario la insertamos.
					Usuario u = new Usuario();
					
					Integer identificador = Integer.valueOf(id);
					
					u.setNombre(nombre);
					u.setUsuario(usuario);
					u.setPassword(password);
					u.setId(identificador);
					
					usuariosEJB.updateUsuario(u);
				}
			}
			catch(Exception e) {
				
			}
			// Finalmente enviamos a la página principal
			response.sendRedirect("Principal");			
		}
	}

}
