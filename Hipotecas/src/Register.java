
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	private static final String SAVE_DIR = "imagenes";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoge el parametro error
		String error = request.getParameter("error");

		// Si hay un error redirige al formulario con error en caso contrario redirige
		// al formulario normal
		if (error != null) {

			response.sendRedirect("FormularioRegisterERROR.html");

		} else {
			response.sendRedirect("FormularioRegister.html");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recoge los parametros para hacer el registro

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		String nombre = request.getParameter("nombre");
		String img = request.getParameter("img");

		// Obtenemos la ruta en el servidor
		String uploadPath = getServletContext().getRealPath("\\Hipotecas\\WebContent") + File.separator + SAVE_DIR;

		File uploadDir = new File(uploadPath);

		// Guardamos el nombre del archivo
		String fileName = null;

		// Si no existe creamos el directorio
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		//Por alguna razon la guarda en una carpeta temporal por lo cual no la puedo usar
		for (Part part : request.getParts()) {
			fileName = getFileName(part);
			part.write(uploadPath + File.separator + fileName);

		}

		boolean correcto = false;

		try {
			correcto = CRUD.registroUsuario(nombre, usuario, password, img );

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// Si se registra correctamente redirige al log y en caso contrario recarga la
		// pagina con un error
		if (correcto == true) {
			response.sendRedirect("LogIn");

		} else {
			response.sendRedirect("Register?error=1");
		}

	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "desconocido.txt";
	}

}
