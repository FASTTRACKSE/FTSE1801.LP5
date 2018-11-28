<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="row">
			<div class="card">
				<c:if test="${empty listNhanVienDanhGia }">
					<h3>Bạn chưa được ai đánh giá</h3>
				</c:if>

				<c:if test="${not empty listNhanVienDanhGia }">
					<div class="card-header">
						<h4 class="card-title">Danh sách nhân viên đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Bản đánh giá</th>
											<th scope="col">Xếp loại</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listNhanVienDanhGia }" var="x"
											varStatus="stt">
											<tr>
												<th scope="row">${stt.index+1 }</th>
												<td>Nhân viên ${stt.index+1 }</td>
												<td>${x.xepLoai }</td>
												<td><a class="btn btn-info"
													href="<c:url value="/quantridanhgia/nhanviendanhgia/${x.id}" />">Xem</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>