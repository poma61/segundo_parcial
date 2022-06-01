
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
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">

        <title>Seminario</title>

    </head>
    <body class="main">

        <div class="container">
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value="seminarios"/>  
            </jsp:include>
            <br>
            <h1>Seminarios</h1>
            <br>
            <a href="Controller_seminarios?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i>Nuevo</a>
            <br>
            <br>
            <table class="table table-info" border="1">

                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>Cupos</th>
                    <th>Editar</th>
                    <th>Eliminar</th>

                </tr> 
                <c:forEach var="conten" items="${list_seminario}">
                    <tr>
                        <td>${conten.id}</td>
                        <td>${conten.titulo}</td>
                        <td>${conten.fecha}</td>
                        <td>${conten.cupo}</td>
                        <td><a href="Controller_seminarios?action=edit&id=${conten.id}" 
                               ><i class="fa-solid fa-pencil"></i></a></td>
                        <td><a href="Controller_seminarios?action=delete&id=${conten.id}"
                               onclick="return(confirm('Esta seguro de eliminar??'))"   ><i class="fa-regular fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>  
            </table>

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