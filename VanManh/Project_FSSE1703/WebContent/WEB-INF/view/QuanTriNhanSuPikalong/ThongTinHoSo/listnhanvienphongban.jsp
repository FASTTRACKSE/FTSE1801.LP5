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
		 Danh Sách Nhân viên <c:if test="${size > 0}">${listNhanVienByPhongBan.get(0).maPhongBan.tenPhongBan}</c:if>
		</h3>
		<!-- title -->
		<br>
		<br>
		<!-- add button -->
		<div class="table">
			<table class="table mb-0">
				<thead>
					<tr>
						<th>STT</th>
						<th>Mã Nhân Viên</th>
						<th>Họ Tên</th>
						<th>Giới tính</th>
						<th>Ngày Sinh</th>
						<th>Phòng Ban</th>
						<th>Chức Danh</th>
						<th>Ảnh Đại Diện</th>
						<th>Chức Năng</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${size > 0}">
					<c:forEach items="${listNhanVienByPhongBan}" var="x"
						varStatus="stt">
						<tr>
							<td>${stt.index + 1}</td>
							<td>${x.maNv}</td>
							<td>${x.hoTenNv}</td>
							<td>${x.gioiTinh}</td>
							<td>${x.ngaySinh}</td>
							<td>${x.maPhongBan.tenPhongBan}</td>
							<td>${x.maChucDanh.tenChucDanh}</td>
							<td><img src="<c:url value="/uploads/${x.avatar}" />"
								width="60" height="80"></td>
							<td>
								<div class="stroke">						
									<a href="/ffse-fbms/quantrinhansu/hosonhanvien/hosochitiet/${x.maNv}"><button
											style="background-color: #F5F7FA" class="btn btn-light">
											<i class="fa fa-eye"></i>
										</button></a>
								</div>
							</td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>

		
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />