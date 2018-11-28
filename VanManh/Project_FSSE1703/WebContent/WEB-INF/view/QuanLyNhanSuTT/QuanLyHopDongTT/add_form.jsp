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
					<spring:message code="label.themHopDong" />
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
								href='<c:url value="/quanlynhansutt/hop_dong/" />'><spring:message
										code="label.danhSachHopDong" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="label.themHopDong" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<!-- Basic Elements start -->
			<section id="horizontal-form-layouts">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="horz-layout-basic">
									<spring:message code="label.thongTinCoBan" />
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
									<form:form method="POST"
										action="/ffse-fbms/quanlynhansutt/hop_dong/save"
										modelAttribute="hopDongTT">
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
														<div class="col-md-6">
															<div class="form-group">
																<label><spring:message code="label.trangThai" /></label>
																<div style="word-wrap: break-word;"
																	class="form-control well">
																	<c:if test="${hosonv.trangThai == 1 }">
																		<spring:message code="label.dangLamViec" />
																	</c:if>
																	<c:if test="${hosonv.trangThai == 2 }">
																		<spring:message code="label.daNghiViec" />
																	</c:if>
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="form-group">
																<label><spring:message code="label.maChucDanh" /></label>
																<input placeholder="Mã nhân viên" class="form-control"
																	value="${hosonv.phongBan.maPhongBan}"
																	name="phongBan.maPhongBan" readonly="readonly"
																	type="text">
															</div>
														</div> 
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label><spring:message code="label.maChucDanh" /></label>
															<div class="form-control well">${hosonv.chucDanh.maChucDanh}</div>
														</div>
														<div class="form-group col-sm-6">
															<label><spring:message code="label.tenHopDong" /></label>
															<form:select path="loaiHopDong.maLoaiHopDong" type="text"
																id="companyName" class="form-control"
																name="loaiHopDongSelect">
																<option value="none"><spring:message
																		code="label.chonHopDong" /></option>
																<c:forEach items="${listLoaiHopDong}" var="x">
																	<option value="${x.maLoaiHopDong}">${x.tenHopDong}</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-user"><spring:message
														code="label.thongTinHopDong" /></i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label><spring:message code="label.luongThang13" /></label>
																<form:select class="custom-select form-control"
																	path="luongThang13">
																	<option value="none"><spring:message
																			code="label.chonLuongThang13" /></option>
																	<form:option value="1">
																		<spring:message code="label.co" />
																	</form:option>
																	<form:option value="2">
																		<spring:message code="label.khong" />
																	</form:option>
																</form:select>
															</div>
														</div>
														<div class="form-group col-sm-6">
															<label><spring:message code="label.soNgayPhep" /></label>
															<form:input class="form-control" path="soNgayPhep"
																placeholder="Số Ngày Phép" />
															<form:errors path="soNgayPhep"
																cssClass="invalid-feedback d-block" />
														</div>

													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="date1"><spring:message
																		code="label.ngayKy" /></label>
																<fieldset class="form-group position-relative">
																	<form:input placeholder="Ngày Ký" type="date"
																		class="form-control round" path="ngayKy" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>
																</fieldset>
																<form:errors path="ngayKy"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="date1"><spring:message
																		code="label.hopDongTuNgay" /></label>
																<fieldset class="form-group position-relative">
																	<form:input placeholder="Hợp Đồng Từ Ngày" type="date"
																		class="form-control round" path="hopDongTuNgay" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>
																	<form:errors path="hopDongTuNgay"
																		cssClass="invalid-feedback d-block" />
																</fieldset>

															</div>
														</div>
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="date1"><spring:message
																		code="label.hopDongDenNgay" /></label>
																<fieldset class="form-group position-relative">
																	<form:input placeholder="Hợp Đồng Đến Ngày" type="date"
																		class="form-control round" path="hopDongDenNgay" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>

																</fieldset>
																<form:errors path="hopDongDenNgay"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="location1"><spring:message
																		code="label.trangThai" /></label>
																<form:select class="custom-select form-control"
																	path="trangThai">
																	<form:option value="1">
																		<spring:message code="label.conHopDong" />
																	</form:option>
																	<form:option value="2">
																		<spring:message code="label.hetHopDong" />
																	</form:option>
																</form:select>

															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-actions center">
											<p style="color: red">${messageQuanHe}</p>
											<a
												href="<c:url value = "/quanlynhansutt/hop_dong/viewOneHopDong/${maNhanVien}"/>"
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
			</section>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />