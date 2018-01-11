<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v" uri="http://vdab.be/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="nl">
	<head>
		<v:head title="Brouwers"/>
	</head>
	<body>
		<v:menu/>
		<h1>Brouwers</h1>
		<h2><spring:message code="${begroeting}"/></h2>
	</body>
</html>