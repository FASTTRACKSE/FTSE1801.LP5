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
					<a href='<c:url value="/QuanLyVangNghi/danhsachngaynghi" />'><i
						class="icon-arrow-left"></i></a>
				</h1>
				<form:form method="POST" modelAttribute="editDate">
					<div class="row">
						<div>
							<label>Mã Nhân Viên</label>
							<form:input class="form-control round" path="idNhanVien"
								readonly="true" value="" />
							<form:errors path="idNhanVien" cssStyle="color: red"></form:errors>

						</div>

						<div>
							<label>Hò Và Tên</label>
							<form:select multiple="single" path="idNhanVien.hoDem"
								class="custom-select block round">
								<form:options items="${hoso}" itemValue="hoDem"
									itemLabel="hoDem" />
							</form:select>
							<form:errors path="idNhanVien.hoDem" cssStyle="color: red"></form:errors>
						</div>

						<div>
							<label>Số Ngày Đã Nghĩ</label>
							<form:input class="form-control round" path="soNgayDaNghi" />
						</div>

						<div>
							<label>Số Ngày Nghỉ Còn Lại</label>
							<form:input class="form-control round" path="soNgayConLai" />
						</div>
						<br>
						<div>
							<button type="submit"
								class="btn btn-outline-danger round  mr-1 mb-1"
								formaction="<%=request.getContextPath()%>/QuanLyVangNghi/editDate/save">
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