<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thông tin nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<a href="<c:url value="/QuanLyNhanSu/hoSoNhanVien/excelfile/${hoSoNhanVien.maNhanVien}"/>"><button
								class="btn btn-success">
								<i class="fa fa-download"></i> Tải xuống
							</button></a>
					</div>
				</div>
			</div>
		</div>
		<!-- Left Column -->
		<!-- Thông Tin Chính -->
		<div class="w3-third">
			<div class="w3-white w3-text-grey w3-card-4">
				<div class="profile-container">
					<div style="text-align: center;">
						<img class="profile"
							src="/FBMS/resources/images/portrait/small/avatar-s-1.png<%-- <c:url value="/uploads/${hoSoNhanVien.anhDaiDien}" /> --%>"
							width="150" height="180" alt="ảnh đại diện" />
					</div>
					<h1 class="name" style="text-align: center;">${hoSoNhanVien.hoDem}
						${hoSoNhanVien.ten}</h1>
					<h3 class="tagline" style="text-align: center;">Full Stack
						Developer</h3>
				</div>
				<div class="w3-container">
					<p>
						<i
							class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVien.maChucDanh.tenChucDanh}</p>
					<p>
						<i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVien.queQuan}
					</p>
					<p>
						<i
							class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVien.email}</p>
					<p>
						<i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVien.soDienThoai}</p>
					<hr>

					<p class="w3-large">
						<b><i
							class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Skills</b>
					</p>
					<p>Adobe Photoshop</p>
					<div class="w3-light-grey w3-round-xlarge w3-small">
						<div class="w3-container w3-center w3-round-xlarge w3-teal"
							style="width: 90%">90%</div>
					</div>
					<p>Photography</p>
					<div class="w3-light-grey w3-round-xlarge w3-small">
						<div class="w3-container w3-center w3-round-xlarge w3-teal"
							style="width: 80%">
							<div class="w3-center w3-text-white">80%</div>
						</div>
					</div>
					<p>Java</p>
					<div class="w3-light-grey w3-round-xlarge w3-small">
						<div class="w3-container w3-center w3-round-xlarge w3-teal"
							style="width: 75%">75%</div>
					</div>
					<p>PHP</p>
					<div class="w3-light-grey w3-round-xlarge w3-small">
						<div class="w3-container w3-center w3-round-xlarge w3-teal"
							style="width: 50%">50%</div>
					</div>
					<br>

					<p class="w3-large w3-text-theme">
						<b><i class="fa fa-globe fa-fw w3-margin-right w3-text-teal"></i>Languages</b>
					</p>
					<p>English</p>
					<div class="w3-light-grey w3-round-xlarge">
						<div class="w3-round-xlarge w3-teal"
							style="height: 24px; width: 100%"></div>
					</div>
					<p>Spanish</p>
					<div class="w3-light-grey w3-round-xlarge">
						<div class="w3-round-xlarge w3-teal"
							style="height: 24px; width: 55%"></div>
					</div>
					<p>German</p>
					<div class="w3-light-grey w3-round-xlarge">
						<div class="w3-round-xlarge w3-teal"
							style="height: 24px; width: 25%"></div>
					</div>
					<br>
				</div>
			</div>
			<br>
			<!-- End Left Column -->
		</div>

		<!-- Right Column -->
		<div class="w3-twothird">
			<!-- Phần Thông Tin Học Vấn -->
			<div class="w3-container w3-card w3-white">
				<h2 class="w3-text-grey w3-padding-16">
					<i
						class="fa fa-graduation-cap fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Education
				</h2>
				<div class="w3-container">
					<section class="section projects-section">
						<c:forEach items="${thongTinChungChi}" var="x" varStatus="stt">
							<h5 class=" fa fa-university w3-opacity">
								<b>${x.donViCap}</b>
							</h5>
							<h6 class="w3-text-teal">
								<i class="fa fa-calendar fa-fw w3-margin-right"></i>2013 - 2015
							</h6>
							<hr>
							<div class="table-responsive">
								<table class="table mb-0">
									<tr>
										<td><h6>
												<i
													class="fa fa-eyedropper fa-fw w3-margin-right w3-text-teal"></i>
												Tên Chứng chỉ
											</h6></td>
										<td style="text-align: right">${x.tenChungChi}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="fa fa-calendar fa-fw w3-margin-right w3-text-teal"></i>
												Ngày cấp
											</h6></td>
										<td style="text-align: right">${x.ngayCap}</td>
									</tr>
								</table>
							</div>
						</c:forEach>
					</section>
				</div>
			</div>
			<!-- Phần Thông Tin Gia Đình -->
			<div class="w3-container w3-card w3-white w3-margin-bottom">
				<h2 class="w3-text-grey w3-padding-16">
					<i class="icon-home fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Family
					information
				</h2>
				<div class="w3-container">
					<section class="section projects-section">
						<c:forEach items="${thongTinGiaDinh}" var="x" varStatus="stt">
							<div class="table-responsive">
								<table class="table mb-0">
									<tr>
										<td><h6>
												<i
													class="fa fa-eyedropper fa-fw w3-margin-right w3-text-teal"></i>
												Họ tên
											</h6></td>
										<td style="text-align: right">${x.hoTen}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="icon-globe fa-fw w3-margin-right w3-text-teal"></i>
												Quê quán
											</h6></td>
										<td style="text-align: right">${x.queQuan}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="fa fa-calendar fa-fw w3-margin-right w3-text-teal"></i>
												namSinh
											</h6></td>
										<td style="text-align: right">${x.namSinh}</td>
									</tr>
									<tr>
										<td><h6>
												<i class="icon-users fa-fw w3-margin-right w3-text-teal"></i>
												Giới tính
											</h6></td>
										<c:if test="${x.gioiTinh == 1}">
											<td style="text-align: right">Nam</td>
										</c:if>
										<c:if test="${x.gioiTinh == 2}">
											<td style="text-align: right">Nữ</td>
										</c:if>
									</tr>
									<tr>
										<td><h6>
												<i
													class="icon-screen-smartphone fa-fw w3-margin-right w3-text-teal"></i>
												Số điện thoại
											</h6></td>
										<td style="text-align: right">${x.soDienThoai}</td>
									</tr>
									<tr>
										<td><h6>
												<i
													class="icon-user-follow fa-fw w3-margin-right w3-text-teal"></i>
												Quan hệ
											</h6></td>
										<td style="text-align: right">${x.quanHe}</td>
									</tr>
								</table>
							</div>
						</c:forEach>
					</section>
				</div>
				<div class="w3-container">
					<h5 class="w3-opacity">
						<b>Web Developer / something.com</b>
					</h5>
					<h6 class="w3-text-teal">
						<i class="fa fa-calendar fa-fw w3-margin-right"></i>Mar 2012 - Dec
						2014
					</h6>
					<p>Consectetur adipisicing elit. Praesentium magnam consectetur
						vel in deserunt aspernatur est reprehenderit sunt hic. Nulla
						tempora soluta ea et odio, unde doloremque repellendus iure, iste.</p>
					<hr>
				</div>
				<div class="w3-container">
					<h5 class="w3-opacity">
						<b>Graphic Designer / designsomething.com</b>
					</h5>
					<h6 class="w3-text-teal">
						<i class="fa fa-calendar fa-fw w3-margin-right"></i>Jun 2010 - Mar
						2012
					</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
					<br>
				</div>
			</div>
			<!-- End Right Column -->
		</div>

		<!-- End Grid -->
	</div>
</div>
	<!-- End Page Container -->

	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />