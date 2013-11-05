<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="wrapper base">
		<%@ include file="/WEB-INF/jsp/sidebar.jsp"%>
		<div class="container">
			<h1>ODS</h1>
			<table class="consumer">
				<tr>
					<th>Subject Area
					<th>Existing Consumers
					<th>Potential Consumers <c:forEach
							items="${model.ODSconsumers}" var="consumer">
							<tr>
								<td><c:out value="${consumer.sub_area}" />
								<td><c:out value="${consumer.existing}" />
								<td><c:out value="${consumer.potential}" />
							</tr>
						</c:forEach>
			</table >
			<br>
			<h1>WH</h1>
			<table class="consumer">
				<tr>
					<th>Subject Area
					<th>Existing Consumers
					<th>Potential Consumers <c:forEach
							items="${model.WHconsumers}" var="consumer">
							<tr>
								<td><c:out value="${consumer.sub_area}" />
								<td><c:out value="${consumer.existing}" />
								<td><c:out value="${consumer.potential}" />
							</tr>
						</c:forEach>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>