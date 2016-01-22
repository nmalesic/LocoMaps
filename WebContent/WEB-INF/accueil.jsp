<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue sur LOCO MAPS</title>
<link rel="stylesheet" type="text/css" href="register.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="script/geocode.js"></script>


</head>
<body onload="init()">

    <c:import url="/WEB-INF/banniere.jsp" /></br>
    <c:import url="/WEB-INF/menu.jsp" /></br>
  	
	<c:import url="/WEB-INF/profil.jsp" /></br>

<c:if test="${!empty origin}"> 
     	  <c:import url="/WEB-INF/ListUser.jsp" /></br>


 	</c:if>	

</body>
</html>