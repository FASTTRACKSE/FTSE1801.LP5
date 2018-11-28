<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">Thêm mới Tài Liệu</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item"><a
									href='<c:url value="/TranDuc-QuanLyTaiLieu/TaiLieu/" />'>Danh
										sách Tài Liệu</a></li>
								<li class="breadcrumb-item active">Thêm mới Tài Liệu</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- End Path -->

			<div class="content-body">
				<div class="main-content">
					<div class="row">
						<form:form method="POST" modelAttribute="TaiLieu" action=""
							enctype="multipart/form-data">
							<form:input type="hidden" path="idTL" />
							<div class="form-group col-sm-6">
								<label>Mã Tài Liệu</label>
								<form:input class="form-control" path="maTL"
									placeholder="Mã Tài Liệu" />
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicSelect">Danh Mục</label>
									<form:select cssClass="form-control" path="danhMuc.maDM">
										<option title="DanhMuc"></option>
										<c:forEach var="item" items="${listDanhMuc}" begin="0" >
											<form:option value="${item.maDM}" label="${item.tenDM}"></form:option>
										</c:forEach>
									</form:select>
								</fieldset>
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicSelect">Phòng Ban</label>
									<form:select cssClass="form-control" path="phongBan.maPhongBan">
										<option></option>
										<c:forEach var="item" items="${listPhongBan}" begin="0">
											<form:option value="${item.maPhongBan }"
												label="${item.tenPhongBan }"></form:option>
										</c:forEach>
									</form:select>
								</fieldset>
							</div>
							<div class="form-group col-sm-6">
								<label>Mô Tả Tài Liệu</label>
								<form:input class="form-control" path="motaTL"
									placeholder="Mô Tả Tài Liệu" />
							</div>
							<div class="form-group col-sm-6">
								<form:hidden class="form-control" path="tenTL"
									placeholder="Tên Tài Liệu" />
							</div>
							<div class="form-group col-sm-6">
								<fieldset class="form-group">
									<label for="basicInputFile">Tài Liệu</label>
									<form:hidden path="link" />
									<input type="file" class="form-control-file"
										id="basicInputFile" name="file">
								</fieldset>
							</div>
							<center>
								<div class="col-sm-12 text-center">
									<button type="submit" class="btn btn-success"
										formaction="<%=request.getContextPath()%>/TranDuc-QuanLyTaiLieu/TaiLieu/submit">
										Submit Document</button>
									<button type="submit" class="btn btn-primary"
										formaction="<%=request.getContextPath()%>/TranDuc-QuanLyTaiLieu/TaiLieu/draft">
										Save Draft</button>
									<button type="submit" class="btn btn-danger"
										formaction="<%=request.getContextPath()%>/TranDuc-QuanLyTaiLieu/TaiLieu/cancel">
										Cancel</button>
								</div>
							</center>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>