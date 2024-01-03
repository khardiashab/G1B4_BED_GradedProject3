<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/header.jsp" />

<div class="container">
	<h1>List of Tickets</h1>
	<br>
	<br>
	<jsp:include page="templates/search_box.jsp" />
	<table class="table">
		<thead class="table-dark font-weight-bold">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Ticket Title</th>
				<th scope="col">Short Description</th>
				<th scope="col">Created On</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty tickets}">
				<c:forEach var="ticket" items="${tickets}" varStatus="status">
					<tr>
						<th scope="row">${status.index + 1}</th>
						<td>${ticket.title}</td>
						<td>${ticket.shortDescription}</td>
						<td>${ticket.createdOn}</td>
						<td><a href="/admin/tickets/${ticket.id}/edit"
							class="btn btn-info">Edit</a> <a
							href="/admin/tickets/${ticket.id}/delete" class="btn btn-danger"
							onclick='return confirm("Do you want to delete Ticket(${ticket.title})")'>Delete</a>
							<a href="/admin/tickets/${ticket.id}" class="btn btn-primary">View</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>

<jsp:include page="templates/footer.jsp" />