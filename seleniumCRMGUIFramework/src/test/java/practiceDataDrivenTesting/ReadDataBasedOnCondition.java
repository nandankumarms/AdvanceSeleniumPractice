package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String expectedTC_ID="TC_02";
		String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		
		FileInputStream fis=new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");
		
		Workbook workbook=WorkbookFactory.create(fis);
		
		Sheet sheet=workbook.getSheet("org");
		
		
		int rowCount=sheet.getLastRowNum();
		
		for(int i=0;i<=rowCount;i++) {
			String data="";
			try {
				//Read Only first column data
				data=sheet.getRow(i).getCell(0).toString();
				
				//Compare TC_ID with expected TC_ID
				if(data.equals(expectedTC_ID)) {
					flag=true;
					data1=sheet.getRow(i).getCell(1).toString();
				data2=sheet.getRow(i).getCell(2).toString();
					 data3=sheet.getRow(i).getCell(3).toString();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		if(flag==true) {
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		}
		else {
			System.out.println(expectedTC_ID+" is not available");
		}
		workbook.close();
		
		
	}

}
