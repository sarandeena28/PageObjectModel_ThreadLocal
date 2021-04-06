package utils;

import java.io.IOException;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public String[][] readData(String SheetName) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook("./data/caseAndLegalEntity.XLSX");
		XSSFSheet ws=wb.getSheet(SheetName);
		int row = ws.getLastRowNum();
		short columnNo = ws.getRow(0).getLastCellNum();
		String[][] data=new String[row][columnNo];
		for (int i = 1; i <=row; i++) {
			for (int j = 0; j < columnNo; j++) {
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=cellValue;
				System.out.println(cellValue);
				
			}
		}
		wb.close();
		return data;
	}

}
