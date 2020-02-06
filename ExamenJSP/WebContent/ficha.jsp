<%@page import="model.entidad.Distritos"%>
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
	Accidente j = (Accidente) sesionM.getAttribute("accidente");
	Tipos tipo = (Tipos) sesionM.getAttribute("tipo");
	Distritos d = (Distritos) sesionM.getAttribute("distrito");

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

		<table>
			<thead>
				<tr>
					<th>Expediente</th>
					<th>Fecha</th>
					<th>Direccion</th>
					<th>Tipo Accidente</th>
					<th>Distrito</th>
					<th>Tipo Vehiculo</th>
					<th>Tipo persona</th>
					<th>Sexo</th>
					<th>Lesividad</th>

				</tr>
			</thead>
			<tbody>
				<%
					if (j != null ) {

							out.print("<tr>");
							out.print("<td><a href='Ficha?i=" + j.getId() + "'>" + j.getExpediente() + "</a></td>");
							out.print("<td>" + j.getFecha() + "</td>");
							out.print("<td>" + j.getDireccion() + "</td>");
							out.print("<td>" + tipo.getNombre() + "</td>");
							out.print("<td>" + d.getNombre()+ "</td>");
							out.print("<td>" + j.getTipo_vehiculo() + "</td>");
							out.print("<td>" + j.getTipo_persona()+ "</td>");
							out.print("<td>" + j.getSexo() + "</td>");
							out.print("<td>" + j.getLesividad() + "</td>");






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