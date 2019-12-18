package aplicacion.modelo.ejb;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;

import org.slf4j.LoggerFactory;

import aplicacion.modelo.dao.UsuariosDAO;
import ch.qos.logback.classic.Logger;

/**
 * Clase ue periodicamente registra un evento
 * @author daw
 *
 */
@Stateless
public class RegistroEJB {

	/**
	 * Logger para la clase
	 */
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuariosDAO.class);	


	/**
	 * Método que se llama periódicamente cada minuto.
	 * @param t Temporizador
	 */	
	@Schedule(second="0", minute="*/1", hour="*", dayOfWeek="*", dayOfMonth="*", month="*", year="*", info="MyTimer")
    private void scheduledTimeout(final Timer t) {
		logger.debug("@Schedule called at: " + new java.util.Date());
    }
}