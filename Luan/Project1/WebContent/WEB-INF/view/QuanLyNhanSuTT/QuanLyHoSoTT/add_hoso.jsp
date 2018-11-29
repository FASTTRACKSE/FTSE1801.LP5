<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.themNhanVien" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangChu" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/ho_so/" />'><spring:message code="label.danhSachNhanVien" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.themNhanVien" /></li>
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
								<h4 class="card-title" id="horz-layout-basic"><spring:message code="label.gioiThieu" /></h4>
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
									<form:form method="POST" action="insert"
										modelAttribute="formHoso" enctype="multipart/form-data">
										<div class="form-body">
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label><spring:message code="label.tenNhanVien" /></label>
															<form:input class="form-control" path="tenNhanVien"
																placeholder="tên nhân viên" />
															<form:errors path="tenNhanVien"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label><spring:message code="label.ngaySinh" /></label>
															<form:input class="form-control" path="namSinh"
																placeholder="năm sinh" />
															<form:errors path="namSinh"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>
													<div class="row">
													  <div class="form-group col-sm-6">
															<div class="form-group">
																<label><spring:message code="label.gioiTinh" /></label>
																<form:select class="custom-select form-control"
																	path="gioiTinh">
																	<option value="none"><spring:message code="label.chonGioiTinh" /></option>
																	<form:option value="1"><spring:message code="label.nam" /></form:option>
																	<form:option value="2"><spring:message code="label.nu" /></form:option>
																</form:select>
																<form:errors path="gioiTinh"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
														<div class="form-group col-sm-6">
															<label for="projectinput2"><spring:message code="label.tinhTrangHonNhan" /></label>
															<form:select path="tinhTrangHonNhan.maTinhTrangHonNhan" type="text"
																id="projectinput2" class="form-control">
																<option value="none" selected="selected"><spring:message code="label.chonTinhTrang" /></option>
																<c:forEach items="${listTrangTrangHonNhan}" var="x">
																	<option value="${x.maTinhTrangHonNhan}">${x.tinhTrangHonNhan}</option>
																</c:forEach>
															</form:select>
															<form:errors path="tinhTrangHonNhan.maTinhTrangHonNhan"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>

													<div class="row">
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="projectinput4"><spring:message code="label.soCMND" /></label>
																<form:input path="soCmnd" type="text" id="projectinput4"
																	class="form-control" placeholder="Số CMND" />
																	<form:errors path="soCmnd"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
														<div class="form-group col-sm-6">

															<label for="projectinput4"><spring:message code="label.noiCap" /></label>
															<form:input path="noiCap" type="text" id="projectinput4"
																class="form-control" placeholder="Nơi cấp" />
																<form:errors path="noiCap"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label for="projectinput4"><spring:message code="label.ngayCap" /></label>
															<fieldset class="form-group position-relative">
																<form:input placeholder="Ngày cấp" type="date"
																		class="form-control round" path="ngayCap" />
																	<div class="form-control-position">
																		<i class="fa fa-calendar-o"></i>
																	</div>
															</fieldset>
															<form:errors path="ngayCap"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="projectinput4"><spring:message code="label.danToc" /></label>
																<form:select path="danToc.maDanToc" type="text"
																	id="projectinput4" class="form-control">
																	<option value="none" selected="selected">Chọn
																		dân tộc</option>
																	<c:forEach items="${listDanToc}" var="x">
																		<option value="${x.maDanToc}">${x.tenDanToc}</option>
																	</c:forEach>
																</form:select>
																<form:errors path="danToc.maDanToc"
																	cssClass="invalid-feedback d-block" />
															</div>
														</div>
													</div>


													<div class="row">
														<div class="form-group col-sm-6">

															<label for="projectinput4"><spring:message code="label.quocTich" /></label>
															<form:select path="quocTich.maQuocTich" type="text"
																id="projectinput4" class="form-control">
																<option value="none" selected="selected"><spring:message code="label.chonQuocTich" /></option>
																<c:forEach items="${listQuocTich}" var="x">
																	<option value="${x.maQuocTich}">${x.tenQuocTich}</option>
																</c:forEach>
															</form:select>
																<form:errors path="quocTich.maQuocTich"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>
												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-user"> <spring:message code="label.thongTinLienHe" /></i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label><spring:message code="label.sdt" /></label>
															<form:input class="form-control" path="soDienThoai"
																placeholder="số điện thoại" />
																<form:errors path="soDienThoai"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label>Email</label>
															<form:input class="form-control" path="email"
																placeholder="Email" />
																<form:errors path="email"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label><spring:message code="label.thanhPho" /></label>
															<form:select path="thanhPho.maThanhPho" type="text" id="thanhPhoId"
																class="form-control" onchange="clickComboboxThanhPho()">
																<option value="noThanhPho" selected="selected"><spring:message code="label.chonThanhPho" /></option>
																<c:forEach items="${listThanhPho}" var="x">
																	<option value="${x.maThanhPho}">${x.tenThanhPho}</option>
																</c:forEach>
															</form:select>
															<form:errors path="thanhPho.maThanhPho"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label><spring:message code="label.quanHuyen" /></label>
															<form:select path="quanHuyen.maQuanHuyen" id="quanHuyenId"
																type="text" class="form-control" disabled="true"
																onchange="clickComboboxQuan()" name="quanHuyen">
																<option value="noQuanHuyen" selected="selected"><spring:message code="label.chonQuanHuyen" /></option>
															</form:select>
																<form:errors path="quanHuyen.maQuanHuyen"
																	cssClass="invalid-feedback d-block" />
														</div>

													</div>
													<div class="row">

														<div class="form-group col-sm-6">
															<label><spring:message code="label.phuongXa" /></label>

															<form:select path="xaPhuong.maXa" type="text" id="phuongXaId"
																class="form-control" name="phuongXaSelect"
																disabled="true">
																<option value="noPhuongXa" selected="selected"><spring:message code="label.chonPhuongXa" /></option>

															</form:select>
															<form:errors path="xaPhuong.maXa"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label><spring:message code="label.diaChi" /></label>
															<form:input class="form-control" path="diaChi"
																placeholder="địa chỉ" />
																<form:errors path="diaChi"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>


												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-user"><spring:message code="label.thongTinKhac" /> </i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label><spring:message code="label.phongBan" /></label>
															<form:select path="phongBan.maPhongBan" type="text" id="companyName"
																class="form-control" name="phongBanSelect">
																<option value="none" selected><spring:message code="label.chonPhongBan" /></option>
																<c:forEach items="${listPhongBan}" var="x">
																	<option value="${x.maPhongBan}">${x.tenPhongBan}</option>
																</c:forEach>
															</form:select>
															<form:errors path="phongBan.maPhongBan"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label><spring:message code="label.chucDanh" /></label>
															<form:select path="chucDanh.maChucDanh" type="text"
																id="companyName" class="form-control"
																placeholder="Company Name" name="chucDanhSelect">
																<option value="none" selected="selected"><spring:message code="label.chonChucDanh" /></option>
																<c:forEach items="${listChucDanh}" var="x">
																	<option value="${x.maChucDanh}">${x.tenChucDanh}</option>
																</c:forEach>
															</form:select>
															<form:errors path="chucDanh.maChucDanh"
																	cssClass="invalid-feedback d-block" />
														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label for="location1"><spring:message code="label.trangThai" /></label>
															<form:select class="custom-select form-control"
																path="trangThai">
																<option value="none" selected="selected"><spring:message code="label.chonTrangThai" /></option>
																<form:option value="1"><spring:message code="label.dangLamViec" /></form:option>
																<form:option value="2"><spring:message code="label.daNghiViec" /></form:option>
															</form:select>
															<form:errors path="trangThai"
																	cssClass="invalid-feedback d-block" />
														</div>
														<div class="form-group col-sm-6">
															<label>Avatar:</label> <input id="imgUrl"
																class="form-control" type="file" name="file" /> <br>
															<img id="img" src="#" alt="your image" width="100"
																height="150" />
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="form-actions center">
											<input class="btn btn-success" type="submit" value="Save" />
											<%-- <a href="<c:url value = "/quanlynhansutt/add"/>"
												class="btn btn-primary">Back</a>
 											--%>
										</div>
									</form:form>
									<script type="text/javascript">
										window.onload = function() {

											console.log("aaa");
										}
										function clickComboboxThanhPho() {
											var maThanhPho = $("#thanhPhoId")
													.val();

											if (maThanhPho == 'noThanhPho') { // nếu người dùng chưa chọn thành phố

												$('#quanHuyenId option')
														.remove();
												$('#quanHuyenId')
														.append(
																$(
																		'<option>',
																		{
																			value : 'noQuanHuyen',
																			text : 'Chọn Quận Huyện'
																		}));

												$('#quanHuyenId').prop(
														'disabled', true); /*disable combobox quận huyện */

											} else { // nếu người dùng đã chọn thành phố

												$('#quanHuyenId').prop(
														'disabled', false); /*enable combobox quận huyện */
												$('#quanHuyenId option')
														.remove(); /* xóa những option quận huyện cũ */
											}

											$
													.ajax({
														url : "/ffse-fbms/quanlynhansutt/ho_so/selectquan/"
																+ maThanhPho,
														dataType : "json",
														success : function(data) {
															/* alert("Hello! I am an alert box!"); */
															$('#quanHuyenId')
																	.append(
																			$(
																					'<option>',
																					{
																						value : 'noQuanHuyen',
																						text : 'Chọn Quận Huyện'
																					}));

															for (var i = 0; i < data.length; i++) {
																$(
																		'#quanHuyenId')
																		.append(
																				$(
																						'<option>',
																						{
																							value : data[i].maQuanHuyen,
																							text : data[i].tenQuanHuyen
																						}));
															}

														}
													});
										};
									</script>

									<script type="text/javascript">
									<!-- ajax select QuanHuyen -->
										function clickComboboxQuan() {
											var maQuanHuyen = $("#quanHuyenId")
													.val();
											if (maQuanHuyen == 'noQuanHuyen') { /* nếu người dùng chưa chọn quận huyện */
												$('#phuongXaId').prop(
														'disabled', true); /*disable combobox phường xã */

											} else { /* nếu người dùng đã chọn quận huyện*/

												$('#phuongXaId').prop(
														'disabled', false); // enable combobox phường xã
												$('#phuongXaId option')
														.remove(); // xóa những option phường xã cũ
											}

											$
													.ajax({
														url : "/ffse-fbms/quanlynhansutt/ho_so/selectphuong/"
																+ maQuanHuyen,
														dataType : "json",
														success : function(data) {
															/* alert("Hello! I am an alert box!"); */

															$('#phuongXaId')
																	.append(
																			$(
																					'<option>',
																					{
																						value : 'noPhuongXa',
																						text : 'Chọn phường xã'
																					}));

															for (var i = 0; i < data.length; i++) {
																$('#phuongXaId')
																		.append(
																				$(
																						'<option>',
																						{
																							value : data[i].maXa,
																							text : data[i].tenXa
																						}));
															}

														}
													});
										};
									</script>
									
									<!-- preview image -->  
                     <script type="text/javascript">
						function readURL(input) {
						if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
						$('#img').attr('src', e.target.result);
						}
						reader.readAsDataURL(input.files[0]);
						}
						}
						$("#imgUrl").change(function() {
						readURL(this);
						});
					</script>
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