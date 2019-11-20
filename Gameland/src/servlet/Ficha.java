package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Juego;
import query.Nombre;

/**
 * Servlet implementation class Ficha
 */
@WebServlet("/Ficha")
public class Ficha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ficha() {
        super();
            }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean logged = false;
		String user = "";
		int id = 0;
		
		/**
		 * Creamos la sesion
		 */
		HttpSession sesion = request.getSession(true);
		
		/**
		 * Coge el atributo usuario de la sesion
		 */
		user = (String) sesion.getAttribute("user");
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
			sesion.setAttribute("idJuego", id);


		} catch (Exception e) {
					}
		/**
		 * Si encuentra hay algo que se guarde en user significa que
		 * hay un usuario Logged
		 */
		if(user != null && !user.contentEquals("")) {
			logged = true;
		}
		
		/**
		 * Si esta logged muestra la pagina para usuarios loggeados y si no la busqueda normal
		 */
		
		if(id == 0) {
			response.sendRedirect("Main");
		}
		else if(logged) {
			
			response.getWriter()
			.print(htmlLogged(user,id));			
		}else {
			
			response.getWriter()
			.print(htmlNoLogged(id));	
		}
		
	}

	/**
	 * Muestra la ficha para el usuario logged del juego con la id dada
	 * @param user Nick de usuario
	 * @param id id del juego
	 * @return String con el html
	 */
	protected String htmlLogged(String user, int id) {
		String html = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<title>Gameland - Ficha Juego</title>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\" />\n" + 
				"\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<div class=\"nav\">\n" + 
				"		<div class=\"header\">\n" + 
				"			<div class=\"logoHeader\"></div>\n" + 
				"			<h1>Gameland</h1>\n" + 
				"			<div class=\"nodoInvisibleHeader\"></div>\n" + 
				"			<div class=\"usuario\">\n" + 
				"				<div>\n" + 
				"					<p class=\"nombreUsuario\">Usuario</p>\n" + 
				"					<a class=\"fotoUsuario\">imagen</a>\n" + 
				"				</div>\n" + 
				"				<div>\n" + 
				"					<a href=\"#\">LogIn</a>\n" + 
				"					<p>|</p>\n" + 
				"					<a href=\"#\"> Register</a>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"		</div>\n" + 
				"		<div class=\"tab\">\n" + 
				"			<ul>\n" + 
				"				<li><a href=\"Main\">SEARCH</a></li>\n" + 
				"				<li><a href=\"#\">TOP Games</a></li>\n" + 
				"				<li><a href=\"MostarPorGenero\">By Genre</a></li>\n" + 
				"				<li>|</li>\n" + 
				"				<li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n" + 
				"			</ul>\n" + 
				"		</div>\n" + 
				"	</div>\n" + 
				/**
				 * Crea la ficha
				 */
				"	<div class=\"container\">\n" + crearFicha(id)+

				"		</div>\n" + 
				"	</div>\n" +  
				"	<div class=\"footer\">\n" + 
				"		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + 
				"	</div>\n" + 
				"</body>\n" + 
				"</html>";

		return html;
	}
	
	/**
	 * Muestra la ficha para el usuario no logged del juego con la id dada
	 * @param id id del juego
	 * @return String con el html
	 */
	protected String htmlNoLogged(int id) {
		
		String html = "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<title>Gameland - Ficha Juego</title>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"gameland.css\" />\n" + 
				"\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"	<div class=\"nav\">\n" + 
				"		<div class=\"header\">\n" + 
				"			<div class=\"logoHeader\"></div>\n" + 
				"			<h1>Gameland</h1>\n" + 
				"			<div class=\"nodoInvisibleHeader\"></div>\n" + 
				"			<div class=\"usuario\">\n" + 
				"				<div>\n" + 
				"					<p class=\"nombreUsuario\">Usuario</p>\n" + 
				"					<a class=\"fotoUsuario\">imagen</a>\n" + 
				"				</div>\n" + 
				"				<div>\n" + 
				"					<a href=\"#\">LogIn</a>\n" + 
				"					<p>|</p>\n" + 
				"					<a href=\"#\"> Register</a>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"		</div>\n" + 
				"		<div class=\"tab\">\n" + 
				"			<ul>\n" + 
				"				<li><a href=\"Main\">SEARCH</a></li>\n" + 
				"				<li><a href=\"#\">TOP Games</a></li>\n" + 
				"				<li><a href=\"MostarPorGenero\">By Genre</a></li>\n" + 
				"				<li>|</li>\n" + 
				"				<li><a href=\"MostrarPorPlataforma\">By Platform</a></li>\n" + 
				"			</ul>\n" + 
				"		</div>\n" + 
				"	</div>\n" + 
				"	<div class=\"container\">\n" + crearFichaNoLogged(id)+
				"	</div>\n" + 
				"	<div class=\"footer\">\n" + 
				"		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>\n" + 
				"	</div>\n" + 
				"</body>\n" + 
				"</html>";
		
		
		return html;
		
		
	}
	
	/**
	 * Crea la ficha segun la id para usuarios logged
	 * @param id id del juego
	 * @return Ficha creada del juego
	 */
	protected String crearFicha(int id) {
		
		String ficha="";
		
		Juego game = query.Busqueda.buscarJuegoPorId(id);
		double media = query.Valoracion.valoracionMedia(id);
		
		ficha += "		<div class=\"ficha\">\n" + 
				"			<div class=\"fichaImagen\"></div>\n" + 
				"			<div class=\"fichaContenido\">\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Nombre:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+game.getTitulo()+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Género:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+Nombre.nombreGenero(game.getIdGenero())+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Año:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+game.getAnyo()+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Plataforma:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+Nombre.nombrePlataforma(game.getIdPlataforma())+ "</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Valoración:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+media+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Descripción:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+ game.getDescripcion()+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
"					<form method=\"GET\" action='Valoracion'>\n" + 
"						<p class=\"fichaAtributo\">Valorar:</p>\n" + 
"						<select name=\"valor\">\n" + 
"							<option value=\"1\">1</option>\n" + 
"							<option value=\"2\">2</option>\n" + 
"							<option value=\"3\" >3</option>\n" + 
"							<option value=\"4\" >4</option>\n" + 
"							<option value=\"5\" >5</option>\n" + 
"\n" + 
"						</select>\n" + 
"                <input type=\"submit\" value=\"Añadir Valoracion\"/>\n" + 
"					</form>"+
				"				</div>\n" + 
				"			</div>\n" + 
				"		</div>";
		
		
		
		return ficha;
		
	}
	/**
	 * Crea la ficha segun la id para usuarios no logged
	 * @param id id del juego
	 * @return Ficha creada del juego
	 */
	protected String crearFichaNoLogged(int id) {
		
		String ficha="";
		
		Juego game = query.Busqueda.buscarJuegoPorId(id);
		double media = query.Valoracion.valoracionMedia(id);

		
		ficha += "		<div class=\"ficha\">\n" + 
				"			<div class=\"fichaImagen\"></div>\n" + 
				"			<div class=\"fichaContenido\">\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Nombre:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+game.getTitulo()+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Género:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+Nombre.nombreGenero(game.getIdGenero())+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Año:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+game.getAnyo()+"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Plataforma:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+Nombre.nombrePlataforma(game.getIdPlataforma())+ "</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Valoración:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+media +"</p>\n" + 
				"				</div>\n" + 
				"				<div class=\"fichaRow\">\n" + 
				"					<p class=\"fichaAtributo\">Descripción:</p>\n" + 
				"					<p class=\"fichaDescripcion\">"+ game.getDescripcion()+"</p>\n" + 
				"				</div>\n" + 
				"			</div>\n" + 
				"		</div>";
		
		
		
		return ficha;
		
	}


}
