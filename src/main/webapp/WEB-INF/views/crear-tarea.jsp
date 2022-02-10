<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Tarea</title>
</head>
<body>

	<form method="post" modelAttribute="nuevaTarea">
	
	Titulo: <input path="titulo" type="text"/> <!-- en el path va lo que lleva el get.atributo -->
	Descripcion: <input path="descripcion"/>
	
	<input type="submit" id="btnClear" class="btn btn-primary" value="Crear Nuevo"/>
	</form>
	
</body>
</html>