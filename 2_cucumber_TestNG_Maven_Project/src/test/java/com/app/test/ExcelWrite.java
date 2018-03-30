package com.app.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {

	public static void main(String[] args) throws Exception{
				
		String testDataPath = "./src/test/resources/test_data/Employees.xlsx";
		//Create fielinput stream
		FileInputStream inStream = new FileInputStream(testDataPath);
		Workbook workbook = WorkbookFactory.create(inStream);
		Sheet worksheet = workbook.getSheet("Sheet1");
		
		Cell job = worksheet.getRow(2).getCell(2);
		
		job.setCellValue("Automation GIP");
		
		worksheet.getRow(6).getCell(0).setCellValue("Alex");
		worksheet.getRow(6).getCell(1).setCellValue("Kotlyar");
		worksheet.getRow(6).getCell(2).setCellValue("ADT");
		
		Row row7 = worksheet.createRow(7);
		Cell cell1 = row7.createCell(0);
		cell1.setCellValue("FirstName");
		Cell cell2 = row7.createCell(1);
		cell1.setCellValue("LastName");
		Cell cell3 = row7.createCell(2);
		cell1.setCellValue("Department");
		
		
		
		Cell janeLasrName = worksheet.getRow(5).getCell(1);
		janeLasrName.setCellValue("Rangaeva Jn");
		
		//save changes
		FileOutputStream outStream = new FileOutputStream(testDataPath);
		workbook.write(outStream);
		
		outStream.close();
		workbook.close();
		inStream.close();
		

	}

}
