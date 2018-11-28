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
				<h3 class="content-header-title mb-0">Danh sách trạng thái</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/status/list-status" />'>Danh sách trạng thái</a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!-- End Path -->

		<div class="content-body">
			<div class="x_panel">
				<div class="x_title">
					<a class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						href="<c:url value="/mvpquanliduan/status/show-form-add" />">
						<h5class="ft-plus-circle">Thêm trạng Thái
						</h5>
					</a>
				</div>
				<div class="x_content">

					<table class="table table-striped"
						style="text-align: center; background: white">
						<thead style="background: #AEEEEE">
							<tr>
								<th style="text-align: center">Mã trạng thái</th>
								<th style="width: 40%; text-align: center">Trạng thái</th>
								<th style="text-align: center"><spring:message code="label.vaitro"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="status" items="${listStatus}" varStatus="count">
								<tr>

									<th scope="row">${count.count  }</th>
									<td style= "color: ${status.color}">${status.nameStatus}</td>
									
									<td><a
										style="width: 50px; high: 50px; border-color: #00E5EE; border-radius: 100%;"
										class="btn btn-outline-info "
										href="<c:url value="/mvpquanliduan/status/show-form-edit/${status.idStatus }" />"
										title=""><i class="ft-edit"></i></a>
									<button
											style="width: 50px; high: 50px; border-color: #FF6A6A; border-radius: 100%;"
											data-href="<c:url value="/mvpquanliduan/status/delete/${status.idStatus }" />"
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
				<p>Bạn muốn xóa Trạng thái này???</p>
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
