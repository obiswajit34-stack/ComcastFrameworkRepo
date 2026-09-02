package practiceTestNG;

import org.testng.annotations.Test;

public class ContactUsingPriorityTest {

	@Test(priority = 1)
	public void createContactTest() {
		System.out.println("execute createContact --->HDFC");
	}
	
	@Test(priority = 2)
	public void modifycontactTest() {
		System.out.println("execute modifyContactTest -->HDFC =>ICICI");
	}
	
	@Test(priority = 3)
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest -->ICICI");
	}
}
