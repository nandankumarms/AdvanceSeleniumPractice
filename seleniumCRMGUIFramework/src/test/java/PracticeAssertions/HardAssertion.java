package PracticeAssertions;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertion {
	
	@Test
	public void homePageTest(Method method) {
		
		SoftAssert softAssert=new SoftAssert();
		
		System.out.println(method.getName()+ " test start");
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals("Home", "Home");
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		Assert.assertTrue(true);
		System.out.println("Step 6");
		System.out.println(method.getName()+ " test end");
	}
	
	@Test
	public void logoVerfiyTest(Method method) {
		System.out.println(method.getName()+ " Test start");
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals("Logo", "Logo");
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		Assert.assertTrue(false);
		System.out.println("Step 6");
		System.out.println(method.getName()+ " Test end");
	}

}
