<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Tarea</title>
</head>
<body>

	<form:form method="post" modelAttribute="nuevaTarea">
	
	
	Titulo: <input path="titulo" type="text"/></br> <!-- en el path va lo que lleva el get.atributo --> <form:errors path="titulo" cssClass="text-danger" />

	Descripcion: <input path="descripcion"/></br>
	
	
	<input type="submit" id="btnClear" class="btn btn-primary" value="Crear Nueva"/>
	
	</form:form>
	
</body>
</html>