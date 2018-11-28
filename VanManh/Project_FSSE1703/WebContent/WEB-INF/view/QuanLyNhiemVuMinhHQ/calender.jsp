<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.danhsachnhiemvu"/></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangchunhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.danhsachnhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyNhiemVuMinhHQ/create"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span><spring:message code="label.themmoinhiemvu"/></a>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
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
						<form:form method="GET">
							<div class="form-group col-sm-10">
								<div class="form-group col-sm-4">
									<label><spring:message code="label.duannhiemvu" /></label> <select
										class="custom-select block round" name="maDuAn" id="maDuAn">
										<option value="0"
											label="<spring:message code="label.tatcanhiemvu"/>" />
										<c:forEach items="${DuAn}" var="ld">
											<option value="${ld.maDuAn}" label="${ld.tenDuAn}" />
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-4">
									<label><spring:message code="label.nguoiduocphancong" /></label>
									<select class="custom-select block round" name="maNhanVien"
										id="maNhanVien">
										<option value="0"
											label="<spring:message code="label.tatcanhiemvu"/>" />
										<c:forEach items="${NhanVien}" var="ld">
											<option value="${ld.maNhanVien}"
												label="${ld.hoDem} ${ld.ten}" />
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-4">
									<label><spring:message code="label.trangthainhiemvu" /></label>
									<select class="custom-select block round" name="maTrangThai"
										id="maTrangThai">
										<option value="0"
											label="<spring:message code="label.tatcanhiemvu"/>" />
										<c:forEach items="${TrangThai}" var="ld">
											<option value="${ld.maTrangThai}" label="${ld.trangThai}" />
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
								maNhanVien =
							<%=request.getParameter("maNhanVien")%>
								;
								if (maNhanVien != 0 && maNhanVien != null) {
									$("#maNhanVien").val(maNhanVien);
								}
								maTrangThai =
							<%=request.getParameter("maTrangThai")%>
								;
								if (maTrangThai != 0 && maTrangThai != null) {
									$("#maTrangThai").val(maTrangThai);
								}
							</script>
							<div class="form-group col-sm-2">

								<button class="btn btn-success block round"
									style="margin-top: 25px">
									<i class="ft-search"></i>
									<spring:message code="label.timkiemnhiemvu" />
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<script>
				$(document).ready(function() {

					$('#calendar').fullCalendar({
						header : {
							left : 'prev,next today',
							center : 'title',
							right : 'month,basicWeek,basicDay'
						},
						defaultDate : '2018-10-10',
						navLinks : true, // can click day/week names to navigate views
						editable : true,
						eventLimit : true, // allow "more" link when too many events
						events :
			<%=request.getAttribute("js")%>
				});

				});
			</script>
			<div class="card-body">
				<div id="calendar"></div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />