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
					class="fa fa-graduation-cap fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>HỢP
				ĐỒNG
			</h2>
			<h2 class="w3-text-grey w3-padding-16" style="text-align: center;">
				CÔNG TY PHẦN MỀM XYZ</h2>
			<div class="w3-container">
				<section class="section projects-section">
					<hr>
					<div class="table-responsive">
						<table class="table mb-0">
							<tr>
								<td><h3>
										<i class="fa fa-user fa-fw w3-margin-right w3-text-teal"></i>
										Họ tên
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${hopDong.maNhanVien.hoDem}
									${hopDong.maNhanVien.ten}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-eyedropper fa-fw w3-margin-right w3-text-teal"></i>
										Loại hợp đồng
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${hopDong.maLoaiHopDong.tenLoaiHopDong}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-university fa-fw w3-margin-right w3-text-teal"></i>
										Chế độ ngày phép
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${hopDong.soNgayPhep}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-calendar fa-fw w3-margin-right w3-text-teal"></i>
										Chế độ lương tháng 13
									</h3></td>

								<td style="text-align: center; font-size: 20px;"><c:if
										test="${hopDong.luongThang13 ==1}">Không có</c:if> <c:if
										test="${hopDong.luongThang13 ==2}">Nửa tháng</c:if> <c:if
										test="${hopDong.luongThang13 ==3}">Đầy đủ</c:if></td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-university fa-fw w3-margin-right w3-text-teal"></i>
										Ngày ký
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${hopDong.ngayKy}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-university fa-fw w3-margin-right w3-text-teal"></i>
										Hợp đồng hiệu lực từ ngày
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${hopDong.hopDongTuNgay}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-university fa-fw w3-margin-right w3-text-teal"></i>
										Hợp đồng hiệu lực đến ngày
									</h3></td>
								<td style="text-align: center; font-size: 20px;">${hopDong.hopDongDenNgay}</td>
							</tr>
							<tr>
								<td><h3>
										<i class="fa fa-university fa-fw w3-margin-right w3-text-teal"></i>
										Trạng thái hợp đồng
									</h3></td>
								<td style="text-align: center; font-size: 20px;"><c:if
										test="${hopDong.trangThai == 1}">Có hiệu lực</c:if> <c:if
										test="${hopDong.trangThai == 2}">Hết hiệu lực</c:if></td>
							</tr>
						</table>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
