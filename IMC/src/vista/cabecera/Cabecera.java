package vista.cabecera;

import java.io.PrintWriter;

import model.entidad.usuario.Usuario;

public class Cabecera {

	public static void mostrarLogged(PrintWriter out, Usuario user) {
		String html = "<!DOCTYPE html>\n" + "<html>\n" + "    <head>\n" + "        <title>IMC</title>\n"

				+ "        <meta charset=\"UTF-8\">\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "        <link rel=\"stylesheet\" type=\"text/css\" href=\"imc.css\"/>\n" + "\n"
				+ "    </head>\n" + "    <body>\n" + "        <div class=\"nav\">\n"
				+ "            <div class=\"header\">  \n"
				+ "                <div class=\"logoHeader\"></div><h1>IMC</h1>\n"
				+ "                <div class=\"nodoInvisibleHeader\"></div>\n"
				+ "                <div class=\"usuario\">\n" + "                    <div>\n"
				+ "                        <p class=\"nombreUsuario\">" + user.getCorreo()
				+ "</p> <a class=\"fotoUsuario\">imagen</a>\n" + "                    </div>\n"
				+ "                    <div>            \n"
				+ "                        <a href=\"Logout\">Log Out</a> <p>" + " </div>\n"
				+ "                </div>\n" + "            </div>\n" ;

		out.append(html);
	};

}
