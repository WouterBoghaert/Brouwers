<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Brouwers op naam"/>
	</head>
	<body>
		<v:menu/>
		<h1>Brouwers op naam</h1>
		<spring:url var="url" value="/brouwers/beginnaam"/>
		<form:form action="${url}" commandName="brouwerBeginNaam" method="get">
			<form:label path="beginnaam">Begin van de naam:
			<form:errors path="beginnaam"/></form:label>
			<form:input path="beginnaam" autofocus="autofocus"
			type="search" required="required"/>
			<input type="submit" value="Zoeken">
			<form:errors cssClass="fout"/>
		</form:form>
		<c:if test="${not empty brouwers}">
			<ul>
				<c:forEach items="${brouwers}" var="brouwer">
					<li>${brouwer.naam}</li>
				</c:forEach>
			</ul>
		</c:if>
		
	</body>
</html>