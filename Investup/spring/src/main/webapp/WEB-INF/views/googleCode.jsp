<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Here u are !</h3><br>
<div id='map' style ='width:400px;height:400px;background:white;'>
</div> 
<script> 
function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
//           center: {lat: -34.397, lng: 150.644}
        center:{lat:<%=request.getAttribute("latitude")%>, lng:<%=request.getAttribute("longitude")%>}
        });
        var geocoder = new google.maps.Geocoder();

          geocodeAddress(geocoder, map);

      }

      function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }

</script> 
<!--<script async defer src='https://maps.googleapis.com/maps/api/js?key=AIzaSyDBar_R3M919kyfhIJUQrBwnC2bSBWVaLI&callback=func'> -->
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCTXJiIB9T5WQ4Iti8xQoSZpa0PinktKh4&callback=initMap"
  type="text/javascript"></script>
</script><br>
</body>
</html>