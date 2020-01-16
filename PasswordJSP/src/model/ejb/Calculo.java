package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Clase que hace los calculos de la pagina de password
 * @author horabaixa
 *
 */
@Stateless(mappedName = "CalculoEJB")
@LocalBean
public class Calculo {

	/**
	 * Calcula el tiempo necesario para conseguir descifrar la pass
	 * @param numero tamaño de la pass
	 * @param herramienta herramienta estipulada en el html que descrifra la pass
	 * @return string con el tiempo de descifrado
	 */
	public String calcularTiempo(int numero, int herramienta) {
		long tamanio = (long) Math.pow(256, numero);

		long anyo = 0, meses = 0, semanas = 0, dias = 0, horas = 0, minutos = 0, segundos = 0;

		if (herramienta == 1) {

			tamanio = tamanio / 1000;

		} else if (herramienta == 2) {

			tamanio = tamanio / 12000;

		} else if (herramienta == 3) {

			tamanio = tamanio / 1500000;

		}

		if (tamanio < 1) {

			return "instantaneo";

		}

		if (tamanio >= 31536000) {

			anyo = tamanio / 31536000;
			tamanio = tamanio % 31536000;

		}
		if (tamanio >= 2592000) {

			meses = tamanio / 2592000;
			tamanio = tamanio % 2592000;

		}
		if (tamanio >= 604800) {

			semanas = tamanio / 604800;
			tamanio = tamanio % 604800;

		}
		if (tamanio >= 86400) {

			dias = tamanio / 86400;
			tamanio = tamanio % 86400;

		}
		if (tamanio >= 3600) {

			horas = tamanio / 3600;
			tamanio = tamanio % 3600;

		}
		if (tamanio >= 60) {

			minutos = tamanio / 60;
			tamanio = tamanio % 60;

		}
		if (tamanio < 60) {

			segundos = tamanio;

		}

		return anyo + " anos " + meses + " meses " + semanas + " semanas " + dias + " dias " + horas + " horas "
				+ minutos + " minutos " + segundos + " segundos";

	}

}
