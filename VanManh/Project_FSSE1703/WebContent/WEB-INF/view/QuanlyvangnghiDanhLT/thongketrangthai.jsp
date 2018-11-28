<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
		<div>
		<div class="col-md-5"></div>
			<h3 ><spring:message code="label.danhsachtrangthai"/></h3>
		</div>
			
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th ><spring:message code="label.matrangthai"/></th>
					<th ><spring:message code="label.tentrangthai"/></th>
					<th >Số Đơn</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="tl" items="${thongketrangthai}" varStatus="stt">
					<tr>
					<td>${tl.id}</td>
					<td>${tl.trangThai}</td>
					<td>${count.get(stt.count-1)}</td>
					</tr>
				</c:forEach>
				</tbody>
		</table>
		</div>
		</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />