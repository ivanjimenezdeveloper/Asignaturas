<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Examen JSP</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imcDark.css" />


</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>NBA</h1>
			<div class="nodoInvisibleHeader"></div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='Main'>HOME</a></li>
				<li><a href='Lista'>Lista</a></li>
				<li><a href='Estadisticas'>Estadisticas</a></li>


			</ul>
		</div>
	</div>
	<div class="container">
		<table>
			<thead>
				<tr><th>Nombre</th><th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (arrJ != null | !arrJ.isEmpty()) {
						for (Jugador j : arrJ) {
							out.print("<tr>");
							out.print("<td><a href='Ficha?i="+j.getId() +"'>"+j.getNombre()+"</a></td>");
							out.print("<td><a href='Eliminar?i="+j.getId() +"'>Eliminar</td>");

							out.print("</tr>");
						}
					}
				%>
			</tbody>
		</table>
	</div>
	<div class="footer">
		<p>Web creada por XENOTECK INDUSTRIES copyright 2019</p>
	</div>
</body>
</html>