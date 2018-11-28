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
					<c:if test="${empty danhGia}">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content">
										<div class="card-body" style="margin: 1em">
											<h2>Nhân viên này chưa đánh giá bản thân</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty danhGia }">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<form:form cssClass="form form-horizontal form-bordered"
												method="POST">
												<div class="form-body">
													<h4 class="form-section">
														<i class="ft-user"></i> Bản đánh giá
													</h4>
													<form:hidden path="id" />
													<form:hidden path="kyDanhGia.maKy" />
													<form:hidden path="phongBan.maPhongBan" />
													<form:hidden path="nhanVienDanhGia" />
													<form:hidden path="nhanVien.maNhanVien" />
													<div class="form-group row">
														<label class="col-md-3 label-control">Tên nhân
															viên</label>
														<div class="col-md-9">
															<h3>${danhGia.nhanVien.hoDem}
																${danhGia.nhanVien.ten}</h3>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control"> Kỷ luật
															công việc </label>
														<div class="col-md-9">
															<div class="col-md-2">
																<input class="form-control"
																	value="${danhGia.kyLuatCongViec_DG }"
																	readonly="readonly">
															</div>
															<div class="col-md-10">
																<textarea class="form-control" rows="3"
																	readonly="readonly">${danhGia.kyLuatCongViec_MT }</textarea>
																<label></label>
																<form:textarea rows="5" cssClass="form-control"
																	path="kyLuatCongViec"></form:textarea>
																<form:errors cssStyle="color:red;" path="kyLuatCongViec"></form:errors>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Tinh thần
															làm việc</label>
														<div class="col-md-9">
															<div class="col-md-2">
																<input class="form-control"
																	value="${danhGia.tinhThanLamViec_DG }"
																	readonly="readonly">
															</div>
															<div class="col-md-10">
																<textarea class="form-control" rows="3"
																	readonly="readonly">${danhGia.tinhThanLamViec_MT }</textarea>
																<label></label>
																<form:textarea rows="5" cssClass="form-control"
																	path="tinhThanLamViec"></form:textarea>
																<form:errors cssStyle="color:red;"
																	path="tinhThanLamViec"></form:errors>
															</div>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Khối lượng
															công việc đạt được</label>
														<div class="col-md-9">
															<div class="col-md-2">
																<input class="form-control"
																	value="${danhGia.khoiLuongCongViec_DG }"
																	readonly="readonly">
															</div>
															<div class="col-md-10">
																<textarea class="form-control" rows="3"
																	readonly="readonly">${danhGia.khoiLuongCongViec_MT }</textarea>
																<label></label>
																<form:textarea rows="5" cssClass="form-control"
																	path="khoiLuongCongViec"></form:textarea>
																<form:errors cssStyle="color:red;"
																	path="khoiLuongCongViec"></form:errors>
															</div>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kết quả công
															việc đạt được</label>
														<div class="col-md-9">
															<div class="col-md-2">
																<input class="form-control"
																	value="${danhGia.ketQuaCongViec_DG }"
																	readonly="readonly">
															</div>
															<div class="col-md-10">
																<textarea class="form-control" rows="3"
																	readonly="readonly">${danhGia.ketQuaCongViec_MT }</textarea>
																<label></label>
																<form:textarea rows="5" cssClass="form-control"
																	path="ketQuaCongViec"></form:textarea>
																<form:errors cssStyle="color:red;" path="ketQuaCongViec"></form:errors>
															</div>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kỹ năng tích
															lũy</label>
														<div class="col-md-9">
															<div class="col-md-2">
																<input class="form-control"
																	value="${danhGia.kyNangTichLuy_DG }"
																	readonly="readonly">
															</div>
															<div class="col-md-10">
																<textarea class="form-control" rows="3"
																	readonly="readonly">${danhGia.kyNangTichLuy_MT }</textarea>
																<label></label>
																<form:textarea readonly="readonly" rows="5"
																	cssClass="form-control" path="kyNangTichLuy"></form:textarea>
																<form:errors cssStyle="color:red;" path="kyNangTichLuy"></form:errors>
															</div>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Định hướng</label>
														<div class="col-md-9">
															<form:textarea cssClass="form-control" rows="5"
																path="dinhHuong"></form:textarea>
															<form:errors cssStyle="color:red;" path="dinhHuong"></form:errors>
														</div>
													</div>

													<div class="form-group last">
														<label class="col-md-3 label-control">Xếp loại</label>
														<div class="col-md-9">
															<form:select cssClass="form-control" path="xepLoai">
																<form:option value="0">Chọn xếp loại</form:option>
																<form:option value="1">1 Sao</form:option>
																<form:option value="2">2 Sao</form:option>
																<form:option value="3">3 Sao</form:option>
																<form:option value="4">4 Sao</form:option>
																<form:option value="5">5 Sao</form:option>
															</form:select>
															<form:errors cssStyle="color:red;" path="xepLoai"></form:errors>
														</div>
													</div>
												</div>
												<form:hidden path="isDelete" />
												<div class="form-actions">
													<a
														href="<c:url value="/quantridanhgia/nhanvien/danhgianhanvien"/>"
														class="btn btn-danger btn-min-width mr-1 mb-1">Trở về</a>
													<button type="submit"
														formaction="<c:url value="/quantridanhgia/danhgianhanvien/submit"/>"
														class="btn btn-info btn-min-width mr-1 mb-1">Đánh
														giá</button>
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</section>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>