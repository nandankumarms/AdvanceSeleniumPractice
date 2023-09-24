package practiceDataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestngXmlTest {

	@Test
	public void sampleTest(XmlTest test) {
		
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("userName"));
		System.out.println(test.getParameter("password"));
		
	}
}
