<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>Xem Nghiệp Vụ</strong>
				</h1>
			</div>
		</div>
			<div class="form-group col-sm-6"> 
				<label>Mã Nghiệp Vụ</label>
				<p>${domain.maNghiepVu}</p>
			</div>
			<div class="form-group col-sm-6">
				<label>Tên Nghiệp Vụ</label>
				<p>${domain.tenNghiepVu}</p>
			</div>
			
			
			<div class="col-sm-12 text-center">
				<a class="btn btn-primary" href='<c:url value="/qlda/domain/list" ></c:url>' >Trở về</a>
			</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
