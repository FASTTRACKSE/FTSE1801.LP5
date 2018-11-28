<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid"
	style="background-color: #AAAAAA; font-weight: bold; color: white">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.newDuAn" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a href="/ffse-fbms/qlda/DuAn/"><spring:message code="label.listDA" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.newDuAn" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">

			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong><spring:message code="label.newDuAn" /></strong>

				</h1>

			</div>
		</div>
		<div class="row" style="background-color: #DDDDDD; color: white">
			<div class="col-xs-12">
				<div class="card">
					<div class="card-header" style="background-color: #DDDDDD;">


						<div class="heading-elements">
							<ul class="list-inline mb-0">
								<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
								<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
								<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
								<li><a data-action="close"><i class="ft-x"></i></a></li>
							</ul>
						</div>
					</div>
					<form:form method="POST" action="/ffse-fbms/qlda/DuAn/creat"
						modelAttribute="duAn">
						<div class="form-group col-sm-6">

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <label><spring:message code="label.maDuAn" /></label>
							<form:errors path="maDuAn" cssStyle="color: red"></form:errors>

							<form:input class="form-control" path="maDuAn"
								placeholder="Mã dự án" />
						</div>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenDuAn" /></label>
							<form:errors path="tenDuAn" cssStyle="color: red"></form:errors>

							<form:input class="form-control" path="tenDuAn"
								placeholder="Tên dự án" />
						</div>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.moTaDuAn" /></label>
							<form:errors path="moTaDuAn" cssStyle="color: red"></form:errors>

							<form:textarea path="moTaDuAn" cssClass="form-control"
								style="height:calc(2.95rem - 2px);" placeholder="Mô Tả dự án" />
						</div>
						<c:set var="khang" value="${duAn.khachHang.makh }"></c:set>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenKhachHang" /></label>
							<form:errors path="khachHang" cssStyle="color: red"></form:errors>

							<form:select path="khachHang.makh" cssClass="form-control"
								mutiple="mutiple">
								<form:option selected="selected" value="" disabled="true"></form:option>
								<c:forEach items="${khachhang}" var="kh">
									<form:option value="${kh.makh }">${kh.tenkh}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenTechnical" /></label>
							<form:select path="technical" cssClass="form-control"
								mutiple="true">
								<c:forEach items="${technical}" var="tc">
									<option value="${tc.ma_cong_nghe }">${tc.ten_cong_nghe}</option>
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenDatabase" /></label>
							<form:select multiple="true" cssClass="form-control"
								path="database">
								<c:forEach items="${database}" var="db">
									<option value="${db.maDatabase}">${db.tenDatabase}</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenFramework" /></label>
							<form:select path="framework" cssClass="form-control"
								mutiple="mutiple">
								<c:forEach items="${framework}" var="fw">
									<option value="${fw.ma_framework }">${fw.ten_framework}</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.ngonNgu" /></label>
							<form:select path="ngonNgu" cssClass="form-control"
								mutiple="true">

								<c:forEach items="${ngonNgu}" var="vd">
									<option value="${vd.maNn }">${vd.tenNn }</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenVendor" /></label>
							<form:select path="vendor" cssClass="form-control" mutiple="true"
								style="height:calc(2.95rem - 2px);">

								<c:forEach items="${vendor}" var="vd">
									<option value="${vd.mavd }">${vd.tenvd }</option>
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.NghiepVu" /></label>
							<form:errors path="domain" cssStyle="color: red"></form:errors>

							<form:select path="domain.maNghiepVu" cssClass="form-control">
								<form:option selected="selected" value="" disabled="true"></form:option>
								<c:forEach items="${domain}" var="domain">
									<option value="${domain.maNghiepVu}">${domain.tenNghiepVu}</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.phongDuAn" /></label>
							<form:errors path="phongBan" cssStyle="color: red"></form:errors>
							<form:select path="phongBan.maPhongBan" cssClass="form-control"
								mutiple="true" onchange="clickComboboxPhongBan()"
								id="phongBanId">
								<form:option value="" selected="selected" disabled="true"></form:option>
								<c:forEach items="${phongBan}" var="pb">
									<option value="${pb.maPhongBan}">${pb.tenPhongBan}</option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">

							<label>PM</label>
							<form:select path="pM.maNhanVien" cssClass="form-control"
								mutiple="true" id="pMId">
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.ngayBatDau" /></label>
							<form:errors path="startDate" cssStyle="color: red"></form:errors>

							<form:input path="startDate" cssClass="form-control"
								style="height:calc(2.95rem - 2px);" type="date" />
							<div class="help-block"></div>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.ngayKetThuc" /></label>
							<form:errors path="endDate" cssStyle="color: red"></form:errors>

							<form:input path="endDate" cssClass="form-control" type="date"
								style="height:calc(2.95rem - 2px);" />
							<div class="help-block"></div>
						</div>
						<div class="form-group col-sm-12">
							<form:hidden path="trangThai.maTrangThai" value="TT01" />

							<label><spring:message code="label.trangThai" /></label>
							<form:select path="trangThai" cssClass="form-control"
								mutiple="true" disabled="true">
								<c:forEach items="${trangThai}" var="tt">
									<option value="${tt.maTrangThai }">${tt.tenTrangThai}</option>
								</c:forEach>
								<form:errors path="TrangThai" cssStyle="color: red"></form:errors>
							</form:select>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success"><spring:message code="label.luu" /></button>
						</div>
					</form:form>
					<div class="col-sm-4">
						<c:if test="${message !=null }">
						 ${message}
			</c:if>
					</div>
					<!-- ajax select QuanHuyen -->

					<script type="text/javascript">
						function clickComboboxPhongBan() {
							var phongBan = $("#phongBanId").val();
							if (phongBan == 'phongBan') { // nếu người dùng chưa chọn 

								$('#pMId option').remove();

								$('#pMId').prop('disabled', true); /*disable combobox */

							} else { // nếu người dùng đã chọn thành phố

								$('#pMId').prop('disabled', false); /*enable combobox  */
								$('#pMId option').remove(); /* xóa những option  cũ */
							}
							$.ajax({
								url : "/ffse-fbms/qlda/DuAn/selectPhongBan/"
										+ phongBan,
								dataType : "json",
								success : function(data) {
									for (var i = 0; i < data.length; i++) {
										$('#pMId').append($('<option>', {
											value : data[i].maPhongBan,
											text : data[i].tenPM
										}));
									}
								}
							});
						};
					</script>


				</div>
			</div>
		</div>

	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
