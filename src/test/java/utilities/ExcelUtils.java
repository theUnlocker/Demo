
package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream filePath;
	public static FileOutputStream filePathout;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public int getRowCount(String path, String sheetName) throws IOException {
		filePath = new FileInputStream(path);
		workBook = new XSSFWorkbook(filePath);
		sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workBook.close();
		filePath.close();
		return rowCount;
	}

	public int getCellCount(String path, String sheetName) throws IOException {
		filePath = new FileInputStream(path);
		workBook = new XSSFWorkbook(filePath);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(0);
		int cellCount = row.getLastCellNum();
		workBook.close();
		filePath.close();
		return cellCount;

	}

	public String getCellValue(String path, String sheetName, int rowNum, int cellNum) throws IOException {
		filePath = new FileInputStream(path);
		workBook = new XSSFWorkbook(filePath);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String cellValue = cell.toString();
		workBook.close();
		filePath.close();
		return cellValue;
	}

	public void setCellValue(String path, String sheetName, int rowNum, int cellNum, String cellValue)
			throws IOException {
		filePath = new FileInputStream(path);
		workBook = new XSSFWorkbook(filePath);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		if (row == null) {
			sheet.createRow(rowNum);
		}
		cell = row.getCell(cellNum);
		if (cell == null) {
			row.createCell(cellNum);
		}
		cell.setCellValue(cellValue);
		filePathout = new FileOutputStream(path);
		workBook.write(filePathout);
		workBook.close();
		filePath.close();
		filePathout.close();
	}
}
