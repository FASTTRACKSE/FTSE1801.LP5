<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Danh sách nhân viên cần đánh giá</h4>
				</div>
				<div class="card-content">
					<div class="card-body" style="margin: 1em">
						<c:if test="${empty listDanhGia }">
							<h3>Phòng này không có nhân viên nào</h3>
						</c:if>
						<c:if test="${not empty listDanhGia }">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Nhân viên</th>
											<th scope="col">Xếp loại</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listDanhGia}" var="x" varStatus="stt">
											<tr>
												<th scope="row">${stt.index+start+1}</th>
												<td>${x.nhanVien.hoDem }${x.nhanVien.ten }</td>
												<td>${x.xepLoai }</td>
												<td><a class="btn btn-info"
													href="<c:url value="/quantridanhgia/truongphongdanhgia/view/${x.id }"/>">Xem</a>
													<c:if test="${x.xepLoai < 1 }">
														<a class="btn btn-success"
															href="<c:url value="/quantridanhgia/truongphongdanhgia/add/${x.id }"/>">Đánh
															giá</a>
													</c:if>
													<c:if test="${x.xepLoai > 1 }">
														<a class="btn btn-success"
															href="<c:url value="/quantridanhgia/truongphongdanhgia/edit/${x.id }"/>">Sửa</a>
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination firstLast1-links">
									<c:if test="${pageTPDG > 1 }">
										<li class="page-item first"><a
											href="<c:url value="/quantridanhgia/truongphongdanhgia/1" />"
											class="page-link">First</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/truongphongdanhgia/${pageTPDG-1 }" />"
											class="page-link">Prev</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/truongphongdanhgia/${pageTPDG-1 }" />"
											class="page-link">${pageTPDG-1 }</a></li>
									</c:if>
									<li class="page-item active"><a href="#" class="page-link">${pageTPDG}</a></li>
									<c:if test="${pageTPDG < total }">
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/truongphongdanhgia/${pageTPDG+1 }" />"
											class="page-link">${pageTPDG + 1 }</a></li>
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/truongphongdanhgia/${pageTPDG+1 }" />"
											class="page-link">Next</a></li>
										<li class="page-item last"><a
											href="<c:url value="/quantridanhgia/truongphongdanhgia/${total}" />"
											class="page-link">Last</a></li>
									</c:if>
								</ul>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>