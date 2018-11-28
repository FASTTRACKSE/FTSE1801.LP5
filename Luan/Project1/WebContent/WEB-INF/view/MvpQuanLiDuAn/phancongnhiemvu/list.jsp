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
				<h3 class="content-header-title mb-0">Phân công nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/project/list-project" />'>Danh
									sách dự án</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/project/detail-project/${idProjects}" />'>Chi
									tiết dự án</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/nhiemvu/list-nhiemvu/${idProjects}" />'>Phân
									công nhiệm vụ</a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->


		<div class="content-body">
			<div class="x_panel">

				<div class="x_title">

					<input ${disable }
						class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						value=" Thêm phân công nhiệm vụ"
						onclick="location.href='<c:url value="/mvpquanliduan/nhiemvu/show-form-add/${idProjects}" />'">
				</div>
				<hr>
				<div class="row">
					<form method="GET" action="">
						<div class="col-md-6">
							<h1>
								<b>${project.nameProject }</b>
							</h1>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								Mã Nhân Viên <select class="form-control form-control-sm"
									name="maNV" id="maNV">
									<option value="0" selected label="--- Tất cả ---" />
									<c:forEach items="${nhanVienList}" var="x">
										<option value="${x.maNv}">(${x.maNv}) ${x.hoTenNv}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								Vai Trò <select class="form-control form-control-sm"
									name="vaiTro" id="vaiTro">
									<option value="0" selected label="--- Tất cả ---" />
									<c:forEach items="${listRoles}" var="x">
										<option value="${x.idRoles}">${x.nameRoles}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-md-2" style="margin-top: 25px;">
							<label></label>
							<button type="submit" class="btn mr-1 mb-1 btn-success btn-sm">
								<i class="fa fa-search"></i> Lọc
							</button>
						</div>

					</form>
				</div>
				<script>
window.onload = function () { 
	maNV = "<%=request.getParameter("maNV")%>";
	if (maNV != 0 && maNV != "null") {
		$("#maNV").val(maNV);
	}
	vaiTro= "<%=request.getParameter("vaiTro")%>"
						if (vaiTro != 0 && vaiTro != "null") {
							$("#vaiTro").val(vaiTro);
						}
					}
				</script>
				<div class="x_content">

					<table class="table table-striped" style="text-align: center;background: white">
						<thead style="background: #AEEEEE">
							<tr>


								<th style="text-align: center">Mã Nhân Viên</th>
								<th style="text-align: center">Tên Nhân Viên</th>

								<th style="text-align: center">Vai trò</th>
								<th style="text-align: center">Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="nhiemVu" items="${listNhiemVu}" varStatus="count">
								<tr>



									<td style="text-align: left">${nhiemVu.hoSoNhanVien.maNv}</td>
									<td style="text-align: left">${nhiemVu.hoSoNhanVien.hoTenNv}</td>
									<td style="text-align: left">${nhiemVu.roles.nameRoles}</td>

									<td>
										 <input ${disable }
										class="btn btn-outline-info ft-edit"
										style="width: 50px; high: 50px; border-color: #00E5EE; border-radius: 100%;"
										value="Edit"
										onclick="location.href='<c:url value="/mvpquanliduan/nhiemvu/show-form-edit/${nhiemVu.id }" />'">
										<button ${disable }
											style="width: 50px; high: 50px; border-color: #FF6A6A; border-radius: 100%;"
											data-href="<c:url value="/mvpquanliduan/nhiemvu/delete/${nhiemVu.id  }" />"
											class="btn btn-outline-danger" data-toggle="modal"
											data-target="#xoa_pr">
											<i class="ft-delete"></i>
										</button>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					<c:if test="${totalPage > 1}">
						<div class="text-center" style="float: right; margin-right: 50px">
							<ul class="pagination firstLast1-links">
								<c:if test="${pageId > 1}">
									<li class="page-item"><a href="1" class="page-link">First</a></li>
									<li class="page-item"><a href="${pageId-1 }"
										class="page-link">${pageId-1 }</a></li>
								</c:if>
								<li class="page-item active"><a href="#" class="page-link">${pageId }</a></li>
								<c:if test="${pageId < totalPage}">
									<li class="page-item"><a href="${pageId+1 }"
										class="page-link">${pageId+1 }</a></li>
									<li class="page-item"><a href="${totalPage }"
										class="page-link">Last</a></li>
								</c:if>
							</ul>
						</div>
					</c:if>
					<c:if test="${success != null }">
						${success}
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
				<p>Bạn muốn xóa Nhiệm vụ này???</p>
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
