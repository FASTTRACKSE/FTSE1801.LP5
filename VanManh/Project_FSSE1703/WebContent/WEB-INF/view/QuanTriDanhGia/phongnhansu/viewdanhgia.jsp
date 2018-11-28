<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-body">
				<!-- Basic form layout section start -->
				<section id="basic-form-layouts">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-content collpase show">
									<div class="card-body" style="margin: 1em">
										<form:form cssClass="form form-horizontal form-bordered"
											method="POST">
											<div class="form-body">
												<h4 class="form-section">
													<i class="ft-user"></i> Nội dung đánh giá
												</h4>
												<div class="form-group row">
													<label class="col-md-3 label-control">Nhân viên</label>
													<div class="col-md-9">
														<h3>
															<label>${command.nhanVien.maNhanVien}</label>
														</h3>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-md-3 label-control">Kỷ luật công
														việc</label>
													<div class="col-md-9">
														<div class="row">
															<form:label path="kyLuatCongViec_DG"></form:label>
															<form:label path="kyLuatCongViec_MT"></form:label>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-md-3 label-control">Tinh thần làm
														việc</label>
													<div class="col-md-9">
														<form:label path="tinhThanLamViec_DG"></form:label>
														<form:label path="tinhThanLamViec_MT"></form:label>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Khối lượng
														công việc đạt được</label>
													<div class="col-md-9">
														<form:label path="khoiLuongCongViec_DG"></form:label>
														<form:label path="khoiLuongCongViec_MT"></form:label>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Kết quả công
														việc đạt được</label>
													<div class="col-md-9">
														<form:label path="ketQuaCongViec_DG"></form:label>
														<form:label path="ketQuaCongViec_MT"></form:label>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Kỹ năng tích
														lũy</label>
													<div class="col-md-9">
														<form:label path="kyNangTichLuy_DG"></form:label>
														<form:label path="kyNangTichLuy_MT"></form:label>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Định hướng</label>
													<div class="col-md-9">
														<form:label path="dinhHuong"></form:label>
													</div>
												</div>

												<div class="form-group last">
													<label class="col-md-3 label-control">Đánh giá tổng
														thể</label>
													<div class="col-md-9">
														<form:label path="danhGiaTongThe"></form:label>
													</div>
												</div>
												<div class="form-actions">
													<a href="<c:url value="/quantridanhgia/phongnhasu/home/"/>"
														class="btn btn-danger btn-min-width mr-1 mb-1">Trở về</a>
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
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>