<%-- 
    Document   : usuarioListLector
    Created on : 11-24-2016, 10:48:29 PM
    Author     : Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
--%>
<%@include file="../taglib_include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head_include.jsp" %>
    </head>
    <body>
        <div class="container">
            <h1>${titulo}</h1>
            <hr>
            <a class="btn btn-success" role="button" href="recursoAdd.html">Adicionar usuario</a> <a class="btn btn-default" role="button" href="adminIndex">Regresar</a>
            <hr>
            <div class="table-responsive">
                <table class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Password</th>
                        <th>E-mail</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th style="text-align: right"></th>
                    </tr>
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr>
                            <td><c:out value="${usuario.idusuario}"/></td>
                            <td><c:out value="${usuario.usuario}"/></td>
                            <td><c:out value="${usuario.password}"/></td>
                            <td><c:out value="${usuario.email}"/></td>
                            <td><c:out value="${usuario.persona.nombre}"/></td>
                            <td><c:out value="${usuario.persona.apellidos}"/></td>
                            <td style="text-align: right"><a class="btn btn-warning" role="button" href="usuarioEdit?id=${usuario.idusuario}"><span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-danger" role="button" href="usaurioDelete?id=${usuario.idusuario}"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
