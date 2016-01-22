
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
	<c:if test="${!empty userSession}">    
    Vous etes connecté en tant que <i><b> ${userSession.pseudo}</b></i>.<br>
    Cliquer <a href="UserProfile"> ICI</a> pour modifier vos informations
    
    </c:if>
	
	<div id="tabnav">
        <li class="active"><a href="accueil"> Accueil</a></li>
		<li class="active"><a href="identification"> Se connecter</a></li>
		<li class="active"><a href="Register"> S'inscrire</a></li>
	</div>
</fieldset>
