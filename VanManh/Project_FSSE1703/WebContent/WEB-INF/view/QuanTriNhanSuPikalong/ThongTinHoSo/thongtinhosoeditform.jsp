<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<!-- Header -->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
	
	<h3 class="content-header-title mb-0">Sửa Nhân Viên</h3> <!-- title -->
	
                    <form:form class="form" method="POST" action="/ffse-fbms/quantrinhansu/hosonhanvien/update" modelAttribute="formHosopkl"  enctype="multipart/form-data">
                      <div class="form-body">
                        <h4 class="form-section"><i class="ft-user"></i>Thông tin cơ bản</h4>
<div class="row"> <!-- div row 1 -->
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput1">Mã nhân viên</label>
                              <form:input path="maNv" type="number" id="projectinput1" class="form-control" placeholder="Mã nhân viên"
                              name="maNhanVienInput" readonly="true"/>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Họ tên</label>
                              <form:input path="hoTenNv" type="text" id="projectinput2" class="form-control" placeholder="Họ tên"
                              name="hoTenInput" />
                               <form:errors path="hoTenNv" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          </div> <!-- /div row 1 -->
                          
                          <div class="row"><!-- /div row 2 -->
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Email</label>
                              <form:input path="email" type="text" id="projectinput2" class="form-control" placeholder="Email"
                              name="emailInput" />
                               <form:errors path="email" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Tình trạng hôn nhân</label>
                              <form:select path="tinhTrangHonNhan" type="text" id="projectinput2" class="form-control"
                              name="tinhTrangHonNhanRadio">
                              		<form:option value="" selected="selected" >Chọn tình trạng hôn nhân</form:option>
                              		<form:option value="0" >Chưa kết hôn</form:option>
                              		<form:option value="1" >Đã kết hôn</form:option>
                              </form:select>
                              <form:errors path="tinhTrangHonNhan" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                        </div> <!-- /div row 2 -->
                        
                        <div class="row"> <!-- div row 3 -->
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput3">Giới tính</label>
                              <form:select path="gioiTinh" type="text" id="projectinput3" class="form-control" placeholder="Giới tính" name="gioiTinhRadio">
                              		<form:option value="" selected="selected" >Chọn giới tính</form:option>
                              		<form:option value="Nam" >Nam</form:option>
                              		<form:option value="Nữ" >Nữ</form:option>
                              </form:select>
                              <form:errors path="gioiTinh" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Ngày sinh</label>
                              <form:input path="ngaySinh" type="date" id="projectinput4" class="form-control" placeholder="Ngày sinh" name="ngaySinhInput" />
                               <form:errors path="ngaySinh" cssStyle="color: red" /> <!-- validate error mess-->
                            </div>
                          </div>
                          </div> <!-- /div row 3 -->
                          
                          <div class="row"> <!-- div row 4 -->
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Số điện thoại</label>
                              <form:input path="sDT" type="number" id="projectinput4" class="form-control" placeholder="Số điện thoại" name="soDienThoaiInput" />
                              <form:errors path="sDT" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Số CMND</label>
                              <form:input path="cMND" type="number" id="projectinput4" class="form-control" placeholder="Số CMND" name="soCMNDInput" />
                              <form:errors path="cMND" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          </div><!-- /div row 4 -->
                          
                          <div class="row"> <!-- div row 5 -->
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Nơi cấp</label>
                              <form:input path="noiCap" type="text" id="projectinput4" class="form-control" placeholder="Nơi cấp" name="noiCapInput" />
                              <form:errors path="noiCap" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Ngày cấp</label>
                              <form:input path="ngayCap" type="date" id="projectinput4" class="form-control" placeholder="Ngày cấp" name="ngayCapInput" />
                              <form:errors path="ngayCap" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          </div> <!-- /div row 5 -->
                          
                          <div class="row"> <!-- div row 6 -->
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Quốc tịch</label>
                              <form:select path="quocTich" type="text" id="projectinput4" class="form-control" name="quocTichSelect">
                              		<form:option value="" selected="selected" >Chọn quốc tịch</form:option>
                              	 <c:forEach items="${listQuocTich}" var="x">
                              		<form:option value="${x.tenNuoc}" >${x.tenNuoc}</form:option>
                              	 </c:forEach>
                              </form:select>
                              <form:errors path="quocTich" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Dân tộc</label>
                              <form:input path="danToc" type="text" id="projectinput4" class="form-control" placeholder="Dân tộc" name="danTocInput" />
                              <form:errors path="danToc" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                          </div><!-- /div row 6 -->
                          
                          <div class="row"><!-- div row 7 -->
                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="projectinput4">Nơi ở hiện nay</label>
                              <form:textarea path="noiOHienNay" type="text" id="projectinput4" class="form-control" placeholder="Nơi ở hiện nay" name="noiOHienNayInput" />
                              <form:errors path="noiOHienNay" cssStyle="color: red" /> <!-- validate error mess -->
                            </div>
                          </div>
                        </div> <!-- /div row 7 -->
                        <h4 class="form-section"><i class="fa fa-paperclip"></i>Thông tin quê quán</h4>
                        <div class="form-group">
                          <label for="thanhPhoId">Thành Phố</label>
                          <form:select path="thanhPho.maTinhThanh" type="text" id="thanhPhoId" class="form-control"
                          				name="thanhPhoSelect" onchange="clickComboboxThanhPho()">
                          		<option value="" selected="selected" disabled >Chọn thành phố</option>
    								<c:forEach items="${listThanhPho}" var="x">
                              			<form:option value="${x.maTinhThanh}" >${x.tenTinhThanh}</form:option>
                              		</c:forEach>						
                          </form:select>
                          <form:errors path="thanhPho" cssStyle="color: red" /> <!-- validate error mess -->
                        </div>
                        <div class="form-group">
                          <label for="quanHuyenId">Quận huyện</label>
                          <form:select path="quanHuyen.maQuanHuyen" id="quanHuyenId"  name="quanHuyen" type="text" class="form-control"
                          			onchange="clickComboboxQuan()" >
                          		 <option value="" selected="selected" disabled>Chọn quận huyện</option>
                          </form:select>
                     		<form:errors path="quanHuyen" cssStyle="color: red" /> <!-- validate error mess -->
                        </div>
                        <div class="form-group">
                          <label for="phuongXaId">Phường xã</label>
                          <form:select path="phuongXa.maPhuong" type="text" id="phuongXaId" class="form-control"
                          name="phuongXaSelect">
                          		<option value="" selected="selected" disabled>Chọn phường xã</option>
                          </form:select>
                          <form:errors path="phuongXa" cssStyle="color: red" /> <!-- validate error mess -->
                        </div>
                        
                      </div>
                      
                      <h4 class="form-section"><i class="fa fa-paperclip"></i>Phòng Ban</h4>
                        <div class="form-group">
                          <label for="companyName">Phòng ban</label>
                          <form:select path="maPhongBan.maPhongBan" type="text" id="companyName" class="form-control"
                          name="phongBanSelect">
                          		<option value="" selected="selected" disabled>Chọn Phòng ban</option>
                          	  <c:forEach items="${listPhongBan}" var="x">
                              	<form:option value="${x.maPhongBan}" >${x.tenPhongBan}</form:option>
                              </c:forEach>
                          </form:select>
                          <form:errors path="maPhongBan" cssStyle="color: red" /> <!-- validate error mess -->
                        </div>
                        <div class="form-group">
                          <label for="companyName">Chức danh</label>
                          <form:select path="maChucDanh.maChucDanh" type="text" id="companyName" class="form-control" placeholder="Company Name"
                          name="chucDanhSelect">
                          		<option value="" selected="selected" disabled>Chọn chức danh</option>
                          	  <c:forEach items="${listChucDanh}" var="x">
                              	<form:option value="${x.maChucDanh}" >${x.tenChucDanh}</form:option>
                              </c:forEach>
                          </form:select>
                          <form:errors path="maChucDanh" cssStyle="color: red" /> <!-- validate error mess -->
                        </div>
                        
                        <div class="form-group">
                          <label>Hình Ảnh:</label> <input id="imgUrl" class="form-control"
						type="file" name="file" /> <br>
						 <img src="<c:url value="/uploads/${formHosopkl.avatar}" />"
						width="100" height="150">
						<img id="img" src="#"
						alt="your image" width="100" height="150" />
						 
                        </div>
                         <div class="form-group">
                         <form:hidden path="avatar"/>
                         </div>
                        
             
                        <div class="form-actions">
                        
                        <button type="submit" class="btn btn-primary">
                          <i class="fa fa-check-square-o"></i> Lưu
                        </button>
                        
                        <a href="/ffse-fbms/quantrinhansu/hosonhanvien/${pageIndex}"><button type="button" class="btn btn-warning mr-1">
                          <i class="ft-x"></i> Hủy
                        </button></a>
                      </div>
                    </form:form>
                    <div ><p id="result"></p></div>
               
                        
                     
                     <script>
                     
                     	window.onload= function(){
                     		clickComboboxThanhPho(); // gọi function này để load quận
                     		
                     	
                    		
                     	}
                     </script>
                        
                     <script type="text/javascript">
                     <!-- ajax select ThanhPho -->
                     function clickComboboxThanhPho(){
                    	 var maThanhPho = $("#thanhPhoId").val();
                    	 $('#quanHuyenId option').remove(); // delete old data in quan huyen
                		 $('#phuongXaId option').remove();// delete old data in phuong xa
                    	 
                         $.ajax({
                        	 url: "/ffse-fbms/quantrinhansu/hosonhanvien/selectquan/" + maThanhPho, 
                        	 dataType: "json",
                        	 success: function(data){
                        		$('#quanHuyenId').append($('<option>', {
                             		    value: 'noQuanHuyen',
                             		    text: 'Chọn Quận Huyện'
                             		}));
                        		$('#quanHuyenId option[value=noQuanHuyen]').attr('disabled', true);
                        		for (var i = 0; i < data.length; i++) {
                        			$('#quanHuyenId').append($('<option>', {
                             		    value: data[i].maQuanHuyen,
                             		    text: data[i].tenQuanHuyen
                             		}));
                        		
								}
                        		$('#quanHuyenId option[value=${formHosopkl.quanHuyen.maQuanHuyen}]').attr('selected', 'selected')
                        		
                        		$('#phuongXaId').append($('<option>', { // insert default data in phuong xa
                         		    value: 'noPhuongXa',
                         		    text: 'Chọn phường xã'
                         		}));
                        		$('#phuongXaId option[value=noPhuongXa]').attr('disabled', true);
                        			clickComboboxQuan(); // gọi function này để load phường
                        		
                         }});
                     };
                   
                     </script>
                     
                     <script>
                     // ajax select QuanHuyen
                     function clickComboboxQuan(){
                    	 var maQuanHuyen = $("#quanHuyenId").val();
                    	 $('#phuongXaId option').remove(); // delete old data in phuong xa
                    	 
                         $.ajax({
                        	 url: "/ffse-fbms/quantrinhansu/hosonhanvien/selectphuong/" + maQuanHuyen, 
                        	 dataType: "json",
                        	 success: function(data){
                 
                        		
                        		$('#phuongXaId').append($('<option>', {
                             		    value: 'noPhuongXa',	
                             		    text: 'Chọn phường xã'
                             		}));
                        		$('#phuongXaId option[value=noPhuongXa]').attr('disabled', true);
                        		
                        		for (var i = 0; i < data.length; i++) {
                        			$('#phuongXaId').append($('<option>', {
                             		    value: data[i].maPhuong,
                             		    text: data[i].tenPhuong
                             		}));
                        			
								}
                        		$('#phuongXaId option[value=${formHosopkl.phuongXa.maPhuong}]').attr('selected', 'selected')
	
                         }});
                     };
                     </script>
                     
                      <!-- preview image -->  
                     <script type="text/javascript">
						function readURL(input) {
						if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
						$('#img').attr('src', e.target.result);
						}
						reader.readAsDataURL(input.files[0]);
						}
						}
						$("#imgUrl").change(function() {
						readURL(this);
						});
					</script>
                     
			
	</div>
</div>

<!-- Footer -->
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />