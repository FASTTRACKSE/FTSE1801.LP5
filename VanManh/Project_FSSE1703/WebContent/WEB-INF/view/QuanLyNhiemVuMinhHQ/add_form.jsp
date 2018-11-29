<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.themmoinhiemvu"/></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangchunhiemvu"/></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVuMinhHQ/" />'><spring:message code="label.danhsachnhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.themmoinhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<c:if test="${messageError ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<spring:message code="label.luuthatbainhiemvu"/>
				</div>
			</c:if>
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="CongViec"
						action="/ffse-fbms/QuanLyNhiemVuMinhHQ/create">
						<div class="form-group col-sm-6">
							<label><spring:message code="label.duannhiemvu"/></label>
							<form:errors style="color:red" path="duAn.maDuAn" />
							<form:select class="custom-select block round" path="duAn.maDuAn">
								<c:forEach items="${DuAn}" var="lb">
									<form:option value="${lb.maDuAn}" label="${lb.tenDuAn}"></form:option>
								</c:forEach>
							</form:select>

						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tencongviec"/></label>
							<form:input class="form-control block round" path="tenCongViec" />
							<form:errors path="tenCongViec" cssStyle="color: red"></form:errors>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.loaicongviecnhiemvu"/></label>
							<form:select class="custom-select block round"
								path="maCongViec.maCongViec">
								<c:forEach items="${LoaiCongViec}" var="cv">
									<form:option value="${cv.maCongViec}"
										label="${cv.loaiCongViec}"></form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.trangthainhiemvu"/></label>
							<form:hidden class="form-control block round"
								path="maTrangThai.maTrangThai" value="1" readonly="true" />
							<input class="form-control block round" value="Mới" readonly />
						</div>
						<div class="form-group col-sm-6">
							<div class="form-group col-sm-6">
								<label><spring:message code="label.tgbatdau"/></label>
								<fieldset class="form-group position-relative">
								<form:input class="form-control block round" type="date"
									path="tgBatDau"  id="from" onchange="myFunction()"/>
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
								<script>
									var today = new Date();
									var dd = today.getDate();
									var mm = today.getMonth() + 1; // January is 0!
									var yyyy = today.getFullYear();
									if (dd < 10) {
										dd = '0' + dd
									}
									if (mm < 10) {
										mm = '0' + mm
									}
									today = yyyy + '-' + mm + '-' + dd;
									document.getElementById("from")
											.setAttribute("min", today);
									document.getElementById('from').value = today;
									function myFunction() {
										var today = new Date(document
												.getElementById("from").value);
										var dd = today.getDate();
										var mm = today.getMonth() + 1; // January is 0!
										var yyyy = today.getFullYear();
										if (dd < 10) {
											dd = '0' + dd
										}
										if (mm < 10) {
											mm = '0' + mm
										}
										today = yyyy + '-' + mm + '-' + dd;
										document.getElementById("to")
												.setAttribute("min", today);
										document.getElementById('to').value = new Date(
												document.getElementById("from").value)
												.toISOString().substring(0, 10);
										var iWeeks, iDateDiff, iAdjust = 0;
										var dDate1 = new Date(document
												.getElementById("from").value);
										var dDate2 = new Date(document
												.getElementById("to").value);
										if (dDate2 < dDate1)
											return -1; // error code if dates transposed
										var iWeekday1 = dDate1.getDay(); // day of week
										var iWeekday2 = dDate2.getDay();
										iWeekday1 = (iWeekday1 == 0) ? 7
												: iWeekday1; // change Sunday from 0 to 7
										iWeekday2 = (iWeekday2 == 0) ? 7
												: iWeekday2;
										if ((iWeekday1 > 5) && (iWeekday2 > 5))
											iAdjust = 1; // adjustment if both days on weekend
										iWeekday1 = (iWeekday1 > 5) ? 5
												: iWeekday1; // only count weekdays
										iWeekday2 = (iWeekday2 > 5) ? 5
												: iWeekday2;
										// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
										iWeeks = Math
												.floor((dDate2.getTime() - dDate1
														.getTime()) / 604800000)
										if (iWeekday1 <= iWeekday2) {
											iDateDiff = (iWeeks * 5)
													+ (iWeekday2 - iWeekday1)
													+ 1
										} else {
											iDateDiff = ((iWeeks + 1) * 5)
													- (iWeekday1 - iWeekday2)
													+ 1
										}
										iDateDiff -= iAdjust
										document.getElementById("total").value = iDateDiff;
									}
								</script>
							</div>
							<div class="form-group col-sm-6">
								<label><spring:message code="label.tgketthuc"/></label>
								<fieldset class="form-group position-relative">
								<form:input class="form-control block round" type="date"
									path="tgKetThuc" id="to" onchange="count()"/>
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
								<script>
									var today = new Date();
									var dd = today.getDate();
									var mm = today.getMonth() + 1; // January is 0!
									var yyyy = today.getFullYear();
									if (dd < 10) {
										dd = '0' + dd
									}
									if (mm < 10) {
										mm = '0' + mm
									}
									today = yyyy + '-' + mm + '-' + dd;
									document.getElementById("to").setAttribute(
											"min", today);
									function count() {
										var iWeeks, iDateDiff, iAdjust = 0;
										var dDate1 = new Date(document
												.getElementById("from").value);
										var dDate2 = new Date(document
												.getElementById("to").value);
										if (dDate2 < dDate1)
											return -1; // error code if dates transposed
										var iWeekday1 = dDate1.getDay(); // day of week
										var iWeekday2 = dDate2.getDay();
										iWeekday1 = (iWeekday1 == 0) ? 7
												: iWeekday1; // change Sunday from 0 to 7
										iWeekday2 = (iWeekday2 == 0) ? 7
												: iWeekday2;
										if ((iWeekday1 > 5) && (iWeekday2 > 5))
											iAdjust = 1; // adjustment if both days on weekend
										iWeekday1 = (iWeekday1 > 5) ? 5
												: iWeekday1; // only count weekdays
										iWeekday2 = (iWeekday2 > 5) ? 5
												: iWeekday2;
										// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
										iWeeks = Math
												.floor((dDate2.getTime() - dDate1
														.getTime()) / 604800000)
										if (iWeekday1 <= iWeekday2) {
											iDateDiff = (iWeeks * 5)
													+ (iWeekday2 - iWeekday1)
													+ 1
										} else {
											iDateDiff = ((iWeeks + 1) * 5)
													- (iWeekday1 - iWeekday2)
													+ 1
										}
										iDateDiff -= iAdjust
										document.getElementById("total").value = iDateDiff;
									}
								</script>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.nguoiduocphancong"/></label>
							<form:select class="custom-select block round"
								path="phanCong.maNhanVien">
								<c:forEach items="${NhanVien}" var="nv">
									<form:option value="${nv.maNhanVien}"
										label="${nv.hoDem} ${nv.ten}"></form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message code="label.tgdukienhoanthanh"/></label>
							<div class="input-group">
								<form:input class="form-control block round" path="tgDuKien" />
								<span class="input-group-addon round"><spring:message code="label.gionhiemvu"/></span>
								<form:errors cssStyle="color:red" path="tgDuKien" />
							</div>
							
						</div>
						<div class="form-group col-sm-6" style="margin-top: -6.4rem">
							<label><spring:message code="label.motanhiemvu"/></label>
							<form:textarea class="form-control block round" path="moTa" />
							<form:errors cssStyle="color:red" path="moTa" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success round"><spring:message code="label.luunhiemvu"/></button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
window.setTimeout(function() {
	$(".alert").fadeTo(500, 0).slideUp(500, function() {
		$(this).remove();
	});	
}, 2500);
</script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
