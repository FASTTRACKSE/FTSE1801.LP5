<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<link rel="shortcut icon" href="<c:url value="/resources/cv/favicon.ico"/>">  
    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500,400italic,300italic,300,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- FontAwesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js" integrity="sha384-3LK/3kTpDE/Pkp8gTNp2gR/2gOiwQ6QaO7Td0zV76UFJVhqLl4Vl3KL1We6q6wR9" crossorigin="anonymous"></script>
    <!-- Global CSS -->
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/cv/css/orbit-1.css"/>">   
    <!-- Theme CSS -->  

<div class="app-content content container-fluid">
	<div class="content-wrapper">
	  <div class="wrapper">
        <div class="sidebar-wrapper">
            <div class="profile-container">
                <img class="profile" src="<c:url value="/uploads/${hoSoNhanVien.avatar}" />" width="150" height="180" alt="" />
                <h1 class="name">${hoSoNhanVien.hoTenNv}</h1>
                <h2 class="tagline">${hoSoNhanVien.maPhongBan.tenPhongBan}</h2>
                <h6 class="tagline">${hoSoNhanVien.maChucDanh.tenChucDanh}</h6>
            </div><!--//profile-container-->
            
            <div class="education-container container-block">
                <h2 class="container-block-title">Education</h2>
                <div class="item">
                    <h4 class="degree">MSc in Computer Science</h4>
                    <h5 class="meta">University of London</h5>
                    <div class="time">2011 - 2012</div>
                </div><!--//item-->
                <div class="item">
                    <h4 class="degree">BSc in Applied Mathematics</h4>
                    <h5 class="meta">Bristol University</h5>
                    <div class="time">2007 - 2011</div>
                </div><!--//item-->
            </div><!--//education-container-->
            
            <div class="languages-container container-block">
                <h2 class="container-block-title">Languages</h2>
                <ul class="list-unstyled interests-list">
                    <li>English <span class="lang-desc">(Native)</span></li>
                    <li>French <span class="lang-desc">(Professional)</span></li>
                    <li>Spanish <span class="lang-desc">(Professional)</span></li>
                </ul>
            </div><!--//interests-->
            
            <div class="interests-container container-block">
                <h2 class="container-block-title">Interests</h2>
                <ul class="list-unstyled interests-list">
                    <li>Climbing</li>
                    <li>Snowboarding</li>
                    <li>Cooking</li>
                </ul>
            </div><!--//interests-->
            
        </div><!--//sidebar-wrapper-->
        
        <div class="main-wrapper">
            
            <section class="section summary-section">
                <h2 class="section-title"><span class="icon-holder"><i class="fas fa-user"></i></span>Thông Tin Chi Chi tiết</h2>
                <div class="summary">
                  <div class="table-responsive">
					<table class="table mb-0">
					<tr>
						<td><h6>Mã Nhân Viên:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.maNv}</td>
					</tr>
					<tr>
						<td><h6>Giới Tính:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.gioiTinh}</td>
					</tr>
					<tr>
						<td><h6>Ngày Sinh:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.ngaySinh}</td>
					</tr>
					<tr>
						<td><h6>Quốc Tịch:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.quocTich}</td>
					</tr>
					
					<tr>
						<td><h6>Dân Tộc:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.danToc}</td>
					</tr>
					<tr>
						<td><h6>Quê Quán:</h6></td>
						<td style="text-align: right">phường xã: ${hoSoNhanVien.phuongXa.tenPhuong}, quận huyện: ${hoSoNhanVien.quanHuyen.tenQuanHuyen}, tỉnh thành: ${hoSoNhanVien.thanhPho.tenTinhThanh}</td>
					</tr>
					<tr>
						<td><h6>Nơi Ở Hiện Nay:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.noiOHienNay}</td>
					</tr>
					<tr>
					<tr>
						<td><h6>Số Điện Thoại:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.sDT}</td>
					</tr>
					<tr>
						<td><h6>email:</h6></td>
						<td style="text-align: right">${hoSoNhanVien.email}</td>
					</tr>
					<tr>
					<tr>
						<td><h6>Tình Trạng Hôn Nhân:</h6></td>
							<c:if test = "${hoSoNhanVien.tinhTrangHonNhan == 0}">
         						<td style="text-align: right">Chưa Kết Hôn</td>
     						 </c:if>
     						 <c:if test = "${hoSoNhanVien.tinhTrangHonNhan == 1}">
         						<td style="text-align: right">Đã Kết Hôn</td>
     						 </c:if>							
					</tr>
					<tr>
								<td><h6>Số CMND:</h6></td>
								<td style="text-align: right">${hoSoNhanVien.cMND}</td>
							</tr>
							<tr>
								<td><h6>Nơi Cấp:</h6></td>
								<td style="text-align: right">${hoSoNhanVien.noiCap}</td>
							</tr>
							<tr>
								<td><h6>Ngày Cấp:</h6></td>
								<td style="text-align: right">${hoSoNhanVien.ngayCap}</td>
							</tr>
					
					</table>
				  </div>
                </div><!--//summary-->
            </section><!--//section-->
            
            <section class="section experiences-section">
                <h2 class="section-title"><span class="icon-holder"><i class="fas fa-briefcase"></i></span>Thông Tin Gia Đình</h2>
                <c:forEach items="${thongTinGiaDinh}" var="x" varStatus="stt">
                	<div class="table-responsive">
						<table class="table mb-0">
							<tr>
								<td><h6>Họ và Tên:</h6></td>
								<td style="text-align: right">${x.hoTen}</td>
							</tr>
							<tr>
								<td><h6>Quan Hệ:</h6></td>
								<td style="text-align: right">${x.quanHe}</td>
							</tr>
							<tr>
								<td><h6>Nghề Nghiệp:</h6></td>
								<td style="text-align: right">${x.ngheNghiep}</td>
							</tr>
							<tr>
								<td><h6>Số Điện Thoại:</h6></td>
								<td style="text-align: right">${x.sdt}</td>
							</tr>
							<tr>
								<td><h6>Nơi Ở Hiện Nay:</h6></td>
								<td style="text-align: right">${x.noiOHienNay}</td>
							</tr>
							<tr>
								<td><h6>Quê Quán:</h6></td>
								<td style="text-align: right">${x.queQuan}</td>
							</tr>
							
						</table>
					</div>
                </c:forEach>
                
            </section><!--//section-->

            <section class="section projects-section">
                <h2 class="section-title"><span class="icon-holder"><i class="fas fa-archive"></i></span>Thông Tin Bằng Cấp</h2>
                            	<c:forEach items="${thongTinBangCap}" var="x" varStatus="stt">
                	<div class="table-responsive">
						<table class="table mb-0">
							<tr>
								<td><h6>Chuyên Ngành:</h6></td>
								<td style="text-align: right">${x.chuyenNganh}</td>
							</tr>
							<tr>
								<td><h6>Nơi Cấp:</h6></td>
								<td style="text-align: right">${x.noiCap}</td>
							</tr>
							<tr>
								<td><h6>Ngày Cấp:</h6></td>
								<td style="text-align: right">${x.ngayCap}</td>
							</tr>
							<tr>
								<td><h6>Xếp Loại:</h6></td>
								<td style="text-align: right">${x.xepLoai}</td>
							</tr>
							
						</table>
					</div>
                </c:forEach>
            </section><!--//section-->
            
            <section class="section projects-section">
                <h2 class="section-title"><span class="icon-holder"><i class="fa fa-align-left"></i></span>Kinh Nghiệm Dự Án</h2>
                            	<c:forEach items="${kinhNghiem}" var="x" varStatus="stt">
                	<div class="table-responsive">
						<table class="table mb-0">
							<tr>
								<td><h6>Tên dự án:</h6></td>
								<td style="text-align: right">${x.projects.nameProject}</td>
							</tr>
							<tr>
								<td><h6>Vai trò:</h6></td>
								<td style="text-align: right">${x.roles.nameRoles}</td>
							</tr>
						</table>
					</div>
                </c:forEach>
            </section><!--//section-->
            		 <a href="/ffse-fbms/quantrinhansu/hosonhanvien/exportexcel/${hoSoNhanVien.maNv}"><button class="btn btn-success">
										<i class="fa fa-download"></i> Tải xuống
										</button></a> <!-- export file excel button -->
					<a href="/ffse-fbms/quantrinhansu/hosonhanvien/view/${hoSoNhanVien.maNv}"><button type="button" class="btn btn-warning mr-1">
                          <i class="ft-x"></i> Trở về
                        </button></a>
        </div><!--//main-body-->
       	
    </div>
 		
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
