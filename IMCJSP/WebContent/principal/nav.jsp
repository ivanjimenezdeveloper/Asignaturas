<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="cabecera.jsp"%>
<div class=tab></div>
<ul>
	<li><a href='Main'>HOME</a></li>
	
	<%
	//recupero el usuario de la sesion
	HttpSession sesionC = request.getSession(true);
	Usuario userC = (Usuario) sesionC.getAttribute("user");
	String imagenC;
	if (userC == null ||userC.getImagen() == null ) {
		imagenC = "estandar.png";
	} else {
		imagenC = userC.getImagen();
	}
	//Si no hay usuario no mostrara el menu correspondiente
	if(userC != null){
		out.print("<li><a href='MisCalculos'>Mis calculos</a></li><li><a href='BorrarCuenta'> BORRARCUENTA</a></li>");
	}
%>
<li><a href='ChangeMode'>Change Mode</a></li>
</ul>
</div>
</div>