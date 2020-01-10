<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%! private int numero = (int) Math.floor(Math.random() * ((10 - 5) + 1) + 5); %>
<%!
public void reiniciaNumero(){
	numero = (int) Math.floor(Math.random() * ((10 - 5) + 1) + 5);	
}

%>
<%= numero %>

<p>ACIERTA EL NUMERO</p>
<form action="compruebaNumero.jsp">

<input value="<%= numero %>" style="display:none;" name="numeroAdivinar">

<input type="number" name="numero">
<input type="submit" value="dale">
</form>



</body>
</html>