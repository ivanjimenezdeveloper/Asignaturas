<%@page import="model.ejb.Calculo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>THE CONTRASENYA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="password.css">
    </head>
    <%@ page import="model.ejb.Calculo" %>
    <%@ page import="javax.naming.InitialContext" %>
    <%@ page import="javax.naming.Context" %>
    <%! Calculo calculoEJB;
    String html =  " <div>\n"
			+ "            <form name=\"numerosForm\" action=\"password.jsp\">\n"
			+ "                <h1>HOW SECURE IS MY PASSWORD</h1>"
			+ "                <select class=\"contrasena\" name=\"herramienta\">\n"
			+ "                    <option value=\"1\">CPU</option>\n"
			+ "                    <option value=\"2\">GPU</option>\n"
			+ "                    <option value=\"3\">GRID</option>\n" + "                </select>\n"
			+ "                <input class=\"contrasena\" placeholder=\"ENTER PASSWORD\" type=\"password\" name=\"pass\"/>"; %>
   
    
    <%Context context = null; 
    try{
    	context = new InitialContext();
    	calculoEJB = (Calculo) context.lookup("java:global/PasswordJSP/Calculo");
    }catch(Exception e){
    	e.printStackTrace();
    }
    %>
    
    <%	
	String herramienta = request.getParameter("herramienta");
	String password = request.getParameter("pass");
    if (herramienta == null || herramienta == "" || password == null || password == "") {

	out.print( html);
	
	} else if (password.equals("123456") || password.equals("123456789") || password.equals("qwerty")
			|| password.equals("password") || password.equals("111111") || password.equals("12345678")
			|| password.equals("abc123") || password.equals("1234567") || password.equals("password1")
			|| password.equals("12345")) {
		response.sendRedirect(
				"https://edition.cnn.com/2019/04/22/uk/most-common-passwords-scli-gbr-intl/index.html");

	} else {
		
		herramienta = request.getParameter("herramienta");
		
		password = request.getParameter("pass");
		
		out.println(html);
		
		out.println("<p class=\"contrasena\">" + calculoEJB.calcularTiempo(password.length(), Integer.valueOf(herramienta)) + "</p>");
		
	}
	out.println("\n<input type=\"submit\" class=\"contrasena\"/>\n" + "</form>\n"
			+ "</div>");
		%>
	
    <body>

    


</body></html>