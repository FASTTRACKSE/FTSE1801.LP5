<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0"><spring:message code="label.thongTinBangCap" /></h3>
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
					<li class="breadcrumb-item active"><spring:message code="label.thongTinBangCap" /></li>
				</ol>
			</div>
		</div>
		<div class="table-responsive">
			<a href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/add/${maNv}"
				class="btn btn-outline-success round btn-min-width mr-1 mb-1"><spring:message code="label.themBangCap" /></a>
			<table class="table mb-0">
				<thead>
					<tr>
						<th><spring:message code="label.chuyenNganh" /></th>
						<th><spring:message code="label.xepLoai" /></th>
						<th><spring:message code="label.noiCapBang" /></th>
						<th><spring:message code="label.ngayCap" /></th>
						<th><spring:message code="label.chucNang" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bangcap" items="${viewOne}">
						<tr>
							<td>${bangcap.chuyenNganh}</td>
							<td>${bangcap.xepLoai}</td>
							<td>${bangcap.noiCap}</td>
							<td>${bangcap.ngayCap}</td>
							<td><a
								href='<c:url value = "/QuanTriNhanSuPikalong/QuanLiBangCap/edit/${bangcap.id}"></c:url>'
								class="btn btn-outline-info round"><spring:message code="label.chinhSua" /></a> <a
								href='<c:url value = "/QuanTriNhanSuPikalong/QuanLiBangCap/remove/${bangcap.id}"></c:url>'
								class="btn btn-outline-danger round"
								onclick="return confirm('Bạn có muốn xóa bằng cấp này?');"><spring:message code="label.xoa" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />