package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Calculo_Imc;
import model.entidad.Usuario;
import model.entidad.dao.CalculoDAO;

@Stateless
@LocalBean
public class CalculoEJB {

	public Double calcularIMC(Double peso, Double estatura) {

		estatura = estatura / 100;

		Double resultado = peso / (estatura * estatura);

		return Math.round(resultado * 100.0) / 100.0;

	}

	public void guardarCalculo(Double peso, Integer estatura, Usuario user) {
		CalculoDAO calculo = new CalculoDAO();

		calculo.guardarCalculo(peso, estatura, user);

	}
	
	public ArrayList<Calculo_Imc> getCalculosUsuario(Usuario user) {
		CalculoDAO c = new CalculoDAO();
		
		return c.getCalculosUsuario(user);
	}
}
