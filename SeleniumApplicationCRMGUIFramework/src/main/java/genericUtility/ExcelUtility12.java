
package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility12 { 

	  public FileInputStream fis;

	    public int totalNumberOfRows(String sheetName) throws Exception {
	        fis = new FileInputStream("./src/test/resources/hrx.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);
	        wb.close();

	        return wb.getSheet(sheetName).getLastRowNum();
	    }

	    public int totalNumberOfColumns(String sheetName) throws Exception {
	        fis = new FileInputStream("./src/test/resources/hrx.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);
	        wb.close();

	        return wb.getSheet(sheetName)
	                 .getRow(0)
	                 .getPhysicalNumberOfCells();
	    }

	    public String readDataFromExcel(String sheetName, int row, int cell)
	            throws Exception {

	        fis = new FileInputStream("./src/test/resources/hrx.xlsx");
	        Workbook wb = WorkbookFactory.create(fis);

	        return wb.getSheet(sheetName)
	                 .getRow(row)
	                 .getCell(cell)
	                 .toString();
	    }

	    public void setCellDataInExcel(String sheetName,
	                                   int row,
	                                   int cell,
	                                   String value) throws Exception {

	        fis = new FileInputStream("./src/test/resources/hrx.xlsx");

	        Workbook wb = WorkbookFactory.create(fis);

	        wb.getSheet(sheetName)
	          .getRow(row)
	          .createCell(cell)
	          .setCellValue(value);

	        FileOutputStream fos =
	                new FileOutputStream("./src/test/resources/hrx.xlsx");

	        wb.write(fos);

	        wb.close();
	    }

	    public void updateCellDataInExcel(String sheetName,
	                                      int row,
	                                      int cell,
	                                      String value) throws Exception {

	        fis = new FileInputStream("./src/test/resources/hrx.xlsx");

	        Workbook wb = WorkbookFactory.create(fis);

	        wb.getSheet(sheetName)
	          .getRow(row)
	          .getCell(cell)
	          .setCellValue(value);

	        FileOutputStream fos =
	                new FileOutputStream("./src/test/resources/hrx.xlsx");

	        wb.write(fos);

	        wb.close();
	    }
	    public String readLongNumber(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
			fis = new FileInputStream("./src/test/resources/hrx.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			DataFormatter data=new DataFormatter();
			return data.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(cell));
			}
	
}
