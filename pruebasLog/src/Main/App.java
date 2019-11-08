package Main;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class App {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(App.class);	

	public static void main(String[] args) {
		
		logger.warn("El usuario con IP " + 1 + " ha sido saludado");
		logger.error("ERROR");

	}
	
}
