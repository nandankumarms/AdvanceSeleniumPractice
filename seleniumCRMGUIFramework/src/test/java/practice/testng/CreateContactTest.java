package practice.testng;

import org.testng.annotations.Test;

public class CreateContactTest {

	@Test(priority = 1)
	public void createContact() {
		System.out.println("Create ");
	}
	
	@Test(priority = 2)
	public void modifyContact() {
		System.out.println("modify");
	}
	
	@Test(priority = 3)
	public void deleteContact() {
		System.out.println("delete");
	}
}
