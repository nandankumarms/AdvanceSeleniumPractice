package practiceDataDrivenTesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {

	@Test
	public void runtimeParameterTest() {
		
		String url=System.getProperty("url");
		System.out.println("URL : "+url);
		
		String browser=System.getProperty("browser");
		System.out.println("browser : "+browser);
		
		String UN=System.getProperty("UN");
		System.out.println("User name : "+UN);
		
		String pwd=System.getProperty("pwd");
		System.out.println("Password : "+pwd);
	}
}
