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