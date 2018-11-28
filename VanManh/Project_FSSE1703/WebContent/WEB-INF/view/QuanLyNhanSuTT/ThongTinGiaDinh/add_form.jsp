<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="label.themMoiGiaDinh" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quanlynhansutt/ho_so/"/>"><spring:message
										code="label.quanLyNhanSu" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/bang_cap/" />'><spring:message
										code="label.thongTinBangCap" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.themMoiGiaDinh" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<!-- Basic Elements start -->
			<section class="basic-elements">
				<div class="row">
					<div class="col-md-12">
						<div>
							<div>
								<div>
									<div class="row">
										<form:form method="POST"
											action="/ffse-fbms/quanlynhansutt/gia_dinh/save"
											modelAttribute="hsgd">
											<div class="form-body">
												<div class="row">
													<div class="col-md-8">
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label><spring:message code="label.maNhanVien" /></label>
																	<fmt:formatNumber type="number" var="hosonv.maNhanVien"
																		minIntegerDigits="5" groupingUsed="false"
																		value="${hoSoNhanVienTT.maNhanVien}" />
																	<input placeholder="Mã nhân viên" class="form-control"
																		value="${hosonv.maNhanVien}"
																		name="hoSoNhanVienTT.maNhanVien" readonly="readonly"
																		type="text">
																</div>
															</div>
														</div>
													</div>
												</div>
												<h4 class="form-section">
													<i class="ft-user"><label><spring:message
																code="label.thongTinGiaDinh" /></label></i>
												</h4>
												<div class="row">
													<div class="col-md-8">
														<div class="row">
															<div class="form-group col-sm-6">
																<label><spring:message code="label.hoTen" /></label>
																<form:input class="form-control" path="hoTen"
																	placeholder="Họ Và Tên" />
																<form:errors path="hoTen"
																	cssClass="invalid-feedback d-block" />
															</div>
															<div class="form-group col-sm-6">
																<div class="form-group">
																	<label for="date1"><spring:message
																			code="label.ngaySinh" /></label>
																	<fieldset class="form-group position-relative">
																		<form:input placeholder="Năm Sinh" type="date"
																			class="form-control round" id="date1" path="namSinh" />
																		<div class="form-control-position">
																			<i class="fa fa-calendar-o"></i>
																		</div>
																	</fieldset>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="form-group col-sm-6">
																<label><spring:message code="label.queQuan" /></label>
																<form:input class="form-control" path="queQuan"
																	placeholder="Quê Quán" />
																<form:errors path="queQuan"
																	cssClass="invalid-feedback d-block" />
															</div>
															<div class="form-group col-sm-6">
																<label><spring:message code="label.dienThoai" /></label>
																<form:input class="form-control" path="soDienThoai"
																	placeholder="Số Điện Thoại" />
																<form:errors path="soDienThoai"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
														<div class="row">
															<div class="form-group col-sm-6">
																<div class="form-group">
																	<label><spring:message code="label.gioiTinh" /></label>
																	<form:select class="custom-select form-control"
																		path="gioiTinh">
																		<option value="none"><spring:message
																				code="label.chonGioiTinh" /></option>
																		<form:option value="1">
																			<spring:message code="label.nam" />
																		</form:option>
																		<form:option value="2">
																			<spring:message code="label.nu" />
																		</form:option>
																	</form:select>
																</div>
															</div>
															<div class="form-group col-sm-6">
																<label><spring:message code="label.quanHe" /></label>
																<form:input class="form-control" path="quanHe"
																	placeholder="Nơi Cấp" />
																<form:errors path="quanHe"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions center">
												<a
													href="<c:url value = "/quanlynhansutt/gia_dinh/viewOneGiaDinh/${maNhanVien}"/>"
													class="btn btn-primary"><spring:message
														code="label.quaylai" /></a> <input class="btn btn-success"
													type="submit" value="Save" />
												<p style="color: red">${messageQuanHe}</p>
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