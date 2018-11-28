/'<%@ page language="java" contentType="text/html; charset=UTF-8"
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
					<spring:message code="label.thongTinBangCap" />
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
									code="label.themmoibangcap" /></li>
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
											action="/ffse-fbms/quanlynhansutt/bang_cap/save"
											modelAttribute="ttbc">
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
													<i class="ft-user"><spring:message
															code="label.thongTinBangCap" /></i>
												</h4>
												<div class="row">
													<div class="col-md-8">
														<div class="row">
															<div class="form-group col-sm-6">
																<label><spring:message code="label.tenBangCap" /></label>
																<form:input class="form-control" path="tenBangCap"
																	placeholder="Tên Bằng Cấp" />
																<form:errors path="tenBangCap"
																	cssClass="invalid-feedback d-block" />
															</div>
															<div class="form-group col-sm-6">
																<label><spring:message code="label.loaiBangCap" /></label>
																<form:input class="form-control" path="loaiBangCap"
																	placeholder="Loại Bằng Cấp" />
																<form:errors path="loaiBangCap"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
														<div class="row">
															<div class="form-group col-sm-6">
																<label><spring:message code="label.noiCapBang" /></label>
																<form:input class="form-control" path="donViCap"
																	placeholder="Đơn Vị Cấp" />
																<form:errors path="donViCap"
																	cssClass="invalid-feedback d-block" />
															</div>
															<div class="form-group col-sm-6">
																<label><spring:message code="label.noiCap" /></label>
																<form:input class="form-control" path="noiCap"
																	placeholder="Nơi Cấp" />
																<form:errors path="noiCap"
																	cssClass="invalid-feedback d-block" />
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label for="date1"><spring:message
																			code="label.ngayCap" /></label>
																	<fieldset class="form-group position-relative">
																		<form:input placeholder="Ngày Cấp" type="date"
																			class="form-control round" id="date1" path="ngayCap" />
																		<div class="form-control-position">
																			<i class="fa fa-calendar-o"></i>
																		</div>
																	</fieldset>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="form-actions center">
												<a
													href="<c:url value = "/quanlynhansutt/bang_cap/viewOneBangCap/${maNhanVien}"/>"
													class="btn btn-primary"><spring:message
														code="label.quaylai" /></a> <input class="btn btn-success"
													type="submit" value="Save" />
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