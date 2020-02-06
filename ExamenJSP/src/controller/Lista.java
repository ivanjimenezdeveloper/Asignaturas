package controller;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ejb.AccidenteEJB;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }
	@EJB
	AccidenteEJB accidenteEJB;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		sesion.setAttribute("accidentes", accidenteEJB.busquedaGeneral() );
		sesion.setAttribute("tiposA", accidenteEJB.getTipos());
		response.setContentType("text/html;charset=utf-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/lista.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		String selector =request.getParameter("selector");
		String tipoA =request.getParameter("tipo");
		String fecha = request.getParameter("fecha");
		
		if(selector.equals("antes")) {
			sesion.setAttribute("accidentes", accidenteEJB.busquedaAccidente(tipoA, fecha) );

		}else {
			sesion.setAttribute("accidentes", accidenteEJB.busquedaAccidenteDespues(tipoA, fecha) );

		}

		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher rs = getServletContext().getRequestDispatcher("/lista.jsp");
		rs.forward(request, response);
	}

}
