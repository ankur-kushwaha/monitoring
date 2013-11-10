<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ include file="/WEB-INF/jsp/header1.jsp"%>
<div class="container">
	<table class="checkup">
		<tr>
			<th>Subject Area <th>Business Date
				
			<th>Expected Business Date <c:forEach items="${model.busdate}"	var="prod">
						<tr>
							<td class="subarea"><c:out value="${prod.subArea}" />
							
						<td><c:out value="${prod.businessDate}" />
							
						<td class="diff"><c:out value="${prod.expectedBusDate}" />
					
				</c:forEach>
		
	</table>
		<div id="statusMessage">
			<a id="correctDates" href="#">Correct Dates</a>
		</div>
	</div>
	<script type="text/javascript" src="/monitoring/script/routinescript.js"></script>
	<%@ include file="/WEB-INF/jsp/footer1.jsp"%>