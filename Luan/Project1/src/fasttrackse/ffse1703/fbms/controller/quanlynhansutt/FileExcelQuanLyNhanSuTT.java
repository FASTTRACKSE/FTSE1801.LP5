package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;

public class FileExcelQuanLyNhanSuTT extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workBook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HoSoNhanVienTT hoSo = (HoSoNhanVienTT) model.get("hoSoNhanVienTT");

		/* sheet thông tin chi tiết begin */
		Sheet sheetHosoChiTiet = workBook.createSheet("Hồ Sơ CHi Tiết");

		// merge cells header
		sheetHosoChiTiet.addMergedRegion(new CellRangeAddress(1, 1, 0, 15));

		// Tạo định dạng: font Times New Roman, in đậm, font-size 14, chữ màu trắng
		Font font = workBook.createFont();
		font.setFontHeightInPoints((short) 24);// font size
		font.setColor(IndexedColors.BLUE.getIndex());// text color
		font.setBold(true);

		Font fontTh = workBook.createFont();
		fontTh.setFontHeightInPoints((short) 10);
		fontTh.setBold(true);

		Font fontTd = workBook.createFont();
		fontTd.setFontHeightInPoints((short) 10);

		// Set font into style
		// Tạo cell style áp dụng font ở trên
		// Sử dụng màu nền xanh (Blue), định dạng border dưới 
		CellStyle style = workBook.createCellStyle();
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		

		CellStyle styleTh = workBook.createCellStyle();
		styleTh.setFont(fontTh);

		CellStyle styleTd = workBook.createCellStyle();
		styleTd.setFont(fontTd);

		// Set borders
		styleTh.setBorderBottom(BorderStyle.THIN);
		styleTh.setBorderTop(BorderStyle.THIN);
		styleTh.setBorderRight(BorderStyle.THIN);
		styleTh.setBorderLeft(BorderStyle.THIN);

		styleTd.setBorderBottom(BorderStyle.THIN);
		styleTd.setBorderTop(BorderStyle.THIN);
		styleTd.setBorderRight(BorderStyle.THIN);
		styleTd.setBorderLeft(BorderStyle.THIN);

		// Áp dụng định dạng CellStyle cho một Cell
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
		rowHoSoChiTietTd.createCell(0).setCellValue(hoSo.getMaNhanVien());
		rowHoSoChiTietTd.createCell(1).setCellValue(hoSo.getTenNhanVien());
		rowHoSoChiTietTd.createCell(2).setCellValue(hoSo.getGioiTinh());
		rowHoSoChiTietTd.createCell(3).setCellValue(hoSo.getNamSinh().toString());
		rowHoSoChiTietTd.createCell(4).setCellValue(hoSo.getQuocTich().getTenQuocTich());
		rowHoSoChiTietTd.createCell(5).setCellValue(hoSo.getDanToc().getTenDanToc());
		rowHoSoChiTietTd.createCell(6).setCellValue("phuờng xã " + hoSo.getXaPhuong().getTenXa() + ", quận huyện "
				+ hoSo.getQuanHuyen().getTenQuanHuyen() + ", tỉnh thành " + hoSo.getThanhPho().getTenThanhPho());
		rowHoSoChiTietTd.createCell(7).setCellValue(hoSo.getDiaChi());
		rowHoSoChiTietTd.createCell(8).setCellValue(hoSo.getSoDienThoai());
		rowHoSoChiTietTd.createCell(9).setCellValue(hoSo.getEmail());
		rowHoSoChiTietTd.createCell(10).setCellValue(hoSo.getTinhTrangHonNhan().getTinhTrangHonNhan());
		rowHoSoChiTietTd.createCell(11).setCellValue(hoSo.getSoCmnd());
		rowHoSoChiTietTd.createCell(12).setCellValue(hoSo.getNgayCap().toString());
		rowHoSoChiTietTd.createCell(13).setCellValue(hoSo.getNoiCap());
		rowHoSoChiTietTd.createCell(14).setCellValue(hoSo.getChucDanh().getTenChucDanh());
		rowHoSoChiTietTd.createCell(15).setCellValue(hoSo.getPhongBan().getTenPhongBan());

		for (int colNumber = 0; colNumber < rowHoSoChiTietTd.getLastCellNum(); colNumber++) {
			sheetHosoChiTiet.autoSizeColumn(colNumber);

			Cell cellTh = rowHoSoChiTietTh.getCell(colNumber);
			cellTh.setCellStyle(styleTh);

			Cell cellTd = rowHoSoChiTietTd.getCell(colNumber);
			cellTd.setCellStyle(styleTd);
		}
		/* sheet thông tin chi ti?t end */

		/* sheet thong tin gia dinh begin */
		
		List<ThongTinGiaDinhTT> giaDinh = (List<ThongTinGiaDinhTT>) model.get("thongTinGiaDinhTT");

		// merge cells
		Sheet sheetThongTinGiaDinh = workBook.createSheet("Thông Tin Gia Ðình");

		sheetThongTinGiaDinh.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinGiaDinh = sheetThongTinGiaDinh.createRow(1);
		Cell cellHeaderThongTinGiaDinh = headerThongTinGiaDinh.createCell(0);
		cellHeaderThongTinGiaDinh.setCellValue("Thông Tin Gia Ðình");
		cellHeaderThongTinGiaDinh.setCellStyle(style);

		Row rowThongTinGiaDinhTh = sheetThongTinGiaDinh.createRow(3);
		rowThongTinGiaDinhTh.createCell(0).setCellValue("Họ và Tên");
		rowThongTinGiaDinhTh.createCell(1).setCellValue("Quan Hệ");
		rowThongTinGiaDinhTh.createCell(2).setCellValue("Quê Quán");
		rowThongTinGiaDinhTh.createCell(3).setCellValue("Năm Sinh");
		rowThongTinGiaDinhTh.createCell(4).setCellValue("Giới Tính");
		rowThongTinGiaDinhTh.createCell(5).setCellValue("Số Ðiện Thoại");

		Row rowThongTinGiaDinhTd = sheetThongTinGiaDinh.createRow(4);

		int row = 4;
		for (int i = 0; i < giaDinh.size(); i++) {
			rowThongTinGiaDinhTd = sheetThongTinGiaDinh.createRow(row);

			rowThongTinGiaDinhTd.createCell(0).setCellValue(giaDinh.get(i).getHoTen());
			rowThongTinGiaDinhTd.createCell(1).setCellValue(giaDinh.get(i).getQuanHe());
			rowThongTinGiaDinhTd.createCell(2).setCellValue(giaDinh.get(i).getQueQuan());
			rowThongTinGiaDinhTd.createCell(3).setCellValue(giaDinh.get(i).getNamSinh().toString());
			rowThongTinGiaDinhTd.createCell(4).setCellValue(giaDinh.get(i).getGioiTinh());
			rowThongTinGiaDinhTd.createCell(5).setCellValue(giaDinh.get(i).getSoDienThoai().toString());

			for (int j = 0; j < rowThongTinGiaDinhTd.getLastCellNum(); j++) {
				Cell cellTd = rowThongTinGiaDinhTd.getCell(j);
				cellTd.setCellStyle(styleTd);
			}
			row++;
		}
		for (int colNumber = 0; colNumber < rowThongTinGiaDinhTd.getLastCellNum(); colNumber++) {
			sheetThongTinGiaDinh.autoSizeColumn(colNumber);

			Cell cellTh = rowThongTinGiaDinhTh.getCell(colNumber);
			cellTh.setCellStyle(styleTh);

		}
	}

}
