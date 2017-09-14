<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>#/ contact.sh</title>
</head>
<body>
<c:set var="liste_contacts" value= "${requestScope['LISTE_CONTACTS']}"/>
<c:set var="id" value= "${requestScope['ID']}"/>
<c:set var="pays" value= "${requestScope['PAYS']}"/>
<c:set var="arrayTag" value="${requestScope['LIST_BY_USER_ALL']}"/>

	<p>./liste_contacts.sh</p>
	<c:forEach var="show" items="${liste_contacts}" varStatus="status">
		<c:set var="i" value="${status.count}"></c:set>
		#<c:out value="${show.id} ${show.firstname} ${show.name} "/>
		<a href="${pageContext.request.contextPath}/contacts.do?ID=${show.id}&DELETE=false">...</a>&nbsp; 
		<a href="${pageContext.request.contextPath}/contacts.do?ID=${show.id}&DELETE=true">x</a>&nbsp; 
		<c:forEach var="tag" items="${arrayTag[i-1]}">
			<c:out value="${tag.value}"/>
		</c:forEach>
		<br>
	</c:forEach>



	<c:set var="liste_tag" value= "${requestScope['LISTE_TAG']}"/>
	<c:set var="contact" value= "${requestScope['CONTACT']}"/>

	
	<br>
	<c:if test = "${id > 0 && !requestScope['DELETE']}"> 
		<p>./show_contact.sh <c:out value="${contact.firstname} ${contact.name}" /> </p>
	
		echo &nbsp; "
		<br>
			* email: ${contact.email}
		<br>
			* tag:
		<br>
		<c:forEach var="tag" items="${liste_tag}">
			#<c:out value="${tag.id} ${tag.value} "/>
		<br>
		</c:forEach>
		* pays <c:out value="${pays.name}"/>
		&nbsp;"
	</c:if>
	<br>
	<br>
<form action="${pageContext.request.contextPath}/contacts.do" method="post">
		./add_contact.sh :
		<br>
		#nom
		<input type= "text" name="NOM"/>
		&nbsp;
		#prenom
		<input type= "text" name="PRENOM"/>
		&nbsp;
		#email
		<input type= "text" name="EMAIL"/>
		&nbsp;
		#pays
		<select name="BOX_PAYS">
		<option value="none">aucun</option>
		<c:forEach var="pays" items="${requestScope['LISTE_PAYS']}">
		<option value="${pays.abbreviation}"> <c:out value="${pays.name}" /></option>
	</c:forEach>
			</select>
		&nbsp;
		<select multiple name="BOX_TAG">
		<c:forEach var="tagss" items="${requestScope['ALL_TAG']}">
		<option value="${tagss.value}"> <c:out value="${tagss.value}" /></option>
	</c:forEach>
			</select>
		&nbsp;
	<input type="submit" value="!"/>
</form>
<a href="${pageContext.request.contextPath}/pays.do">./liste_pays.sh</a>
<br>
<a href="${pageContext.request.contextPath}/tag.do">./liste_tags.sh</a>
<a href="${pageContext.request.contextPath}/contacts.do">home</a>&nbsp; 
</body>
</html>