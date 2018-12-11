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
					<form:form method="POST" modelAttribute="hopDong" action="">
						<form:input type="hidden" path="maHopDong" style="display:none"
							value="${hopDong.maHopDong}" />
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien.maNhanVien"
								value="${hopDong.maNhanVien.maNhanVien}"
								placeholder="Mã nhân viên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Loại hợp đồng</label>
							<form:select path="maLoaiHopDong.maLoaiHopDong">
								<form:option value="${hopDong.maLoaiHopDong.maLoaiHopDong}">${hopDong.maLoaiHopDong.tenLoaiHopDong}</form:option>
								<form:option value="1">Thử việc</form:option>
								<form:option value="2">Ngắn hạn</form:option>
								<form:option value="3">Dài hạn</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Lương tháng 13</label>
							<form:select path="luongThang13">
								<form:option value="${hopDong.luongThang13}"></form:option>
								<form:option value="1">Không có </form:option>
								<form:option value="2">1/2</form:option>
								<form:option value="3">Đầy đủ</form:option>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Số ngày phép</label>
							<form:input class="form-control" path="soNgayPhep"
								value="${hopDong.soNgayPhep}" placeholder="Số ngày phép" />
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày ký</label>
							<form:input class="form-control" path="ngayKy"
								value="${hopDong.ngayKy}" placeholder="Ngày Ký" />
						</div>
						<div class="form-group col-sm-6">
							<label>Hợp đồng từ ngày</label>
							<form:input class="form-control" path="hopDongTuNgay"
								value="${hopDong.hopDongTuNgay}" placeholder="Hợp đồng từ ngày" />
						</div>
						<div class="form-group col-sm-6">
							<label>Hợp đồng đến ngày</label>
							<form:input class="form-control" path="hopDongDenNgay"
								value="${hopDong.hopDongDenNgay}"
								placeholder="Hợp đồng đến ngày" />
						</div>
						<div class="form-group col-sm-6">
							<label>Hợp đồng đến ngày</label>
							<form:input class="form-control" path="hopDongDenNgay"
								value="${hopDong.hopDongDenNgay}"
								placeholder="Hợp đồng đến ngày" />
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:select path="trangThai">
								<form:option value="${hopDong.trangThai}"></form:option>
								<form:option value="1">Có hiệu lực</form:option>
								<form:option value="2">Hết hiệu lực</form:option>
							</form:select>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
