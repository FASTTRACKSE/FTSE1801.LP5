<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid"
	style="background-color: #CCCCCC">
	<div class="content-wrapper">
		<div class="content-header-left col-md-9 col-xs-12 mb-2">
			<h3 class="content-header-title mb-0"><spring:message code="label.listDA" /></h3>
			<div class="row breadcrumbs-top">
				<div class="breadcrumb-wrapper col-xs-12">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
						<li class="breadcrumb-item active"><spring:message code="label.DuAn" /></li>
					</ol>
				</div>
			</div>
		</div>
		<div class="content-header-right col-md-3 col-xs-12">
			<div role="group" aria-label="Button group with nested dropdown"
				class="btn-group float-md-right" id="add-new">
				<a href="/ffse-fbms/qlda/DuAn/add_form" class="btn btn-primary"><span
					class="fa fa-plus"></span><spring:message code="label.newDuAn" /></a>
			</div>
		</div>
		<div class="content-body">

			<!-- Show message -->


			<!-- End Show message -->

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title"><spring:message code="label.listDA" /></h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
									<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									<li><a data-action="close"><i class="ft-x"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<form:form method="GET" action="">
										<div class="form-group col-sm-16">
											<div class="form-group col-sm-3">
												<label><spring:message code="label.tenDuAn" /></label> <select
													class="custom-select block round" name="maDuAn" id="maDuAn">
													<option value="0" label="Tất cả" />
													<c:forEach items="${duan}" var="ld">
														<option value="${ld.maDuAn}" label="${ld.tenDuAn}" />
													</c:forEach>
												</select>
											</div>
											<div class="form-group col-sm-3">
												<label><spring:message code="label.khachHang" /></label> <select
													class="custom-select block round" name="makh" id="makh">
													<option value="0" label="Tất cả" />
													<c:forEach items="${khachHang}" var="ld">
														<option value="${ld.makh}" label="${ld.tenkh} " />
													</c:forEach>
												</select>
											</div>
											<div class="form-group col-sm-3">
												<label><spring:message code="label.phongBan1" /></label> <select
													class="custom-select block round" name="maPhongBan"
													id="maPhongBan">
													<option value="0" label="Tất cả" />
													<c:forEach items="${phongBan}" var="ld">
														<option value="${ld.maPhongBan}" label="${ld.tenPhongBan}" />
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group col-sm-3">
											<label><spring:message code="label.trangThai" /></label> <select
												class="custom-select block round" name="maTrangThai"
												id="maTrangThai">
												<option value="0" label="Tất cả" />
												<c:forEach items="${trangThai}" var="ld">
													<option value="${ld.maTrangThai}"
														label="${ld.tenTrangThai}" />
												</c:forEach>
											</select>
										</div>
								</div>
								<script type="text/javascript">
									maDuAn =
								<%=request.getParameter("maDuAn")%>
									;
									if (maDuAn != 0 && maDuAn != null) {
										$("#maDuAn").val(maDuAn);
									}
									makh =
								<%=request.getParameter("makh")%>
									;
									if (makh != 0 && makh != null) {
										$("#makh").val(makh);
									}
									maPhongBan =
								<%=request.getParameter("maPhongBan")%>
									;
									if (maPhongBan != 0 && maPhongBan != null) {
										$("#maPhongBan").val(maPhongBan);
									}
									TrangThai =
								<%=request.getParameter("TrangThai")%>
									;
									if (TrangThai != 0 && TrangThai != null) {
										$("#TrangThai").val(TrangThai);
									}
								</script>

								<div class="form-group col-sm-4">

									<button class="btn btn-success" style="margin-top: 25px">
										<i class="ft-search"></i> <spring:message code="label.timkiem" />
									</button>
								</div>
								</form:form>
								<table class="table"
									style="border-collapse: collapse; border-collapse: separate;">
									<thead style="background: graytext; color: white;">
										<tr>
											<th><spring:message code="label.maDuAn" /></th>
											<th><spring:message code="label.tenDuAn" /></th>
											<th><spring:message code="label.khachHang" /></th>
											<th><spring:message code="label.phongBan1" /></th>
											<th><spring:message code="label.trangThai" /></th>

											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="entities" items="${list }">
											<tr>
												<td>${entities.maDuAn}</td>
												<td>${entities.tenDuAn}</td>
												<td>${entities.khachHang.tenkh}</td>
												<td>${entities.phongBan.tenPhongBan}</td>
												<td>${entities.trangThai.tenTrangThai}</td>
												<td>
												
												<a href="/ffse-fbms/qlda/DuAn/view/${entities.maDuAn}"
													data-toggle="tooltip" title="view">
														<button type="button"
															class="btn btn-icon btn-outline-info">
															<i class="fa fa-eye"></i>
														</button>
												</a>
												<sec:authorize access="hasRole('ROLE_PDATPP') or hasRole('ROLE_PITTPP') or hasRole('ROLE_PITNV')">
												
												<a
													href="/ffse-fbms/qlda/DuAn/edit/${entities.maDuAn}"
													data-toggle="tooltip" title="edit">
														<button type="button"
															class="btn btn-icon btn-outline-warning">
															<i class="fa fa-pencil"></i>
														</button>
												</a>  <a href="/ffse-fbms/qlda/DuAn/delete/${entities.maDuAn}">
														<button type="button"
															onclick="if (!confirm('Are you sure you want to delete this database?')) return false"
															class="btn btn-outline-danger btn-icon checkid"
															data-toggle="modal" title="delete" data-target="#danger">
															<i class="fa fa-trash-o"></i>
														</button>
												</a>
												</sec:authorize>
												</td>
										
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%
			String query = "&maDuAn=" + request.getParameter("maDuAn") + "&makh=" + request.getParameter("makh")
					+ "&maPhongBan=" + request.getParameter("maPhongBan") + "&maTrangThai="
					+ request.getParameter("maTrangThai");
			boolean search = !(request.getParameter("maDuAn") == null);
			query = search ? query : "";
		%>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="/ffse-fbms/qlda/DuAn/list/1" <%=query%>><spring:message code="label.firtVendor" /></a></li>
				<c:if test="${currentPage > 2}">
					<li class="page-item"><a class="page-link"
						href="/ffse-fbms/qlda/DuAn/list/<%=query %>${page-2}">${page-2}</a></li>
				</c:if>
				<c:if test="${page > 1}">
					<li class="page-item"><a class="page-link"
						href="/ffse-fbms/qlda/DuAn/list/<%=query %>${page-1}">${page-1}</a></li>
				</c:if>
				<li class="page-item active"><a class="page-link"
					href="/ffse-fbms/qlda/DuAn/list/<%=query %>${page}">${page}</a></li>
				<c:if test="${page < total}">
					<li class="page-item"><a class="page-link"
						href="/ffse-fbms/qlda/DuAn/list/${page+1}">${page+1}</a></li>
				</c:if>
				<c:if test="${page < total - 1}">
					<li class="page-item"><a class="page-link"
						href="/ffse-fbms/qlda/DuAn/list/${page+2}">${page+2}</a></li>
				</c:if>
				<li class="page-item"><a class="page-link"
					href="/ffse-fbms/qlda/DuAn/list/${total}"><spring:message code="label.lastVendor" /></a></li>
			</ul>
		</nav>

		<div class="row"></div>
	</div>
	<div class="col-sm-4">

		<c:if test="${message !=null }">
						 ${message }
			</c:if>

	</div>
</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />


