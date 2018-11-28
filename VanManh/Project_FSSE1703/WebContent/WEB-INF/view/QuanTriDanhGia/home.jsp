<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.dash-board-item {
	margin-bottom: 50px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row"></div>
		<div class="content-body">
			<!-- Stats -->
			<div class="row">
				<div class="col-xl-3 col-lg-6 col-xs-12">
					<div class="card">
						<div class="card-body">
							<div class="media">
								<div
									class="p-2 text-xs-center bg-primary bg-darken-2 media-left media-middle">
									<i class="icon-layers font-large-2 white"></i>
								</div>
								<div class="p-2 bg-gradient-x-primary white media-body">
									<h5>Đánh giá bản thân</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-lg-6 col-xs-12">
					<div class="card">
						<div class="card-body">
							<div class="media">
								<div
									class="p-2 text-xs-center bg-danger bg-darken-2 media-left media-middle">
									<i class="icon-user font-large-2 white"></i>
								</div>
								<div class="p-2 bg-gradient-x-danger white media-body">
									<h5>Đánh giá nhân viên</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-lg-6 col-xs-12">
					<div class="card">
						<div class="card-body">
							<div class="media">
								<div
									class="p-2 text-xs-center bg-warning bg-darken-2 media-left media-middle">
									<i class="icon-user-follow font-large-2 white"></i>
								</div>
								<div class="p-2 bg-gradient-x-warning white media-body">
									<h5>Nhân viên đánh giá</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-lg-6 col-xs-12">
					<div class="card">
						<div class="card-body">
							<div class="media">
								<div
									class="p-2 text-xs-center bg-success bg-darken-2 media-left media-middle">
									<i class="icon-wallet font-large-2 white"></i>
								</div>
								<div class="p-2 bg-gradient-x-success white media-body">
									<h5>Trưởng phòng đánh giá</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/ Stats -->
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />

<script
	src="<c:url value="/resources/vendors/js/charts/raphael-min.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/vendors/js/charts/morris.min.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/vendors/js/extensions/unslider-min.js"/>"
	type="text/javascript"></script>
<script
	src="<c:url value="/resources/vendors/js/timeline/horizontal-timeline.js"/>"
	type="text/javascript"></script>

<script
	src="<c:url value="/resources/js/scripts/pages/dashboard-ecommerce.js"/>"
	type="text/javascript"></script>
