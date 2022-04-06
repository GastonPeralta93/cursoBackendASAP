<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
		<title>${titulo}</title>	
	</head>
	<body>
		<h1>PROFESOR ${profesor}</h1>
		<br>
	
		<h2 class="mx-auto" style="width: 800px;">Lista de Alumnos:</h2>
		<br>
		<table class="table table-bordered mx-auto" style="width: 800px;">
		  <tr>
		    <th scope="col">Arriba 1</th>
		    <th scope="col">Arriba 2</th>
		    <th scope="col">Arriba 3</th>
		    <th scope="col">Arriba 4</th>
		  </tr>
		  <tr>
		    <td>Alfreds Futterkiste</td>
		    <td>Maria Anders</td>
		    <td>Germany</td>
		    <td>Achalu</td>
		  </tr>
		  <tr>
		    <td>Centro Moctezuma</td>
		    <td>Francisco Chang</td>
		    <td>Mexico</td>
		    <td>Tarandim</td>
		  </tr>
		  <tr>
		    <td>Centro Moctezuma</td>
		    <td>Francisco Chang</td>
		    <td>Mexico</td>
		    <td>Babulin</td>
		  </tr>
		</table>		
		
		<ul>
			<c:forEach items="${alumnos}" var="alumno">
				<li><c:out value="${alumno}" /></li>
			</c:forEach>
		</ul>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>