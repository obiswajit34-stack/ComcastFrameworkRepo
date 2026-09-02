package practiceTestNG2;

import org.testng.annotations.Test;

import baseClass.BaseClass;


public class CreateContactTest  extends BaseClass{


	@Test
	public void createContact() {
		System.out.println("excute createContact & Verify");
	}
	@Test
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate & Verify");
	}
}
