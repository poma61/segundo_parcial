
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
                <jsp:param name="opcion" value="participantes"/>  
            </jsp:include>
            <br>
            <h1>
                <c:if test="${requestScope.action=='nuevo'}" var="control" scope="request">
                    Nuevo 
                </c:if>
                <c:if test="${requestScope.action=='modificar'}" var="control" scope="request">
                    Edicion de
                </c:if>
                Participantes
            </h1>
            <br>
            <form action="Controller_participantes" method="post">
                <input  type="hidden" name="id" value="${par.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Nombres</label>
                    <input type="text" class="form-control" name="nombres" 
                           value="${par.nombres}"placeholder="escriba su nombre" required>

                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" name="apellidos"
                           value="${par.apellidos}"      placeholder="escriba sus apellidos" required>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Seminarios</label>
                    <select name="id_seminario"  class="form-control" required >
                        <option value="">--Seleccione--</option>
                        <c:forEach var="valor" items="${list_seminario}">
                            <option value="${valor.id}" 
                                    <c:if test="${par.id_seminario==valor.id}" var="c" >
                                        selected
                                    </c:if>               
                                    >${valor.titulo}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">Confirmar Participacion</label>

                    <input class="chek" type="checkbox" name="confirmado" value="1"                      
                           <c:if test="${par.confirmado=='1'}" var="verificar" >
                               checked 
                           </c:if>           
                           >

                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
            <br>
            <a href="Controller_participantes" class="btn btn-warning btn-sm">Volver</a>
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