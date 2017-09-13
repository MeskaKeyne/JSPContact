<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="liste_pays" value= "${requestScope['LISTE_PAYS']}"/>

	<p>./liste_pays.sh</p>
	
	<c:forEach var="pays" items="${liste_pays}">
		
		#<c:out value="${pays.id} ${pays.name} ${pays.abbreviation }"/>
		<br>

	</c:forEach>

<c:set var="addPays" value="${requestScope['ADD_PAYS']}"/>
<c:set var="addAbr" value= "${requestScope['ADD_ABR']}"/>
<br><br>
<form action="${pageContext.request.contextPath}/pays.do" method="post">
		./add_pays.sh :
		<br>
		#pays
		<input type= "text" name="ADD_PAYS"/>
		<br>
		#abr
		<input type= "text" name="ADD_ABR"/>
		<input type="submit" value="envoyer"/>
<a href="${pageContext.request.contextPath}/contacts.do">cd ..</a>
</form>
</body>
</html>