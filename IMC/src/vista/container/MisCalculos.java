package vista.container;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.entidad.Calculo_Imc;
/**
 * Muestra el html de los calculos de un ususario
 * @author HIBAN
 *
 */
public class MisCalculos {

	/**
	 * Muestra el html
	 * @param out printwriter que sirve para mostrar
	 * @param arrCalc Arraylist de calculos
	 */
	public static void mostrar(PrintWriter out, ArrayList<Calculo_Imc> arrCalc) {
		String html = "	<div class=\"container\">\n";
		
		
		String pattern = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date fecha = new Date();
		simpleDateFormat.format(fecha);
		
		for (Calculo_Imc c : arrCalc) {

			html += "<div class='calculo'>";

			html += "<div>";

			html += "<p> Peso: <span>" + c.getPeso() + "</span></p>";
			html += "<p> Estatura: <span>" + c.getEstatura() + "</span></p>";
			html += "<p> Fecha: <span>" + simpleDateFormat.format(c.getFecha()) + "</span></p>";

			html += "</div>";
			
			html += "<div><a href='Calculo?peso="+c.getPeso()+"&estatura="+c.getEstatura()+"&guardar=n'>Ver</a></div>";

			html += "</div>";

		}

		html += "\n" + "	</div>";
//pinta el html
		out.append(html);
	};

}
