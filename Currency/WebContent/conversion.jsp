<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><a href="conversion.jsp?i=es">ES</a></li>
		<li><a href="conversion.jsp?i=en">EN</a></li>
	</ul>
	<%@ page import="model.ejb.Calculo"%>
	<%@ page import="javax.naming.InitialContext"%>
	<%@ page import="javax.naming.Context"%>
	<%!Calculo calculoEJB;%>

	<%
		String idioma = request.getParameter("i");
		out.print(idioma);
	%>
	<%
		Context context = null;
		try {
			context = new InitialContext();
			calculoEJB = (Calculo) context.lookup("java:global/Currency/Calculo");
		} catch (Exception e) {
			e.printStackTrace();
			out.print(e.getMessage());

		}
	%>

	<%
		if (idioma == null) {
			out.print("<h1>Conversion</h1>");
		} else if (idioma.equals("en")) {
			out.print("<h1>Convert</h1>");
		} else if (idioma.equals("es")) {
			out.print("<h1>Conversion</h1>");
		}
	%>
	<form action="conversion.jsp">
		<div>
			<label>Bitcoin</label><input type="number" name="bitcoinValor">
		</div>
		<div>
			<label>LiteCoin</label>
			<%
				if (request.getParameter("bitcoinValor") == null || request.getParameter("bitcoinValor").equals("")) {
					if (idioma == null) {
						out.print("SIN VALOR");
					} else if (idioma.equals("en")) {
						out.print("NO VALUE");
					} else if (idioma.equals("es")) {
						out.print("SIN VALOR");
					}
				} else {
					int valor = Integer.parseInt(request.getParameter("bitcoinValor"));
					int muestra = calculoEJB.convertirLitecoin(valor);
					out.print(" " + muestra);

				}
			%>
		</div>
	</form>





</body>
</html>