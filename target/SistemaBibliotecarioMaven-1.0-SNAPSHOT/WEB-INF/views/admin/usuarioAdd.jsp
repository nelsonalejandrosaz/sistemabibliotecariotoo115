<%-- 
    Document   : usuarioAdd
    Created on : 11-25-2016, 11:52:15 PM
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
                        <label for="nombre" class="control-label">Nombre:</label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <input id="nombre" name="nombre" class="form-control" type="text" value=""/>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <label for="apellidos" class="control-label">Apellidos:</label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <input id="apellidos" name="apellidos" class="form-control" type="text" value=""/>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <label for="dui" class="control-label">DUI:</label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <input id="dui" name="dui" class="form-control" type="text" value=""/>
                    </div>
                </div>
                <!-- Atributo 2 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <label for="departamento" class="control-label">Departamento:</label>
                    </div>
                    <!-- Input o select -->
                    <div class="col-sm-10">
                        <select id="departamentoS" name="departamento" class="form-control">
                            <option value="0">--- Selecione el departamento ---</option>
                            <c:forEach items="${departamentos}" var="departamento">
                                <option value="${departamento.iddepartamento}">${departamento.nombredepartamento}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <!-- Atributo 3 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <label for="municipio" class="control-label">Municipio:</label>
                    </div>
                    <!-- Input o select -->
                    <div class="col-sm-10">
                        <select id="municipioS" name="municipio" class="form-control">
                            <option value="0">--- Selecione el municipio ---</option>
                        </select>
                    </div>
                </div>
                
                
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
                        <form:label path="email" class="control-label">E-mail:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                    <form:input path="email" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 5 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <label class="control-label">Tipo usuario: </label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <select id="tipo" name="tipo" class="form-control">
                            <option value="1">Lector</option>
                            <option value="0">Administrador</option>
                        </select>
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
    <c:url value="municipioByDepartamento" var="municipioURL" />    
    <script>
        $(document).ready(function() { 
	$('#departamentoS').change(
		function() {
			id = $(this).val();
                        $("#municipioS").load("municipioByDepartamento?id="+id);
		});
        });
    </script>
</html>
