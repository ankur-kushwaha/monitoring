<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title><fmt:message key="title" /></title>
</head>

<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<div class="wrapper base">
		<%@ include file="/WEB-INF/jsp/sidebar.jsp"%>
		<div class="container">
			<table class="status">
				<tr>
					<th>Subject Area
					<th>Business Date
					<th>Feed Business Date
					<th>Status
					<th>Remarks <c:forEach items="${model.status}" var="prod">
							<tr>
								<td><c:out value="${prod.subarea}" />
								<td class="sbd"><c:out value="${prod.sbd}" />
								<td class="fbd"><c:out value="${prod.fbd}" />
								<td class="status"><c:out value="${prod.status}" />
						</c:forEach>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
	<script type="text/javascript">
		$("document").ready(
				function() {
					$('.status tr')
							.each(
									function() {
										if ($(this).find('.sbd').text() == $(
												this).find('.fbd').text()
												&& $(this).find('.status')
														.text().trim() == 'S') {
											$(this).css('background-color',
													'green');
										} else {
											$(this).css('background-color',
													'red');
										}
										if ($(this).find('.status').text()
												.trim() == 'S') {
											$(this).append(
													"<td>Successfully executed for BD:"
															+ $(this).find(
																	'.fbd')
																	.text()
															+ "</td>")
										} else if ($(this).find('.status')
												.text().trim() == 'F') {
											$(this).append(
													"<td>Job failed for BD:"
															+ $(this).find(
																	'.fbd')
																	.text()
															+ "</td>")
										}else  {
											$(this).find('.status').parent().append(
													"<td>No Status</td>");
										}

									});
				});
	</script>
</body>

</html>