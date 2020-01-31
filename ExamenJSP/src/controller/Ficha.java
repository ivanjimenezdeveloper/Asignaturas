package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.EquipoEJB;
import model.ejb.JugadorEJB;

/**
 * Servlet implementation class Ficha
 */
@WebServlet("/Ficha")
public class Ficha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	JugadorEJB jugadorEJB;
	@EJB
	EquipoEJB equipoEJB;
	
    public Ficha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		HttpSession sesion = request.getSession(true);

		try {
			id = Integer.parseInt(request.getParameter("i"));

		} catch (Exception e) {
			
			id = 0;
		}
		
		sesion.setAttribute("jugador", jugadorEJB.buscarJugador(id) );
		sesion.setAttribute("equipo", equipoEJB.buscarJugador(id) );
		
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/ficha.jsp");
		rs.forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
