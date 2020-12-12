
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>      
         
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Anuncio&accion=Agregar" method="POST">
                            <div class="form-group">
                                <label>Titulo</label>
                                <input type="text" value="${anuncio.getTitulo()}" name="txtTitulo" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Contenido</label>
                                <input type="text" value="${anuncio.getContenido()}" name="txtContenido" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="text" value="${anuncio.getPrecio()}" name="txtPrecio" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Fecha</label>
                                <input type="text" value="${anuncio.getFecha()}" name="txtFecha" class="form-control">
                            </div>    
                            <c:forEach var="a" items="${anuncio}">
                            <a class="btn btn-primary" href="Controlador?menu=Anuncio&accion=Agregar&id=${a.getId()}">Nuevo</a>
                            <a class="btn btn-warning" href="Controlador?menu=Anuncio&accion=Editar&id=${a.getId()}">Editar</a>
                            <a class="btn btn-primary" href="Controlador?menu=Anuncio&accion=Actualizar&id=${a.getId()}">Actualizar</a>

                            <a class="btn btn-danger" href="Controlador?menu=Anuncio&accion=Delete&id=${a.getId()}">Delete</a>
                          </c:forEach>
                        </form>
                    </div>                         
                </div>
            </div>                     
            
        </div>      
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
