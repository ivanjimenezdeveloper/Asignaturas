package controlador;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.ejb.Sesiones;
import model.ejb.UsuarioEJB;
import model.ejb.VerificacionEJB;
import model.entidad.Mail;
import model.entidad.Usuario;

@WebServlet("/Register")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "imagenes";

	private static final Logger logger = (Logger) LoggerFactory.getLogger(Register.class);

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
	VerificacionEJB verificacionEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession(true);

		Usuario user = new Usuario();
		String error = request.getParameter("error");
		user = sesionEJB.usuarioLogeado(sesion);

		if (error != null) {
			response.sendRedirect("RegisterERROR.html");
		} else {
			if (user != null) {
				response.sendRedirect("Main");
			} else {
				response.sendRedirect("Register.html");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean existe = false;
		String remitente = "basiliscoxalligator@gmail.com";
		// Recoge los parametros

		String userName = request.getParameter("user");
		String pass = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
		String img = request.getParameter("img");

		// Comprueba si ya existe un usuario con ese nombre

		Usuario user = new Usuario();

		user.setCorreo(userName);
		user.setImagen(img);
		user.setNombre(nombre);
		user.setPass(pass);
		existe = userEJB.existeUsuario(userName);
		/*
		 * Si existe el usuario o no ha rellenado algun campo recarga la pagina con un
		 * error en caso contrario continua con el registro
		 */
		if (userName.length() == 0 || pass.length() == 0 || nombre.length() == 0 || existe == true) {
			response.sendRedirect("Register?error=1");
		} else {

			try {
				
				String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				String fileName = null;

				// Obtenemos el archivo y lo guardamos a disco
				for (Part part : request.getParts()) {
					fileName = userEJB.getFileName(part);
					user.setImagen(fileName);
					part.write(uploadPath + File.separator + fileName);
				}
				userEJB.registrarUsuario(user);
				
				Integer codigo = verificacionEJB.crearVerificacion(user);
				
				
				Mail m = new Mail("smtp.gmail.com", 587, remitente, "Ageofempires2");

				m.sendMail(user.getCorreo(), remitente, "Verificacion de correo IMC", "http://localhost:8080/IMC/MainNoLogged.html?ver="+codigo);

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			response.sendRedirect("Login");

		}
	}

}
