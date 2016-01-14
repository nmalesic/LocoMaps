<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre Profil</title>
</head>
<link rel="stylesheet" type="text/css" href="register.css">
<body>
<table width="100%"> 
<tr>
<td width="60%"><form>
<fieldset>
<legend> Utilisateur</legend>
<label for="name"> Nom :</label><input type=text id="name" name="name"><br>
<label for="firstname"> Prénom : </label><input type=text id="firstname" name="firstname">
<br>
<br>
<label for="adresse">Adresse:</label><input type="text" id="adresse" name="adresse" placeholder="ex:64,rue jean rostand"> <Br>
<label for="cp">Code Postal : </label><input type="text" id="cp" name="cp" size=5 placeholder="31670"><br>
<label for="ville">Ville :</label><input type="text" id="ville" name="ville" size=15 placeholder="Labege">

</fieldset>
</form></td>
<td width="40%" align="center">
<iframe width="550" height="450" frameborder="1" style="border:1px solid black"
  src="https://www.google.com/maps/embed/v1/search?key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM&q=64+rue+rostand+labege" allowfullscreen>
</iframe>
</td>
</tr>
<tr>
<td><p>The following URL parameters are optional:</p>
<ul>
<li><code>waypoints</code> specifies one or more intermediary places to route directions
  through between the origin and destination. Multiple waypoints can be
  specified by using the pipe character (|) to separate places
  (e.g. <code>Berlin,Germany|Paris,France</code>). You can specify up to 20 waypoints. Each
  waypoint can be either a place name, address or place ID.</li>
<li><code>mode</code> defines the method of travel. Options are <code>driving</code>, <code>walking</code>
  (which prefers pedestrian paths and sidewalks, where available),
  <code>bicycling</code> (which routes via bike paths and preferred streets where
  available), <code>transit</code>, or <code>flying</code>. If no mode is specified, the
  Google Maps Embed API will show one or more of the most relevant modes
  for the specified route.</li>
<li><code>avoid</code> tells Google Maps to avoid <code>tolls</code>, <code>ferries</code> and/or <code>highways</code>.
  Separate multiple values with the pipe character (e.g.
  <code>avoid=tolls|highways</code>). Note that this doesn't preclude
  routes that include the restricted feature(s); it simply biases the result
  to more favorable routes.</li>
<li><code>units</code> specifies either <code>metric</code> or <code>imperial</code> units when displaying
  distances in the results. If <code>units</code> are not specified, the <code>origin</code>
  country of the query determines the units to use.</li>
</ul></td>
<td align="center"><iframe width="600" height="450" frameborder="1" style="border:1px solid red"
src="https://www.google.com/maps/embed/v1/directions?origin=Toulouse&destination=64+rue+rostand+labege&key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM&waypoints=Ramonville+st+agne" allowfullscreen></iframe> </td>
</tr>
</table>





</body>
</html>