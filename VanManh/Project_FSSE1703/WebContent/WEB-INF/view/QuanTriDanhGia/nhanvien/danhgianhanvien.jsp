<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<c:if test="${empty listDanhGiaNhanVien}">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-content">
							<div class="card-body" style="margin: 1em">
								<h2>Chưa có danh sách đánh giá</h2>
								<a class="btn btn-primary"
									href="<c:url value = "/quantridanhgia/danhgianhanvien/create"/>">Tạo
									ngay</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty listDanhGiaNhanVien}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách nhân viên cần đánh giá</h4>
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
											<th scope="col">Hoạt động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listDanhGiaNhanVien }" var="x"
											varStatus="stt">
											<tr>
												<th scope="row">${stt.index + 1 }</th>
												<td>${x.nhanVien.hoDem}${x.nhanVien.ten}</td>
												<td>${x.xepLoai }</td>
												<td><c:if test="${x.xepLoai !=0 }">
														<a class="btn btn-info"
															href="<c:url value = "/quantridanhgia/danhgianhanvien/view/${x.id }" />">Xem</a>
														<a class="btn btn-info"
															href="<c:url value = "/quantridanhgia/danhgianhanvien/edit/${x.id }" />">Sửa</a>
													</c:if> <c:if test="${x.xepLoai == 0 }">
														<a class="btn btn-info"
															href="<c:url value = "/quantridanhgia/danhgianhanvien/add/${x.id }" />">Tạo</a>
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>