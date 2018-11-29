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
					<a href='<c:url value="/Quanlyvangnghi1703004/danhsachngaynghi" />'><i
						class="icon-arrow-left"></i></a>
				</h1>
				<form:form method="POST" modelAttribute="editDate">
					<div class="row">
						<div>
							<label><spring:message code="label.maNhanVien" /></label>
							<form:input class="form-control round" path="maNhanVien"
								readonly="true" value="" />
							<form:errors path="maNhanVien" cssStyle="color: red"></form:errors>

						</div>

						<div>
							<label><spring:message code="label.hoTen" /></label>
							<form:select multiple="single" path="tenNhanVien"
								class="custom-select block round">
								<form:options items="${hoso}" itemValue="hoDem"
									itemLabel="hoDem" />
							</form:select>
							<form:errors path="tenNhanVien" cssStyle="color: red"></form:errors>
						</div>

						<div>
							<label><spring:message code="label.songaydanghi" /></label>
							<form:input class="form-control round" path="soNgayDaNghi" />
						</div>

						<div>
							<label><spring:message code="label.songayconlai" /></label>
							<form:input class="form-control round" path="soNgayConLai" />
						</div>
						<br>
						<div>
							<button type="submit"
								class="btn btn-outline-danger round  mr-1 mb-1"
								formaction="<%=request.getContextPath()%>/Quanlyvangnghi1703004/editDate/save">
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