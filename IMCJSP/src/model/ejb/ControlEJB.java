package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import model.entidad.Mail;
import model.entidad.dao.ControlDAO;

/**
 *Envia correos cada 5 min al administrador y hace operaciones de registros y bajas 
*/
@Stateless
@LocalBean
public class ControlEJB {
	
	/**
	 * Envia el correo
	 */
	@Schedule(second = "00", minute = "*/5", hour = "*", persistent = false)
	public void prueba() {
		int registros =0;
		int bajas = 0;
		
		ControlDAO c = new ControlDAO();
		
		registros = c.recibirRegistros();
		bajas = c.recibirBajas();
		
		c.borrarBajas();
		c.borrarRegistros();
		
		Mail m = new Mail("smtp.gmail.com", 587, "basiliscoxalligator@gmail.com", "Ageofempires2");

		m.sendMail("ivanjl4444@hotmail.com", "basiliscoxalligator@gmail.com", "Bajaas y registors IMC", "Bajas: " + bajas +"\nRegistros: "+ registros);

	}
	
	public int recibirRegistros() {
		ControlDAO c = new ControlDAO();

		return c.recibirRegistros();
	};
	
	public int recibirBajas() {
		ControlDAO c = new ControlDAO();

		return c.recibirBajas();
	};
	
	public void borrarRegistros() {
		ControlDAO c = new ControlDAO();

		c.borrarRegistros();
	};
	public void borrarBajas() {
		ControlDAO c = new ControlDAO();

		c.borrarBajas();
	};
	/**
	 * Inserta bajas
	 */
	public void insertarBaja() {

		ControlDAO c = new ControlDAO();

		c.insertarBaja();

	}
	
	/**
	 * Inserta registros
	 */
	public void insertarRegistro() {

		ControlDAO c = new ControlDAO();

		c.insertarRegistro();

	}
}
