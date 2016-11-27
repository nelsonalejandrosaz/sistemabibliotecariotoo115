<%-- 
    Document   : indexAdmin
    Created on : 11-13-2016, 06:20:57 PM
    Author     : nelso
--%>
<%@include file="../taglib_include.jsp" %>
<%@include file="../taglib_include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head_include.jsp" %>
    </head>
    <body>
        <%@include file="../navbar_include.jsp" %>
        <div class="container">
            <h1>${titulo}</h1>
            <hr>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <a role="button" class="btn btn-default" href="<c:url value="admin/recursoList"/>">Recursos</a>
                </div>
                <div class="btn-group" role="group">
                    <a role="button" class="btn btn-default" href="<c:url value="admin/categoriaList"/>">Categorias</a>
                </div>
                <div class="btn-group" role="group">
                    <a role="button" class="btn btn-default" href="<c:url value="admin/subcategoriaList"/>">Subcategorias</a>
                </div>
            </div>
            <hr>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <a role="button" class="btn btn-default" href="<c:url value="admin/usuarioAdminList"/>">Administradores</a>
                </div>
                <div class="btn-group" role="group">
                    <a role="button" class="btn btn-default" href="<c:url value="admin/usuarioLectorList"/>">Lectores</a>
                </div>
            </div>
        </div>        
    </body>
</html>
