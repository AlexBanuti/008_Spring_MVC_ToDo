
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>TABLERO KAMBAN</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>TABLERO</h1>
                    <p>lista tareas</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div class="row">
            	<div class="col">
            	
            	<h3> TO DO</h3>
            	<c:forEach items="${columnaToDo}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}</p>
                               <a class="btn btn-primary"
                                href="tablero/${tarea.id}/INPROGRESS" >&gt;&gt;</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            	</div>
            	
            	<div class="col">
            	 <h3>IN PROGRESS</h3>
            	 <c:forEach items="${columnaInProgress}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}</p>
                                <a class="btn btn-primary"
                                href="tablero/${tarea.id}/DONE" >&gt;&gt;</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            	</div>
            	
            	 <div class="col">
            	 	<h3>DONE</h3>
            	 	<c:forEach items="${columnaDone}" var="tarea">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${tarea.titulo}</h3>
                                <p>${tarea.descripcion}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            	</div>
            </div>
     
        </section>
          <footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    </body>
</html>