<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About <c:out value="${ thisShow.title }"/></title>
</head>
<body>
	<h2>About <c:out value="${ thisShow.title }"/>:</h2>
	<p><a href="/shows">All shows</a></p>
	<p>Aired by: <c:out value="${ thisShow.airer }"/></p>
	<p>Has <c:out value="${ thisShow.staffCount }"/> staff members</p>
	<c:choose>
		<c:when test="${ thisShow.isPresentDay }">
			<p>Is set in the present day</p>
		</c:when>
		<c:otherwise>
			<p>Is not set in the present day</p>
		</c:otherwise>
	</c:choose>
	<p>Premiered on <fmt:formatDate value="${thisShow.premiereDate}" dateStyle="full" pattern="MMMM d, y"/></p>
	<p>Description: <c:out value="${ thisShow.description }"/></p>
	<p>Rating: <c:out value="${ thisShow.rating }"/></p>
</body>
</html>