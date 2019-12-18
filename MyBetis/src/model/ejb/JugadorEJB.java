package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.dao.JugadorDAO;
import model.entidad.Jugador;
@Stateless
@LocalBean
public class JugadorEJB {
	
    public ArrayList<Jugador> getJugadores() {
    	JugadorDAO JugadorDAO = new JugadorDAO();
    	
    	return JugadorDAO.getJugadores();
    }

}
