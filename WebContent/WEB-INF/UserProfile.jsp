<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    submitQuery(getOrigin());
    setTimeout(function(){
        document.forms["userprofile"].submit();
    }, 1000)
    
}
</script>

<div>
	<form method="POST" action="UserProfile" name="f" id="userprofile">
		<fieldset>


			<legend> Vos informations </legend>
			<label for="nomUtil"> Nom :<span class="requis">*</span></label>
			<input type=text id="nomUtil" 	name="nomUtil" value="${userSession.getLastName()}"></input><span class="error">${erreurs['nomUtil']}</span><br>
			
			<label name="lblPrenomUtil">Prénom :<span class="requis">*</span></label>
            <input name="prenomUtil" value="${userSession.getFirstName()}"></input><span class="error">${erreurs['prenomUtil']}</span></br>
            
            <label name="lblPseudo">Pseudo :<span class="requis">*</span></label>
            <input name="pseudo" value="${userSession.getPseudo()}"></input><span class="error">${erreurs['pseudo']}</span></br>
            
            
			<label for="email">Email :<span class="requis">(non modifiable)</span></label>
            <input type="text" id="email" name="email" value="${userSession.getEmail()}" readonly="readonly" ><span class="error">${erreurs['email']}</span><Br>
			
			<label for="password">Mot de passe :<span class="requis">(non modifiable)</span></label>
            <input type="text" id="password" name="password" value="${userSession.getPassword()}" readonly="readonly" ><span class="error">${erreurs['password']}</span><Br><br><br>
            
			<label name="lblVoie1">Adresse :<span class="requis">*</span></label>
            <input name="adresse1" value="${userSession.getAdress1()}"></input><span class="error">${erreurs['adresse1']}</span></br>
            <input name="adresse2" class="sansLabel" value="${userSession.getAdress2()}"></input><span class="error">${erreurs['adresse2']}</span></br>
                    <label name="lblCPVille">Code postal - Ville :<span class="requis">*</span></label>
                    <input name="CP" class="CP" value="${userSession.getCodePostal()}"></input><span class="error">${erreurs['CP']}</span>
                    <input name="ville" class="ville" value="${userSession.getCity()}"></input><span class="error">${erreurs['ville']}</span></br><br><br>
			
			<label for="telephone">N° téléphone :</label>
			<input type="text" id="telephone"  name="telephone" size=15 value="${userSession.getTelephone()}"><span class="error">${erreurs['telephone']}</span><br>
			
            <label name="lblSexe">Sexe :</label>
                    <Select name="sexe" size="1" ></br>
                        <option value='Féminin' <c:if test="${userSession.getSex() == 'Féminin'}">selected="selected"</c:if>>Féminin</option>
                        <option value='Masculin' <c:if test="${userSession.getSex() == 'Masculin'}">selected="selected"</c:if>>Masculin</option>
                    </Select><br>			
			
			<label name="lblFumeur">Fumeur :</label>
                    <Select name="fumeur" size="1" ></br>
                        <option value='Oui' <c:if test="${userSession.getSmoker() == 'Oui'}">selected="selected"</c:if>>Fumeur</option>
                        <option value='Non' <c:if test="${userSession.getSmoker() == 'Non'}">selected="selected"</c:if>>Non Fumeur</option>
                    </Select><br>
			
			
			
			<input class="btn" type="submit" value="Modifier" onclick="geocodeEtEnvoie()"/>			
			
		</fieldset>
		<p class="info">${actionMessage}</p>
		
	</form>
</div>