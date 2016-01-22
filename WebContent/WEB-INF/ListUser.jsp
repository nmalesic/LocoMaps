<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<fieldset>
<legend> Liste des personnes � proximit� </legend>
<table class="ListUser">
<tr>
<th>Nom</th>
<th>Pr�nom</th>
<th>Adresse</th>
<th>T�l�phone</th>
<th>email</th>
</tr>
<c:forTokens var="p" items="raoul;john;nicolas;cyrille;gr�goire;Sylvain;Jeanine;Robert" delims=";" varStatus="pStatus">

<tr class="${pStatus.index%2==0?'pair':'impair'}">
<td>${p}</td>
<td>TEST</td>
<td><c:choose>
  <c:when test="${!empty userSession}">
  ${pStatus.count} rue du Test 99999 ESSAI
 </c:when>
    <c:otherwise>
   <span class=> <a href="identification"> Vous devez �tre connect�</a></span>
  </c:otherwise>
</c:choose>
</td>


<td ><c:choose>
  <c:when test="${!empty userSession}">
   ${pStatus.count}${pStatus.count}-${pStatus.count}${pStatus.count}-${pStatus.count}${pStatus.count}-${pStatus.count}${pStatus.count}-${pStatus.count}${pStatus.count}
     </c:when>
    <c:otherwise>
   <span class=> <a href="identification"> Vous devez �tre connect�</a></span>
  </c:otherwise>
</c:choose>
</td>


<td ><c:choose>
  <c:when test="${!empty userSession}">
   ${p}.test@test${pStatus.count}.fr
     </c:when>
    <c:otherwise>
   <span class=> <a href="identification">  Vous devez �tre connect�</a></span>
  </c:otherwise>
</c:choose></td>
</tr>
</c:forTokens>

</table>
</fieldset>