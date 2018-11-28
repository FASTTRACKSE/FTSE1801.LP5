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
				<c:if test="${empty listNhanVien }">
					<div class="card-body" style="margin: 1em">
						<h3>Chưa có đánh giá nào từ nhân viên</h3>
					</div>
				</c:if>
				<c:if test="${not empty listNhanVien }">
					<div class="card-header">
						<h4 class="card-title">Danh sách đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Nhân viên</th>
											<th scope="col">Đánh giá tổng thể</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listNhanVien }" var="x" varStatus="stt">
											<tr>
												<th scope="row">${stt.index + start +1}</th>
												<td>${x.nhanVien.hoDem }${x.nhanVien.ten }</td>
												<td>${x.danhGiaTongThe }</td>
												<td><a class="btn btn-primary"
													href="<c:url value="/quantridanhgia/duyetdanhgia/view/${x.id }" />">Xem</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination firstLast1-links">
									<c:if test="${pageDDG > 1 }">
										<li class="page-item first"><a
											href="<c:url value="/quantridanhgia/duyetdanhgia/1" />"
											class="page-link">First</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/duyetdanhgia/${pageDDG-1 }" />"
											class="page-link">Prev</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/duyetdanhgia/${pageDDG-1 }" />"
											class="page-link">${pageDDG-1 }</a></li>
									</c:if>
									<li class="page-item active"><a href="#" class="page-link">${pageDDG}</a></li>
									<c:if test="${pageDDG < total }">
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/duyetdanhgia/${pageDDG+1 }" />"
											class="page-link">${pageDDG+1 }</a></li>
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/duyetdanhgia/${pageDDG+1 }" />"
											class="page-link">Next</a></li>
										<li class="page-item last"><a
											href="<c:url value="/quantridanhgia/duyetdanhgia/${total}" />"
											class="page-link">Last</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>