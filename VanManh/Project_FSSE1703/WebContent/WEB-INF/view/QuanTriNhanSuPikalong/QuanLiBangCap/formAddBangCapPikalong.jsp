<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.themBangCap" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/quantrinhansu/hosonhanvien/" />'><spring:message
										code="label.danhSachNhanVien" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quantrinhansu/hosonhanvien/view/${maNv }" />'><spring:message
										code="label.thongTinCaNhan" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCap/${maNv}" />'><spring:message
										code="label.thongTinBangCap" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.themBangCap" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="content-body">
			<!-- Basic Elements start -->
			<section class="basic-elements">
				<div class="row">
					<div class="col-md-12">
						<div>
							<div>
								<div>
									<div class="row">
										<form:form method="post"
											action="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/saveOneBangCap"
											class="form-horizontal">
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message
															code="label.maNhanVien" /></label>
													<form:input path="maNV" type="text"
														class="form-control round" readonly="true" />
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message
															code="label.chuyenNganh" /></label>
													<form:input path="chuyenNganh" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="chuyenNganh"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message
															code="label.xepLoai" /></label>
													<form:input path="xepLoai" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="xepLoai"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message
															code="label.noiCap" /></label>
													<form:input path="noiCap" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="noiCap"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message
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
													<input class="btn btn-outline-success round" type="submit"
														value="<spring:message code="label.luu" />" /> <a
														class="btn btn-outline-danger round"
														href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/viewOneBangCap/${maNv}"><spring:message
															code="label.huy" /></a>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />