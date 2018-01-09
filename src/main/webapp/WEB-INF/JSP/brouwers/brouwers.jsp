<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Alle brouwers"/>
	</head>
	<body>
		<v:menu/>
		<h1>Alle brouwers</h1>
		<c:if test="${not empty brouwers}">
			<table>
			<thead>
				<tr>
					<th>Nummer</th>
					<th>Naam</th>
					<th>Straat</th>
					<th>HuisNr</th>
					<th>Postcode</th>
					<th>Gemeente</th>
					<th>Omzet</th>
				</tr>
			</thead>
				<c:forEach items="${brouwers}" var="brouwer">
					<tr>
						<td class="rechts">${brouwer.brouwerNr}</td>
						<td><c:out value="${brouwer.naam}"/></td>
						<td><c:out value="${brouwer.adres.straat}"/></td>
						<td>${brouwer.adres.huisNr}</td>
						<td>${brouwer.adres.postcode}</td>
						<td><c:out value="${brouwer.adres.gemeente}"/></td>
						<td class="rechts"><fmt:formatNumber value="${brouwer.omzet}"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</body>
</html>