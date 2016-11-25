<%-- 
    Document   : categoriaList
    Created on : 11-24-2016, 01:14:25 AM
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
            <a class="btn btn-success" role="button" href="categoriaAdd">Adicionar Categoria</a> <a class="btn btn-default" role="button" href="adminIndex">Regresar</a>
            <hr>
            <div class="table-responsive">
                <table class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>Categoria</th>
                        <th style="text-align: right"></th>
                    </tr>
                    <c:forEach items="${categorias}" var="categoria">
                        <tr>
                            <td><c:out value="${categoria.idcategoria}"/></td>
                            <td><c:out value="${categoria.nombrecategoria}"/></td>
                            <td style="text-align: right"><a class="btn btn-warning" role="button" href="categoriaEdit?id=${categoria.idcategoria}"><span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-danger" role="button" href="categoriaDelete?id=${categoria.idcategoria}"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>