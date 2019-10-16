package TestPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class Write_File {
	public String path;
	public FileInputStream inputStream=null;
	public FileOutputStream outputStream=null;
	
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	
	
	@Test
	public void write_Data(String data,int rowNum,int colNum){
		path="C:\\Users\\ASHOK\\workspace\\FreeCrmTesting\\MynewBook.xlsx";
		String sheetName="Testing3";
		
	    try {
			inputStream=new FileInputStream(path);
			workbook=new XSSFWorkbook(inputStream);
			int index=workbook.getSheetIndex(sheetName);
			if(index==-1){
				sheet=workbook.createSheet(sheetName);
			}else{
				sheet=workbook.getSheetAt(index);
			}
			int last=sheet.getLastRowNum();
			//sheet.getRow(rowNum).createCell(colNum).setCellValue(data);
			if(last==0){
				row=sheet.createRow(rowNum);
			}else{
				row=sheet.getRow(last);
			}
			if(rowNum==1){
				CellStyle cellstyle=workbook.createCellStyle();
				Font font=workbook.createFont();
				
				font.setColor(IndexedColors.GREEN.getIndex());
				cellstyle.setFont(font);
				cellstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				Cell cell=row.createCell(colNum);
				cell.setCellValue(data);
				cell.setCellStyle(cellstyle);
				sheet.autoSizeColumn(colNum);
			}else{
			
			CellStyle cellstyle=workbook.createCellStyle();
			Font font=workbook.createFont();
			
			font.setColor(IndexedColors.BLUE.getIndex());
			cellstyle.setFont(font);
			cellstyle.setFillBackgroundColor(IndexedColors.BROWN.getIndex());
			Cell cell=row.createCell(colNum);
			cell.setCellValue(data);
			cell.setCellStyle(cellstyle);
			sheet.autoSizeColumn(colNum);

			
			}
		
			
			
			
			
			outputStream=new FileOutputStream(path);
			workbook.write(outputStream);
			outputStream.close();
	        
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
		
	    
	}
	

}









/*Iterator<Row> iterator = sheet.iterator();

while (iterator.hasNext()) {
    Row nextRow = iterator.next();
    Iterator<Cell> cellIterator = nextRow.cellIterator();
     
    while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
         
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;
        }
        System.out.print(" - ");
    }*/














