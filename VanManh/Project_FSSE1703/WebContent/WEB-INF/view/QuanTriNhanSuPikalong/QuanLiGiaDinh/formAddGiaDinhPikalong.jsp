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
				<h3 class="content-header-title mb-0"><spring:message code="label.themGiaDinh" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/quantrinhansu/hosonhanvien/" />'><spring:message code="label.danhSachNhanVien" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quantrinhansu/hosonhanvien/view/${maNv }" />'><spring:message code="label.thongTinCaNhan" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/${maNv}" />'><spring:message code="label.thongTinGiaDinh" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.themGiaDinh" /></li>
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
											action="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiGiaDinh/saveOneGiaDinh"
											class="form-horizontal">
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.maNhanVien" /></label>
													<form:input path="maNV" type="text"
														class="form-control round" readonly="true" />
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.quanHe" /></label>
													<form:select path="quanHe" class="form-control round">
														<form:option value=""><spring:message code="label.chonQuanHe" /></form:option>
														<form:option value="Bố">Bố</form:option>
														<form:option value="Mẹ">Mẹ</form:option>
														<form:option value="Anh">Anh</form:option>
														<form:option value="Chị">Chị</form:option>
														<form:option value="Em">Em</form:option>
														<form:option value="Vợ">Vợ</form:option>
													</form:select>
													<form:errors path="quanHe"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.hoTen" /></label>
													<form:input path="hoTen" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="hoTen"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.queQuan" /></label>
													<form:input path="queQuan" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="queQuan"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.noiOHienNay" /></label>
													<form:input path="noiOHienNay" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="noiOHienNay"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.ngheNghiep" /></label>
													<form:input path="ngheNghiep" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="ngheNghiep"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText"><spring:message code="label.sdt" /></label>
													<form:input path="sdt" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="sdt" cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-12 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<input class="btn btn-outline-success round" type="submit"
														value="<spring:message code="label.luu" />" /> <a
														class="btn btn-outline-danger round"
														href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/${maNv}"><spring:message
															code="label.huy" /></a>
													<p style="color: red">${messageQuanHe}</p>
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