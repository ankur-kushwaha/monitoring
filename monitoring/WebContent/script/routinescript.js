$('document').ready(function() {
	console.log(2);
	$('.diff').each(function() {
		var subarea = $(this).siblings('.subarea').text().trim();
		if ($(this).text() == -1) {
			$(this).parent().css('background-color', 'green');
		} else {
			$(this).parent().css('background-color', 'red');
		}
		if (subarea == ('FLSBCS') || subarea == 'FMSBCS') {
			if ($(this).text() == 0) {
				$(this).parent().css('background-color', 'green');
			} else {
				$(this).parent().css('background-color', 'red');
			}
		} else if ((subarea == ('INDX_GPR')) || (subarea == ('INDX_HSBC'))) {
			if ($(this).text() == -2) {
				$(this).parent().css('background-color', 'green');
			} else {
				$(this).parent().css('background-color', 'red');
			}
		}
		if ($(this).parent().css('background-color') == 'rgb(255, 0, 0)') {
			$(this).append("<a class='correctdates' href='#'>Correct Date</a>")
		}
	})

	$('.correctdates').live('click', function() {
		console.log("getting query");
		$subarea = $(this).parent().siblings('.subarea').text();
		console.log($subarea);
		$.post('correctDates.htm', {
			data : $subarea
		}, function(e) {
			$('#statusMessage').append("<p>" + e + "</p>");
		});
	});
	$('#correctDates').click(function() {
		$('.correctdates').click();
	});
})
