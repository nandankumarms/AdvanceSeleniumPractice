package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_UsingDataProvider {

	
	
	@Test(dataProvider = "getData")
	public void createContactTest_UsingDataProvider(String firstname, String lastname) {
		System.out.println("First name "+firstname+" "+"Last name "+lastname  );
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="nandan";
		data[0][1]="M S";
		data[1][0]="Gagan";
		data[1][1]="H R";
		data[2][0]="Deepak";
		data[2][1]="Sam";
				
		return data;
	}
}
