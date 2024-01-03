<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/header.jsp" />
<br>
<div class="container">
	<c:if test="${not empty ticket}">
		<h1>Ticket</h1>
		<hr>
		<p>
			<span class="font-weight-bold"> Title : </span> ${ticket.title}
		</p>
		<p>
			<span class="font-weight-bold"> CreatedOn : </span> ${ticket.createdOn}
		</p>
		<p>
			<span class="font-weight-bold"> Short Description : </span>
			${ticket.shortDescription}
		</p>
		<p>
			<span class="font-weight-bold">Content</span>
		</p>
		<p>${ticket.content}</p>
	</c:if>
</div>
<jsp:include page="templates/footer.jsp" />