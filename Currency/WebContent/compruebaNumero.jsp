<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
int numeroAdivinar = Integer.parseInt(request.getParameter("numeroAdivinar"));
int numero= Integer.parseInt(request.getParameter("numero"));


if(numero == numeroAdivinar){
	out.print("HAS GANAO");
	
	response.sendRedirect("adivina.jsp?ganado=1");
}else if(numero < numeroAdivinar){
	out.print("MAYOR");
	out.print("<a href='adivina.jsp'>VOLVER</a>");

}else if(numero > numeroAdivinar){
	out.print("MENOR");
	out.print("<a href='adivina.jsp'>VOLVER</a>");


}

%>
</body>
</html>