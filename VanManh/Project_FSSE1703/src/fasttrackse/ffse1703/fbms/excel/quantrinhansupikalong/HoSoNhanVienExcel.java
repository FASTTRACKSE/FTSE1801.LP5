package fasttrackse.ffse1703.fbms.excel.quantrinhansupikalong;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.GiaDinhPikalong;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;


public class HoSoNhanVienExcel extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workBook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HoSoNhanVienPikalong hoSo =  (HoSoNhanVienPikalong) model.get("hoSoNhanVien");
		
		
		
		/*sheet thông tin chi ti?t begin */
		Sheet sheetHosoChiTiet = workBook.createSheet("Hồ Sơ CHi Tiết"); 
		
		//merge cells header
		sheetHosoChiTiet.addMergedRegion(new CellRangeAddress(1,1,0,15));
		
		// create font
		Font font = workBook.createFont();
		font.setFontHeightInPoints((short) 20);
		font.setBold(true);
		
		Font fontTh = workBook.createFont();
		fontTh.setFontHeightInPoints((short) 10);
		fontTh.setBold(true);
		
		Font fontTd = workBook.createFont();
		fontTd.setFontHeightInPoints((short) 10);
		
		
		//Set font into style
		CellStyle style = workBook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		
		CellStyle styleTh = workBook.createCellStyle();
		styleTh.setFont(fontTh);
		
		CellStyle styleTd = workBook.createCellStyle();
		styleTd.setFont(fontTd);
		
		
		//Set borders
		styleTh.setBorderBottom(BorderStyle.THIN);
		styleTh.setBorderTop(BorderStyle.THIN);
		styleTh.setBorderRight(BorderStyle.THIN);
		styleTh.setBorderLeft(BorderStyle.THIN);
		
		styleTd.setBorderBottom(BorderStyle.THIN);
		styleTd.setBorderTop(BorderStyle.THIN);
		styleTd.setBorderRight(BorderStyle.THIN);
		styleTd.setBorderLeft(BorderStyle.THIN);
		
		Row headerHoSoChiTiet = sheetHosoChiTiet.createRow(1);
		Cell cellHeaderHoSoChiTiet = headerHoSoChiTiet.createCell(0);
		cellHeaderHoSoChiTiet.setCellValue("Hồ Sơ Chi Tiết");
		cellHeaderHoSoChiTiet.setCellStyle(style);
		
		
		Row rowHoSoChiTietTh = sheetHosoChiTiet.createRow(3);
		rowHoSoChiTietTh.createCell(0).setCellValue("Mã Nhân Viên");
		rowHoSoChiTietTh.createCell(1).setCellValue("Họ và Tên");
		rowHoSoChiTietTh.createCell(2).setCellValue("Giới Tính");
		rowHoSoChiTietTh.createCell(3).setCellValue("Ngày Sinh");
		rowHoSoChiTietTh.createCell(4).setCellValue("Quốc Tịch");
		rowHoSoChiTietTh.createCell(5).setCellValue("Dân Tộc");
		rowHoSoChiTietTh.createCell(6).setCellValue("Quê Quán");
		rowHoSoChiTietTh.createCell(7).setCellValue("Noi Ở Hiện Nay");
		rowHoSoChiTietTh.createCell(8).setCellValue("Số Ðiện Thoại");
		rowHoSoChiTietTh.createCell(9).setCellValue("Email");
		rowHoSoChiTietTh.createCell(10).setCellValue("Tình Trạng Hôn Nhân");
		rowHoSoChiTietTh.createCell(11).setCellValue("Số CMND");
		rowHoSoChiTietTh.createCell(12).setCellValue("Nơi Cấp");
		rowHoSoChiTietTh.createCell(13).setCellValue("Ngày Cấp");
		rowHoSoChiTietTh.createCell(14).setCellValue("Chức Danh");
		rowHoSoChiTietTh.createCell(15).setCellValue("Phòng Ban");
		
		Row rowHoSoChiTietTd = sheetHosoChiTiet.createRow(4);
		rowHoSoChiTietTd.createCell(0).setCellValue(hoSo.getMaNv());
		rowHoSoChiTietTd.createCell(1).setCellValue(hoSo.getHoTenNv());
		rowHoSoChiTietTd.createCell(2).setCellValue(hoSo.getGioiTinh());
		rowHoSoChiTietTd.createCell(3).setCellValue(hoSo.getNgaySinh().toString());
		rowHoSoChiTietTd.createCell(4).setCellValue(hoSo.getQuocTich());
		rowHoSoChiTietTd.createCell(5).setCellValue(hoSo.getDanToc());
		rowHoSoChiTietTd.createCell(6).setCellValue("phuờng xã " + hoSo.getPhuongXa().getTenPhuong() + ", quận huyện " + hoSo.getQuanHuyen().getTenQuanHuyen() + ", tỉnh thành " + hoSo.getThanhPho().getTenTinhThanh());
		rowHoSoChiTietTd.createCell(7).setCellValue(hoSo.getNoiOHienNay());
		rowHoSoChiTietTd.createCell(8).setCellValue(hoSo.getsDT());
		rowHoSoChiTietTd.createCell(9).setCellValue(hoSo.getEmail());
		if(hoSo.getTinhTrangHonNhan() == 0) {
			rowHoSoChiTietTd.createCell(10).setCellValue("Chua Kết Hôn");
		} else {
			rowHoSoChiTietTd.createCell(10).setCellValue("Ðã Kết Hôn");
		}
		
		rowHoSoChiTietTd.createCell(11).setCellValue(hoSo.getcMND());
		rowHoSoChiTietTd.createCell(12).setCellValue(hoSo.getNgayCap().toString());
		rowHoSoChiTietTd.createCell(13).setCellValue(hoSo.getNoiCap());
		rowHoSoChiTietTd.createCell(14).setCellValue(hoSo.getMaChucDanh().getTenChucDanh());
		rowHoSoChiTietTd.createCell(15).setCellValue(hoSo.getMaPhongBan().getTenPhongBan());
		
		for(int colNumber = 0; colNumber < rowHoSoChiTietTd.getLastCellNum(); colNumber++) {
			sheetHosoChiTiet.autoSizeColumn(colNumber); 
			
			 Cell cellTh = rowHoSoChiTietTh.getCell(colNumber);
			 cellTh.setCellStyle(styleTh);
			 
			 Cell cellTd = rowHoSoChiTietTd.getCell(colNumber);
			 cellTd.setCellStyle(styleTd);
		} 
		/*sheet thông tin chi ti?t end */
		
		/* sheet thong tin gia dinh begin */
		@SuppressWarnings("unchecked")
		List<GiaDinhPikalong> giaDinh = (List<GiaDinhPikalong>) model.get("thongTinGiaDinh");
		
		// merge cells 
		Sheet sheetThongTinGiaDinh = workBook.createSheet("Thông Tin Gia Ðình");
		
		sheetThongTinGiaDinh.addMergedRegion(new CellRangeAddress(1,1,0,5));
		
		Row headerThongTinGiaDinh = sheetThongTinGiaDinh.createRow(1);
		Cell cellHeaderThongTinGiaDinh = headerThongTinGiaDinh.createCell(0);
		cellHeaderThongTinGiaDinh.setCellValue("Thông Tin Gia Ðình");
		cellHeaderThongTinGiaDinh.setCellStyle(style);
		
		Row rowThongTinGiaDinhTh = sheetThongTinGiaDinh.createRow(3);
		rowThongTinGiaDinhTh.createCell(0).setCellValue("Họ và Tên");
		rowThongTinGiaDinhTh.createCell(1).setCellValue("Quan Hệ");
		rowThongTinGiaDinhTh.createCell(2).setCellValue("Quê Quán");
		rowThongTinGiaDinhTh.createCell(3).setCellValue("Noi Ở Hiện Nay");
		rowThongTinGiaDinhTh.createCell(4).setCellValue("Nghề Nghiệp");
		rowThongTinGiaDinhTh.createCell(5).setCellValue("Số Ðiện Thoại");
		
		Row rowThongTinGiaDinhTd = sheetThongTinGiaDinh.createRow(4);
		
		int row = 4; 
		for(int i = 0; i < giaDinh.size(); i++) {
			rowThongTinGiaDinhTd = sheetThongTinGiaDinh.createRow(row);
			
			rowThongTinGiaDinhTd.createCell(0).setCellValue(giaDinh.get(i).getHoTen());
			rowThongTinGiaDinhTd.createCell(1).setCellValue(giaDinh.get(i).getQuanHe());
			rowThongTinGiaDinhTd.createCell(2).setCellValue(giaDinh.get(i).getQueQuan());
			rowThongTinGiaDinhTd.createCell(3).setCellValue(giaDinh.get(i).getNoiOHienNay());
			rowThongTinGiaDinhTd.createCell(4).setCellValue(giaDinh.get(i).getNgheNghiep());
			rowThongTinGiaDinhTd.createCell(5).setCellValue(giaDinh.get(i).getSdt().toString());
			
			for(int j = 0; j <  rowThongTinGiaDinhTd.getLastCellNum(); j++ ) {
				Cell cellTd = rowThongTinGiaDinhTd.getCell(j);
				cellTd.setCellStyle(styleTd);
			}
			row++;
		}
		for(int colNumber = 0; colNumber < rowThongTinGiaDinhTd.getLastCellNum(); colNumber++) {
			sheetThongTinGiaDinh.autoSizeColumn(colNumber);
			
			Cell cellTh = rowThongTinGiaDinhTh.getCell(colNumber);
			cellTh.setCellStyle(styleTh);
			
			
			
		}
		
		/* sheet thong tin gia dinh end */
		
		
		/* sheet thong tin bang cap begin */
				@SuppressWarnings("unchecked")
				List<BangCapPikalong> bangCap = (List<BangCapPikalong>) model.get("thongTinBangCap");
				
				Sheet sheetThongTinBangCap = workBook.createSheet("Thông Tin Bằng Cấp");
				
				sheetThongTinBangCap.addMergedRegion(new CellRangeAddress(1,1,0,3));
				
				
				Row headerThongTinBangCap = sheetThongTinBangCap.createRow(1);
				Cell cellHeaderThongTinBangCap = headerThongTinBangCap.createCell(0);
				cellHeaderThongTinBangCap.setCellValue("Thông Tin Bằng Cấp");
				cellHeaderThongTinBangCap.setCellStyle(style);
				
				Row rowThongTinBangCapTh = sheetThongTinBangCap.createRow(3);
				rowThongTinBangCapTh.createCell(0).setCellValue("Chuyên Ngành");
				rowThongTinBangCapTh.createCell(1).setCellValue("Xếp Loại");
				rowThongTinBangCapTh.createCell(2).setCellValue("Nơi Cấp");
				rowThongTinBangCapTh.createCell(3).setCellValue("Ngày Cấp");
				
				Row rowThongTinBangCapTd = sheetThongTinBangCap.createRow(4);
				
				int rowb = 4; 
				for(int i = 0; i < bangCap.size(); i++) {
					rowThongTinBangCapTd = sheetThongTinBangCap.createRow(rowb);
					
					rowThongTinBangCapTd.createCell(0).setCellValue(bangCap.get(i).getChuyenNganh());
					rowThongTinBangCapTd.createCell(1).setCellValue(bangCap.get(i).getXepLoai());
					rowThongTinBangCapTd.createCell(2).setCellValue(bangCap.get(i).getNoiCap());
					rowThongTinBangCapTd.createCell(3).setCellValue(bangCap.get(i).getNgayCap().toString());
					for(int j = 0; j < rowThongTinBangCapTd.getLastCellNum(); j++ ) {
						 Cell cellTd = rowThongTinBangCapTd.getCell(j);
						 cellTd.setCellStyle(styleTd);
					}
					rowb++;
					
				}
				for(int colNumber = 0; colNumber < rowThongTinBangCapTd.getLastCellNum(); colNumber++) {
					sheetThongTinBangCap.autoSizeColumn(colNumber);
					
					 Cell cellTh = rowThongTinBangCapTh.getCell(colNumber);
					 cellTh.setCellStyle(styleTh);
					 
				}
				
				/* sheet thong tin bang cap end */
				
				/* sheet kinh nghiệm dự án begin */
				
				@SuppressWarnings("unchecked")
				List<Nhiemvu> kinhNghiem = (List<Nhiemvu>) model.get("kinhNghiem");
				
				Sheet sheetKinhNghiem = workBook.createSheet("Kinh Nghiệm Dự Án");
				
				sheetKinhNghiem.addMergedRegion(new CellRangeAddress(1,1,0,1));
				
				
				Row headerKinhNghiem = sheetKinhNghiem.createRow(1);
				Cell cellHeaderKinhNghiem = headerKinhNghiem.createCell(0);
				cellHeaderKinhNghiem.setCellValue("Kinh Nghiệm Dự Án");
				cellHeaderKinhNghiem.setCellStyle(style);
				
				Row rowKinhNghiemTh = sheetKinhNghiem.createRow(3);
				rowKinhNghiemTh.createCell(0).setCellValue("Tên Dự Án");
				rowKinhNghiemTh.createCell(1).setCellValue("Vai Trò");
				
				Row rowKinhNghiemTd = sheetKinhNghiem.createRow(4);
				
				int rowk = 4; 
				for(int i = 0; i < kinhNghiem.size(); i++) {
					rowKinhNghiemTd = sheetKinhNghiem.createRow(rowk);
					
					rowKinhNghiemTd.createCell(0).setCellValue(kinhNghiem.get(i).getProjects().getNameProject());
					rowKinhNghiemTd.createCell(1).setCellValue(kinhNghiem.get(i).getRoles().getNameRoles());
					
					for(int j = 0; j < rowKinhNghiemTd.getLastCellNum(); j++ ) {
						 Cell cellTd = rowKinhNghiemTd.getCell(j);
						 cellTd.setCellStyle(styleTd);
					}
					rowk++;
					
				}
				for(int colNumber = 0; colNumber < rowKinhNghiemTd.getLastCellNum(); colNumber++) {
					sheetKinhNghiem.autoSizeColumn(colNumber);
					
					 Cell cellTh = rowKinhNghiemTh.getCell(colNumber);
					 cellTh.setCellStyle(styleTh);
					 
				}
				/* sheet kinh nghiệm dự án end */
	}

}