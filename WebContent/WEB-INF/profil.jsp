<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil Utilisateur</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="register.css"/>
</head>
<body>
<table width="100%" align="center" style="border:none">
<tr>
<td width="45%">
<form>
<fieldset>
<legend> Utilisateur </legend>

<label for="name"> Nom :</label><input type=text id="name" name="name"><br>
<label for="firstname"> Prénom : </label><input type=text id="firstname" name="firstname">
<br>
<br>
<label for="adresse">Adresse:</label><input type="text" id="adresse" name="adresse" placeholder="ex:64,rue jean rostand"><Br>
<label for="cp">Code Postal : </label><input type="text" id="cp" name="cp" size=5 placeholder="ex:31670"><br>
<label for="ville">Ville :</label><input type="text" id="ville" name="ville" size=15 placeholder="ex:Labege">

</fieldset>
</form>
</td>
<td width="10%">&nbsp;</td>
<td width="45%" rowspan="2">
		<iframe width="550" height="450" frameborder="1" style="border:1px solid black"
  		src="https://www.google.com/maps/embed/v1/search?key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM&q=64+rue+rostand+labege" 
  		allowfullscreen></iframe>
 </td>
</tr>
<tr>
	<td>
		<form>
		<fieldset>
		<legend> Itineraire </legend>
		<label for="origin">Départ :</label><input type="text" id="origin" name="origin" placeholder="Votre Adresse de départ"><Br>
		<label for="destination">Destination :</label><input type="text" id="destination" name="destination" value=" *BERGER-LEVRAULT* " disabled><Br>
		<label for="waypoint1">Point de passage :</label><input type="text" id="waypoint1" name="waypoint1" placeholder="ex:Balma"><Br>
		<label for="waypoint2">Point de passage :</label><input type="text" id="waypoint2" name="waypoint2" placeholder="ex:Castanet-Tolosan"><Br>
		<label for="waypoint3">Point de passage :</label><input type="text" id="waypoint3" name="waypoint3" placeholder="ex:Berlin (mais c'est plus long!)"><Br>
		</fieldset>
		</form>
	</td>
<td></td>

</tr>
</table>





<%--  <c:import url="/WEB-INF/User/menu.jsp" /> --%>
</body>
</html>