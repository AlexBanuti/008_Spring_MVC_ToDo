<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  


 

<html> 
    <title>Producto no encontrado</title> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
      rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head> 
<body> 
    <section> 
        <div class="jumbotron"> 
            <div class="container"> 
                <h1 > Atención</h1> 
                <p class="alert alert-danger">
                   <spring:message code="${claveMensage}" 
                                    arguments="${argsMensage}" />
                </p>
            </div> 
        </div> 
    </section> 
    <section> 
        <div class="container"> 
            <p> 
                <a href="<spring:url value="/tablero" />" 
                   class="btn btn-primary"> 
                    <span class="glyphicon-hand-left glyphicon">
                    </span> Ir a tablero 
                </a> 
            </p> 
        </div> 
    </section> 
</body> 
</html>