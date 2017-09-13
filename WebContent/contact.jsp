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
<c:set var="liste_contacts" value= "${requestScope['LISTE_CONTACTS']}"/>

	<p>./liste_contacts.sh</p>
	
	<c:forEach var="contact" items="${liste_contacts}">
		#<c:out value="${contact.id} ${contact.firstname} ${contact.name} ${contact.email} "/>
		<a href="${pageContext.request.contextPath}/contacts.do?ID=${contact.id}">...</a>
		<br>

	</c:forEach>
	
	<c:set var="liste_tag" value= "${requestScope['LISTE_TAG']}"/>

	<p>./liste_tag.sh&nbsp; ${requestScope['ID']}</p>
	
	<c:forEach var="tag" items="${liste_tag}">
		#<c:out value="${tag.id} ${tag.value} "/>
		<br>

	</c:forEach>

<!--<c:set var="addPays" value="${requestScope['ADD_TAG']}"/>
<br><br>
<form action="${pageContext.request.contextPath}/tag.do" method="post">
		./add_tag.sh :
		<br>
		#tag
		<input type= "text" name="ADD_TAG"/>
		<input type="submit" value="envoyer"/>
</form>-->

<a href="${pageContext.request.contextPath}/pays.do">./liste_pays.sh</a>
<br>
<a href="${pageContext.request.contextPath}/tag.do">./liste_tags.sh</a>
</body>
</html>