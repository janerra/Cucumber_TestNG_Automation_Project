package com.app.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.app.pages.GasMilageCalculatorPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

//  http://www.calculator.net/gas-mileage-calculator.html

public class BasicDataDrivenTest {
WebDriver driver;
Workbook workbook;
Sheet worksheet;
FileInputStream inStream;
FileOutputStream outStream;

GasMilageCalculatorPage page;
public static final int CURRENT_ODOM_COLNUM = 1;
public static final int PREVIOU_SODOM_COLNUM = 2;
public static final int GAS_COLNUM = 3;

@BeforeClass
public void setUp() throws Exception{
	inStream = new FileInputStream(ConfigurationReader.getProperty("gasmilage.testdata.path"));
	
	workbook = WorkbookFactory.create(inStream);
    worksheet = workbook.getSheetAt(0);

	
	driver=Driver.getDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://www.calculator.net/gas-mileage-calculator.html");
}

@AfterClass
public void tearDown() throws Exception{
	outStream = new  FileOutputStream(ConfigurationReader.getProperty("gasmilage.testdata.path"));
	workbook.write(outStream);
	outStream.close();
	
	inStream.close();
	workbook.close();
	driver.close();
}

@Test
public void dataDriverMileageCalculatorTest() {
	//loop throw all data in Excel file (exclude the first row with headers)
	for(int rownum = 1; rownum < worksheet.getPhysicalNumberOfRows(); rownum++ ) {
		
		Row currentRow = worksheet.getRow(rownum);
		
		//check the control column (where Y or N - about testing this column). If "N"--> then skip this row
		if(!currentRow.getCell(0).toString().equalsIgnoreCase("Y")) {
			continue;
		}
		//take values from Excel table - to put them into the Gas-Milage-Calculator Internet tool
		double currentOd = currentRow.getCell(CURRENT_ODOM_COLNUM).getNumericCellValue();
		double previousOd = currentRow.getCell(PREVIOU_SODOM_COLNUM).getNumericCellValue();
		double gas = currentRow.getCell(GAS_COLNUM).getNumericCellValue();
	
		//create the page with Calculator
	page = new GasMilageCalculatorPage();
	//clean the field before put the data. Send the String representation of data to the field
	page.currentOdometer.clear();
	page.currentOdometer.sendKeys(String.valueOf(currentOd));
	
	page.previousOdometer.clear();
	page.previousOdometer.sendKeys(String.valueOf(previousOd));
	
	page.gas.clear();
	page.gas.sendKeys(String.valueOf(gas));
	//click the button - calculate
	page.calculate.click();
	
	//  Extract the "5.00" from the text-WEB Element 'resul'. text <b>5.00 miles per gallon</b>
	String[] result = page.result.getText().split(" ");
	System.out.println(result[0]);
	//---------------------
	//write result to ACTUAL RESULT column in Excel file
	if(currentRow.getCell(5) == null) {
		currentRow.createCell(5);
	}
	currentRow.getCell(5).setCellValue(result[0]);
	
	double culculationResult = ((currentOd - previousOd) / gas);
	DecimalFormat my_format = new DecimalFormat("#.00");
	
	System.out.println(my_format.format(culculationResult));
	//write result to EXPECTED RESULT column
	if(currentRow.getCell(4) == null) {
		currentRow.createCell(4);
	}
	currentRow.getCell(4).setCellValue(my_format.format(culculationResult));
	
	
	if(currentRow.getCell(6) == null) {
		currentRow.createCell(6);
	}
	
	//write PASS or Fail status 
	if(result[0].equals(my_format.format(culculationResult))) {
		System.out.println("Pass");
		currentRow.getCell(6).setCellValue("Pass");
	} else {
		System.out.println("Fail");
		currentRow.getCell(6).setCellValue("Fail");
	}
	//write current time in Rxcel cell
		
	if(currentRow.getCell(7) == null) {
		currentRow.createCell(7);
	}
		
	String dateTimeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM.dd.yyyy hh:mm"));
	currentRow.getCell(7).setCellValue(dateTimeStr);
	currentRow.getCell(7).getCellStyle().setWrapText(true);
	}
}
}
