package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("tsdata");
		
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			Row row=sheet.getRow(i);
		
		String FirstColumnData=row.getCell(0).toString();
		String SecondColumnData=row.getCell(1).toString();
		
		System.out.println(FirstColumnData+"\t"+ SecondColumnData);
		}

		workbook.close();
		
		
	}

}
