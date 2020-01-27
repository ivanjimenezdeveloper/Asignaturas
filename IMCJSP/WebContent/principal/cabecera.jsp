<%@page import="model.entidad.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
//recupero el usuario de la sesion
		HttpSession sesion = request.getSession(true);
		Usuario userNav = (Usuario) sesion.getAttribute("user");

	%>
<div class="nav">
	<div class="header">
		<div class="logoHeader"></div>
		<h1>IMC</h1>
		<div class="nodoInvisibleHeader"></div>
		<div class="usuario">
			<div>
				<p class="nombreUsuario">

					<%
					//Muestro el nombre del usuario o en caso contrario Muestro el nombre estandar
						if(userNav == null){
							out.print("Usuario");
						}else{
							out.print(userNav.getNombre());
	
						}
						%>
				</p>
				<div class="fotoUsuario"
					style='background-image: url(imagenes/ "+imagen+")'></div>
			</div>
			<div>
				<%
				//muestro el menu segun para usuarios registrados o anonimos
				if(userNav == null){
					
					out.print(				"<a href=\"Login\">LogIn</a>\n" + 
							"<p>|</p>\n" + 
							"<a href=\"Register\"> Register</a>\n" );

				}else{
					out.print(" <a href='Login?logout=1'>Log Out</a>");

				}
				 %>
				<p>
			</div>
		</div>