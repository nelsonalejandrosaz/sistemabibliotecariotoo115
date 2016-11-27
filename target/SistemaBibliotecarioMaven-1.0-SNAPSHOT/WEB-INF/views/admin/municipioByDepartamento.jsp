<%-- 
    Document   : municipioByDepartamento
    Created on : 11-26-2016, 12:23:09 AM
    Author     : Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${municipios}" var="municipio">
    <option value="${municipio.idmunicipio}">${municipio.nombremunicipio}</option>
</c:forEach>
