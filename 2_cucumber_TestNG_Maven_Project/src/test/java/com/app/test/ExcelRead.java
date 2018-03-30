package com.app.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelRead {
public static void main(String[] args) throws Exception {
	String filePath = "/C:/Eclipse/Employees.xlsx";
	//Open file and convert to a stream of data
	
	FileInputStream inStream = new FileInputStream(filePath);
	//take the stream of data and use it as WorkBook
	Workbook workbook = WorkbookFactory.create(inStream);
	//GEt the first worksheet from the workbook
	Sheet worksheet = workbook.getSheetAt(0);
	//go to first row
	Row row = worksheet.getRow(0);
	//go to first cell
	Cell cell = row.getCell(0);
	
	System.out.println(cell.toString());
	
	//How many rows in Excel sheet
	//int rowsCount = worksheet.getLastRowNum();
	int rowsCount = worksheet.getPhysicalNumberOfRows();
	System.out.println("Number of rows "+rowsCount);
	
	int lastRowNumber = worksheet.getLastRowNum();
	
	System.out.println("last row number "+ lastRowNumber);
	
	//Print all first names
	for (int rowNum = 1; rowNum< rowsCount; rowNum++) {
		row = worksheet.getRow(rowNum);
		cell =  row.getCell(0);
		
		System.out.println(rowNum + " - "+cell.toString());
		
		//System.out.println(rowNum+" - "+worksheet.getRow(rowNum).getCell(0));
	}
	
	//print the job_Id for Jane
	for (int rowNum = 1; rowNum< rowsCount; rowNum++) {
		row = worksheet.getRow(rowNum);
		cell =  row.getCell(0);
		
		if (cell.toString().equals("Jane")){
			System.out.println("job = "+ row.getCell(2).toString());
			break;
		}
	}
	
	for(int i = 1; i< worksheet.getPhysicalNumberOfRows(); i++) {
		Row myRow = worksheet.getRow(i);
		if(myRow.getCell(0).toString().equals("Jane")) {
			System.out.println("Jane works as "+ myRow.getCell(2).toString());
			break;
		}
		
	}
	
	
	
	
	workbook.close();
	inStream.close();
	
}
}
