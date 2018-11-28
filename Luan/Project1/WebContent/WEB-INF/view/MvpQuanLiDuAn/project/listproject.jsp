<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<!-- ///////////////////////////////////////////////////////// -->


<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách Dự án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/project/list-project" />'>Danh
									sách Dự án</a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!-- End Path -->

		<div class="content-body">
			<div class="x_panel">

				<div class="x_content">

					<!-- Show message -->
					<c:if test="${success ne null}">
						<div class="alert alert-success alert-dismissable" role="alert">
							<button type="button" class="close" data-dismiss="alert">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							${success}
						</div>
					</c:if>
					<form method="GET" action="">
						<div class="col-md-3">
						<h6><b>${totalProject} Dự án.</b></h6>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								Khách hàng <select name="khachhang"
									class="form-control form-control-sm" id="khachhang">
									<option value="0" selected="selected">--Tất cả--</option>
									<c:forEach items="${khachHang}" var="kh">
										<option value="${kh.idKhachHang }"
										<c:if test="${khachHangs == kh.idKhachHang }"> selected="selected"</c:if>
										>${kh.idKhachHang }-${kh.fullname }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								Phòng dự án<select name="roomproject"
									class="form-control form-control-sm" id="roomproject">
									<option value="0" selected="selected">--Tất cả--</option>
									<c:forEach items="${phongDuAn}" var="kh">
										<option value="${kh.maPhongBan }"
										<c:if test="${phongDuAns == kh.maPhongBan }"> selected="selected"</c:if>
										>${kh.tenPhongBan }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								Nghiệp vụ <select name="domain"
									class="form-control form-control-sm" id="domain">
									<option value="0" selected="selected">--Tất cả--</option>
									<c:forEach items="${domain}" var="kh">
										<option value="${kh.idDomain }"
										<c:if test="${domains == kh.idDomain }"> selected="selected"</c:if>
										>${kh.nameDomain }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								Trạng thái <select name="status"
									class="form-control form-control-sm" id="status">
								<option value="0" selected="selected">--Tất cả--</option>
									<c:forEach items="${status}" var="kh">
										<option value="${kh.idStatus }"
											<c:if test="${statuss == kh.idStatus }"> selected="selected"</c:if>
										>${kh.nameStatus }</option>
									</c:forEach>
								</select>

							</div>
						</div>
						<div class="col-md-1" style="margin-top: 20px">
							<label></label>
							<button type="submit" class="btn mr-1 mb-1 btn-success btn-sm">
								<i class="fa fa-search"></i> Lọc
							</button>
						</div>
						<script type="text/javascript">
							khachhang =
						<%=request.getParameter("khachhang")%>
							;
							if (khachhang != 0 && khachhang != null) {
								$("#khachhang").val(khachhang);
							}
							roomproject =
						<%=request.getParameter("roomproject")%>
							;
							if (roomproject != 0 && roomproject != null) {
								$("#roomproject").val(roomproject);
							}
							domain =
						<%=request.getParameter("domain")%>
							;
							if (domain != 0 && domain != null) {
								$("#domain").val(domain);
							}
							status =
						<%=request.getParameter("status")%>
							;
							if (status != 0 && status != null) {
								$("#status").val(status);
							}
						</script>

					</form>
					<table class="table table-bordered"
						style="text-align: center; background: white">
						<thead style="background: #AEEEEE">
							<tr>
								<th style="text-align: center">Mã Dự án</th>
								<th style="text-align: center">Dự án</th>
								<th style="text-align: center">Khách hàng</th>
								<th style="text-align: center">Phòng dự án</th>
								<th style="text-align: center">Nghiệp vụ</th>
								<th style="text-align: center">Trạng thái</th>
								<th style="text-align: center">chức năng ${totalPage}</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="project" items="${listProject}">
								<tr>
									<td style="text-align: left">${project.idProject}</td>
									<td style="text-align: left">${project.nameProject}</td>
									<td style="text-align: left">${project.khachHang.fullname}</td>
									<td style="text-align: left">${project.roomProject.tenPhongBan}</td>
									<td style="text-align: left">${project.domain.nameDomain}</td>
									<td style="color: ${project.status.color}"><h6>
											<b>${project.status.nameStatus}</b>
										</h6></td>

									<td><a class="btn btn-outline-info  "
										href="<c:url value="/mvpquanliduan/project/detail-project/${project.idProject}" />"
										title=""><i class="icon-eye"></i> </a>
										
										<button
											data-href="<c:url value="/mvpquanliduan/project/delete/${project.idProject}" />"
											class="btn btn-outline-danger" data-toggle="modal"
											data-target="#xoa_pr" ${disable }>
											<i class="icon-close"></i>
										</button>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					<c:if test="${totalPage > 1}">
					<div class="text-center" style="float: right;margin-right: 50px">
						<ul class="pagination firstLast1-links">
							<c:if test="${pageId > 1}">
								<li class="page-item"><a href="1" class="page-link">First</a></li>
								<li class="page-item"><a href="${pageId-1 }"
									class="page-link">${pageId-1 }</a></li>
							</c:if>
							
							<li class="page-item active"><a href="#" class="page-link">${pageId } </a></li>
							<c:if test="${pageId < totalPage}">
								<li class="page-item"><a href="${pageId+1 }"
									class="page-link">${pageId+1 }</a></li>
								<li class="page-item"><a href="${totalPage }"
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
<!--                 Css for confirm delete -->
<div class="modal fade" id="xoa_pr" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Xác nhận</h4>
			</div>
			<div class="modal-body">
				<p>Bạn muốn xóa Dự án này???</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				<a class="btn btn-primary del_pr">Xóa</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script type="text/javascript">
	$('#xoa_pr').on('show.bs.modal', function(e) {
		// var test = $(e.relatedTarget).data('href'); console.log(test);
		$(this).find('.del_pr').attr('href', $(e.relatedTarget).data('href'));
	});

</script>

<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />