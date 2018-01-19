<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Alle brouwers"/>
	</head>
	<body>
		<v:menu/>
		<h1>Alle brouwers</h1>
		<c:if test="${not empty page}">
			<table>
			<thead>
				<tr>
					<th><c:url value="" var="url"><c:param name="sort" value="id"/></c:url>
					<a href="${url}">Nummer</a></th>
					<th><c:url value="" var="url"><c:param name="sort" value="naam"/></c:url>
					<a href="${url}">Naam</a></th>
					<th><c:url value="" var="url"><c:param name="sort" value="adres.straat"/></c:url>
					<a href="${url}">Straat</a></th>
					<th><c:url value="" var="url"><c:param name="sort" value="adres.huisNr"/></c:url>
					<a href="${url}">HuisNr</a></th>
					<th><c:url value="" var="url"><c:param name="sort" value="adres.postcode"/></c:url>
					<a href="${url}">Postcode</a></th>
					<th><c:url value="" var="url"><c:param name="sort" value="adres.gemeente"/></c:url>
					<a href="${url}">Gemeente</a></th>
					<th><c:url value="" var="url"><c:param name="sort" value="omzet"/></c:url>
					<a href="${url}">Omzet</a></th>
				</tr>
			</thead>
				<c:forEach items="${page.content}" var="brouwer">
					<tr>
						<td class="rechts">${brouwer.id}</td>
						<td><c:out value="${brouwer.naam}"/></td>
						<td><c:out value="${brouwer.adres.straat}"/></td>
						<td>${brouwer.adres.huisNr}</td>
						<td>${brouwer.adres.postcode}</td>
						<td><c:out value="${brouwer.adres.gemeente}"/>
						<spring:url value="/temperatuur/temperatuur/{gemeente}" var="temperatuurURL">
							<spring:param name="gemeente" value="${brouwer.adres.gemeente}"></spring:param>
						</spring:url>
						<a href="${temperatuurURL}">temperatuur</a>
						</td>
						<td class="rechts"><spring:eval expression="brouwer.omzet"/></td>
					</tr>
				</c:forEach>
			</table>
			<p class="pagineren">
				<c:forEach var="pageNr" begin="1" end="${page.totalPages}">
					<c:choose>
						<c:when test="${pageNr-1 == page.number}">
							${pageNr}
						</c:when>
						<c:otherwise>
							<c:url value="" var="url">
								<c:param name="page" value="${pageNr-1}"/>
								<c:param name="sort" value="${param.sort}"/>
							</c:url>
							<a href="${url}">${pageNr}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</p>
		</c:if>
	</body>
</html>