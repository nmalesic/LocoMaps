    <c:import url="/WEB-INF/banniere.jsp" /></br>
<fieldset>

<c:if test="${!errorStatus}">    
    Vous etes connecté en tant que     ${UserSession.pseudo}
</c:if>

	<div id="tabnav">

    <li class="active">
			<a href="identification"> Se connecter</a>
		</li>
		<li class="active">
            <a href="Register"> S'inscrire</a>
        </li>
	</div>
</fieldset>
