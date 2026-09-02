package practiceTestNG;

import org.testng.annotations.Test;

public class ContactTest {

	@Test
	public void createContactTest() {
		System.out.println("execute login");
		System.out.println("execute navigate To contact Test");
		System.out.println("execute create ContactTest");
		System.out.println("excute verify Contact");
		System.out.println("excute logout");
	}
	
	@Test
	//@test annotation return type is always void if i change the return type it will not executed
	public void createcontactWithMobileNumberTest() {
		System.out.println("execute createcontactWithMoblileNumberTest");
	}
}
