 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<fieldset>

    Vous etes connecté en tant que     ${userSession.pseudo}


	<div id="tabnav">

    <li class="active">
			<a href="identification"> Se connecter</a>
		</li>
		<li class="active">
            <a href="Register"> S'inscrire</a>
        </li>
	</div>
</fieldset>
<c:import url="/WEB-INF/profil.jsp" /></br>