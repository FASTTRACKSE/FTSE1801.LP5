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
											<form:hidden path="id" />
											<form:hidden path="kyDanhGia.maKy" />
											<form:hidden path="phongBan.maPhongBan" />
											<form:hidden path="nhanVien.maNhanVien" />
											<div class="form-body">
												<h4 class="form-section">
													<i class="ft-user"></i> Bản tự đánh giá
												</h4>
												<div class="form-group row">
													<label class="col-md-3 label-control"> Kỷ luật công
														việc </label>
													<div class="col-md-9">
														<div class="col-md-2">
															<form:select cssClass="form-control"
																path="kyLuatCongViec_DG">
																<form:option value="0">Chọn xếp loại</form:option>
																<form:option value="1">1 Sao</form:option>
																<form:option value="2">2 Sao</form:option>
																<form:option value="3">3 Sao</form:option>
																<form:option value="4">4 Sao</form:option>
																<form:option value="5">5 Sao</form:option>
															</form:select>
															<form:errors cssStyle="color:red;"
																path="kyLuatCongViec_DG"></form:errors>
														</div>
														<div class="col-md-10">
															<form:textarea rows="5" cssClass="form-control"
																path="kyLuatCongViec_MT" />
															<form:errors cssStyle="color:red;"
																path="kyLuatCongViec_MT"></form:errors>
														</div>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-md-3 label-control">Tinh thần làm
														việc</label>
													<div class="col-md-9">
														<div class="col-md-2">
															<form:select cssClass="form-control"
																path="tinhThanLamViec_DG">
																<form:option value="0">Chọn xếp loại</form:option>
																<form:option value="1">1 Sao</form:option>
																<form:option value="2">2 Sao</form:option>
																<form:option value="3">3 Sao</form:option>
																<form:option value="4">4 Sao</form:option>
																<form:option value="5">5 Sao</form:option>
															</form:select>
															<form:errors cssStyle="color:red;"
																path="tinhThanLamViec_DG"></form:errors>
														</div>

														<div class="col-md-10">
															<form:textarea rows="5" cssClass="form-control"
																path="tinhThanLamViec_MT" />
															<form:errors cssStyle="color:red;"
																path="tinhThanLamViec_MT"></form:errors>
														</div>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Khối lượng
														công việc đạt được</label>
													<div class="col-md-9">
														<div class="col-md-2">
															<form:select cssClass="form-control"
																path="khoiLuongCongViec_DG">
																<form:option value="0">Chọn xếp loại</form:option>
																<form:option value="1">1 Sao</form:option>
																<form:option value="2">2 Sao</form:option>
																<form:option value="3">3 Sao</form:option>
																<form:option value="4">4 Sao</form:option>
																<form:option value="5">5 Sao</form:option>
															</form:select>
															<form:errors cssStyle="color:red;"
																path="khoiLuongCongViec_DG"></form:errors>
														</div>
														<div class="col-md-10">
															<form:textarea rows="5" cssClass="form-control"
																path="khoiLuongCongViec_MT" />
															<form:errors cssStyle="color:red;"
																path="khoiLuongCongViec_MT"></form:errors>
														</div>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Kết quả công
														việc đạt được</label>
													<div class="col-md-9">
														<div class="col-md-2">
															<form:select cssClass="form-control"
																path="ketQuaCongViec_DG">
																<form:option value="0">Chọn xếp loại</form:option>
																<form:option value="1">1 Sao</form:option>
																<form:option value="2">2 Sao</form:option>
																<form:option value="3">3 Sao</form:option>
																<form:option value="4">4 Sao</form:option>
																<form:option value="5">5 Sao</form:option>
															</form:select>
															<form:errors cssStyle="color:red;"
																path="ketQuaCongViec_DG"></form:errors>
														</div>
														<div class="col-md-10">
															<form:textarea rows="5" cssClass="form-control"
																path="ketQuaCongViec_MT" />
															<form:errors cssStyle="color:red;"
																path="ketQuaCongViec_MT"></form:errors>
														</div>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Kỹ năng tích
														lũy</label>
													<div class="col-md-9">
														<div class="col-md-2">
															<form:select cssClass="form-control"
																path="kyNangTichLuy_DG">
																<form:option value="0">Chọn xếp loại</form:option>
																<form:option value="1">1 Sao</form:option>
																<form:option value="2">2 Sao</form:option>
																<form:option value="3">3 Sao</form:option>
																<form:option value="4">4 Sao</form:option>
																<form:option value="5">5 Sao</form:option>
															</form:select>
															<form:errors cssStyle="color:red;"
																path="kyNangTichLuy_DG"></form:errors>
														</div>
														<div class="col-md-10">
															<form:textarea rows="5" cssClass="form-control"
																path="kyNangTichLuy_MT" />
															<form:errors cssStyle="color:red;"
																path="kyNangTichLuy_MT"></form:errors>
														</div>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Định hướng</label>
													<div class="col-md-9">
														<form:textarea cssClass="form-control" rows="5"
															path="dinhHuong" />
														<form:errors cssStyle="color:red;" path="dinhHuong"></form:errors>
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Đánh giá tổng
														thể</label>
													<div class="col-md-9">
														<form:select cssClass="form-control" path="danhGiaTongThe">
															<form:option value="0">Chọn xếp loại</form:option>
															<form:option value="1">1 Sao</form:option>
															<form:option value="2">2 Sao</form:option>
															<form:option value="3">3 Sao</form:option>
															<form:option value="4">4 Sao</form:option>
															<form:option value="5">5 Sao</form:option>
														</form:select>
														<form:errors cssStyle="color:red;" path="danhGiaTongThe"></form:errors>
													</div>
												</div>
												<div class="form-group last">
													<label class="col-md-3 label-control">Trạng thái</label>
													<div class="col-md-9">
														<form:select cssClass="form-control"
															path="trangThai.maTrangThai">
															<form:option value="1">Nháp</form:option>
															<form:option value="2">Nộp</form:option>
														</form:select>
													</div>
												</div>
											</div>
											<div class="form-actions">
												<a href="<c:url value="/quantridanhgia/danhgiabanthan/"/>"
													class="btn btn-danger btn-min-width mr-1 mb-1">Trở về</a>
												<button type="submit"
													formaction="<c:url value="/quantridanhgia/danhgiabanthan/submit"/>"
													class="btn btn-success btn-min-width mr-1 mb-1">Tạo</button>
											</div>
											<form:hidden path="isDelete" />
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