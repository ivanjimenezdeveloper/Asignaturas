package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Calculos {
	
	//(0 °C × 9 / 5) + 32

	
	public double celsiusToFarenheit(double number) {
		
		return (number+9/5)+32;
		
	}
	
	//(32 °F − 32) × 5 / 9 = 0
	public double farenheitToCelsius(double number) {
		
		return (number-32)+5/9;
		
	}
}
