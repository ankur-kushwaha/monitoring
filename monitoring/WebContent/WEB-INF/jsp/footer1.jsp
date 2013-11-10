</td>
	</table>
	<footer>Copyright @Ankur Kushwaha</footer>
	<script type="text/javascript">
		$('document').ready(function(){
			$('.sidebar a').live('click',function(){
				$url=$(this).attr('class');
				$url="/monitoring/"+$url;
				$('#page').attr('src',$url);
			})
		})
	</script>
</body>
</html>