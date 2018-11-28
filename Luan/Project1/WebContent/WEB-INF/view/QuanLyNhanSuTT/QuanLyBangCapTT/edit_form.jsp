<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.suabangcap" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/bang_cap/" />'><spring:message code="label.thongTinBangCap" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.suabangcap" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="horz-layout-basic">
										<spring:message code="label.thongTinBangCap" />
									</h4>
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
									<div class="card-block">
										<form:form method="POST" modelAttribute="ttbc"
											action="/ffse-fbms/quanlynhansutt/bang_cap/save">
											<form:hidden path="id" />
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<label><spring:message code="label.maNhanVien" /></label>
												<form:input class="form-control" readonly="true"
													path="hoSoNhanVienTT.maNhanVien" placeholder="Mã Nhân Viên" />
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label><spring:message code="label.tenBangCap" /></label>
													<form:input path="tenBangCap" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="tenBangCap"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label><spring:message code="label.loaiBangCap" /></label>
													<form:input path="loaiBangCap" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="loaiBangCap"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label><spring:message code="label.noiCapBang" /></label>
													<form:input path="donViCap" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="donViCap"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label><spring:message code="label.noiCap" /></label>
													<form:input path="noiCap" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="noiCap"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="date1"><spring:message
															code="label.ngayCap" /></label>
													<div class="position-relative has-icon-left">
														<form:input path="ngayCap" type="date" id="roundText"
															class="form-control round" />
														<form:errors path="ngayCap"
															cssStyle="color:red;display:block"></form:errors>
														<div class="form-control-position">
															<i class="ft-message-square"></i>
														</div>
													</div>
												</div>
											</div>
											<div class="col-xl-6 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<a
												href="<c:url value = "/quanlynhansutt/bang_cap/viewOneBangCap/${maNhanVien}"/>"
												class="btn btn-primary"><spring:message code="label.quaylai" /></a> <input class="btn btn-success" type="submit" value="Save" />
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />