<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0">Thêm Hợp Đồng</h3>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'>Danh
							Sách Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/view/${hsnv.maNv }" />'>Thông
							Tin Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/QuanTriNhanSu/quanlihopdong/viewOneHopDong/${hsnv.maNv}" />'>Hợp
							Đồng Nhân Viên</a></li>
					<li class="breadcrumb-item active">Thêm mới Hợp Đồng</li>
				</ol>
			</div>
		</div>
		<form:form class="form" method="POST" modelAttribute="hopDongPikalong"
			action="/ffse-fbms/QuanTriNhanSu/quanlihopdong/save">
			<div class="form-body">
				<div class="form-section"></div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Mã Nhân Viên</label> <input class="form-control"
								value="${hsnv.maNv }" disabled type="text" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Trạng Thái</label>
							<div class="form-control disabled">${hsnv.isActive == 0 ? 'Còn làm việc' : 'Đã nghỉ việc'}</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Phòng ban</label>
							<div class="form-control well">${hsnv.maPhongBan.tenPhongBan}</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Chức danh</label>
							<div class="form-control well">${hsnv.maChucDanh.tenChucDanh}</div>
						</div>
					</div>
				</div>
				<h4 class="form-section">
					<i class="ft-user"></i> Thông Tin Hợp Đồng
				</h4>
				<div class="row">
					<div class="col-md-12">
						<label>Mã hợp đồng</label>

						<fmt:parseNumber var="intValue" value="${lastMaHd}"
							integerOnly="true" />
						<div class="form-control well">${intValue + 1}</div>

					</div>
					<form:hidden path="hoSoNhanVienPikalong.maNv" value="${hsnv.maNv}" />
					<div class="col-md-6">
						<div class="form-group">
							<label>Tên hợp đồng</label>
							<form:select path="loaiHopDongPikalong.maLoaiHopDong" class="form-control">
								<form:option value="0" selected="true">
									<--Chọn--></form:option>
								<form:option value="1">Hợp đồng thử việc</form:option>
								<form:option value="2">Hợp đồng ngắn hạn</form:option>
								<form:option value="3">Hợp đồng chính thức</form:option>
							</form:select>
							<form:errors path="loaiHopDongPikalong" cssStyle="color: red" />     <!-- Validate error  -->
						</div>
					</div>				
							<form:hidden path="trangThai" value="2"/>

				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Lương tháng 13</label>
							<form:select path="luongThang13" class="form-control">
								<form:option value="" selected="true"> <--Chọn--> </form:option>
								<option value="1">Có</option>
								<option value="2">Không</option>
							</form:select>
							<form:errors path="luongThang13" cssStyle="color: red" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Số ngày nghỉ trong năm</label>
							<form:input path="soNgayNghiTrongNam" type="text"
								id="soNgayNghiTrongNam" class="form-control" />
							<form:errors path="soNgayNghiTrongNam" cssStyle="color: red" />
						</div>
					</div>
					</div>
					<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày ký hợp đồng</label>
							<form:input path="ngayKiKet" type="date" id="ngayKiKet"
								class="form-control" />
							<form:errors path="ngayKiKet" cssStyle="color: red" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày kết thúc hợp đồng</label>
							<form:input path="ngayKetThuc" type="date" id="ngayKetThuc"
								class="form-control" />
							<form:errors path="ngayKetThuc" cssStyle="color: red" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-actions center">
				<a
					href="/ffse-fbms/QuanTriNhanSu/quanlihopdong/viewOneHopDong/${maNv}">
					<button type="button"
						class="btn btn-warning btn-min-width mr-1 mb-1">
						<i class="ft-x"></i> Hủy
					</button>
				</a>
				<button type="submit" class="btn btn-info btn-min-width mr-1 mb-1">
					<i class="fa fa-check"></i> Lưu
				</button>

			</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
