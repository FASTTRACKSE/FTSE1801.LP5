<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
div.stroke a button, div.stroke a button:after, div.stroke a button:before
	{
	transition: all .5s;
}

div.stroke a button:hover {
	color: #555;
}

div.stroke a button {
	position: relative;
}

div.stroke a button:after {
	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	width: 0%;
	content: '.';
	color: transparent;
	background: #aaa;
	height: 1px;
}

div.stroke a button:hover:after {
	width: 100%;
}
</style>

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<h3 class="content-header-title mb-0">
			<spring:message code="label.danhSachNhanVien" />
		</h3>
		<!-- title -->
		<br>
		<div class="stroke">
			<a href="addform"><button class="btn btn-light"
					style="background-color: #F5F7FA">
					<i class="ft-user-plus"></i>
				</button></a>
		</div>
		<br>
		<!-- add button -->
		<div class="table">
			<table class="table mb-0">
				<thead>
					<tr>
						<th>STT</th>
						<th><spring:message code="label.maNhanVien" /></th>
						<th><spring:message code="label.hoTen" /></th>
						<th><spring:message code="label.gioiTinh" /></th>
						<th><spring:message code="label.ngaySinh" /></th>
						<th>Phòng Ban</th>
						<th>Chức Danh</th>
						<th><spring:message code="label.anhDaiDien" /></th>
						<th><spring:message code="label.chucNang" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nhanVienListPagination}" var="x"
						varStatus="stt">
						<tr>
							<td>${stt.index + 1}</td>
							<td>${x.maNv}</td>
							<td>${x.hoTenNv}</td>
							<td>${x.gioiTinh}</td>
							<td>${x.ngaySinh}</td>
							<td>${x.maPhongBan.tenPhongBan}</td>
							<td>${x.maChucDanh.tenChucDanh}</td>
							<td><img src="<c:url value="/uploads/${x.avatar}" />"
								width="60" height="80"></td>
							<td>
								<div class="stroke">
								<!-- Phân Quyền phòng nhân sự -->
								<sec:authorize access="hasRole('ROLE_PNSTPP') or hasRole('ROLE_PNSNV')">
									<a href="delete/${x.maNv}"><button
											style="background-color: #F5F7FA" class="btn btn-light"
											onclick="if (!confirm('Bạn có muốn xóa sinh viên này không?')) return false">
											<i class="fa fa-trash"></i>
										</button></a>
									<!-- delete button -->
									<a href="editform/${x.maNv}"><button
											style="background-color: #F5F7FA" class="btn btn-light">
											<i class="fa fa-pencil"></i>
										</button></a>
									<!-- edit button -->
								</sec:authorize>
									
									<a href="view/${x.maNv}"><button
											style="background-color: #F5F7FA" class="btn btn-light">
											<i class="fa fa-eye"></i>
										</button></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<c:if test="${pageIndex > 1}">
			<a href="/ffse-fbms/quantrinhansu/hosonhanvien/1">first</a>
			<a href="/ffse-fbms/quantrinhansu/hosonhanvien/${pageIndex - 1}"><button
					class="btn btn-default">${pageIndex - 1}</button></a>
		</c:if>
		<a href="/ffse-fbms/quantrinhansu/hosonhanvien/${pageIndex}"><button
				class="btn btn-success">${pageIndex}</button></a>
		<c:if test="${pageIndex < totalPage}">
			<a href="/ffse-fbms/quantrinhansu/hosonhanvien/${pageIndex + 1}"><button
					class="btn btn-default">${pageIndex + 1}</button></a>
			<a href="/ffse-fbms/quantrinhansu/hosonhanvien/${totalPage}">last</a>
		</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />