<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="register.css"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire d'inscription</title>
</head>
<body>
	<fieldset>
	    <legend>Formulaire Inscription</legend>
			<form method="POST" action="Register">
                    <label name="lblNomUtil">Nom :<span class="requis">*</span></label>
                    <input name="nomUtil" value="${form['nomUtil']}"></input><span class="error">${erreurs['nomUtil']}</span></br>
                    <label name="lblPrenomUtil">Pr�nom :<span class="requis">*</span></label>
                    <input name="prenomUtil" value="${form['prenomUtil']}"></input><span class="error">${erreurs['prenomUtil']}</span></br>
			        <label name="lblEmail">Adresse email :<span class="requis">*</span></label>
			        <input type="email" name="email" value="${form['email']}"></input><span class="error">${erreurs['email']}</span></br>
			        <label name="lblPassword">Mot de passe :<span class="requis">*</span></label>
			        <input type="password" name="password" value="${form['password']}"></input><span class="error">${erreurs['password']}</span></br>
			        <label name="lblConfirmPassword" >Confirmation du mot de passe :<span class="requis">*</span></label>
			        <input type="password" name="confirmPassword" value="${form['confirmPassword']}"></input></br>
			        <label name="lblVoie1">Adresse :<span class="requis">*</span></label>
			        <input name="adresse1" value="${form['adresse1']}"></input><span class="error">${erreurs['adresse1']}</span></br>
                    <input name="adresse2" class="sansLabel" value="${form['adresse2']}"></input><span class="error">${erreurs['adresse2']}</span></br>
                    <label name="lblCPVille">Code postal - Ville :<span class="requis">*</span></label>
                    <input name="CP" class="CP" value="${form['CP']}"></input><span class="error">${erreurs['CP']}</span>
                    <input name="ville" class="ville" value="${form['ville']}"></input><span class="error">${erreurs['ville']}</span></br>
			    </p>
			    <p>
			        <input type="submit" class="btn" name="soumettre" value="Enregistrer"></button>
                    <!--  <input type="submit" class="btn" name="annuler" value="Annuler"></button>-->

			    <p>
			</form>
			<p class="info">${actionMessage}</p>
	</fieldset>
</body>
</html>