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
						href='<c:url value="/QuanLyVangNghi/danhsachtrangthai" />'><i
						class="icon-arrow-left"></i></a>
				</h1>
				<form:form method="POST" modelAttribute="editStatus">
					<div class="row">
						<div>
							<label>Mã Đơn</label>
							<form:input class="form-control round" path="idDonXinPhep" readonly="true"
								value="" />

						</div>

						<div>
							<label> Mã Trạng thái</label>
							<form:input class="form-control round" path="maTrangThai" />
							<form:errors path="maTrangThai" cssStyle="color: red"></form:errors>
						</div>

						<div>
							<label>Tên Trạng Thái</label>
							<form:input class="form-control round" path="tenTrangThai" />
							<form:errors path="tenTrangThai" cssStyle="color: red"></form:errors>
						</div>
						<br>
						<div>
							<button type="submit"
								class="btn btn-outline-danger round  mr-1 mb-1"
								formaction="<%=request.getContextPath()%>/QuanLyVangNghi/editstatus/save">
								Gửi
							</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />