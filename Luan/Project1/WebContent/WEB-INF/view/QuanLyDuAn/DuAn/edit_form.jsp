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
				<h3 class="content-header-title mb-0"><spring:message code="label.suaDuAn" /></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a href="/ffse-fbms/qlda/DuAn/"><spring:message code="label.listDA" /></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.suaDuAn" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">

			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong><spring:message code="label.suaDuAn" /></strong>

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
					<form:form method="POST" action="/ffse-fbms/qlda/DuAn/update"
						modelAttribute="duAn">
						<div class="form-group col-sm-6">

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <label><spring:message code="label.maDuAn" /></label>
							<form:errors path="maDuAn" cssStyle="color: red"></form:errors>
							<form:input class="form-control" path="maDuAn"
								placeholder="Mã dự án" readonly="true" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenKhachHang" /></label>
							<form:hidden path="khachHang.makh" />
							<form:input path="khachHang.tenkh" class="form-control"
								readonly="true"  />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenDuAn" /></label>
							<form:errors path="tenDuAn" cssStyle="color: red"></form:errors>

							<form:input class="form-control" path="tenDuAn"
								placeholder="Tên dự án" style="height:36px"/>
						</div>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.moTaDuAn" /></label>
							<form:errors path="moTaDuAn" cssStyle="color: red"></form:errors>

							<form:textarea path="moTaDuAn" cssClass="form-control"
								style="height:calc(2.95rem - 2px);" placeholder="Mô Tả dự án" />
						</div>

						<c:set var="tc" value="${duAn.technical }"></c:set>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenTechnical" /></label>
							<form:select path="technical" cssClass="form-control"
								mutiple="true">

								<c:forEach items="${technical}" var="tc1">
									<option value="${tc1.ma_cong_nghe}"
										<c:forEach items="${tc}" var="tc2">
										<c:if test="${tc1.ma_cong_nghe==tc2.ma_cong_nghe}"> selected="selected"</c:if>
										</c:forEach>>${tc1.ten_cong_nghe}
									</option>
								</c:forEach>
							</form:select>
						</div>
						<c:set var="dt" value="${duAn.database}"></c:set>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenDatabase" /></label>
							<form:errors path="database" cssStyle="color: red"></form:errors>

							<form:select multiple="true" cssClass="form-control"
								path="database">

								<c:forEach items="${database}" var="dt1">
									<option value="${dt1.maDatabase}"
										<c:forEach items="${dt}" var="dt2">
										<c:if test="${dt1.maDatabase==dt2.maDatabase}"> selected="selected"</c:if>
										</c:forEach>>${dt1.tenDatabase}
									</option>
								</c:forEach>
							</form:select>
						</div>
						<c:set var="fw" value="${duAn.framework}"></c:set>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenFramework" /></label>
							<form:errors path="ngonNgu" cssStyle="color: red"></form:errors>

							<form:select path="framework" cssClass="form-control"
								mutiple="mutiple">

								<c:forEach items="${framework}" var="fw1">
									<option value="${fw1.ma_framework}"
										<c:forEach items="${fw}" var="fw2">
										<c:if test="${fw1.ma_framework==fw2.ma_framework}"> selected="selected"</c:if>
										</c:forEach>>${fw1.ten_framework}
									</option>
								</c:forEach>
							</form:select>
						</div>
						<c:set var="nn" value="${duAn.ngonNgu}"></c:set>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.ngonNgu" /></label>
							<form:errors path="ngonNgu" cssStyle="color: red"></form:errors>

							<form:select path="ngonNgu" cssClass="form-control"
								mutiple="true">

								<c:forEach items="${ngonNgu}" var="nn1">
									<option value="${nn1.maNn}"
										<c:forEach items="${nn}" var="nn2">
										<c:if test="${nn2.maNn==nn1.maNn}"> selected="selected"</c:if>
										</c:forEach>>${nn1.tenNn}
									</option>
								</c:forEach>

							</form:select>
						</div>
						<c:set var="dt" value="${duAn.vendor}"></c:set>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tenVendor" /></label>

							<form:select path="vendor" cssClass="form-control" mutiple="true"
								style="height:calc(2.95rem - 2px);">
								<c:forEach items="${vendor}" var="vd1">
									<option value="${vd1.mavd }"
										<c:forEach items="${dt}" var="vd2">
											<c:if test="${vd1.mavd==vd2.mavd}"> selected="selected"</c:if>
										</c:forEach>>${vd1.tenvd}
									</option>
								</c:forEach>

							</form:select>
						</div>
						<c:set var="nvu" value="${duAn.domain.maNghiepVu }"></c:set>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.NghiepVu" /></label>

							<form:select path="domain" cssClass="form-control">
								<c:forEach items="${domain}" var="domain">
									<option value="${domain.maNghiepVu}"
										<c:if test="${domain.maNghiepVu ==nvu }" >selected="selected"</c:if>>${domain.tenNghiepVu}</option>
								</c:forEach>
							</form:select>
						</div>
						<c:set var="pb" value="${duAn.phongBan}"></c:set>

						<div class="form-group col-sm-6">
							<label><spring:message code="label.phongDuAn" /></label>
							<form:errors path="phongBan" cssStyle="color: red"></form:errors>
							<form:select path="phongBan.maPhongBan" cssClass="form-control"
								mutiple="true" onchange="clickComboboxPhongBan()"
								id="phongBanId">


								<%-- <c:forEach items="${phongBan}" var="pb1">
									<option value="${pb1.maPhongBan}"
										>${pb1.tenPhongBan}</option>
								</c:forEach> --%>
								<form:options items="${phongBan}" itemValue="maPhongBan"
									itemLabel="tenPhongBan" />
							</form:select>
						</div>
						<div class="form-group col-sm-6">

							<label>PM</label>
							<form:select path="pM.maNhanVien" cssClass="form-control"
								mutiple="true" id="pMId">
								<c:forEach items="${pms}" var="pms">
									<option value="${pms.maNhanVien}"
										<c:if test="${pms.maNhanVien == duAn.pM.maNhanVien }" >selected="selected"</c:if>
										>${pms.hoDem} ${pms.ten}</option>
								</c:forEach>
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
						<c:set var="tt" value="${duAn.trangThai.maTrangThai}"></c:set>

						<div class="form-group col-sm-12">
							<form:hidden path="trangThai.maTrangThai" />
							<label><spring:message code="label.trangThai" /></label>
							<form:select path="trangThai" cssClass="form-control"
								mutiple="true">
								<form:errors path="trangThai" cssStyle="color: red"></form:errors>

								<c:forEach items="${trangThai}" var="tt">
									<option value="${tt.maTrangThai }"
										<c:if test="${tt.maTrangThai ==tt}" >selected="selected"</c:if>>${tt.tenTrangThai}</option>
								</c:forEach>

							</form:select>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success"><spring:message code="label.sua" /></button>
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
