<table width="100%" align="center" style="border:none">

<script type="text/javascript">
function geocodeEtEnvoie(){
	submitQuery();
	setTimeout(function(){
	    document.forms["itineraire"].submit();
	}, 1000)
	
}
</script>
<tr>
	<td width="50%">
		<form name="f" id="itineraire" method="POST" >
		<fieldset>
		<legend> Itineraire </legend>
		<label for="origin">Départ :</label><input type="text" id="origin" name="origin" placeholder="Votre Adresse de départ" onblur="submitQuery()"><Br>
		<label for="destination">Destination :</label><input type="text" id="destination" name="destination" value=" *BERGER-LEVRAULT* " disabled><Br>
		<label for="waypoint1">Point de passage :</label><input type="text" id="waypoint1" name="waypoint1" placeholder="ex:Balma"><Br>
		<label for="waypoint2">Point de passage :</label><input type="text" id="waypoint2" name="waypoint2" placeholder="ex:Castanet-Tolosan"><Br>
		<label for="waypoint3">Point de passage :</label><input type="text" id="waypoint3" name="waypoint3" placeholder="ex:Berlin (mais c'est plus long!)"><Br>
        <input type='hidden' name='result' />
        <input type='hidden' name='coords' />
        <input type='hidden' name='coordslat' />
        <input type='hidden' name='coordslng' />
		<!-- <input type="button" value="Geocode" onclick=""/> -->
		<input type="button" value="chercher" class="sansLabel" onClick="geocodeEtEnvoie()"/>
		<div id="suggestions">  </div>
		</fieldset>
		</form>
	</td>
<td width="50%" rowspan="2" align="center">
		<fieldset>
		<legend> Votre carte </legend>
					${frame}
  		</fieldset>
 </td>
</tr>
</table>


