<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message
										code="label.suaHopDong" /></h3>
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
										code="label.suaHopDong" /></li>
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
										<form:form method="POST" modelAttribute="hopDongTT"
											action="/ffse-fbms/quanlynhansutt/hop_dong/save">
											<div class="form-body">
												<div class="row">
													<div class="col-md-8">
														<div class="row">
															<div class="form-group col-sm-6">
																<label><spring:message code="label.maHopDong" /></label>
																<form:input class="form-control" readonly="true"
																	path="maHopDong" placeholder="Mã Hợp Đồng" />
															</div>
															<div class="form-group col-sm-6">
																<label><spring:message code="label.maNhanVien" /></label>
																<form:input class="form-control" readonly="true"
																	path="hoSoNhanVienTT.maNhanVien"
																	placeholder="Mã Nhân Viên" />
															</div>
														</div>
														<div class="row">
															<div class="form-group col-sm-6">
																<label><spring:message code="label.tenHopDong" /></label>
																<form:select path="loaiHopDong.maLoaiHopDong"
																	type="text" id="companyName" class="form-control"
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
																	<label><spring:message
																			code="label.luongThang13" /></label>
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
															</div>
														</div>
														<div class="row">
															<div class="col-md-6">
																<div class="form-group">
																	<label><spring:message code="label.ngayKy" /></label>
																	<fieldset class="form-group position-relative">
																		<form:input type="date" class="form-control round"
																			id="from" path="ngayKy" />
																		<div class="form-control-position">
																			<i class="fa fa-calendar-o"></i>
																		</div>
																	</fieldset>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label><spring:message code="label.hopDongTuNgay" /></label>
																	<fieldset class="form-group position-relative">
																		<form:input type="date" class="form-control round"
																			id="from" path="hopDongTuNgay" />
																		<div class="form-control-position">
																			<i class="fa fa-calendar-o"></i>
																		</div>
																	</fieldset>
																</div>
															</div>
															<div class="col-md-6">
																<div class="form-group">
																	<label><spring:message code="label.hopDongDenNgay" /></label>
																	<fieldset class="form-group position-relative">
																		<form:input type="date" class="form-control round"
																			id="from" path="hopDongDenNgay" />
																		<div class="form-control-position">
																			<i class="fa fa-calendar-o"></i>
																		</div>
																	</fieldset>
																</div>
															</div>
															<div class="col-md-6">
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
												<a
													href="<c:url value = "/quanlynhansutt/hop_dong/viewOneHopDong/${maNhanVien}"/>"
													class="btn btn-primary"><spring:message code="label.quaylai" /></a> <input
													class="btn btn-success" type="submit" value="Save" />
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