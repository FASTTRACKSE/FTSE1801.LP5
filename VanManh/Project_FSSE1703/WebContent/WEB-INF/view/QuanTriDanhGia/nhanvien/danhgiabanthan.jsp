<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<c:if test="${empty danhGia}">
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="btn-group float-md-right" id="add-new">
						<a href="<c:url value = "/quantridanhgia/danhgiabanthan/add"/>"
							class="btn btn-primary"><span class="fa fa-plus"></span> Tạo</a>
					</div>
				</div>
			</c:if>
			<div class="content-body">
				<!-- Basic form layout section start -->
				<section id="basic-form-layouts">
					<c:if test="${empty danhGia}">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content">
										<div class="card-body" style="margin: 1em">
											<h2>Bạn chưa có bản đánh giá bản thân</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty danhGia}">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<form:form cssClass="form form-horizontal form-bordered">
												<div class="form-body">
													<h4 class="form-section">
														<i class="ft-user"></i> Bản tự đánh giá
													</h4>
													<div class="form-group row">
														<label class="col-md-3 label-control">Kỷ luật công
															việc</label>
														<div class="col-md-9">
															<p>${danhGia.kyLuatCongViec_DG }</p>
															<p>${danhGia.kyLuatCongViec_MT }</p>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Tinh thần
															làm việc</label>
														<div class="col-md-9">
															<p>${danhGia.tinhThanLamViec_DG }</p>
															<p>${danhGia.tinhThanLamViec_MT }</p>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Khối lượng
															công việc đạt được</label>
														<div class="col-md-9">
															<p>${danhGia.khoiLuongCongViec_DG }</p>
															<p>${danhGia.khoiLuongCongViec_MT }</p>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Kết quả công
															việc đạt được</label>
														<div class="col-md-9">
															<p>${danhGia.ketQuaCongViec_DG }</p>
															<p>${danhGia.ketQuaCongViec_MT }</p>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Kỹ năng tích
															lũy</label>
														<div class="col-md-9">
															<p>${danhGia.kyNangTichLuy_DG }</p>
															<p>${danhGia.kyNangTichLuy_MT }</p>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Định hướng</label>
														<div class="col-md-9">
															<p>${danhGia.dinhHuong }</p>
														</div>
													</div>
													<div class="form-group last">
														<label class="col-md-3 label-control">Đánh giá
															tổng thể</label>
														<div class="col-md-9">
															<p>${danhGia.danhGiaTongThe }</p>
														</div>
													</div>
												</div>
											</form:form>
											<c:if
												test="${danhGia.trangThai.maTrangThai == 1 || danhGia.trangThai.maTrangThai == 4}">
												<div class="form-actions">
													<a
														href="<c:url value="/quantridanhgia/danhgiabanthan/edit"/>"
														class="btn btn-success">Cập nhật</a>
												</div>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</section>
				<!-- // Basic form layout section end -->
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>