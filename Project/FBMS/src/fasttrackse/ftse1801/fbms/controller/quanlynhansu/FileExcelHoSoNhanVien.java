package fasttrackse.ftse1801.fbms.controller.quanlynhansu;

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

import fasttrackse.ftse1801.fbms.entity.quanlynhansu.HoSoNhanSu;
import fasttrackse.ftse1801.fbms.entity.quanlynhansu.ThongTinChungChi;

public class FileExcelHoSoNhanVien extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HoSoNhanSu nhanVien = (HoSoNhanSu) model.get("hoSoNhanVien");

		// Tạo định dạng
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 24);// font size
		font.setColor(IndexedColors.BLUE.getIndex());// text color
		font.setBold(true); // font bold

		Font fontTh = workbook.createFont();
		fontTh.setFontHeightInPoints((short) 10);
		fontTh.setBold(true);

		Font fontTd = workbook.createFont();
		fontTd.setFontHeightInPoints((short) 10);

		// Set font into style
		// Tạo cell style áp dụng font ở trên
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);

		CellStyle styleTh = workbook.createCellStyle();
		styleTh.setFont(fontTh);

		CellStyle styleTd = workbook.createCellStyle();
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

		/*
		 * Thông tin hồ sơ
		 */

		// sheet thông tin hồ sơ
		Sheet sheetHoSo = workbook.createSheet("Thông tin hồ sơ");
		sheetHoSo.addMergedRegion(new CellRangeAddress(1, 1, 0, 12));

		// Create cell header
		Row rowHeaderHoSo = sheetHoSo.createRow(1);
		Cell cellHeaderHoSo = rowHeaderHoSo.createCell(0);
		cellHeaderHoSo.setCellValue("Thông tin hồ sơ");
		cellHeaderHoSo.setCellStyle(style);

		Row rowHoSoTh = sheetHoSo.createRow(3);
		rowHoSoTh.createCell(0).setCellValue("Mã nhân viên");
		rowHoSoTh.createCell(1).setCellValue("Mã nhân viên");
		rowHoSoTh.createCell(2).setCellValue("Mã nhân viên");
		rowHoSoTh.createCell(3).setCellValue("Họ đệm");
		rowHoSoTh.createCell(4).setCellValue("Tên");
		rowHoSoTh.createCell(5).setCellValue("Năm sinh");
		rowHoSoTh.createCell(6).setCellValue("Giới tính");
		rowHoSoTh.createCell(7).setCellValue("Tình trạng hôn nhân");
		rowHoSoTh.createCell(8).setCellValue("Quê quán");
		rowHoSoTh.createCell(9).setCellValue("Dân tộc");
		rowHoSoTh.createCell(10).setCellValue("Số CMND");
		rowHoSoTh.createCell(11).setCellValue("Nơi cấp");
		rowHoSoTh.createCell(12).setCellValue("Ngày cấp");

		Row rowHoSoTd = sheetHoSo.createRow(4);
		rowHoSoTd.createCell(0).setCellValue(nhanVien.getMaNhanVien());
		rowHoSoTd.createCell(1).setCellValue(nhanVien.getMaPhongBan().getTenPhongBan());
		rowHoSoTd.createCell(2).setCellValue(nhanVien.getMaChucDanh().getTenChucDanh());
		rowHoSoTd.createCell(3).setCellValue(nhanVien.getHoDem());
		rowHoSoTd.createCell(4).setCellValue(nhanVien.getTen());
		rowHoSoTd.createCell(5).setCellValue(nhanVien.getNamSinh().toString());
		if (nhanVien.getGioiTinh()==1) {
			rowHoSoTd.createCell(6).setCellValue("Nam");
		} else {
			rowHoSoTd.createCell(6).setCellValue("Nữ");
		}
//		rowHoSoTd.createCell(6).setCellValue(nhanVien.getGioiTinh());
		if (nhanVien.getTinhTrangHonNhan()== 1) {
			rowHoSoTd.createCell(7).setCellValue("Độc thân");
		} else if (nhanVien.getTinhTrangHonNhan()== 2) {
			rowHoSoTd.createCell(7).setCellValue("Đã kết hôn");
		}else {
			rowHoSoTd.createCell(7).setCellValue("Đã ly hôn");
		}
//		rowHoSoTd.createCell(7).setCellValue(nhanVien.getTinhTrangHonNhan());
		rowHoSoTd.createCell(8).setCellValue(nhanVien.getQueQuan());
		rowHoSoTd.createCell(9).setCellValue(nhanVien.getDanToc());
		rowHoSoTd.createCell(10).setCellValue(nhanVien.getSoCMND());
		rowHoSoTd.createCell(11).setCellValue(nhanVien.getNoiCap());
		rowHoSoTd.createCell(12).setCellValue(nhanVien.getNgayCap().toString());

		for (int colNumber = 0; colNumber < rowHoSoTd.getLastCellNum(); colNumber++) {
			sheetHoSo.autoSizeColumn(colNumber);

			Cell cellTh = rowHoSoTh.getCell(colNumber);
			cellTh.setCellStyle(styleTh);

			Cell cellTd = rowHoSoTd.getCell(colNumber);
			cellTd.setCellStyle(styleTd);
		}

		/*
		 * Thông tin liên hệ
		 */
		// sheet Thông tin liên hệ
		Sheet sheetLienHe = workbook.createSheet("Thông tin liên hệ");
		sheetLienHe.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));

		// Create cell header
		Row rowHeaderLienHe = sheetLienHe.createRow(1);
		Cell cellHeaderLienHe = rowHeaderLienHe.createCell(0);
		cellHeaderLienHe.setCellValue("Thông tin liên hệ");
		cellHeaderLienHe.setCellStyle(style);

		Row rowLienHeTh = sheetLienHe.createRow(3);
		rowLienHeTh.createCell(0).setCellValue("Số điện thoại");
		rowLienHeTh.createCell(1).setCellValue("Email");
		rowLienHeTh.createCell(2).setCellValue("Địa chỉ liên hệ");

		Row rowLienHeTd = sheetLienHe.createRow(4);
		rowLienHeTd.createCell(0).setCellValue(nhanVien.getSoDienThoai());
		rowLienHeTd.createCell(1).setCellValue(nhanVien.getEmail());
		rowLienHeTd.createCell(2).setCellValue(nhanVien.getNoiTamTru());

		for (int colNumber = 0; colNumber < rowLienHeTd.getLastCellNum(); colNumber++) {
			sheetLienHe.autoSizeColumn(colNumber);

			Cell cellTh = rowLienHeTh.getCell(colNumber);
			cellTh.setCellStyle(styleTh);

			Cell cellTd = rowLienHeTd.getCell(colNumber);
			cellTd.setCellStyle(styleTd);
		}

		/*
		 * Thông tin bằng cấp
		 */
		// sheet thông tin bằng cấp

		/*
		 * Thông tin chứng chỉ
		 */
		List<ThongTinChungChi> listChungChi = (List<ThongTinChungChi>) model.get("thongTinChungChi");

		// sheet Thông tin chứng chỉ
		Sheet sheetChungChi = workbook.createSheet("Thông tin chứng chỉ");
		sheetChungChi.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));

		// create cell header
		Row rowHeaderChungChi = sheetChungChi.createRow(1);
		Cell cellHeaderChungChi = rowHeaderChungChi.createCell(0);
		cellHeaderChungChi.setCellValue("Thông tin chứng chỉ");
		cellHeaderChungChi.setCellStyle(style);

		Row rowChungChiTh = sheetChungChi.createRow(3);
		rowChungChiTh.createCell(0).setCellValue("Id");
		rowChungChiTh.createCell(1).setCellValue("Tên chứng chỉ");
		rowChungChiTh.createCell(2).setCellValue("Đơn vị cấp");
		rowChungChiTh.createCell(3).setCellValue("Ngày cấp");

		Row rowChungChiTd = null;
		int row = 4;

		for (int i = 0; i < listChungChi.size(); i++) {
			rowChungChiTd = sheetChungChi.createRow(row);
			rowChungChiTd.createCell(0).setCellValue(listChungChi.get(i).getId());
			rowChungChiTd.createCell(1).setCellValue(listChungChi.get(i).getTenChungChi());
			rowChungChiTd.createCell(2).setCellValue(listChungChi.get(i).getDonViCap());
			rowChungChiTd.createCell(3).setCellValue(listChungChi.get(i).getNgayCap().toString());

			for (int j = 0; j < rowChungChiTd.getLastCellNum(); j++) {
				Cell cellTd = rowChungChiTd.getCell(j);
				cellTd.setCellStyle(styleTd);
			}
			row++;
		}

		for (int colNumber = 0; colNumber < rowChungChiTd.getLastCellNum(); colNumber++) {
			sheetChungChi.autoSizeColumn(colNumber);
			Cell cellTh = rowChungChiTd.getCell(colNumber);
			cellTh.setCellStyle(styleTh);
		}

		/*
		 * 
		 * Thông tin dự án
		 */

	}

}
