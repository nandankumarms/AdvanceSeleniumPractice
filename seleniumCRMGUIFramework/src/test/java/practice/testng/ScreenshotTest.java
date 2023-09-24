package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenshotTest {

	@Test
	public void amazonTest() throws IOException {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://amazon.com");
		
		//Step 1 Create an object to EventFiringWebDriver
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		
		//Step 2 use getScreenshotAs method to take the screenshot in runtime in file format 
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		
		//step 3 Store screenshot in local drive using common io library
		FileUtils.copyFile(srcFile, new File("./Screenshots/test.png"));
		
		//
		
		driver.quit();
		
	}
}
