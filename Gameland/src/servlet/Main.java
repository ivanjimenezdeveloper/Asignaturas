package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Main() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean logged = false;
		String user = "";
		
		
		//Creamos la sesion
		HttpSession sesion = request.getSession(true);
		
		//Coge el atributo usuario de la sesion
		user = (String) sesion.getAttribute("usuario");
		
		/**
		 * Si encuentra hay algo que se guarde en user significa que
		 * hay un usuario Logged
		 */
		if(user != null && user.contentEquals("")) {
			logged = true;
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
