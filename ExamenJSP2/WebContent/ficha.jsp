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
	Jugador j = (Jugador) sesionM.getAttribute("jugador");
	ArrayList<Equipo> e = (ArrayList) sesionM.getAttribute("equipo");
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


		<table>
			<thead>
				<tr>
					<td>Nombre</td>
					<td>Equipos</td>
				</tr>
			</thead>
			<tbody>
				<%
					if (j != null) {

						out.print("<tr>");
						out.print("<td><a href='Ficha?i=" + j.getId() + "'>" + j.getNombre() + "</a></td>");
						out.print("<td>");
						if (e != null) {
							for (Equipo eq : e) {
								out.println(eq.getNombre());

							}
						}

						out.print("</td>");
						out.print("</tr>");

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