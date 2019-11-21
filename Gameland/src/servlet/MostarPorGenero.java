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
 * Servlet implementation class MostarPorGenero
 */
@WebServlet("/MostarPorGenero")
public class MostarPorGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MostarPorGenero() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idGenero = 1;

		// Recoge el parametro de busqueda

		try {
			idGenero = Integer.parseInt(request.getParameter("idgenero"));

		} catch (Exception e) {
			// Logger
		}
		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		boolean logged = false;
		String user = "";

		// Creamos la sesion

		HttpSession sesion = request.getSession(true);

		// Coge el atributo usuario de la sesion

		user = (String) sesion.getAttribute("user");

		/*
		 * Si encuentra hay algo que se guarde en user significa que hay un usuario
		 * Logged
		 */
		if (user != null && !user.contentEquals("")) {
			logged = true;
		}

		// Guarda en una array los elementos encontrados

		juegoArr = query.Busqueda.buscarPorGenero(idGenero);
		/*
		 * En caso de no encontrar nada devuelve al main. Si esta logged envia al html
		 * de usuarios loggeados y en caso contrario envia al html de usuarios anonimos
		 */
		if (juegoArr.isEmpty()) {
			response.sendRedirect("Main");

		} else {
			if (logged == true) {
				response.getWriter().print(htmlLogged(juegoArr, user));

			}

			else {

				response.getWriter().print(htmlNoLogged(juegoArr));

			}
		}

	}

	/**
	 * Crea el html con su tabla
	 * 
	 * @param juegoArr Arraylist de juegos para crear la tabla
	 * @return String que contiene el html
	 */
	protected String htmlNoLogged(ArrayList<Juego> juegoArr) {

		String html = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<title>Gameland - Table</title>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\" />\n" + "\n" + "</head>\n"
				+ "<body>\n" + "	<div class=\"nav\">\n" + "		<div class=\"header\">\n"
				+ "			<div class=\"logoHeader\"></div>\n" + "			<h1>Gameland</h1>\n"
				+ "			<div class=\"nodoInvisibleHeader\"></div>\n" + "			<div class=\"usuario\">\n"
				+ "				<div>\n" + "					<p class=\"nombreUsuario\">Usuario</p>\n"
				+ "					<a class=\"fotoUsuario\">imagen</a>\n" + "				</div>\n"
				+ "				<div>\n" + "					<a href=\"Login\">LogIn</a>\n"
				+ "					<p>|</p>\n" + "					<a href=\"Register\"> Register</a>\n"
				+ "				</div>\n" + "			</div>\n" + "		</div>\n" + "		<div class=\"tab\">\n"
				+ "			<ul>\n" + "				<li><a href=\"Main\">SEARCH</a></li>\n"
				+ "				<li><a href=\"\">TOP Games</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero\">By Genre</a></li>\n" + "				<li>|</li>\n"
				+ "				<li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n" + "			</ul>\n"
				+ "		</div>\n" + "	</div>\n" + "	<div class=\"containerGenero\">		<div class=\"divGenero\">\n"
				+ "			<ul>\n" + "				<li><a href=\"MostarPorGenero?idgenero=1\">SHOOTER</a></li>\n"
				+ "				<li> <a href=\"MostarPorGenero?idgenero=2\">DEPORTE</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero?idgenero=3\">ESTRATEGIA</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero?idgenero=4\">PUZZLE</a></li>\n" + "\n"
				+ "			</ul>\n" + "		</div>\n" + "\n" + "		<div class=\"divGenero\">\n"
				+ "			<table>\n" + "				<thead>\n" + "					<tr>\n"
				+ "						<td>Titulo</td>\n" + "						<td>Valoracion</td>\n"
				+ "						<td>Genero</td>\n" + "						<td>Año</td>\n"
				+ "						<td>Plataforma</td>\n" + "					</tr>\n"
				+ "				</thead>\n" + "				<tbody>\n" + crearTabla(juegoArr) + "			</tbody>\n"
				+ "		</table>\n" + "	</div>\n</div>" + "	<div class=\"footer\">\n"
				+ "		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + "	</div>\n" + "</body>\n"
				+ "</html>";

		return html;

	}

	/**
	 * Crea el html con su tabla
	 * 
	 * @param juegoArr Arraylist de juegos para crear la tabla
	 * @return String que contiene el html
	 */
	protected String htmlLogged(ArrayList<Juego> juegoArr, String user) {
		String html = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<title>Gameland - Table</title>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\" />\n" + "\n" + "</head>\n"
				+ "<body>\n" + "	<div class=\"nav\">\n" + "		<div class=\"header\">\n"
				+ "			<div class=\"logoHeader\"></div>\n" + "			<h1>Gameland</h1>\n"
				+ "			<div class=\"nodoInvisibleHeader\"></div>\n" + "			<div class=\"usuario\">\n"
				+ "                <div class=\"usuario\">\n" + "                    <div>\n"
				+ "                        <p class=\"nombreUsuario\">" + user
				+ "</p> <a class=\"fotoUsuario\">imagen</a>\n" + "                    </div>\n"
				+ "                    <div>            \n"
				+ "                        <a href=\"Logout\">Log Out</a> <p>" + "                    </div>\n"
				+ "			</div>\n" + "		</div>\n" + "		<div class=\"tab\">\n" + "			<ul>\n"
				+ "				<li><a href=\"Main\">SEARCH</a></li>\n"
				+ "				<li><a href=\"#\">TOP Games</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero\">By Genre</a></li>\n" + "				<li>|</li>\n"
				+ "				<li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n" + "			</ul>\n" + "		</div>\n"
				+ "	</div>\n" + "</div>	<div class=\"containerGenero\">		<div class=\"divGenero\">\n"
				+ "			<ul>\n" + "				<li><a href=\"MostarPorGenero?idgenero=1\">SHOOTER</a></li>\n"
				+ "				<li> <a href=\"MostarPorGenero?idgenero=2\">DEPORTE</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero?idgenero=3\">ESTRATEGIA</a></li>\n"
				+ "				<li><a href=\"MostarPorGenero?idgenero=4\">PUZZLE</a></li>\n" + "\n"
				+ "			</ul>\n" + "		</div>\n" + "\n" + "		<div class=\"divGenero\">\n"
				+ "			<table>\n" + "				<thead>\n" + "					<tr>\n"
				+ "						<td>Titulo</td>\n" + "						<td>Valoracion</td>\n"
				+ "						<td>Genero</td>\n" + "						<td>Año</td>\n"
				+ "						<td>Plataforma</td>\n" + "					</tr>\n"
				+ "				</thead>\n" + "				<tbody>\n" + crearTabla(juegoArr) + "			</tbody>\n"
				+ "		</table>\n" + "	</div>\n</div>" + "	<div class=\"footer\">\n"
				+ "		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + "	</div>\n" + "</body>\n"
				+ "</html>";

		return html;
	}

	/**
	 * A partir de una Arraylist de juegos crea y devuelve las rows para la tabla
	 * 
	 * @param juegoArr Arraylist de juegos
	 * @return String con las rows rellenadas de la tabla a mostrar
	 */
	public static String crearTabla(ArrayList<Juego> juegoArr) {
		String tabla = "";
		String mostrarValoracion;

		// Por cada objeto en la array se crea una row con los valores del objeto

		for (Juego juego : juegoArr) {

			tabla += "<tr>";
			double valoracion = query.Valoracion.valoracionMedia(juego.getId());

			if (valoracion <= 0) {
				mostrarValoracion = "Sin valoraciones";
			} else {
				mostrarValoracion = "" + valoracion;
			}

			// Si clica en el titulo reenvia al servlet Ficha con la id del juego

			tabla += "<td><a href='Ficha?id=" + juego.getId() + "'>" + juego.getTitulo() + "</a></td>";
			tabla += "<td>" + mostrarValoracion + "</td>";
			tabla += "<td>" + query.Nombre.nombreGenero(juego.getIdGenero()) + "</td>";
			tabla += "<td>" + juego.getAnyo() + "</td>";
			tabla += "<td>" + juego.getIdPlataforma() + "</td>";

			tabla += "</tr>";
		}
		return tabla;
	}

}
