<%@page import="model.entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
//Recupero la sesion
	HttpSession sesionMain = request.getSession(true);
	Usuario user = (Usuario) sesionMain.getAttribute("user");
	String imagen;
	if (user == null || user.getImagen() == null) {
		imagen = "estandar.png";
	} else {
		imagen = user.getImagen();
	}
%>
<head>
<title>Calculo</title>
<%@include file="principal/head.jsp"%>
<%
//Muestro el css estipulado
	String modo = (String) sesionMain.getAttribute("color");

	if (modo == null) {
		out.print("<link rel='stylesheet' type='text/css' href='imc.css' />");

	} else {

		if (modo.equals("l")) {
			out.print("<link rel='stylesheet' type='text/css' href='imc.css' />");
		} else {
			out.print("<link rel='stylesheet' type='text/css' href='imcDark.css' />");
		}
	}
%>
</head>
<body>
	<%@include file="principal/nav.jsp"%>
	<div class="container">
		<h1><%
		//Muestro el resultado
		out.print(sesionMain.getAttribute("resultado")); %></h1>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>