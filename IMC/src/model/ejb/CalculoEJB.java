package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Usuario;

@Stateless
@LocalBean
public class CalculoEJB {

	
	public Double calcularIMC(Double peso, Double estatura) {
		
		estatura = estatura/100;
		
		Double resultado = peso / (estatura * estatura);
		
		
		
		return Math.round(resultado * 100.0) / 100.0;
		
	}
	
	public void guardarCalculo(Double peso, Double estatura, Usuario user) {
		
		
		
	}
}
