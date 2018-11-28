package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class CreateExcel {

	private static HSSFCellStyle createStyle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void main(String[] args) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Employees sheet");
		List<User> list = UserDao.listUser();

		int rowNum = 0;
		Cell cell;
		Row row;
		HSSFCellStyle style = createStyle(workbook);
		row = sheet.createRow(rowNum);
		// ID
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("ID");
		cell.setCellStyle(style);
		// Name
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Name");
		cell.setCellStyle(style);
		// Age
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Age");
		cell.setCellStyle(style);
		// Address
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Address");
		cell.setCellStyle(style);

		// Data
		for (User user : list) {
			rowNum++;
			row = sheet.createRow(rowNum);

			// ID (A)
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(user.getId());
			// Name (B)
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(user.getName());
			// Age (C)
			cell = row.createCell(2, CellType.NUMERIC);
			cell.setCellValue(user.getOld());
			// Address (D)
			cell = row.createCell(3, CellType.NUMERIC);
			cell.setCellValue(user.getAddress());
			// Bonus (E)
			String formula = "0.1*C" + (rowNum + 1);
			cell = row.createCell(4, CellType.FORMULA);
			cell.setCellFormula(formula);
		}
		// create file
		File file = new File("D:/user.xls");
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		System.out.println("Created file: " + file.getAbsolutePath());
	}
}
