<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Brouwer toevoegen"/>
	</head>
	<body>
		<v:menu/>
		<h1>Brouwer toevoegen</h1>
		<spring:url value="/brouwers/toevoegen" var="url"/>
		<form:form action="${url}" commandName="brouwer" id="brouwerform">
			<form:label path="naam">Naam:
			<form:errors path="naam" delimiter=", "/></form:label>
			<form:input path="naam" autofocus="autofocus" required="required"
			maxlength="50"/>
			<form:label path="adres.straat">Straat:
			<form:errors path="adres.straat" delimiter=", "/></form:label>
			<form:input path="adres.straat" required="required" maxlength="50"/>
			<form:label path="adres.huisNr">Huisnr.:
			<form:errors path="adres.huisNr" delimiter=", "/></form:label>
			<form:input path="adres.huisNr" required="required" maxlength="7"/>
			<form:label path="adres.postcode">Postcode:
			<form:errors path="adres.postcode" delimiter=", "/></form:label>
			<form:input path="adres.postcode" required="required" type="number"
			min="1000" max="9999"/>
			<form:label path="adres.gemeente">Gemeente:
			<form:errors path="adres.gemeente" delimiter=", "/></form:label>
			<form:input path="adres.gemeente" required="required" maxlength="50"/>
			<form:label path="omzet">Omzet:<form:errors path="omzet"/></form:label>
			<form:input path="omzet" type="number" required="required" min="0"/>
			<input type="submit" value="Toevoegen" id="toevoegknop">
			<script>
				document.getElementById("brouwerform").addEventListener("submit",
					function() {
						document.getElementById("toevoegknop").disabled=true;
				});
			</script>
		</form:form>
	</body>
</html>