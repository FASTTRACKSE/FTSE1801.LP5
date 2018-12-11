<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<%-- <!-- Path -->
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
		<!-- End Path --> --%>

		<div class="w3-container w3-card w3-white">
			<h2 class="w3-text-grey w3-padding-16" style="text-align: center;">
				<i
					class="fa fa-graduation-cap fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Education
			</h2>
			<h2 class="w3-text-grey w3-padding-16" style="text-align: center;">
				Ứng dụng công nghệ thông tin</h2>
			<div class="w3-container">
				<section class="section projects-section">
					<hr>
					<div class="table-responsive">
						<table class="table mb-0">
							<tr>
								<td><h3>
										<i class="fa fa-user fa-fw w3-margin-right w3-text-teal"></i>
										Cấp cho:
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${nhanVien.hoDem}
									${nhanVien.ten}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-eyedropper fa-fw w3-margin-right w3-text-teal"></i>
										Tên Chứng chỉ
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${chungChi.tenChungChi}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-university fa-fw w3-margin-right w3-text-teal"></i>
										Đơn vị cấp
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${chungChi.donViCap}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-calendar fa-fw w3-margin-right w3-text-teal"></i>
										Ngày cấp
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${chungChi.ngayCap}</td>
							</tr>
						</table>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
