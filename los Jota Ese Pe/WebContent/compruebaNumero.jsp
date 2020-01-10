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
	
	out.print("<form action='adivina.jsp' method='reiniciaNumero'><input type='submit' value='REINICIA'></form>");
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