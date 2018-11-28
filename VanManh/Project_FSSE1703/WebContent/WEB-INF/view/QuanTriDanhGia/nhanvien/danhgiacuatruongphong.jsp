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
				<div class="content-body">
					<!-- Basic form layout section start -->
					<section id="basic-form-layouts">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<h2>Chưa có đánh giá nào từ trưởng phòng</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</c:if>
			<c:if test="${not empty danhGia}">
				<div class="content-body">
					<!-- Basic form layout section start -->
					<section id="basic-form-layouts">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<form:form cssClass="form form-horizontal form-bordered">
												<div class="form-body">
													<h4 class="form-section">
														<i class="ft-user"></i>Đánh giá từ trưởng phòng
													</h4>
													<div class="form-group row">
														<label class="col-md-3 label-control">Kỷ luật công
															việc</label>
														<div class="col-md-9">
															<p>${danhGia.kyLuatCongViec }</p>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Tinh thần
															làm việc</label>
														<div class="col-md-9">
															<p>${danhGia.tinhThanLamViec }</p>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Khối lượng
															công việc đạt được</label>
														<div class="col-md-9">
															<p>${danhGia.khoiLuongCongViec }</p>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kết quả công
															việc đạt được</label>
														<div class="col-md-9">
															<p>${danhGia.ketQuaCongViec }</p>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kỹ năng tích
															lũy</label>
														<div class="col-md-9">
															<p>${danhGia.kyNangTichLuy }</p>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Định hướng</label>
														<div class="col-md-9">
															<p>${danhGia.nhanXet }</p>
														</div>
													</div>

													<div class="form-group last">
														<label class="col-md-3 label-control">Xếp loại</label>
														<div class="col-md-9">
															<p>${danhGia.xepLoai }</p>
														</div>
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
			</c:if>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>