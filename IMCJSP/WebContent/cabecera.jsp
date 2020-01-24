<%@page import="model.entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%
	HttpSession sesion = request.getSession(true);
	Usuario user = (Usuario) sesion.getAttribute("usuario");
	String imagen;
	if (user.getImagen() == null) {
		imagen = "estandar.png";
	} else {
		imagen = user.getImagen();
	}
%>
<head>
<title>IMC</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="imc.css" />
</head>
<body>
	<div class="nav">
		<div class="header">
			<div class="logoHeader"></div>
			<h1>IMC</h1>
			<div class="nodoInvisibleHeader"></div>
			<div class="usuario">
				<div>
					<p class="nombreUsuario">
						
						<%
						user.getNombre();
					%>
					</p>
					<div class="fotoUsuario"
						style='background-image: url(imagenes/ "+imagen+")'></div>
				</div>
				<div>
					<a href="Login?logout=1">Log Out</a>
					<p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>