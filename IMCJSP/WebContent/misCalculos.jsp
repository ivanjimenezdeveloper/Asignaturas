<%@page import="java.util.ArrayList"%>
<%@page import="model.entidad.Calculo_Imc"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
	//Recupero el usuario
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
<meta charset="ISO-8859-1">
<title>Mis Calculos</title>
<%@include file="principal/head.jsp"%>
<%
	//Recupero el modo visual estipulado

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

		<%
		//Muestro los calculos hechos
			String html = "";
			String pattern = "YYYY-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date fecha = new Date();
			simpleDateFormat.format(fecha);
			ArrayList<Calculo_Imc> arrCalc = (ArrayList) sesionMain.getAttribute("arrayCalculos");

			for (Calculo_Imc c : arrCalc) {

				html += "<div class='calculo'>";

				html += "<div>";

				html += "<p> Peso: <span>" + c.getPeso() + "</span></p>";
				html += "<p> Estatura: <span>" + c.getEstatura() + "</span></p>";
				html += "<p> Fecha: <span>" + simpleDateFormat.format(c.getFecha()) + "</span></p>";

				html += "</div>";

				html += "<div><a href='Calculo?peso=" + c.getPeso() + "&estatura=" + c.getEstatura()
						+ "&guardar=n'>Ver</a></div>";

				html += "</div>";

			}

			out.print(html);
		%>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>