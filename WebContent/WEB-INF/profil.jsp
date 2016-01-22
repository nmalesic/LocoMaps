<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table width="100%" align="center" style="border:none">

<script type="text/javascript">
function geocodeEtEnvoie(){
	submitQuery(document.getElementById("origin").value);
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
		<c:if test="${!empty origin}"> <c:set var="adresse" scope="session" value="${origin}"/></c:if>
		<c:if test="${!empty userSession.adresse1}">
		<c:set var="adresse" scope="session" value="${userSession.adresse1} ${userSession.adresse2} ${userSession.CP} ${userSession.ville}"/></c:if>
		
		<label for="origin">Départ :</label><input type="text" id="origin" name="origin" value="<c:out value="${adresse}"/>" placeholder="Votre Adresse de départ" ><Br>
		<label for="destination">Destination :</label><input type="text" id="destination" name="destination" value=" *BERGER-LEVRAULT* " disabled><Br>
		<label for="waypoint1">Point de passage :</label><input type="text" id="waypoint1" name="waypoint1" placeholder="ex:Balma"><Br>
		<label for="waypoint2">Point de passage :</label><input type="text" id="waypoint2" name="waypoint2" placeholder="ex:Castanet-Tolosan"><Br>
		<label for="waypoint3">Point de passage :</label><input type="text" id="waypoint3" name="waypoint3" placeholder="ex:Berlin (mais c'est plus long!)"><Br>
		<label for="rayon">Rayon de Recherche :</label>
		<Select size="1" id="rayon" name="rayon"> 
		<option value="1" name="1" selected>1</option>
		<option value="2" name="2" >2</option>
		<option value="3" name="3" >3</option>
		</Select> KM<br>
        <input type='hidden' name='result' />
        <input type='hidden' name='coords' />
        <input type='hidden' name='coordslat' />
        <input type='hidden' name='coordslng' />
		<!-- <input type="button" value="Geocode" onclick=""/> -->
		<input class=btn type="button" value="Chercher" onClick="geocodeEtEnvoie()"/>
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
