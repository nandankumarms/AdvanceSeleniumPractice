package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgTest {
	
	
	@Test
		public void createOrganizaton(XmlTest test) throws FileNotFoundException, IOException, ParseException {
		
		WebDriver driver = null;
       
         
		String url=test.getParameter("url");
		String browser=test.getParameter("browser");
		String userName=test.getParameter("userName");
		String password=test.getParameter("password");
		
		
		//Generate random number
		Random random=new Random();
		int randomInt=random.nextInt();
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 driver.get(url);

		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);;
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("nandanspl3"+randomInt);
		
		driver.findElement(By.name("button")).click();
		String headerMsg=driver.findElement(By.xpath("//span[ @class='dvHeaderText']")).getText();
		String[] text=headerMsg.split(" ");
		System.out.println(text[3]);	
		
		driver.findElement(By.xpath("//td[@class='genHeaderSmall']")).click();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
	}

}
