<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<fieldset>
<legend> Liste des personnes à proximité </legend>
<table class="ListUser">
<tr>
<th>Nom</th>
<th>Prénom</th>
<th>Adresse</th>
<th>Téléphone</th>
<th>email</th>
</tr>
<c:forEach var="p" items="${listUserDansRayon}" varStatus="pStatus">

<tr class="${pStatus.index%2==0?'pair':'impair'}">
<td>${p.nomUtil}</td>
<td>${p.prenomUtil }</td>
<td><c:choose>
  <c:when test="${!empty userSession}">
${p.address.getAdresse1()} ${p.address.getAdresse2()} ${p.address.getCP()} ${p.address.getVille()}
</c:when>
    <c:otherwise>
   <span class=> <a href="identification"> Vous devez être connecté</a></span>
  </c:otherwise>
</c:choose>
</td>


<td ><c:choose>
  <c:when test="${!empty userSession}">
  ${p.telephone}
     </c:when>
    <c:otherwise>
   <span class=> <a href="identification"> Vous devez être connecté</a></span>
  </c:otherwise>
</c:choose>
</td>


<td ><c:choose>
  <c:when test="${!empty userSession}">
   ${p.email}
     </c:when>
    <c:otherwise>
   <span class=> <a href="identification">  Vous devez être connecté</a></span>
  </c:otherwise>
</c:choose></td>
</tr>
</c:forEach>

</table>
</fieldset>
