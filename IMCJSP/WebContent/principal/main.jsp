<%@page import="model.entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
//Recupero el usuario de la sesion
	HttpSession sesionMain = request.getSession(true);
	Usuario user = (Usuario) sesionMain.getAttribute("user");
	String imagen;
	if (user == null ||user.getImagen() == null ) {
		imagen = "estandar.png";
	} else {
		imagen = user.getImagen();
	}
%>


<head>
<%@include file="head.jsp"%>
<%
//Recupero el modo visual y muestro el css correspondiente
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
<%@include file="nav.jsp" %>
	<div class="container">
		<div class="logoMain"></div>
		<p>IMC</p>
		<form method="GET" action="Calculo">
			<div>
				<div>
					<p>Estatura (cm):</p>
					<input type="number" name="estatura" />
				</div>
				<div>
					<p>Peso:</p>
					<input type="number" name="peso" />
				</div>
				<div>
					<input type="submit" value="Calcular" />
				</div>
			</div>
		</form>
	</div>
	<%@include file="../Footer.jsp" %>
</body>
</html>