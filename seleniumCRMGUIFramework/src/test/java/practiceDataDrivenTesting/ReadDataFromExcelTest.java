package practiceDataDrivenTesting;

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
		// Step 1: get the excel path location & java object of the physical Excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");

		// Step 2: open workbook in read mode
		Workbook workbook = WorkbookFactory.create(fis);

		// Step 3: get the control of the "org" sheet
		Sheet sheet = workbook.getSheet("org");

		// Step 4: Get the control of the 1st row
		Row row = sheet.getRow(1);

		// Step 5: get the control of the 2nd cell and read the String data
		Cell cell = row.getCell(2);
		String data = cell.getStringCellValue();
		System.out.println(data);

        //Step 6: Close the workbook
		workbook.close();

	}
}
