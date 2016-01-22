<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votre Profil</title>
<link rel="stylesheet" type="text/css" href="register.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/banniere.jsp" />
</br>
<c:import url="/WEB-INF/menu.jsp" />
</br>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="script/geocode.js"></script>
<script type="text/javascript">
function geocodeEtEnvoie(){
    submitQuery();
    setTimeout(function(){
        document.forms["userprofile"].submit();
    }, 1000)
    
}
</script>

<div>
	<form method="POST" action="UserProfile" id="userprofile">
		<fieldset>

			<legend> Vos informations </legend>
			<label for="nomUtil"> Nom :<span class="requis">*</span></label>
			<input type=text id="nomUtil" 	name="nomUtil" value="${userSession.nomUtil}"></input><span class="error">${erreurs['nomUtil']}</span><br>
			
			<label name="lblPrenomUtil">Prénom :<span class="requis">*</span></label>
            <input name="prenomUtil" value="${userSession.prenomUtil}"></input><span class="error">${erreurs['prenomUtil']}</span></br>
            
            <label name="lblPseudo">Pseudo :<span class="requis">*</span></label>
            <input name="pseudo" value="${userSession.pseudo}"></input><span class="error">${erreurs['pseudo']}</span></br>
            
            
			<label for="email">Email :<span class="requis">(non modifiable)</span></label>
            <input type="text" id="email" name="email" value="${userSession.email}" readonly="readonly" ><span class="error">${erreurs['email']}</span><Br>
			
			<label for="password">Mot de passe :<span class="requis">(non modifiable)</span></label>
            <input type="text" id="password" name="password" value="${userSession.password}" readonly="readonly" ><span class="error">${erreurs['password']}</span><Br><br><br>
            
			<label name="lblVoie1">Adresse :<span class="requis">*</span></label>
            <input name="adresse1" value="${userSession.adresse1}"></input><span class="error">${erreurs['adresse1']}</span></br>
            <input name="adresse2" class="sansLabel" value="${userSession.adresse2}"></input><span class="error">${erreurs['adresse2']}</span></br>
                    <label name="lblCPVille">Code postal - Ville :<span class="requis">*</span></label>
                    <input name="CP" class="CP" value="${userSession.CP}"></input><span class="error">${erreurs['CP']}</span>
                    <input name="ville" class="ville" value="${userSession.ville}"></input><span class="error">${erreurs['ville']}</span></br><br><br>
			
			<label for="telephone">N° téléphone :</label>
			<input type="text" id="telephone"  name="telephone" size=15 value="${userSession.telephone}"><span class="error">${erreurs['telephone']}</span><br>
			
            <label name="lblSexe">Sexe :</label>
                    <Select name="sexe" size="1" ></br>
                        <option value='Féminin' <c:if test="${userSession.sexe == 'Féminin'}">selected="selected"</c:if>>Féminin</option>
                        <option value='Masculin' <c:if test="${userSession.sexe == 'Masculin'}">selected="selected"</c:if>>Masculin</option>
                    </Select><br>			
			
			<label name="lblFumeur">Fumeur :</label>
                    <Select name="fumeur" size="1" ></br>
                        <option value='Oui' <c:if test="${userSession.fumeur == 'Oui'}">selected="selected"</c:if>>Fumeur</option>
                        <option value='Non' <c:if test="${userSession.fumeur == 'Non'}">selected="selected"</c:if>>Non Fumeur</option>
                    </Select><br>
			
			
			
			<input class="btn" type="submit" value="Modifier" onclick="geocodeEtEnvoie()"/>			
			
		</fieldset>
		<p class="info">${actionMessage}</p>
		
	</form>
</div>