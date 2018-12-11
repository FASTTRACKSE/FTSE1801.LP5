<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa thông tin gia đình</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/thongTinChungChi/" />'>Danh
									sách thông tinh gia đình</a></li>
							<li class="breadcrumb-item active">Thông tin gia đình</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<div class="w3-container">
					<section class="section projects-section">
							<div class="table-responsive">
								<table class="table mb-0">
									<tr>
										<td><h6>
												<i
													class="fa fa-eyedropper fa-fw w3-margin-right w3-text-teal"></i>
												Họ tên
											</h6></td>
										<td style="text-align: right">${giaDinh.hoTen}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="icon-globe fa-fw w3-margin-right w3-text-teal"></i>
												Quê quán
											</h6></td>
										<td style="text-align: right">${giaDinh.queQuan}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="fa fa-calendar fa-fw w3-margin-right w3-text-teal"></i>
												Năm sinh
											</h6></td>
										<td style="text-align: right">${giaDinh.namSinh}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="icon-users fa-fw w3-margin-right w3-text-teal"></i>
												Giới tính
											</h6></td>
										<c:if test="${giaDinh.gioiTinh == 1}">
											<td style="text-align: right">Nam</td>
										</c:if>
										<c:if test="${giaDinh.gioiTinh == 2}">
											<td style="text-align: right">Nữ</td>
										</c:if>
									</tr>
									<tr>
										<td><h6>
												<i
													class="icon-screen-smartphone fa-fw w3-margin-right w3-text-teal"></i>
												Số điện thoại
											</h6></td>
										<td style="text-align: right">${giaDinh.soDienThoai}</td>
									</tr>
									<tr>
										<td><h6>
												<i
													class="icon-user-follow fa-fw w3-margin-right w3-text-teal"></i>
												Quan hệ
											</h6></td>
										<td style="text-align: right">${giaDinh.quanHe}</td>
									</tr>
								</table>
							</div>
					</section>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
