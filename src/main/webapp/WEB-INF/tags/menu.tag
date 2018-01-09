<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">&#8962;</a></li>
		<li><a href="#">Brouwers</a>
			<ul>
				<li><a href="<c:url value='/brouwers'/>">Alle brouwers</a></li>
				<li><a href="<c:url value='/brouwers/beginnaam'/>">Brouwers op naam</a></li>
				<li><a href="<c:url value='/brouwers/toevoegen'/>">Brouwer toevoegen</a></li>
			</ul>
		</li>
	</ul>
</nav>
