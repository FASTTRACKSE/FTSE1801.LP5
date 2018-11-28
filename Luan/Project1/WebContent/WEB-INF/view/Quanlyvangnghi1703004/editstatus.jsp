<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="content-body">
			<div class="main-content">
				<h1>
					<a
						href='<c:url value="/Quanlyvangnghi1703004/danhsachtrangthai" />'><i
						class="icon-arrow-left"></i></a>
				</h1>
				<form:form method="POST" modelAttribute="editStatus">
					<div class="row">
						<div>
							<label><spring:message code="label.madon" /></label>
							<form:input class="form-control round" path="id" readonly="true"
								value="" />

						</div>

						<div>
							<label> <spring:message code="label.matrangthai" /></label>
							<form:input class="form-control round" path="maTrangThai" />
							<form:errors path="maTrangThai" cssStyle="color: red"></form:errors>
						</div>

						<div>
							<label><spring:message code="label.tentrangthai" /></label>
							<form:input class="form-control round" path="trangThai" />
							<form:errors path="trangThai" cssStyle="color: red"></form:errors>
						</div>
						<br>
						<div>
							<button type="submit"
								class="btn btn-outline-danger round  mr-1 mb-1"
								formaction="<%=request.getContextPath()%>/Quanlyvangnghi1703004/editstatus/save">
								<spring:message code="label.gui" />
							</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />