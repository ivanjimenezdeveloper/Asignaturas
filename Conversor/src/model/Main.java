package model;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ejb.*;


/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

@EJB
Calculos calcEJB;  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rs= getServletContext().getRequestDispatcher("/app.jsp");
		rs.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String selector = request.getParameter("selector");
		Double numero;
		Double total = 0.0;
		try {
			 numero = Double.parseDouble(request.getParameter("numero"));

		} catch (Exception e) {
			
			numero = 0.0;
		}
		
		if(selector.equals("c")) {
			
			total = calcEJB.farenheitToCelsius(numero);
			
		}else {
			total = calcEJB.celsiusToFarenheit(numero);
		}
		
		response.getWriter().print(total);
		
	}


}
