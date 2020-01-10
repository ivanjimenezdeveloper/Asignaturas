<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String op = "";
	double a = 0, b = 0;%>
		<%
			
			op = request.getParameter("operacion");
		try{
			if (!request.getParameter("a").equals("")) {
				a = Double.parseDouble(request.getParameter("a"));
				b = Double.parseDouble(request.getParameter("b"));
			}}finally{
				a = 0;
				b = 0;
			}
			if (op != null) {
				if (op.equals("Suma")) {
					response.getWriter().print( a + b);
				} else if (op.equals("Resta")) {

					response.getWriter().print( a - b);

				} else if (op.equals("Raiz cuadrada")) {
					response.getWriter().print(Math.sqrt(a));
				}else{
					out.print("xd");
				}
			}
			
		


	%>
	<a href="operacion.jsp">VOLVER</a>
</body>
</html>