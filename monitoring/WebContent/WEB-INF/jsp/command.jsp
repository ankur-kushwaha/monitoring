<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>

<body>
	<form method="post" action="index.htm">
		<textarea rows="5" cols="50" name="command"></textarea>
		<input type="submit">
	</form>
	<blockquote id="output">
		<c:out value="${model.output}"></c:out>
	</blockquote>
	<p>hello</p>
</body>
</html>