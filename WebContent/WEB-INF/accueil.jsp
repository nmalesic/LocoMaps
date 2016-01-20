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
<c:if test="${!empty userSession}"> 
     	<div>
<form>
<fieldset>
<legend>${userSession.prenomUtil} ${userSession.nomUtil} </legend>

<%-- <legend> Utilisateur </legend>
<label for="name"> Nom :</label><input type=text id="name" name="name" value="${userSession.nomUtil}"><br>
<label for="firstname"> Prénom : </label><input type=text id="firstname" name="firstname" value="${userSession.prenomUtil}"> --%>
<label for="adresse1">Adresse :</label><input type="text" id="adresse1" name="adresse1" value="${userSession.adresse1}"><Br>
<label for="adresse2">Adresse :</label><input type="text" id="adresseé" name="adresse2" value="${userSession.adresse2}"><Br>
<label for="cp">Code Postal : </label><input type="text" id="cp" name="cp" size=5 value="${userSession.CP}"><br>
<label for="ville">Ville :</label><input type="text" id="ville" name="ville" size=15 value="${userSession.ville}"><br>
<input class="sansLabel" type="button" value="Modifier Profil" />
</fieldset>
</form>
</div>

 	</c:if>	


</body>
</html>

 