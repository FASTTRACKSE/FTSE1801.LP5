<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
div.stroke a button, div.stroke a button:after, div.stroke a button:before
	{
	transition: all .5s;
}

div.stroke a button:hover {
	color: #555;
}

div.stroke a button {
	position: relative;
}

div.stroke a button:after {
	position: absolute;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	width: 0%;
	content: '.';
	color: transparent;
	background: #aaa;
	height: 1px;
}

div.stroke a button:hover:after {
	width: 100%;
}
</style>

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<h3 class="content-header-title mb-0">
		Danh Sách Hợp Đồng 
		
		</h3>
		<!-- title -->
		<br>
		<br>
		<!-- add button -->
		<div class="table">
			<table class="table mb-0">
				<thead>
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
				<c:if test="${size > 0}"> 
					<c:forEach items="${listHopDongPhongBan}" var="x"
						varStatus="stt">
						<tr>
							<td>${x.hoSoNhanVienPikalong.maNv}</td>
							<td>${x.hoSoNhanVienPikalong.hoTenNv}</td>
							<td>${x.loaiHopDongPikalong.tenHopDong}</td>
							<td>${x.ngayKiKet}</td>
							<td>${x.ngayKetThuc}</td>
							<td>${x.luongThang13 == 1 ? 'Có' : 'Không'}</td>
							<td>${x.trangThai == 1 ? 'Hết hợp đồng' : 'Còn hợp đồng'}</td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>

		
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />