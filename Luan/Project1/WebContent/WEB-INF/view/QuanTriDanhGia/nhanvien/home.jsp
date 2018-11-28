<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="row">
			<div class="col-xl-4 col-lg-6 col-xs-12">
				<div class="card">
					<div class="card-body">
						<div class="media">
							<div
								class="p-2 text-xs-center bg-primary bg-darken-2 media-left media-middle">
								<i class="icon-user font-large-2 white"></i>
							</div>
							<div class="p-2 bg-gradient-x-primary white media-body">
								<h5>Tổng số người đánh giá</h5>
								<h5 class="text-bold-400"></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-4 col-lg-6 col-xs-12">
				<div class="card">
					<div class="card-body">
						<div class="media">
							<div
								class="p-2 text-xs-center bg-warning bg-darken-2 media-left media-middle">
								<i class="icon-trophy font-large-2 white"></i>
							</div>
							<div class="p-2 bg-gradient-x-warning white media-body">
								<h5>Xếp loại trung bình</h5>
								<h5 class="text-bold-400"></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-4 col-lg-6 col-xs-12">
				<div class="card">
					<div class="card-body">
						<div class="media">
							<div
								class="p-2 text-xs-center bg-success bg-darken-2 media-left media-middle">
								<i class="icon-trophy font-large-2 white"></i>
							</div>
							<div class="p-2 bg-gradient-x-success white media-body">
								<h5>Xếp loại từ trưởng phòng</h5>
								<h5 class="text-bold-400"></h5>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>