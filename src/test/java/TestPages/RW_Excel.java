package TestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class RW_Excel {
	public String path= "C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\MynewBook.xlsx";
	public FileInputStream inputStream = null;
	public FileOutputStream outputStream = null;

	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	@Test
	public void TestFile() throws IOException {
		try {
			
			String sheetName = "Testing3";

			inputStream = new FileInputStream(new File(path));

			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(1);
            int rowcount=sheet.getLastRowNum();
          //  sheet.groupColumn(1, 2);
            	
            
           /* System.out.println(rowcount+1);
            for(int i=0;i<=rowcount;i++){
            	
            	row=sheet.getRow(i);
            	//sheet.removeRow(row);
            	cell=row.getCell(2);
            	//row.removeCell(cell);
            	
            	String cellValue=cell.getStringCellValue();//equals("TestData");
            	System.out.println(cellValue);
            	if(cellValue.equalsIgnoreCase("TestData")){
            		cell=row.createCell(2);
            		cell.setCellValue("Pass");
            	}else{
            		
            		cell=row.createCell(2);
            		cell.setCellValue("Fail");
            	}
            		
            }*/
           
           String[] str={"Test","Selenium","Test","Test","Test","Test","Selenium"};
           
			row = sheet.createRow(rowcount+1);
			
			cell=row.createCell(1);
			cell.setCellValue("Selenium");
			int cellcount=row.getLastCellNum();
			System.out.println("LastCell Number is: "+cellcount);
			
			outputStream=new FileOutputStream(path);
			workbook.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	@Test(enabled=false)
	public void removeRow() throws FileNotFoundException{
		inputStream=new FileInputStream(new File(path));
		try {
			workbook=new XSSFWorkbook(inputStream);
			sheet=workbook.getSheetAt(0);
			if(sheet==null){
				System.out.println("False");
			}
			int lastRowNum=sheet.getLastRowNum();
			System.out.println(lastRowNum);
			for(int i=0;i<=lastRowNum;i++){
				
				if(i>=0&&i<lastRowNum){
					sheet.shiftRows(i+1, lastRowNum, -i);
				}
				
				if(i==lastRowNum){
					row=sheet.getRow(i);
					if(row!=null){
						sheet.removeRow(row);
					}
				}
			}
				
			outputStream=new FileOutputStream(path);
			workbook.write(outputStream);
			outputStream.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("True");
	}
	

}







