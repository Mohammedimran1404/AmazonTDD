package com.global;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcellFile{
	Constants constants = new Constants();
	FileInputStream fis;
	Workbook wb;
	
	public String readDataFromExcel(String sheet, int row, int cell) {
		try {
			fis = new FileInputStream(constants.getExcellFilePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cel = r.getCell(cell);
		String value = cel.getStringCellValue();
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}	

	public Object[][] readMultipleDataFromExcel(String sheetName) {
		try {
			fis = new FileInputStream(constants.getExcellFilePath());
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 try {
			wb = WorkbookFactory.create(fis);
		} 
		 catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
		
			for(int j=0;j<lastCell;j++) {
		
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
 }
}
		
		



