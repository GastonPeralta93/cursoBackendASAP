<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado</title>


</head>
<body>

	<h1>El resultado del juego es:</h1>
	<p>El jugador eligio:</p>
	<p>${jugador}</p>
	<br>
	<p>La computadora eligio:</p>
	<p>${computadora}</p>
	${resultado}
	<br>
	<a href="./Juego"><button type="button">Volver a jugar!</button></a>	
</body>
</html>