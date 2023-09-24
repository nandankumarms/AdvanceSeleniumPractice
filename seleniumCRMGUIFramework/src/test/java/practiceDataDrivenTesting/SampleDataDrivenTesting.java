package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		//Step1: Get the java representation object of physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\AdvanceSelenium\\commondata.properties");
		
		
		//Step2: Using Properties class load all the keys
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Step 3: Get the value based on key
		System.out.println(pObj.getProperty("password"));// key is case sensitive
		
	}
}
