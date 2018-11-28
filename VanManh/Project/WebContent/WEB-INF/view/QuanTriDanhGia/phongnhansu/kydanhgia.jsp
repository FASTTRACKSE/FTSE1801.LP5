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
				<div class="card-content">
					<div class="card-body" style="margin: 1em">
						<form:form cssClass="form"
							action="/ffse-fbms/quantridanhgia/kydanhgia/save">
							<div class="form-body">
								<h4 class="form-section">
									<i class="fa fa-plus"></i>Tạo danh sách đánh giá
								</h4>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput1">Mã kỳ đánh giá</label>
											<form:input cssClass="form-control" path="maKy" />
											<form:errors cssStyle="color:red;" path="maKy" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput2">Tên kỳ đánh giá</label>
											<form:input cssClass="form-control" path="tenKy" />
											<form:errors cssStyle="color:red;" path="tenKy" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" style="padding-top: 1.9rem">
											<c:if test="${command.maKy == null }">
												<button class="btn btn-primary" type="submit">Tạo</button>
											</c:if>
											<c:if test="${command.maKy != null }">
												<button class="btn btn-primary" type="submit">Sửa</button>
												<a class="btn btn-danger"
													href="<c:url value = "/quantridanhgia/kydanhgia"/>">Hủy</a>
											</c:if>
										</div>
									</div>
									<form:hidden path="isDelete" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${not empty listKyDanhGia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách kỳ đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Mã kỳ đánh giá</th>
											<th scope="col">Tên kỳ đánh giá</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listKyDanhGia }" var="x" varStatus="stt">
											<tr>
												<th scope="row">${stt.index + 1}</th>
												<td>${x.maKy }</td>
												<td>${x.tenKy }</td>
												<td><a class="btn btn-info"
													href="<c:url value = "/quantridanhgia/kydanhgia/edit/${x.maKy }"/>">Sửa</a>
													<c:if test="${x.isActive == 0 }">
														<a class="btn btn-danger"
															onclick="confirm('Bạn thật sự muốn bắt đầu kỳ đánh giá này')"
															href="<c:url value = "/quantridanhgia/kydanhgia/active/${x.maKy }"/>">Bắt
															đầu</a>
													</c:if> <c:if test="${x.isActive == 1 }">
														<a class="btn btn-danger"
															onclick="confirm('Bạn thật sự muốn kết thúc kỳ đánh giá này')"
															href="<c:url value = "/quantridanhgiakydanhgia/deactive/${x.maKy }"/>">Kết
															thúc</a>
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination firstLast1-links">
									<c:if test="${pageKy > 1 }">
										<li class="page-item first"><a
											href="<c:url value="/quantridanhgia/kydanhgia/1" />"
											class="page-link">First</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/kydanhgia/${pageKy-1 }" />"
											class="page-link">Prev</a></li>
									</c:if>
									<li class="page-item active"><a href="#" class="page-link">${pageKy}</a></li>
									<c:if test="${pageKy < total }">
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/kydanhgia/${pageKy+1 }" />"
											class="page-link">Next</a></li>
										<li class="page-item last"><a
											href="<c:url value="/quantridanhgia/kydanhgia/${total}" />"
											class="page-link">Last</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="card">
				<div class="card-content">
					<div class="card-body" style="margin: 1em">
						<form:form cssClass="form" action="/ffse-fbms/quantridanhgia/phancongdanhgia">
							<div class="form-body">
								<h4 class="form-section">
									<i class="fa fa-plus"></i>Phân công đánh giá
								</h4>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="projectinput1">Chọn phòng ban</label>
											<select id="phongBan" name="phongBan" class="form-control">
												<c:forEach items="${listPhongBan }" var="x">
													<option value="${x.maPhongBan }" label="${x.tenPhongBan }"/>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group" style="padding-top: 1.9rem">
											<button class="btn btn-primary" type="submit">Tạo</button>
										</div>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>