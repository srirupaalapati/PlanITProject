package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	File des;
	XSSFSheet sheet;
	XSSFWorkbook wb;

	public ExcelUtils(String location) {
		try {
			des = new File(location);
			FileInputStream fis = new FileInputStream(des);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	//Read data from excel
	public String[][] getXLDataByPOI(String sheetname) throws IOException, InvalidFormatException {

		int index = 0;

		sheet = wb.getSheet(sheetname);
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(1).getPhysicalNumberOfCells();

		System.out.println("Total rows:" + rows);
		System.out.println("Total columns:" + columns);
		String a[][] = new String[rows - 1][columns];
		try {

			for (int i = 1; i < rows; i++)

			{
				// System.out.println("No of index:"+ index);
				for (int j = 0; j < columns; j++) {

					// System.out.println("No of row:"+ i);
					// System.out.println("No of Column:"+ j);
					// System.out.println("No of index:"+ index);
					if(!sheet.getRow(i).getCell(j).getCellType().equals("BLANK")){
						a[index][j] = sheet.getRow(i).getCell(j).toString();
					}
						
					 System.out.println(j+" and "+index+" "+a[index][j]);
				}
				index = index + 1;
				// System.out.println("No of index:"+ index);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int getLastRowNum(String sheetName){
		sheet = wb.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum();
		return rowNum;
	}
	

}

