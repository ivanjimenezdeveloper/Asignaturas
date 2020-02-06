<%@page import="model.ejb.AccidenteEJB"%>
<%@page import="model.entidad.Tipos"%>
<%@page import="model.entidad.Accidente"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="org.slf4j.LoggerFactory"%>
<%@ page import="ch.qos.logback.classic.Logger"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Examen JSP</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imcDark.css" />

<%
	HttpSession sesionM = request.getSession(true);
	ArrayList<Accidente> arrJ = (ArrayList) sesionM.getAttribute("accidentes");
	ArrayList<Tipos> arrT = (ArrayList) sesionM.getAttribute("tiposA");
%>

<%!AccidenteEJB accidenteEJB;%>
<%!private static final Logger logger = (Logger) LoggerFactory.getLogger(AccidenteEJB.class);%>

<%
	Context context = null;
	try {
		context = new InitialContext();
		accidenteEJB = (AccidenteEJB) context.lookup("java:global/ExamenEJB/AccidenteEJB");
	} catch (Exception e) {
		logger.error(e.getMessage());

	}
%>
</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>Examen JSP</h1>
			<div class="nodoInvisibleHeader"></div>
		</div>
		<div class="tab">
			<ul>
				<li><a href='Main'>HOME</a></li>
				<li><a href='Lista'>Lista</a></li>

			</ul>
		</div>
	</div>
	<div class="container">
		<form action="Lista" method="post">
			Tipo Accidente
			<!-- 			<input type="text" name="tipo"> -->
			<select name="tipo">
			<%
			
			if (arrT != null | !arrT.isEmpty()) {
				for (Tipos j : arrT) {
					
					out.print("<option>"+j.getNombre()+"</option>");
					
				}
			}
			%>
			</select> <br> Fecha <select name="selector">
				<option value="antes">Antes de</option>
				<option value="despues">Despues de</option>

			</select> <input type="date" name="fecha" /> <input type="submit"
				value="FILTRA">
		</form>
		<table>
			<thead>
				<tr>
					<th>Expediente</th>
					<th>Fecha</th>
					<th>Direccion</th>
					<th>Tipo Accidente</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (arrJ != null | !arrJ.isEmpty()) {
						for (Accidente j : arrJ) {
							out.print("<tr>");
							out.print("<td><a href='Ficha?i=" + j.getId() + "'>" + j.getExpediente() + "</a></td>");
							out.print("<td>" + j.getFecha() + "</td>");
							out.print("<td>" + j.getDireccion() + "</td>");
							out.print("<td>" + j.getId_distrito() + "</td>");

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