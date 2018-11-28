
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="FastTrackSE Bunisess Management System.">
<meta name="keywords"
	content="human resource, document, project, working log, leave management">
<meta name="author" content="FFSE1703">
<title>FastTrackSE - The Business Management System</title>
<link rel="apple-touch-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/09/fasttrackselogo.png"/>">
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet" />
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/feather/style.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/font-awesome/css/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/flag-icon-css/css/flag-icon.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/pace.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/tables/datatable/dataTables.bootstrap4.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/unslider.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/weather-icons/climacons.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/meteocons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/charts/morris.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/calendars/fullcalendar.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/calendars/fullcalendar.min.css"/>">

<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-extended.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/colors.css"/>">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-overlay-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-gradient.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-callout.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/forms/extended/form-extended.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/simple-line-icons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/pages/timeline.css"/>">
<!-- END Page Level CSS-->
<style>
.invalid-feedback {
	color: #DC3545;
	padding-top: 10px;
}

.invalid-feedback::before {
	content: "•";
	padding-left: 10px;
	padding-right: 10px;
}
</style>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script>
	$(document).ready(
			function() {
				listClass = [ "phong_ban", "chuc_danh" ];
				url = window.location.href;
				selector = '.'
						+ url.substring(url.lastIndexOf("ffse-fbms") + 10);
				selector = selector.replace(/\//g, '').replace(/[0-9]/g, '');
				$(selector).addClass('active open');

				var i;
				for (i = 0; i < listClass.length; i++) {
					if (selector.includes(listClass[i])) {
						$("." + listClass[i]).addClass('open');
					}
				}
				console.log(selector);
				if (selector.includes('ho_so')
						&& !selector.includes('viewho_so')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('ho_soedit')) {
					$(".pbho_so").addClass('open');
				}
				if (selector.includes('hop_dong')
						&& !selector.includes('viewhop_dong')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('hop_dongedit')) {
					$(".pbhop_dong").addClass('open');
				}
			});
</script>

</head>

<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar">

	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-light bg-gradient-x-grey-blue">
		<div class="continer">

			<!-- Show message -->
			<c:if test="${messageSC ne null}">
				<div class="alert alert-success  btn-min-width mr-1 mb-1"
					role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSC}
				</div>
			</c:if>
			<c:if test="${messageER ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageER}
				</div>
			</c:if>
		</div>
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="/ffse-fbms/home"
						class="navbar-brand"><img
							src="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>"
							alt="FastTrackSE logo" class="brand-logo" />
							<h2 class="brand-text">FBMS</h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<ul class="nav navbar-nav">
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-menu-main menu-toggle hidden-xs"><i
								class="ft-menu"></i></a></li>
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li>
					</ul>
					<ul class="nav navbar-nav float-xs-right">
						<li class="dropdown dropdown-language nav-item"><a
							class="dropdown-toggle nav-link" id="dropdown-flag" href="#"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
								class="flag-icon <spring:message code="label.QuanTriHeThong_NgonNgu" />"></i><span
								class="selected-language"></span></a>
							<div class="dropdown-menu" aria-labelledby="dropdown-flag">
								<a class="dropdown-item" href="?lang=en"><i
									class="flag-icon flag-icon-gb"></i> English</a> <a
									class="dropdown-item" href="?lang=vi"><i
									class="flag-icon flag-icon-vn"></i> Tiếng Việt</a>
							</div></li>
						<li class="dropdown dropdown-user nav-item"><a href="#"
							data-toggle="dropdown"
							class="dropdown-toggle nav-link dropdown-user-link"><span
								class="avatar avatar-online"><img
									src="<c:url value="/resources/images/portrait/small/avatar-s-1.png"/>"
									alt="avatar"><i></i></span><span class="user-name">${pageContext.request.userPrincipal.name}</span></a>
							<div class="dropdown-menu dropdown-menu-right">
								<a href="#" class="dropdown-item"><i class="ft-user"></i> <spring:message
										code="label.suaHoSo" /></a> <a href="#" class="dropdown-item"><i
									class="ft-mail"></i> <spring:message code="label.hopThu" /></a> <a
									href="#" class="dropdown-item"><i class="ft-check-square"></i>
									<spring:message code="label.nhiemVu" /></a> <a href="#"
									class="dropdown-item"><i class="ft-message-square"></i> <spring:message
										code="label.tinNhan" /></a>
								<div class="dropdown-divider"></div>
								<form class="dropdown-item"
									action="<c:url value="/j_spring_security_logout" />"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <a href="#"
										onclick="$(this).closest('form').submit()"><i
										class="ft-power"></i> <spring:message code="label.dangXuat" /></a>
								</form>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-light menu-accordion menu-shadow">
		<div class="main-menu-content">
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<!-- Quản trị hệ thống -->
				<li class=" navigation-header"><span><spring:message
							code="label.QuanTriHeThong" /></span><i data-toggle="tooltip"
					data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
				</li>
				<li class=" nav-item QuanTriHeThongphong_ban"><a
					href="<c:url value = "/QuanTriHeThong/phong_ban/"/>"><i
						class="fa fa-building"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_PhongBan" /></span></a></li>
				<li class=" nav-item QuanTriHeThongchuc_danh"><a
					href="<c:url value = "/QuanTriHeThong/chuc_danh/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_ChucDanh" /></span></a></li>
				<li class=" nav-item QuanTriHeThongtai-khoan"><a
					href="<c:url value = "/QuanTriHeThong/tai-khoan/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_TaiKhoan" /></span></a></li>
				<li class=" nav-item QuanTriHeThongphan-quyen"><a
					href="<c:url value = "/QuanTriHeThong/phan-quyen/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_PhanQuyen" /></span></a></li>

				<sec:authorize access="hasAnyRole('ROLE_PNSNV','ROLE_PNSTPP')">

					<!-- Quản Trị Nhân Sự -->
				</sec:authorize>
				<sec:authorize access="!hasRole('ROLE_NV') or hasRole('ROLE_PNS')">

					<!--  -----------------MVP- Quản lí Dự Án ----------------------->

					<li class="navigation-header"><span>꧁༺M̤̮V̤̮P̤̮-Quản lý
							dự án</span><i class=" ft-minus" data-toggle="tooltip"
						data-placement="right" data-original-title="Components"></i></li>
					<li class="nav-item has-sub"><a href="#"><i
							class="ft-briefcase"></i><span class="menu-title" data-i18n="">Danh
								Mục Dự Án</span></a>
						<ul class="menu-content" style="">
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/khachhang/list-khachhang" />">
									<spring:message code="label.KhachHang" />
							</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/domain/list-domain" />">Domain</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/technical/list-technical" />">Technical</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/vendor/list-vendor" />">Vendor</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/framework/list-framework" />">Framework</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/language/list-language" />">Programing
									Language</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/roles/list-roles" />">Vai
									trò</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/status/list-status" />">Trạng
									thái</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/database/list-database" />">Database</a></li>
						</ul></li>
					<li class="nav-item has-sub"><a href="#"><i class="ft-box"></i><span
							class="menu-title" data-i18n="">Dự Án</span></a>
						<ul class="menu-content" style="">
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/project/show-form-add" />">Thêm
									dự án</a></li>
							<li class=""><a class="menu-item"
								href="<c:url value="/mvpquanliduan/project/list-project" />">Danh
									sách dự án</a></li>


						</ul></li>

					<!--  ////////////////////////////////////////////// -->

					<!--  Quản Lý Vắng Nghỉ H-->
					<li class="navigation-header"><span>Quản Lý Vắng Nghỉ 1</span><i
						class=" ft-minus" data-toggle="tooltip" data-placement="right"
						data-original-title="Components"></i></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title">Đơn
								Xin Nghỉ</span></a>
						<ul class="menu-content">
							<li><a href="<c:url value="/QuanLyVangNghi/donxinnghi"/>"
								class="menu-item">Tạo Đơn Xin Nghỉ</a></li>
							<li><a href="<c:url value="/QuanLyVangNghi/luunhap"/>"
								class="menu-item">Danh sách nháp</a></li>
							<li><a href="<c:url value="/QuanLyVangNghi/choduyet"/>"
								class="menu-item">Danh sách chờ duyệt</a></li>
							<li><a href="<c:url value="/QuanLyVangNghi/daduyet"/>"
								class="menu-item">Danh sách đã duyệt</a></li>
							<li><a href="<c:url value="/QuanLyVangNghi/tuchoi"/>"
								class="menu-item">Danh sách bị từ chối</a></li>
						</ul></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title">Phê
								Duyệt</span></a>
						<ul class="menu-content">
							<li><a href="<c:url value="/QuanLyVangNghi/duyetvong1"/>"
								class="menu-item">Duyệt vòng 1</a></li>
							<li><a href="<c:url value="/QuanLyVangNghi/duyetvong2"/>"
								class="menu-item">Duyệt Vòng 2</a></li>
						</ul></li>


					<!--  ////////////////////////////////////////////// -->

					<!--  Quản lí Vắng nghỉ -->
					<li class="navigation-header"><span><spring:message
								code="label.quanlyvangnghi" /></span><i class=" ft-minus"
						data-toggle="tooltip" data-placement="right"
						data-original-title="Components"></i></li>
					<li><a
						href="<c:url value="/Quanlyvangnghi1703004/soandonmoi"/>"
						class="menu-item"><i class='fa fa-pencil'></i>
						<spring:message code="label.soandonmoi" /></a></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message
									code="label.thongketinhhinh" /></span></a>
						<ul class="menu-content">
							<li><a
								href="<c:url value="/Quanlyvangnghi1703004/danhsachnhap"/>"
								class="menu-item"><spring:message code="label.danhsachnhap" /></a></li>
							<li><a
								href="<c:url value="/Quanlyvangnghi1703004/danhsachcho"/>"
								class="menu-item"><spring:message
										code="label.danhsachchoduyet" /></a></li>
							<li><a
								href="<c:url value="/Quanlyvangnghi1703004/danhsachduyet"/>"
								class="menu-item"><spring:message code="label.danhsachduyet" /></a></li>
							<li><a
								href="<c:url value="/Quanlyvangnghi1703004/danhsachbituchoi"/>"
								class="menu-item"><spring:message
										code="label.danhsachtuchoi" /></a></li>
						</ul></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message
									code="label.thongkengaynghi" /></span></a>
						<ul class="menu-content">
							<li><a
								href="<c:url value="/Quanlyvangnghi1703004/danhsachngaynghi"/>"
								class="menu-item"><spring:message
										code="label.danhsachngaynghi" /></a></li>
						</ul></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message
									code="label.thongketrangthai" /></span></a>
						<ul class="menu-content">
							<li><a
								href="<c:url value="/Quanlyvangnghi1703004/danhsachtrangthai"/>"
								class="menu-item"><spring:message
										code="label.danhsachtrangthai" /></a></li>
						</ul></li>


					<!--  Quản lí Vắng nghĩ DanhLT -->
					<li class="navigation-header"><span><spring:message
								code="label.quanlyvangnghi" /> DanhLT</span><i class=" ft-minus"
						data-toggle="tooltip" data-placement="right"
						data-original-title="Components"></i></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message
									code="label.thongketinhhinh" /></span></a>
						<ul class="menu-content">
							<li><a
								href="<c:url value="/QuanlyvangnghiDanhLT/danhsachnhap003"/>"
								class="menu-item"><spring:message code="label.danhsachnhap" /></a></li>
							<li><a
								href="<c:url value="/QuanlyvangnghiDanhLT/danhsachchoduyet003"/>"
								class="menu-item"><spring:message
										code="label.danhsachchoduyet" /></a></li>
							<li><a
								href="<c:url value="/QuanlyvangnghiDanhLT/danhsachdaduyet003"/>"
								class="menu-item"><spring:message code="label.danhsachduyet" /></a></li>
							<li><a
								href="<c:url value="/QuanlyvangnghiDanhLT/danhsachbituchoi003"/>"
								class="menu-item"><spring:message
										code="label.danhsachtuchoi" /></a></li>
						</ul></li>

					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message
									code="label.thongkengaynghi" /></span></a>
						<ul class="menu-content">
							<li><a
								href="<c:url value="/QuanlyvangnghiDanhLT/ngaynghiphep"/>"
								class="menu-item"><spring:message
										code="label.danhsachngaynghi" /></a></li>
						</ul></li>
					<li class=" nav-item pbho_so"><a href="#"><i
							class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message
									code="label.thongketrangthai" /></span></a>
						<ul class="menu-content">
							<li><a
								href="<c:url value="/QuanlyvangnghiDanhLT/thongketrangthai"/>"
								class="menu-item"><spring:message
										code="label.danhsachtrangthai" /></a></li>
						</ul></li>

					<!-- Quản Lý Nhân Sự Pikalong -->
					<li class=" navigation-header"><span>PKL-Quản Trị Nhân
							Sự</span><i class=" ft-minus" data-toggle="tooltip"
						data-placement="right" data-original-title="Others"></i></li>
					<li class=" nav-item"><a href="#"><i class="ft-layers"></i><span
							class="menu-title" data-i18n="">Quản Lý Hồ Sơ</span></a>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hosonhanvien/">Danh Sách Nhân
									Viên</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/nhanvienphongban/PNS">Phòng
									Nhân Sự</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/nhanvienphongban/PDA">Phòng
									Dự Án</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/nhanvienphongban/PDT">Phòng
									Đào Tạo</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/nhanvienphongban/PGD">Phòng
									Giám Đốc</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/nhanvienphongban/PIT">Phòng
									IT</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/nhanvienphongban/PKT">Phòng Kế Toán</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/thongtincanhan/">Thông Tin Cá Nhân</a></li>
						</ul>
						</li>
						<li class=" nav-item"><a href="#"><i class="ft-layers"></i><span
							class="menu-title" data-i18n="">Quản Lý Hợp Đồng</span></a>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/QuanTriNhanSu/quanlihopdong/">Danh Sách Hợp
									Đồng</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hopdongphongban/PNS">Phòng
									Nhân Sự</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hopdongphongban/PDA">Phòng
									Dự Án</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hopdongphongban/PDT">Phòng
									Đào Tạo</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hopdongphongban/PGD">Phòng
									Giám Đốc</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hopdongphongban/PIT">Phòng
									IT</a></li>
						</ul>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quantrinhansu/hopdongphongban/PKT">Phòng
									Kế Toán</a></li>
						</ul>
						</li>

					<!-- Quản Lý Nhân Sự Pikalong -->

					<!-------------------Quản Lý Nhân Sự TT------------- -->
					<li class=" navigation-header"><span><spring:message
								code="label.quanLyNhanSuTT" /></span><i class=" ft-minus"
						data-toggle="tooltip" data-placement="right"
						data-original-title="Others"></i></li>
					<li class=" nav-item"><a href="#"><i class="ft-layers"></i><span
							class="menu-title" data-i18n=""><spring:message
									code="label.quanLyHoSo" /></span></a>
						<ul class="menu-content">
							<li><a class="menu-item"
								href="/ffse-fbms/quanlynhansutt/ho_so/"><spring:message
										code="label.hoSoNhanVien" /></a></li>
						</ul></li>
					<li class=" nav-item"><a class="menu-item"
						href="/ffse-fbms/quanlynhansutt/hop_dong/"><i
							class="ft-layers"></i><span class="menu-title" data-i18n=""><spring:message
									code="label.danhSachHopDong" /></span></a></li>
					<!-- Quản Lý Nhân Sự TT  -->

					<!-- Quản trị dự án -->
				</sec:authorize>

				<li class=" navigation-header"><span><spring:message
							code="label.quanLyDuAnTeam1" /></span><i class=" ft-minus"
					data-toggle="tooltip" data-placement="right"
					data-original-title="Others"></i></li>
				<li class=" nav-item"><a href="#"><i class="ft-layers"></i><span
						class="menu-title" data-i18n=""><spring:message
								code="label.Category" /></span></a>
					<ul class="menu-content">
						<li><a class="menu-item"
							href="<c:url value="/qlda/khachhang/list"/>"><spring:message
									code="label.khachHang" /></a></li>
						<li><a class="menu-item"
							href="<c:url value="/qlda/domain/list"/>">Domain</a></li>
						<li><a class="menu-item"
							href="<c:url value="/qlda/trangthai/list"/>"><spring:message
									code="label.trangThai" /></a></li>
						<li><a class="menu-item"
							href="<c:url value="/qlda/Framework/"/>">Framework</a></li>
						<li><a class="menu-item"
							href="<c:url value="/qlda/Technical/"/>">Technical</a></li>
						<li><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/Language/list"/>">Programming
								Language</a></li>
						<li><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/vendor/list"/>">Vendor</a></li>
						<li><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/VaiTro/list"/>"><spring:message
									code="label.vaiTroThanhVien" /></a></li>
						<li><a class="menu-item"
							href="<c:url value="/qlda/Database/"/>">Database</a></li>


					</ul></li>


				<li class=" nav-item"><a href="#"><i class="ft-align-left"></i><span
						class="menu-title" data-i18n=""><spring:message
								code="label.thongTinDuAn" /></span></a>
					<ul class="menu-content">
						<li><a class="menu-item" href="<c:url value="/qlda/DuAn/"/>"><spring:message
									code="label.duAn" /></a></li>
					</ul></li>
			</ul>
			<!-- Quản lý nhiệm vụ của HieuLP -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span><spring:message
							code="label.hieulpquanlinhiemvu" /></span><i data-toggle="tooltip"
					data-placement="right" data-original-title=""></i></li>
				<li class=" nav-item"><a href="<c:url value = "/HieuLP/"/>"><i
						class="ft-layers"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.danhsachnhiemvu" /></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/HieuLP/calender"/>"><i class="fa fa-calendar"></i><span data-i18n="" class="menu-title"><spring:message code="label.lichnhiemvu"/>
							</span></a></li>
				<li><hr /></li>
			</ul>
			<!-- Quản lý nhiệm vụ của NghiaBT -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span><spring:message code="label.nghiabtquanlinhiemvu"/></span><i data-toggle="tooltip" data-placement="right"
					data-original-title="" ></i></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuNghiaBT/"/>"><i
						class= "ft-file-text"></i><span data-i18n="" class="menu-title"><spring:message code="label.danhsachnhiemvu"/></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuNghiaBT/Calendar"/>"><i
						class="fa fa-calendar-o"></i><span data-i18n="" class="menu-title"><spring:message code="label.lichnhiemvu"/>
							</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/HieuLP/calender"/>"><i
						class="fa fa-calendar"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.lichnhiemvu" /> </span></a></li>
				<li><hr /></li>
			</ul>
			<!-- Quản lý nhiệm vụ của NghiaBT -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span><spring:message
							code="label.nghiabtquanlinhiemvu" /></span><i data-toggle="tooltip"
					data-placement="right" data-original-title=""></i></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuNghiaBT/"/>"><i
						class="ft-file-text"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.danhsachnhiemvu" /></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuNghiaBT/Calendar"/>"><i
						class="fa fa-calendar-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.lichnhiemvu" /> </span></a></li>
				<li><hr /></li>
			</ul>
			<!-- Qu?n l? nhi?m v? c?a MinhHQ -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span><spring:message
							code="label.minhhqmenu" /></span> <i data-toggle="tooltip"
					data-placement="right" data-original-title="" class=" ft-minus"></i></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuMinhHQ/"/>"> <i
						class="ft-list"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.minhhqitemlist" /></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuMinhHQ/Calendar"/>"> <i
						class="fa fa-calendar-minus-o"></i><span data-i18n=""
						class="menu-title"><spring:message
								code="label.minhhqitemcalendar" /></span></a></li>
				<li><hr /></li>
				<!-- Quản trị đánh giá :: START-->
				<li class=" navigation-header"><span><a
						href="<c:url value = "/quantridanhgia"/>">Quản trị đánh giá</a></span><i
					data-toggle="tooltip" data-placement="right"
					data-original-title="Apps" class=" ft-minus"></i></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/danhgiabanthan"/>"><i
						class="fa fa-user"></i><span data-i18n="" class="menu-title">Đánh
							giá bản thân</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/danhgianhanvien"/>"><i
						class="fa fa-users"></i><span data-i18n="" class="menu-title">Đánh
							giá nhân viên phòng ban</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/nhanviendanhgia"/>"><i
						class="fa fa-users"></i><span data-i18n="" class="menu-title">Đánh
							giá của nhân viên phòng ban</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/danhgiacuatruongphong"/>"><i
						class="fa fa-user-secret"></i><span data-i18n=""
						class="menu-title">Đánh giá của trưởng phòng</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/kydanhgia"/>"><i
						class="fa fa-calendar"></i><span data-i18n="" class="menu-title">Kỳ
							đánh giá</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/danhsachdanhgia"/>"><i
						class="fa fa-table"></i><span data-i18n="" class="">Danh
							sách đánh giá bản thân</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/duyetdanhgia"/>"><i
						class="fa fa-table"></i><span data-i18n="" class="menu-title">Duyệt
							đánh giá của nhân viên phòng ban</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quantridanhgia/truongphongdanhgia"/>"><i
						class="fa fa-table"></i><span data-i18n="" class="menu-title">Đánh
							giá nhân viên phòng ban</span></a></li>
				<!-- Quản trị đánh giá :: END-->
			</ul>
			<!-- Qu?n l? nhi?m v? c?a MinhHQ -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span><spring:message
							code="label.minhhqmenu" /></span> <i data-toggle="tooltip"
					data-placement="right" data-original-title="" class=" ft-minus"></i></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuMinhHQ/"/>"> <i
						class="ft-list"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.minhhqitemlist" /></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/QuanLyNhiemVuMinhHQ/Calendar"/>"> <i
						class="fa fa-calendar-minus-o"></i><span data-i18n=""
						class="menu-title"><spring:message
								code="label.minhhqitemcalendar" /></span></a></li>
				<li><hr /></li>

			</ul>
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<!-- Quản trị tài liệu của Đức -->
				<li class=" navigation-header"><span><spring:message code="label.quanlytailieu" /></span>
					<i data-toggle="tooltip" data-placement="right"
					data-original-title="Đức Đẹp Trai" class=" ft-minus"></i></li>
				<li class=" nav-item"><a href="<c:url value = "/TranDuc-QuanLyTaiLieu/TaiLieu/"/>"><i
					class="ft-file-text"></i><span data-i18n="" class="menu-title"><spring:message code="label.quanlytailieu" />
					</span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/TranDuc-QuanLyTaiLieu/DanhMuc/"/>"><i
						class="ft-bookmark"></i><span data-i18n="" class="menu-title"><spring:message code="label.quanlydanhmuc" /></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/TranDuc-QuanLyTaiLieu/TrangThai/"/>"><i
						class="ft-users"></i><span data-i18n="" class="menu-title"><spring:message code="label.status" /></span></a></li>
				<li class=" nav-item"><a
					href="<c:url value = "/TranDuc-QuanLyTaiLieu/Icon/"/>"><i
						class="ft-folder"></i><span data-i18n="" class="menu-title"><spring:message code="label.filetype" /></span></a></li>
				<li><hr></li>
			</ul>
		</div>
	</div>