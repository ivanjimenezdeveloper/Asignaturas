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

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.ejb.EquipoEJB;
import model.ejb.EstadisticasEJB;
import model.ejb.JugadorEJB;
import model.entidad.Estadisticas;
import model.entidad.dao.JugadorDAO;

/**
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	EstadisticasEJB estadisticasEJB;
	@EJB
	EquipoEJB equipoEJB;
	@EJB
	JugadorEJB jugadorEJB;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(JugadorDAO.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modificar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id;
		HttpSession sesion = request.getSession(true);

		try {
			id = Integer.parseInt(request.getParameter("i"));

		} catch (Exception e) {

			id = 0;
		}

		sesion.setAttribute("estadisticas", estadisticasEJB.estadisticasJugador(id));
		sesion.setAttribute("jugador", jugadorEJB.buscarJugador(id));
		sesion.setAttribute("equipo", equipoEJB.buscarJugador(id));

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/update.jsp");
		rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer partidos, tirosCampo, triples, tirosLibres, puntos;
		HttpSession sesion = request.getSession(true);
		boolean cambio = true;
		Estadisticas es = (Estadisticas) sesion.getAttribute("estadisticas");

		try {
			partidos = Integer.parseInt(request.getParameter("partidos"));
			tirosCampo = Integer.parseInt(request.getParameter("tirosCampo"));
			triples = Integer.parseInt(request.getParameter("triples"));
			tirosLibres = Integer.parseInt(request.getParameter("tirosLibres"));
			puntos = Integer.parseInt(request.getParameter("puntos"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			cambio = false;
			partidos = 0;
			tirosCampo = 0;
			triples = 0;
			tirosCampo = 0;
			puntos = 0;
			tirosLibres = 0;
		}
		if(cambio == true) {
			estadisticasEJB.cambiarEstadisticas(puntos, partidos, tirosCampo, triples, tirosLibres, es.getIdJugador());

		}

		response.sendRedirect("Main");
	}

}
