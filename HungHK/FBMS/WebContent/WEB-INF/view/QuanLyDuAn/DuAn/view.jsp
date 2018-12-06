<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid" style="background-color: #CCCCCC">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.viewDuAn" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a href="/ffse-fbms/qlda/DuAn/"><spring:message code="label.listDA" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.newDuAn" /></li>
						</ol>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="content-body" style="color: black">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong><spring:message code="label.viewDuAn" /></strong>
				</h1>
			</div>
		</div>

		<div class="row">

			<div class="col-12">

				<div class="card">

					<div class="card-header">

						<h3 class="card-title">
							<i class="ft-search"></i><b><spring:message code="label.thongTinDuAn" /></b>
						</h3>
						<a class="heading-elements-toggle"><i
							class="fa fa-ellipsis-v font-medium-3"></i></a>
						<div class="heading-elements">
							<ul class="list-inline mb-0">
								<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
								<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
								<li><a data-action="close"><i class="ft-x"></i></a></li>
							</ul>
						</div>

					</div>

					<div class="card-content">
						<div class="table-responsive">
							<table class="table"
								style="border-collapse: collapse; border-collapse: separate;">
								<tbody>
									<tr>
										<th scope="row"><spring:message code="label.tenDuAn" /></th>
										<td>${duAn.tenDuAn}</td>

									</tr>
									<tr>
										<th scope="row"><spring:message code="label.tenKhachHang" /></th>
										<td>${duAn.khachHang.tenkh}</td>
									</tr>
									<tr>
									<tr>
										<th scope="row"><spring:message code="label.sdtVendor" /></th>
										<td>${duAn.khachHang.sdt}</td>
									</tr>
									<tr>
										<th scope="row"><spring:message code="label.moTaDuAn" /></th>
										<td>${duAn.moTaDuAn}</td>

									</tr>
									<tr>
										<th scope="row"><spring:message code="label.phongDuAn" /></th>
										<td>${duAn.phongBan.tenPhongBan}</td>
									</tr>
									<tr>
										<th scope="row">PM</th>
										<td>${duAn.pM.hoDem}${duAn.pM.ten}</td>
									</tr>

									<tr>
										<th scope="row"><spring:message code="label.NghiepVu" /></th>
										<td>-${duAn.domain.tenNghiepVu}</td>
									</tr>
									
									<tr>
										<th scope="row">Database</th>

										<td><c:forEach items="${duAn.database}" var="dt">
									-${dt.tenDatabase}<br>
											</c:forEach></td>
									<tr>
										<th scope="row">Framework</th>

										<td><c:forEach items="${duAn.framework}" var="dt">
									-${dt.ten_framework}<br>
											</c:forEach></td>
									<tr>
									<tr>
										<th scope="row"><spring:message code="label.doiTac" /></th>

										<td><c:forEach items="${duAn.vendor}" var="dt">
									-${dt.tenvd}<br>
											</c:forEach></td>
									<tr>
									<tr>
										<th scope="row"><spring:message code="label.ngonNgu" /></th>

										<td><c:forEach items="${duAn.ngonNgu}" var="dt">
									-${dt.tenNn}<br>
											</c:forEach></td>
									<tr>
									<tr>
										<th scope="row"><spring:message code="label.ngayBatDau" /></th>
										<td>${duAn.startDate}</td>
									</tr>
									<tr>
										<th scope="row"><spring:message code="label.ngayKetThuc" /></th>
										<td>${duAn.endDate}</td>
									</tr>

<tr>
										<th scope="row"><spring:message code="label.trangThai" /></th>
										<td>${duAn.trangThai.tenTrangThai}</td>
									</tr>




								</tbody>
							</table>
							<div class="content-header-right col-md-3 col-xs-12">
								<a
									href="/ffse-fbms/qlda/DuAn/PhanCongNhienVu/create/${duAn.maDuAn}"><span
									class="fa fa-plus"></span> <spring:message code="label.phanCongNhiemVu" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-4">
			<c:if test="${message !=null }">
						 ${message }
			</c:if>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />



