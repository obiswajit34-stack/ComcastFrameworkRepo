package practiceTestNG;

import org.testng.annotations.Test;

public class UsingDependOnMethodTest {
	

		@Test
		public void createContactTest() {
			System.out.println("execute createContactTest --->HDFC");
		}
		
		@Test(dependsOnMethods = "createContactTest")
		public void modifycontactTest() {
			System.out.println("execute modifyContactTest -->HDFC =>ICICI");
		}
		
		@Test(dependsOnMethods = "modifycontactTest")
		public void deleteContactTest() {
			System.out.println("execute deleteContactTest -->ICICI");
		}
	}


