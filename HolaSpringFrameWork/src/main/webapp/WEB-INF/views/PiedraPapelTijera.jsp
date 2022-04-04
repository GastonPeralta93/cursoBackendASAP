<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Piedra Papel Tijera</title>

</head>
<body>
	<br>
		<form action="http://localhost:8081/HolaSpringFrameWork/Resultado" method="GET">
		<h1>Elija una opcion:</h1>
		<br><br><br>
		
		<select name ="selOpcion"> 
			<c:forEach items="${opciones}" var="opcion">
				<option value="${opcion.getNumero()}">${opcion}</option>			
			</c:forEach>
		</select>
		
		<p><button type="submit">Enviar elección</button></p>
	</form>

</body>
</html>