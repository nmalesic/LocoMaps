<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="register.css">

<title>Identification</title>
</head>
<body>

<form method="POST">
<c:import url="/WEB-INF/banniere.jsp" /></br>
    <c:import url="/WEB-INF/menu.jsp" /></br>
            <fieldset>
            <legend>Identification</legend>
            
             Email : <input required name="email" size=50 maxlength="50" >
             Mot de passe : <input type="password" name="password" size=20 maxlength="20" />
		     <INPUT	type="SUBMIT" class="btn" name="submit" value="Soumettre">
		     <INPUT type="RESET" class="btn" name="reset" value="Rafraichir"> <br>
		</fieldset>
	</form>
<div align=right>Pas encore inscrit? <a href="Register"> S'inscrire</a></div>
</body>
</html>