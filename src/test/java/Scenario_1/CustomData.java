package Scenario_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomData {
	
	public XSSFWorkbook wb;

	@DataProvider(name = "ExcelData")
	public Object[][] testData() {
		File f1 = new File(System.getProperty("user.dir") + "//TestData//Data.xlsx");

		FileInputStream fs;
		Object data[][] = null;
		try {
			fs = new FileInputStream(f1);
			wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet("UserData");
			// Number of rows
			int row = sheet.getPhysicalNumberOfRows();
			int cell = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new Object[row][cell];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < cell; j++) {
					data[i-1 ][j] = sheet.getRow(i).getCell(j).getStringCellValue();

				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

}

}
