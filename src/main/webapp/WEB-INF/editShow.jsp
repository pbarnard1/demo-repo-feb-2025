<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit show</title>
</head>
<body>
	<h1>Edit TV show</h1>
	<p><a href="/shows">All shows</a></p>
	<form:form action="/shows/${thisShow.id}/edit" method="POST" modelAttribute="thisShow">
		<input type="hidden" name="_method" value="put">
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
				<form:options items="${ ratings }"/>
			</form:select>
		</p>
		<input type="submit" value="Edit show">
	</form:form>
</body>
</html>