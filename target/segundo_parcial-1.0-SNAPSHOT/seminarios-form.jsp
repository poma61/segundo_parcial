<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
              rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">

        <title>registro </title>
    </head>
    <body class="main">
        <div class="container">
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="seminarios"/>  
            </jsp:include>
            <br>
            <h1>
                <c:if test="${requestScope.action=='nuevo'}" var="control" scope="request">
                    Nuevo 
                </c:if>
                <c:if test="${requestScope.action=='modificar'}" var="control" scope="request">
                    Edicion de 
                </c:if>
                Seminario
            </h1>
            <br>
            <form action="Controller_seminarios" method="post">
                <input  type="hidden" name="id" value="${semi.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Titulo</label>
                    <input type="text" class="form-control" name="titulo" 
                           value="${semi.titulo}"placeholder="Escriba su titulo del seminario" required>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" name="fecha"
                           value="${semi.fecha}"      placeholder="Escriba fecha de registro" required>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Cupos</label>
                    <input type="number" class="form-control" name="cupo" 
                           value="${semi.cupo}"  placeholder="escriba su N° de cupos" required >
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
            <br>
            <a href="Controller_seminarios" class="btn btn-warning btn-sm">Volver</a>
            <br>
            <br>
        </div>
        <!-- Java Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
        <style>
            .main{
                background-image: url("img/informatica.jpg");
                opacity: 10px;
                background-position: center center;
                background-size: cover;
                height: auto;
                left: 0;
                min-height: 100%;
                min-width: 100%;
                margin: 0;
                width: auto;
                position: relative;
            }
        </style>
    </body>
</html>