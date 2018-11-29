<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="greeting" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty name}">
	<h2><font color="white">${greeting}, ${name}!</font></h2> 
</c:if>

	