package Servlets;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class LoggerPool {

	private static volatile LoggerPool instancia = null;
	private static Logger log;

	/**
	 * Clase para generar logers
	 */
	private LoggerPool() {

		log = (Logger) LoggerFactory.getLogger(LoggerPool.class);
	}

	public static LoggerPool getInstance() {
		if (instancia == null) {
			synchronized (LoggerPool.class) {
				if (instancia == null) {
					instancia = new LoggerPool();
				}

			}
		}

		return instancia;

	}
	
	/**
	 * Crea el mensaje de log de nivel debug
	 * @param msg Mensaje a guardar
	 */
	public void setDebug (String msg) {
		
		log.debug(msg);
	}
	
	/**
	 * Crea el mensaje de log de nivel error
	 * @param msg Mensaje a guardar
	 */
	public void setError(String msg) {
		log.error(msg);
	}

}
