<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0">Danh sách Hợp Đồng Của Nhân
			Viên</h3>
		<section class="basic-elements">

			<div class="col-12">
				<div class="card-content collapse in">
					<div class="card-block card-dashboard">
						<div class="card-body">
							<table class="table mb-0">
								<thead class="bg-info">
									<tr>

										<th>Mã Nhân Viên</th>
										<th>Họ và Tên</th>
										<th>Tên Hợp Đồng</th>
										<th>Ngày Kí Kết</th>
										<th>Ngày Kết Thúc</th>
										<th>Lương Tháng 13</th>
										<th>Trạng Thái</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listHopDong}" var="x" varStatus="stt">
										<tr>

											<td>${x.hoSoNhanVienPikalong.maNv}</td>
											<td>${x.hoSoNhanVienPikalong.hoTenNv}</td>
											<td>${x.loaiHopDongPikalong.tenHopDong}</td>
											<td>${x.ngayKiKet}</td>
											<td>${x.ngayKetThuc}</td>
											<td>${x.luongThang13 == 1 ? 'Có' : 'Không'}</td>
											<td>${x.trangThai == 1 ? 'Hết hợp đồng' : 'Còn hợp đồng'}</td>
											<td></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>

			</div>
		</section>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
