<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil Utilisateur</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<form>
<fieldset>
<legend> Utilisateur </legend>
<label for="name"> Nom :</label><input type=text id="name" name="name"><br>
<label for="firstname"> Prénom : </label><input type=text id="firstname" name="firstname">
<br>
<br>
<label for="adresse">Adresse:</label><input type="text" id="adresse" name="adresse" placeholder="ex:64,rue jean rostand"> <Br>
<label for="cp">Code Postal : </label><input type="text" id="cp" name="cp" size=5 placeholder="31670"><br>
<label for="ville">Ville :</label><input type="text" id="ville" name="ville" size=15 placeholder="Labege">

</fieldset>
</form>
</body>
</html>