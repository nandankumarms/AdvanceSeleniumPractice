package practice.createOrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;

		// Steps to read data from properties file
		FileInputStream fis = new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\data\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String browser = prop.getProperty("browser");
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");

		// Generate random number
		Random random = new Random();
		int randomInt = random.nextInt();

		// Steps to read data from Excel file
		FileInputStream fisExcel = new FileInputStream("C:\\Users\\QSP-Trainer6\\Desktop\\testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fisExcel);
		Sheet sheet = workbook.getSheet("org");
		Row row = sheet.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		workbook.close();

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

		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		;
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.name("button")).click();

		// Verify the organization name in Header message
		String headerMsg = driver.findElement(By.xpath("//span[ @class='dvHeaderText']")).getText();
		if (headerMsg.contains(orgName)) {
			System.out.println("Header meassage verified "+headerMsg);
		} else {
			System.out.println("failed");
		}

		// Verify the oraganization name in Organization information
		String orgInfoOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (orgInfoOrgName.equals(orgName)) {
			System.out.println("Organization information verified "+orgInfoOrgName);
		}
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click().perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.quit();
	}
}
