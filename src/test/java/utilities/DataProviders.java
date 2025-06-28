package utilities;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {;
		String ExcelfilePath = ".\\TestData\\DD_TestData.xlsx";
		ExcelUtilsV2 excel = new ExcelUtilsV2(ExcelfilePath);
		int totalRow = excel.getRowCount("Sheet1");
		int totalCell = excel.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalRow][totalCell];

		for (int r = 1; r <= totalRow; r++) { // starting index from 1 as we do not need headers
			for (int c = 0; c < totalCell; c++) {

				loginData[r - 1][c] = excel.getCellData("Sheet1", r, c); // row is r-1, because we have started row from
					//System.out.println("cell data ==>"+loginData[r - 1][c]);													// 1 not 0, but array index starts from 0
			}
		}
		return loginData;
	}
}
