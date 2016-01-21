
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
	<c:if test="${!empty userSession}">    
    Vous etes connecté en tant que <i><g> ${userSession.pseudo}
			</g></i>
	</c:if>
	<div id="tabnav">

		<li class="active"><a href="identification"> Se connecter</a></li>
		<li class="active"><a href="Register"> S'inscrire</a></li>
	</div>
</fieldset>
