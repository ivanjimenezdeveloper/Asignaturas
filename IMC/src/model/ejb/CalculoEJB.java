package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Calculo_Imc;
import model.entidad.Usuario;
import model.entidad.dao.CalculoDAO;

@Stateless
@LocalBean
/**
 * Logica de los calculos del imc
 * @author HIBAN
 *
 */
public class CalculoEJB {

	/**
	 * Calucla el IMC
	 * @param peso peso ingresado
	 * @param estatura estatura ingresada
	 * @return Double del IMC
	 */
	public Double calcularIMC(Double peso, Double estatura) {

		estatura = estatura / 100;

		Double resultado = peso / (estatura * estatura);

		return Math.round(resultado * 100.0) / 100.0;

	}

	/**
	 * Guarda el calculo en la base de datos
	 * @param peso peso a guardar
	 * @param estatura estatura a guardar
	 * @param user Usuario que ha hecho el calculo
	 */
	public void guardarCalculo(Double peso, Integer estatura, Usuario user) {
		CalculoDAO calculo = new CalculoDAO();

		calculo.guardarCalculo(peso, estatura, user);

	}
	
	/**
	 * Devuelve una array de calculos segun el usuario
	 * @param user Usuario por el que filtrar los calculos
	 * @return Arraylist de calculos
	 */
	public ArrayList<Calculo_Imc> getCalculosUsuario(Usuario user) {
		CalculoDAO c = new CalculoDAO();
		
		return c.getCalculosUsuario(user);
	}
}
