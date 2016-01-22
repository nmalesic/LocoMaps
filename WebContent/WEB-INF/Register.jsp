<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="register.css"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire d'inscription</title>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="script/geocode.js"></script>
<script type="text/javascript">
function geocodeEtEnvoie(){
    submitQuery();
    setTimeout(function(){
        document.forms["itineraire"].submit();
    }, 1000)
    
}
</script>
</head>
<body onload="init()">
    <c:import url="/WEB-INF/banniere.jsp" /></br>
	<fieldset>
	    <legend>Formulaire Inscription</legend>
			<form method="POST" action="Register" name="f" id="itineraire">
                    <label name="lblNomUtil">Nom :<span class="requis">*</span></label>
                    <input name="nomUtil" value="${form['nomUtil']}"></input><span class="error">${erreurs['nomUtil']}</span></br>
                    <label name="lblPrenomUtil">Prénom :<span class="requis">*</span></label>
                    <input name="prenomUtil" value="${form['prenomUtil']}"></input><span class="error">${erreurs['prenomUtil']}</span></br>
                    <label name="lblPseudo">Pseudo :<span class="requis">*</span></label>
                    <input name="pseudo" value="${form['pseudo']}"></input><span class="error">${erreurs['pseudo']}</span></br>
			        <label name="lblEmail">Adresse email :<span class="requis">*</span></label>
			        <input type="email" name="email" value="${form['email']}"></input><span class="error">${erreurs['email']}</span></br>
			        <label name="lblPassword">Mot de passe :<span class="requis">*</span></label>
			        <input type="password" name="password" value="${form['password']}"></input><span class="error">${erreurs['password']}</span></br>
			        <label name="lblConfirmPassword" >Confirmer le mot de passe :<span class="requis">*</span></label>
			        <input type="password" name="confirmPassword" value="${form['confirmPassword']}"></input></br>
			        <label name="lblVoie1">Adresse :<span class="requis">*</span></label>
			        <input name="adresse1" value="${form['adresse1']}"></input><span class="error">${erreurs['adresse1']}</span></br>
                    <input name="adresse2" class="sansLabel" value="${form['adresse2']}"></input><span class="error">${erreurs['adresse2']}</span></br>
                    <label name="lblCPVille">Code postal - Ville :<span class="requis">*</span></label>
                    <input name="CP" class="CP" value="${form['CP']}"></input><span class="error">${erreurs['CP']}</span>
                    <input name="ville" class="ville" value="${form['ville']}"></input><span class="error">${erreurs['ville']}</span></br>
                    <label name="lblTelephone">N° téléphone :</label>
                    <input name="telephone" value="${form['telephone']}"></input><span class="error">${erreurs['telephone']}</span></br>
                    <label name="lblSexe">Sexe :</label>
                    <Select name="sexe" size="1" value="${form['sexe']}"></input><span class="error">${erreurs['sexe']}</span></br>
                        <Option>Féminin
                        <Option>Masculin
                    </Select><br>
                    <label name="lblFumeur">Fumeur :</label>
                    <Select name="fumeur" size="1" value="${form['fumeur']}"></input><span class="error">${erreurs['fumeur']}</span></br>
                        <Option>Non
                        <Option>Oui
                    </Select>
                    <br>
                    
			    </p>
			    <p>
			        <input type='hidden' name='result' />

                    <input type="button" class="btn" value="Enregistrer" onclick="geocodeEtEnvoie()"/>

			        <input type="reset" class="btn" name="annuler" value="Rafraîchir"/>

			    <p>
			</form>
			<p class="info">${actionMessage}</p>
	</fieldset>
</body>
</html>