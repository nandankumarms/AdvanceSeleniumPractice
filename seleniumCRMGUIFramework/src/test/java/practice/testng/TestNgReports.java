package practice.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgReports {

	@Test
	public void homePageTest(Method method) {
		
		SoftAssert softAssert=new SoftAssert();
		
		Reporter.log(method.getName()+ " test start");
		Reporter.log("Step 1");
		Reporter.log("Step 2");
		
		Assert.assertEquals("Home", "Home");
		Reporter.log("Step 3");
		Reporter.log("Step 4");
		Reporter.log("Step 5");
		
		Assert.assertTrue(true);
		Reporter.log("Step 6");
		Reporter.log(method.getName()+ " test end");
	}
}
