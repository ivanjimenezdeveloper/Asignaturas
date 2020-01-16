<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	El nombre es: 
	<%  
		// Obtenemos el objeto del request
		String nombre = (String) request.getAttribute("nombre");
	
		// Lo mostramos en función de su contenido
		if(nombre == null) {
			out.println("No hay nombre");
		}
		else if(nombre.equals("")) {
			out.println("Nombre vacío.");
		}
		else {
			out.println(nombre);
		}
	%>
</body>
</html>