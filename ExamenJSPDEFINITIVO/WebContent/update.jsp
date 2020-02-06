<%@page import="model.entidad.Estadisticas"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.entidad.Equipo"%>
<%@page import="model.entidad.Jugador"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>NBA</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imcDark.css" />

<%
	HttpSession sesionM = request.getSession(true);
	Estadisticas es = (Estadisticas) sesionM.getAttribute("estadisticas");

%>
</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>IMC</h1>
			<div class="nodoInvisibleHeader"></div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='Main'>HOME</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
	
	<form action="Modificar" method="post">
	<label>Puntos</label>
	<input type="number" value="<%= es.getPuntos() %>" name="puntos"/>
		<label>Partidos Jugados</label>
	
		<input type="number" value="<%= es.getPartidosJugados() %>" name="partidos"/>
			<label>Tiros campo</label>
		
		<input type="number" value="<%= es.getTirosCampo() %>" name="tirosCampo"/>
			<label>Triples</label>
		
		<input type="number" value="<%= es.getTriples() %>" name="triples"/>
			<label>Tiros Libres</label>
		
		<input type="number" value="<%= es.getTirosLibres() %>" name="tirosLibres"/>
	
	<input type="submit" value="CAMBIAR"/>
	</form>

	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>