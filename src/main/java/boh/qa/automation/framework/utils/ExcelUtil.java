package boh.qa.automation.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	//public static String OFAC_TKT_TEST_DATA_PATH = "C:\\Users\\hs09136\\eclipse-workspace\\ofactkt\\src\\main\\java\\boh\\qa\\automation\\ofactkt\\testdata\\OFAC_Automation_TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String filePath, String sheetName) {
		
		Object testData[][] = null;
		try {
			FileInputStream fips = new FileInputStream(filePath);
			book = WorkbookFactory.create(fips);
			sheet = book.getSheet(sheetName);
			
			int row= sheet.getLastRowNum();
			int col=sheet.getRow(0).getLastCellNum() - 1;
			testData = new Object[row][col];
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					testData[i][j] = sheet.getRow(i+1).getCell(j).toString();		
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

	public static void putTestData(String filePath, String sheetName, int rowNum, int colNum, String value){
		try {
			FileInputStream fis = new FileInputStream(filePath);
			FileOutputStream fos = null;
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			XSSFRow row = null;
			XSSFCell cell = null;
					
			row = sheet.getRow(rowNum);
			if(row == null)
				row = sheet.createRow(rowNum);
			
			cell = row.getCell(colNum);
			if(cell == null)
				cell = row.createCell(colNum);
			
			cell.setCellValue(value);
			fos = new FileOutputStream(filePath);
			workBook.write(fos);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getAlertNumber(String filePath, String sheetName, int colNum){
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			
//			String ss = sheet.getRow(1).getCell(colNum).getStringCellValue();
//			System.out.println("Alert Number...." + ss);
			
			ArrayList<String> listOfAlertNumbers = new ArrayList<String>();
			for(int i=1; i<=sheet.getLastRowNum(); i++) {
				listOfAlertNumbers.add(sheet.getRow(i).getCell(colNum).getStringCellValue());
			}
			//System.out.println(listOfAlertNumbers);
			return listOfAlertNumbers;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object[][] getAlertActionsTestData(String filePath, String sheetName){
		Object testData[][] = null;
		try {
			FileInputStream fips = new FileInputStream(filePath);
			book = WorkbookFactory.create(fips);
			sheet = book.getSheet(sheetName);
			
			int row= sheet.getLastRowNum();
			int col=sheet.getRow(0).getLastCellNum();
			testData = new Object[row][col];
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					testData[i][j] = sheet.getRow(i+1).getCell(j).toString();		
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}
	
}
