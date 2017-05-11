<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCNgo7zFt-FiFjZtuPzhuDz7VUu87kIFhU&callback=initMap" charset="utf-8"></script>
	<script type="text/javascript" charset="utf-8">
	
		var map;
		var marker;
		var myPos = {lat: -8.190219817622724, lng: -34.92728375330353};
		
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
			center: myPos,
			zoom: 18
			});
		
			marker = new google.maps.Marker({
				position: myPos,
				map: map,
				draggable: false,
				animation: google.maps.Animation.DROP
			});
	
			function drop() {
				for (var i = 0; i < markerArray.length; i++) {
					setTimeout(function() {
					addMarkerMethod();
					}, i * 200);
				}
			}
			
			marker.addListener('click', function() {
				var infowindow = new google.maps.InfoWindow({
					content: "<div><h1>Compliance Software LTDA</h1><h4>Empresa focada na criação de softwares web e Android</h4></div>"
				});
				infowindow.open(map, marker);
			});

		}
		</script>

		<footer class="container-fluid text-center">
			<a href="#myPage" title="To Top">
				<span class="glyphicon glyphicon-chevron-up"></span>
			</a>
			<p>Siga-nos nas redes sociais</p>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
						<ul class="list-inline text-center">
							<li>
								<a href="http://facebook.com/compliancesoftwarebr">
									<span class="fa-stack fa-lg">
										<i class="fa fa-circle fa-stack-2x"></i>
										<i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
									</span>
								</a>
							</li>
						</ul>
						<p class="copyright text-muted">Copyright &copy; 
						<span lang="pt-br">Compliance Software</span> 2016</p>
					</div>
				</div>
			</div>
		</footer>
	<body>
</html>