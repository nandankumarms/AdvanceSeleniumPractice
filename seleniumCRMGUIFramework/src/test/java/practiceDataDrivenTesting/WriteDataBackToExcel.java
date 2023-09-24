package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("org");
		
		Row row=sheet.getRow(1);
		Cell cell= row.createCell(4);
		
		//Format cell to store String value
		cell.setCellType(CellType.STRING);
		
		//Enter value to cell
		cell.setCellValue("Pass");
		
		//Convert java representation object to Physical file
		FileOutputStream fos=new FileOutputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");
		
		//Write data into file
		workbook.write(fos);
		
		//Close workbook
		workbook.close();
		System.out.println("==executed==");
	}

}
