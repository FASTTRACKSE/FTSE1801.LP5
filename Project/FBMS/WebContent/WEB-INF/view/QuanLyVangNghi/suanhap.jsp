<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="content-body">
			<div class="main-content">
				<h1>
					<a href='<c:url value="/QuanLyVangNghi/danhsachnhap" />'><i
						class="icon-arrow-left"></i></a>
				</h1>
				<form:form method="POST" modelAttribute="suadon">
					<div class="row">
						<div>
							<form:hidden class="form-control round" path="idDonXinPhep" readonly="true"
								value="" />
							<form:hidden path="maNhanVien.soNgayDaNghi" />
							<form:hidden path="maNhanVien.soNgayConLai" />
						</div>
						<br>
						<div>
							<label>Mã Nhân Viên</label>
							<form:select multiple="single" path="maNhanVien.idNhanVien"
								class="custom-select block round">
								<form:options items="${hoso}" itemValue="maNhanVien"
									itemLabel="maNhanVien" />
							</form:select>
						</div>
						<br>
						<div>
							<label>Họ Và Tên</label>
							<form:select multiple="single" path="maNhanVien.idNhanVien.hoDem"
								class="custom-select block round">
								<c:forEach items="${hoso}" var="ld">
									<form:option value="${ld.hoDem}" label="${ld.hoDem}" />
								</c:forEach>
							</form:select>
						</div>
						<br>
						<div>
							<label>Phòng Ban</label>
							<form:select multiple="single" path="maPhongBan.maPhongBan"
								class="custom-select block round">
								<c:forEach items="${phongban}" var="ld">
									<form:option value="${ld.maPhongBan}"
										label="${ld.maPhongBan}" />
								</c:forEach>
							</form:select>
						</div>
						<br>
						<div>
							<label>Lý Do</label>
							<form:select path="maLoaiNghi.maLoaiNghi" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${lydo}" var="ld">
									<form:option value="${ld.id}" label="${ld.lyDo}" />
								</c:forEach>
							</form:select>
						</div>
						<br>
						<div>

							<label>Ngày Bắt Đầu</label>
							<fieldset class="form-group position-relative">
								<form:errors style="color:red" path="thoiGianBatDau" />
								<form:input type="date" class="form-control round" id="from"
									onchange="myFunction()" path="thoiGianBatDau" />
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
								document.getElementById("from").setAttribute(
										"min", today);
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
									document.getElementById("to").setAttribute(
											"min", today);
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
									iWeekday1 = (iWeekday1 > 5) ? 5 : iWeekday1; // only count weekdays
									iWeekday2 = (iWeekday2 > 5) ? 5 : iWeekday2;
									// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
									iWeeks = Math
											.floor((dDate2.getTime() - dDate1
													.getTime()) / 604800000)
									if (iWeekday1 <= iWeekday2) {
										iDateDiff = (iWeeks * 5)
												+ (iWeekday2 - iWeekday1) + 1
									} else {
										iDateDiff = ((iWeeks + 1) * 5)
												- (iWeekday1 - iWeekday2) + 1
									}
									iDateDiff -= iAdjust
									document.getElementById("total").value = iDateDiff;
								}
							</script>
						</div>

						<br>
						<div>
							<label>Ngày Kết Thúc</label>
							<fieldset class="form-group position-relative">
								<form:errors style="color:red" path="thoiGianKetThuc" />
								<form:input type="date" class="form-control round" id="to"
									onchange="count()" path="thoiGianKetThuc" />
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
									iWeekday1 = (iWeekday1 > 5) ? 5 : iWeekday1; // only count weekdays
									iWeekday2 = (iWeekday2 > 5) ? 5 : iWeekday2;
									// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
									iWeeks = Math
											.floor((dDate2.getTime() - dDate1
													.getTime()) / 604800000)
									if (iWeekday1 <= iWeekday2) {
										iDateDiff = (iWeeks * 5)
												+ (iWeekday2 - iWeekday1) + 1
									} else {
										iDateDiff = ((iWeeks + 1) * 5)
												- (iWeekday1 - iWeekday2) + 1
									}
									iDateDiff -= iAdjust
									document.getElementById("total").value = iDateDiff;
								}
							</script>
						</div>
						<br>
						<div>
							<label>Số Ngày Nghỉ</label>
							<form:input type="text" class="form-control round" id="total"
								readonly="true" path="soNgayNghi" />
							<form:errors style="color:red" path="soNgayNghi" />
						</div>

						<br>
						<div>
							<label>Ghi Chú</label>
							<form:input class="form-control round" placeholder="ghiChu"
								path="ghiChu" />
							<form:errors path="ghiChu" cssStyle="color: red"></form:errors>
						</div>
						<br>
					</div>
					<br>
					<div>
						<br>
					</div>

					<div class="col-md-2">
						<button type="submit"
							class="btn btn-outline-danger round  mr-1 mb-1"
							formaction="<%=request.getContextPath()%>/QuanLyVangNghi/trove/nhap">
							Hủy
						</button>
					</div>
					<div class="col-md-4">
						<div class="col-md-2">
							<button type="submit"
								class="btn btn-outline-success round  mr-1 mb-1"
								formaction="<%=request.getContextPath()%>/QuanLyVangNghi/taodonmoi/choduyet">
								Gửi
							</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />