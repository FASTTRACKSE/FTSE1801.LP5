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
					<strong>Danh Sách Programing Language</strong>
				</h1>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Mã Ngôn Ngữ</th>
						<th>Tên Ngôn Ngữ</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="nn" items="${list}">
						<tr>
							<td>${nn.maNn}</td>
							<td>${nn.tenNn}</td>

							<td><a href="/ffse-fbms/QuanLyDuAn/Language/edit/${nn.maNn}"
								data-toggle="tooltip" title="edit">
									<button type="button" class="btn btn-icon btn-outline-warning">
										<i class="fa fa-pencil"></i>
									</button>
							</a> <a href="/ffse-fbms/QuanLyDuAn/Language/delete/${nn.maNn}">
									<button type="button"
										onclick="if (!confirm('Are you sure you want to delete this database?')) return false"
										class="btn btn-outline-danger btn-icon checkid"
										data-toggle="modal" title="delete" data-target="#danger">
										<i class="fa fa-trash-o"></i>
									</button>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="?page=1">First
							Page</a></li>
					<c:if test="${currentPage > 2}">
						<li class="page-item"><a class="page-link"
							href="?page=${currentPage-2}">${currentPage-2}</a></li>
					</c:if>
					<c:if test="${currentPage > 1}">
						<li class="page-item"><a class="page-link"
							href="?page=${currentPage-1}">${currentPage-1}</a></li>
					</c:if>
					<li class="page-item active"><a class="page-link"
						href="?page=${currentPage}">${currentPage}</a></li>
					<c:if test="${currentPage < lastPage}">
						<li class="page-item"><a class="page-link"
							href="?page=${currentPage+1}">${currentPage+1}</a></li>
					</c:if>
					<c:if test="${currentPage < lastPage - 1}">
						<li class="page-item"><a class="page-link"
							href="?page=${currentPage+2}">${currentPage+2}</a></li>
					</c:if>
					<li class="page-item"><a class="page-link"
						href="?page=${lastPage }">Last Page</a></li>
				</ul>
			</nav>

			<div class="row"></div>
		</div>
		<div class="col-sm-4">
			<h5>
				<a href="/ffse-fbms/QuanLyDuAn/Language/add"><strong>Thêm
						Ngôn Ngữ</strong></a>
			</h5>
			<c:if test="${message !=null }">
						 ${message }
			</c:if>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />