package vista.container;

import java.io.PrintWriter;
import java.util.ArrayList;

import model.entidad.Calculo_Imc;

public class MisCalculos {

	public static void mostrar(PrintWriter out, ArrayList<Calculo_Imc> arrCalc) {
		String html = "	<div class=\"container\">\n";

		for (Calculo_Imc c : arrCalc) {

			html += "<div class='calculo'>";

			html += "<div>";

			html += "<p> Peso: <span>" + c.getPeso() + "</span></p>";
			html += "<p> Estatura: <span>" + c.getEstatura() + "</span></p>";
			html += "<p> Fecha: <span>" + c.getFecha() + "</span></p>";

			html += "</div>";
			
			html += "<div><a href='#'>Ver</a></div>";

			html += "</div>";

		}

		html += "\n" + "	</div>";
//pinta el html
		out.append(html);
	};

}
