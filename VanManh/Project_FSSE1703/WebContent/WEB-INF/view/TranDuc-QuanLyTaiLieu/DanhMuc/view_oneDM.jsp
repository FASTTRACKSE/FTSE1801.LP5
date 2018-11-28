<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<h3 class="content-header-title mb-0">Thông Tin Danh Mục</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item"><a
									href='<c:url value="/TranDuc-QuanLyTaiLieu/DanhMuc/" />'>Danh
										sách danh mục</a></li>
								<li class="breadcrumb-item active">Thông Tin Danh Mục</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- End Path -->
			<div class="content-body">
				<div class="main-content">
					<div class="row">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Thông Tin Danh Mục</h4>
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
									<div class="table-responsive">
										<table class="table">
											<tr>
												<td><label>Mã Danh Mục</label> <input
													class="form-control" value="${DanhMuc.maDM}" readonly /></td>
												<td><label>Tên Danh Mục</label> <input
													class="form-control" value="${DanhMuc.tenDM}" readonly /></td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>