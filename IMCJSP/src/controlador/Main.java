package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.ejb.VerificacionEJB;
import model.entidad.Mail;
import model.entidad.Usuario;
import model.entidad.UsuarioKey;
import vista.Cabecera;
import vista.Footer;
import vista.Nav;
import vista.container.NoVerificado;
import vista.container.Principal;

@WebServlet("/Main")
/**
 * Muestra la pantalla principal de la pagina
 * 
 * @author HIBAN
 *
 */
public class Main extends HttpServlet {
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
	 * EJB para trabajar con verificaciones
	 */
	@EJB
	VerificacionEJB verificacionEJB;

	/**
	 * Muestra la pagina principal de la pagina
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		/*
		 * TENER UN TOMEE VERSION 9 <Resource name="jdbc/IMC" auth="Container"
		 * type="javax.sql.DataSource" maxActive="100" maxIdle="30" maxWait="10000"
		 * username="imcivan" password= "Ageofempires2"
		 * driverClassName="com.mysql.cj.jdbc.Driver" url=
		 * "jdbc:mysql://localhost:3306/IMC?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC&amp;useSSL=FALSE"
		 * />
		 */
		boolean ver = false;
		HttpSession sesion = request.getSession(true);

	
		// Obtenemos el usuario de la sesion si existe
		Usuario user = sesionEJB.usuarioLogeado(sesion);
		if(user != null) {
			 ver = verificacionEJB.usuarioVerificado(user);

		}
		//comprueba si esta verficado
		if(user != null && ver == false) {
			
			verificacionEJB.borrarVerificacionesExistentes(userEJB.existeUsuario(user.getCorreo(), user.getPass()));
			Integer codigo = verificacionEJB.crearVerificacion(userEJB.existeUsuario(user.getCorreo(), user.getPass()));
			Mail m = new Mail("smtp.gmail.com", 587, "basiliscoxalligator@gmail.com", "Ageofempires2");
			m.sendMail(user.getCorreo(), "basiliscoxalligator@gmail.com", "Verificacion de correo IMC", "http://localhost:8080/IMC/Verificar?ver="+codigo);

			Cabecera.mostrarLogged(response.getWriter(), user);
			Nav.mostrar(response.getWriter());
			NoVerificado.mostrar(response.getWriter());
			Footer.mostrar(response.getWriter());
			
		}
		else if (user != null) {
			Cabecera.mostrarLogged(response.getWriter(), user);
			Nav.mostrar(response.getWriter());
			Principal.mostrar(response.getWriter());
			Footer.mostrar(response.getWriter());

		} else {
			response.sendRedirect("MainNoLogged.html");
		}

	}


}
