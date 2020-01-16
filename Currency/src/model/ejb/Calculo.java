package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(mappedName = "CalculoEJB")
@LocalBean
public class Calculo {
	private int litecoin = 151;
	public int convertirLitecoin(int bitcoin) {
		int litecoinR;
		litecoinR = bitcoin*151;
		return litecoinR;
	}
}
