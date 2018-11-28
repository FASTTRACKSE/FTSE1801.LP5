<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<c:if test="${empty listDanhgia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Chưa có bản đánh giá nào</h4>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty listDanhgia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách đánh giá nhân viên</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Nhân viên</th>
											<th scope="col">Xếp loại</th>
											<th scope="col">Trang Thái</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listDanhgia}" var="x" varStatus="stt">
											<tr>
												<th scope="row">${stt.index+1}</th>
												<td>${x.nhanVien.hoDem } ${x.nhanVien.ten }</td>
												<td>${x.danhGiaTongThe }</td>
												<td>${x.trangThai.tenTrangThai }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination firstLast1-links">
									<c:if test="${pageDanhGia > 1 }">
										<li class="page-item first"><a
											href="<c:url value="/quantridanhgia/danhsachdanhgia/1" />"
											class="page-link">First</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/danhsachdanhgia/${pageDanhGia-1 }" />"
											class="page-link">Prev</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/danhsachdanhgia/${pageDanhGia-1 }" />"
											class="page-link">${pageDanhGia-1 }</a></li>
									</c:if>
									<li class="page-item active"><a href="#" class="page-link">${pageDanhGia}</a></li>
									<c:if test="${pageDanhGia < total }">
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/danhsachdanhgia/${pageDanhGia+1 }" />"
											class="page-link">${pageDanhGia+1 }</a></li>
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/danhsachdanhgia/${pageDanhGia+1 }" />"
											class="page-link">Next</a></li>
										<li class="page-item last"><a
											href="<c:url value="/quantridanhgia/danhsachdanhgia/${total}" />"
											class="page-link">Last</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>