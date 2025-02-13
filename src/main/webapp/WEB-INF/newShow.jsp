<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a show</title>
</head>
<body>
	<h1>Add a TV show</h1>
	<p><a href="/shows">All shows</a></p>
	<form:form action="/shows/new" method="POST" modelAttribute="newShow">
		<p>
			<form:label path="title">Title:</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="airer">Network/streamer:</form:label>
			<form:errors path="airer" />
			<form:input path="airer" />
		</p>
		<p>
			<form:label path="staffCount">Number of staff members:</form:label>
			<form:errors path="staffCount" />
			<form:input type="number" path="staffCount" />
		</p>
		<p>
			<form:label path="isPresentDay">Is set in present day:</form:label>
			<form:errors path="isPresentDay" />
			<form:radiobutton value="true" label="Yes" path="isPresentDay" />
			<form:radiobutton value="false" label="No" path="isPresentDay" />
		</p>
		<p>
			<form:label path="premiereDate">Premiere date:</form:label>
			<form:errors path="premiereDate" />
			<form:input type="date" path="premiereDate" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<p>
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating" />
			<form:select path="rating">
				<form:option value="Y" />
				<form:option value="Y7" />
				<form:option value="G" />
				<form:option value="PG" />
				<form:option value="14" />
				<form:option value="MA" />
			</form:select>
		</p>
		<input type="submit" value="Add show">
	</form:form>
</body>
</html>