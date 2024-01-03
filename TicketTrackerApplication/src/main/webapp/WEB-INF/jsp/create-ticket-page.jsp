<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="templates/header.jsp" />

<br>
<div class="container">
	<div class="center border my-5 p-5 ">
		<h2 class="text-center bg-light font-weight-bold">${formHeading}</h2>
		<hr>
		<form:form action="/admin/tickets/newTicket" method="post"
			modelAttribute="ticket">
			<div class="mb-3">
				<label for="ticketTitle" class="form-label font-weight-bold">Ticket
					Title</label>
				<form:input type="text" class="form-control" id="ticketTitle"
					placeholder="Ticket Title" path="title" />
			</div>
			<c:if test="${ticket.id != null }">
				<form:hidden path="id" />
				<form:hidden path="createdOn" readOnly="true" />
			</c:if>
			<div class="mb-3">
				<label for="shortDescription" class="form-label font-weight-bold">Short
					Description</label>
				<form:input type="text" class="form-control" id="shortDescription"
					placeholder="Short Description" path="shortDescription" />
			</div>
			<div class="mb-3">
				<label for="content" class="form-label font-weight-bold">Content</label>
				<form:textarea class="form-control ckeditor" id="content" rows="3"
					path="content" />
			</div>
			<input class="btn btn-primary btn-lg" type="submit" value="Submit">
		</form:form>
		<script>
            ClassicEditor
                .create(document.querySelector('.ckeditor', {
                    resize_dir: 'both',
                }))
                .catch(error => {
                    console.error(error);
                });
        </script>
	</div>
</div>

<jsp:include page="templates/footer.jsp" />