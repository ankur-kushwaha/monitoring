<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>

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
                <table class="checkup">
                    <tr>
                        <th>Subject Area
                        <th>Business Date
                        <th>Expected Business Date <c:forEach items="${model.busdate}"
                                   var="prod">
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
        </div>
        <%@ include file="/WEB-INF/jsp/footer.jsp"%>
        <script>
            $('document')
                    .ready(
                    function() {
                    	
                        $('.diff')
                                .each(
                                function() {
                                    var subarea = $(this).siblings(
                                            '.subarea').text()
                                            .trim();
                                    if ($(this).text() == -1) {
                                        $(this).parent().css(
                                                'background-color',
                                                'green');
                                    } else {
                                        $(this).parent().css(
                                                'background-color',
                                                'red');
                                    }
                                    if (subarea == ('FLSBCS')
                                            || subarea == 'FMSBCS') {
                                        if ($(this).text() == 0) {
                                            $(this)
                                                    .parent()
                                                    .css(
                                                    'background-color',
                                                    'green');
                                        } else {
                                            $(this)
                                                    .parent()
                                                    .css(
                                                    'background-color',
                                                    'red');
                                        }
                                    } else if ((subarea == ('INDX_GPR'))
                                            || (subarea == ('INDX_HSBC'))) {
                                        if ($(this).text() == -2) {
                                            $(this)
                                                    .parent()
                                                    .css(
                                                    'background-color',
                                                    'green');
                                        } else {
                                            $(this)
                                                    .parent()
                                                    .css(
                                                    'background-color',
                                                    'red');
                                        }
                                    }
                                    if ($(this).parent().css(
                                            'background-color') == 'rgb(255, 0, 0)') {
                                        $(this)
                                                .append(
                                                "<a class='correctdates' href='#'>Correct Date</a>")
                                    }
                                })

                        $('.correctDates').live('click',
                                function() {
                                    alert(1);
                                    $subarea = $(this).parent().siblings(
                                            '.subarea').text();
                                    console.log($subarea);
                                    $.post('correctDates.htm', {
                                        data: $subarea
                                    }, function(e) {
                                        $('#statusMessage').append(
                                                "<p>" + e + "</p>");
                                    });
                                });
                        $('#correctDates').click(function() {
                        	alert(1);
                        	console.log(1);
                            $('table a').click();
                        });
                    })
        </script>
    </body>
</html>