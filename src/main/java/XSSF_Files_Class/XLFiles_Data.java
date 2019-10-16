package XSSF_Files_Class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLFiles_Data {
	
	public String path;
	public FileInputStream inputStream=null;
	public FileOutputStream outputStream=null;
	
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	
	public XLFiles_Data(String path){
		this.path=path;
		try {
			inputStream=new FileInputStream(path);
			workbook=new XSSFWorkbook(inputStream);
			sheet=workbook.getSheetAt(0);
			inputStream.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	public boolean writeData(String sheetName,int rowNum,String colName,String data,String path) {
		try {
		inputStream=new FileInputStream(path);
		
			workbook=new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		int index=workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		sheet=workbook.getSheetAt(index);
		//sheet=workbook.createSheet(sheetName);
		row=sheet.getRow(0);
		
		
		if(row==null){
			row=sheet.createRow(rowNum);
		}
		cell=row.getCell(colNum);
		if(cell==null){
			cell=row.createCell(colNum);
		}
		cell.setCellValue(data);
		
	try {
		outputStream=new FileOutputStream(path);
		   workbook.write(outputStream);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
	
		
	}
	
	
	
	
	
	

}
