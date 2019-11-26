package ejb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PruebaEJB
 */
@WebServlet("/PruebaEJB")
public class PruebaEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaEJB() {
        super();
            }
    
	@EJB
	private CalculadoraBean ejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer a = 25;
		Integer b = 5;
		response.setContentType("text/html;charset:utf-8");
		response.getWriter().append("suma "+ ejb.suma(a, b))
		.append("<br>resta "+ ejb.resta(a, b))
		.append("<br>multiplicacion "+ ejb.multiplicacion(a, b))
		.append("<br>division "+ ejb.division(a, b))
		.append("<br>Raiz "+ ejb.raiz(a));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		doGet(request, response);
	}

}
