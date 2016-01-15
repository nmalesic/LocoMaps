

<table width="100%" align="center" style="border:none">
<tr>
<td width="50%">
<form method=POST>
<fieldset>
<legend> Utilisateur </legend>

<label for="name"> Nom :</label><input type=text id="name" name="name" value="${User.nomUtil}"><br>
<label for="firstname"> Prénom : </label><input type=text id="firstname" name="firstname" value="${User.prenomUtil}">
<br>
<br>
<label for="adresse1">Adresse :</label><input type="text" id="adresse1" name="adresse1" value="${User.adresse1}"><Br>
<label for="adresse2">Adresse :</label><input type="text" id="adresseé" name="adresse2" value="${User.adresse2}"><Br>
<label for="cp">Code Postal : </label><input type="text" id="cp" name="cp" size=5 value="${User.cp}"><br>
<label for="ville">Ville :</label><input type="text" id="ville" name="ville" size=15 value="${User.ville}">

</fieldset>
</form>
</td>

<td width="50%" rowspan="2" align="center">
		<fieldset>
		<legend> Votre carte </legend><iframe width="600" height="450" frameborder="1" style="border:0px"
src="https://www.google.com/maps/embed/v1/directions?origin=Toulouse&destination=64+rue+rostand+labege&key=AIzaSyDHdpHkRbHmVj4tZ4pt96z7lntPfvQ3naM&waypoints=Ramonville+st+agne" 
allowfullscreen></iframe>
  		</fieldset>
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
		<input type=submit value="chercher" class="sansLabel">
		
		</fieldset>
		</form>
	</td>
<td></td>

</tr>
</table>
