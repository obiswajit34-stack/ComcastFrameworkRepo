package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Craete An Object for FileInputStream 
		FileInputStream fis = new FileInputStream("C:\\Users\\obisw\\OneDrive\\Desktop\\testScriptdata.xlsx");
		
		//Open Excel workbook in raed mode
		Workbook wb =WorkbookFactory.create(fis);
		
		//Take Control of the sheet
          Sheet sheet = wb.getSheet("Sheet1");
	    //Take the control of the row
         Row row = sheet.getRow(1);
         //Take Control of cell
         Cell cell = row.getCell(2);
         
        //read data from the cell
       String value = cell.getStringCellValue();
	    
       //close the workbook
       wb.close(); 
	
	}
}
