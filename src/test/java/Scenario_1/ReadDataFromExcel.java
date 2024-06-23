package Scenario_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
  @Test
  public void dataRead() throws IOException {
	  //File
	  File f1=new File(System.getProperty("user.dir")+"//TestData//Data.xlsx");
	  FileInputStream fs=new FileInputStream(f1);
	  
	  //Workbook
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  
	  //Number of rows
	  int rows=wb.getSheet("UserData").getPhysicalNumberOfRows();
	  
	  //Number of Cells
	  int cells=wb.getSheet("UserData").getRow(0).getPhysicalNumberOfCells();
	  
	  //Array of same size like file
	  Object data[][]=new Object[rows-1][cells];
	  
	  //Read data from file and keep it inside the array
	  
	  for(int i=1;i<rows;i++)//rows
	  {
		  for(int j=0;j<cells;j++)//col
		  {
			  data[i-1][j]=wb.getSheet("UserData").getRow(i).getCell(j).getStringCellValue();
			  System.out.print(data[i-1][j]+" ");
		  }
		  
		  System.out.println();
	  }
	  
  }
}
