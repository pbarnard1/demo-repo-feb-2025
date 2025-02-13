<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All shows</title>
</head>
<body>
	<h1>All shows</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Show</th>
				<th>Aired by</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thisShow" items="${ allShows }">
				<tr>
					<td><c:out value="${ thisShow.id }"/></td>
					<td><c:out value="${ thisShow.title }"/></td>
					<td><c:out value="${ thisShow.airer }"/></td>
					<td><a href="/shows/${ thisShow.id }">View</a> <a href="/shows/${ thisShow.id }/edit">Edit</a>
					<form action="/shows/${ thisShow.id }/delete" method="POST">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete" />
					</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/shows/new">Add show</a></p>
</body>
</html>