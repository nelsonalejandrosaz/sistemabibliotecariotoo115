<%-- 
    Document   : usuarioEdit
    Created on : 11-24-2016, 11:13:59 PM
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
            <!-- Inicio del form -->
            <form:form class="form-horizontal">
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="usuario" class="control-label">Usuario:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="usuario" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 2 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                    <form:label path="password" class="control-label">Password:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                    <form:input id="password" path="password" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 4 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="email" class="control-label">Sinopsis:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                    <form:input path="email" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Boton enviar -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <form:button onclick="cifrar()" class="btn btn-success" ><span class="glyphicon glyphicon-refresh"></span> Actualizar</form:button> <a class="btn btn-success" role="button" href="personaEdit.html"><span class="glyphicon glyphicon-edit"></span> Editar datos personales</a> <a class="btn btn-warning" role="button" href="usuarioList"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                    </div>
                </div>
            </form:form>
            <!-- Fin del form -->
        </div>
    </body>
</html>
