package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Juego;

/**
 * Servlet implementation class GameManagement
 */
@WebServlet("/GameManagement")
public class GameManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GameManagement() {
        super();
            }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean logged = false;
		String user = "";
		boolean admin = false;

		/*
		 * Creamos la sesion
		 */
		HttpSession sesion = request.getSession(true);

		/*
		 * Coge el atributo usuario de la sesion
		 */
		user = (String) sesion.getAttribute("user");

		/*
		 * Si encuentra hay algo que se guarde en user significa que hay un usuario
		 * Logged y ademas comprueba que sea admin
		 */
		if (user != null && !user.contentEquals("")) {
			logged = true;
			admin = query.Mantenimiento.esAdministrador(user);

		}

		/*
		 * Si esta logged muestra la pagina para usuarios loggeados y si no la busqueda
		 * normal. En caso de ser un admin mostrara su html
		 */
		if (logged == true && admin == true) {
			ArrayList<Juego> juegoArr = new ArrayList<Juego>();
			
			juegoArr = query.Busqueda.todosLosJuego();
			
			
			response.getWriter().print(mostrarAdmin(user, juegoArr));


		} else if (logged) {

			response.sendRedirect("Main");
		} else {

			response.sendRedirect("Main");
		}
		
		
	}


	
	public String mostrarAdmin(String user,ArrayList<Juego> juegoArr) {
		
		String html = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"    <head>\n" + 
				"        <title>Gameland</title>\n" + 
				"        <meta charset=\"UTF-8\">\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"        <link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\"/>\n" + 
				"\n" + 
				"    </head>\n" + 
				"    <body>\n" + 
				"        <div class=\"nav\">\n" + 
				"            <div class=\"header\">  \n" + 
				"                <div class=\"logoHeader\"></div><h1>Gameland</h1>\n" + 
				"                <div class=\"nodoInvisibleHeader\"></div>\n" + 
				"                <div class=\"usuario\">\n" + 
				"                    <div>\n" + 
				"                        <p class=\"nombreUsuario\">"+user+"</p> <a class=\"fotoUsuario\">imagen</a>\n" + 
				"                    </div>\n" + 
				"                    <div>            \n" + 
				"                        <a href=\"Logout\">Log Out</a> <p>" + 
				"                    </div>\n" + 
				"                </div>\n" + 
				"            </div>\n" + 
				"            <div class=\"tab\">\n" + 
				"                <ul>\n" + 
				"                    <li><a href=\"Main\">SEARCH</a></li>\n" + 
				"                    <li><a href=\"\">TOP Games</a></li>\n" + 
				"                    <li><a href=\"MostarPorGenero\">By Genre</a></li>\n" + 
				"                    <li> |</li>\n" + 
				"                    <li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n" +
				"				<li><a href=\"GameManagement\">GAME MANAGEMENT</a></li>\n" + 
				"<li><a href='AnyadirJuego'>Añadir Juego</a>"+
				"                </ul>\n" + 
				"            </div>\n" + 
				"        </div>\n" + 
				"<div class=\"container\">\n" + "\n" + "		<table>\n" + "			<thead>\n"
						+ "				<tr>\n" + "					<td>Titulo</td>\n"
						+ "					<td>Valoracion</td>\n" + "					<td>Genero</td>\n"
						+ "					<td>Año</td>\n" + "					<td>Plataforma</td>\n" + "				</tr>\n"
						+ "			</thead>\n" + "			<tbody>\n" + crearTabla(juegoArr) + "			</tbody>\n"
						+ "		</table>\n" + "	</div>\n" +
				"        <div class=\"footer\">\n" + 
				"            <p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + 
				"        </div>\n" + 
				"    </body>\n" + 
				"</html>";
		
		return html;
		
	}
	
	/*
	 * A partir de una Arraylist de juegos crea y devuelve las rows para la tabla
	 * @param juegoArr Arraylist de juegos
	 * @return String con las rows rellenadas de la tabla a mostrar
	 */
	public static String crearTabla(ArrayList<Juego> juegoArr) {
		String tabla = "";

		/**
		 * Por cada objeto en la array se crea una row con los valores del objeto
		 */
		for (Juego juego : juegoArr) {

			tabla += "<tr>";
			
			/**
			 * Si clica en el titulo reenvia al servlet Ficha con la id del juego
			 */
			tabla += "<td><a href='Ficha?id=" + juego.getId() + "'>" + juego.getTitulo() + "</a></td>";
			tabla += "<td>" + "VALORACION" + "</td>";
			tabla += "<td>" + query.Nombre.nombreGenero(juego.getIdGenero()) + "</td>";
			tabla += "<td>" + juego.getAnyo() + "</td>";
			tabla += "<td>" + juego.getIdPlataforma() + "</td>";
			tabla += "<td><a href='EditarJuego?idjuego="+juego.getId()+"'>" + "EDITAR"+ "</a></td>";
			tabla += "<td><a href='EliminarJuego?idjuego="+juego.getId()+"'>" + "BORRAR" + "</a></td>";

			tabla += "</tr>";
		}
		return tabla;
	}

}
