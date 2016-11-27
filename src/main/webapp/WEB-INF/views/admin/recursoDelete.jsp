<%-- 
    Document   : recursoDelete
    Created on : 11-20-2016, 11:25:52 PM
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
            <h1><c:out value="${titulo}"/></h1>
            <hr>
            <form:form class="form-horizontal">
                <div class="form-group">
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <h4>Seguro que desea eliminar el recurso: <c:out value="${command.nombrerecurso}"/></h4>
                            <form:button class="btn btn-danger" ><span class="glyphicon glyphicon-trash"></span> Eliminar</form:button> <a class="btn btn-warning" role="button" href="admin/recursoList.html"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                            </div>
                        </div>
                    </div>
            </form:form>
        </div>
    </body>
</html>
