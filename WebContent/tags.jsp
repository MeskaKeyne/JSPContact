<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>#tags</title>
</head>
<body>
<c:set var="liste_tags" value= "${requestScope['LISTE_TAG']}"/>

	<p>./liste_tags.sh</p>
	
	<c:forEach var="tag" items="${liste_tags}">
		#<c:out value="${tag.id} ${tag.value} "/>
		<br>

	</c:forEach>

<c:set var="addPays" value="${requestScope['ADD_TAG']}"/>
<br><br>
<form action="${pageContext.request.contextPath}/tag.do" method="post">
		./add_tag.sh :
		<br>
		#tag
		<input type= "text" name="ADD_TAG"/>
		<input type="submit" value="envoyer"/>
</form>
<a href="${pageContext.request.contextPath}/contacts.do">cd ..</a>
</body>
</html>