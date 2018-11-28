<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0"><spring:message code="label.kinhNghiemDuAn" /></h3>
		<h4><spring:message code="label.hoTen" />: ${hosonhanvien.hoTenNv}</h4>
		<p><spring:message code="label.chucDanh" />: ${hosonhanvien.maChucDanh.tenChucDanh } // <spring:message code="label.phongBan" />:
			${hosonhanvien.maPhongBan.tenPhongBan }</p>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'><spring:message code="label.danhSachNhanVien" /></a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/view/${maNv }" />'><spring:message code="label.thongTinCaNhan" /></a></li>
					<li class="breadcrumb-item active"><spring:message code="label.kinhNghiemDuAn" /></li>
				</ol>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table mb-0">
				<thead>
					<tr>
						<th><spring:message code="label.tenDuAn" /></th>
						<th><spring:message code="label.vaiTroDuAn" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="knda" items="${viewOne}">
						<tr>
							<td>${knda.projects.nameProject}</td>
							<td>${knda.roles.nameRoles}</td>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />