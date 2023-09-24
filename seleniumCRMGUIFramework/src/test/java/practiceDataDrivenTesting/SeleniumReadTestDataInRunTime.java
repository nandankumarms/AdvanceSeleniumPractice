package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumReadTestDataInRunTime {

	@Test
	public void seleniumTest() throws EncryptedDocumentException, IOException {

		WebDriver driver = null;

		//Steps to read data from CMD
		String browser =System.getProperty("browser");
		String url = 	System.getProperty("url");	 
		String userName = System.getProperty("UN");
		String password = System.getProperty("pwd");

		// Steps to read data from Excel file
		// Step 1: get the excel path location & java object of the physical Excel file
		FileInputStream fis2 = new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");

		// Step 2: open workbook in read mode
		Workbook workbook = WorkbookFactory.create(fis2);

		// Step 3: get the control of the "org" sheet
		Sheet sheet = workbook.getSheet("org");

		// Step 4: Get the control of the 1st row
		Row row = sheet.getRow(1);

		// Step 5: get the control of the 2nd cell and read the String data
		Cell cell = row.getCell(2);
		String orgName = cell.getStringCellValue();

		// Close workbook
		workbook.close();

		// Generate Random number
		Random random = new Random();
		
		int randomIntNumber = random.nextInt(1000);

		//Select browser based on user requirement
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);

		// Step 1: Login to app

		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		;
		driver.findElement(By.id("submitButton")).click();

		// Step 2: navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();

		// Step 3: Click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 4: Enter all details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName+randomIntNumber);
		driver.findElement(By.name("button")).click();

		// Step 5: Verify the organization Name in Header message
		String headerMsg = driver.findElement(By.xpath("//span[ @class='dvHeaderText']")).getText();
		String[] text = headerMsg.split(" ");
		System.out.println(text[3]);

		// Step 6: Log out
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.quit();
	}
}
