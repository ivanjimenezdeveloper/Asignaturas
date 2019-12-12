package pruebas;

import java.util.Date;
import java.text.SimpleDateFormat;

public class fechas {

	public static void main(String[] args) {
		String pattern = "YYYY-MM-DD hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date fecha = new Date();
		String date = simpleDateFormat.format(fecha);
		
		System.out.println(date);
	}

	

}
