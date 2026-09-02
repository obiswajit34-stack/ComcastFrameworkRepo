package practiceTestNG;

import org.testng.annotations.Test;

public class OrederUsingInvocationTest {

	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("Execute createOrderTest==>123");
	}
	
	@Test(enabled = false)
	public void billingAnOrderTest() {
		System.out.println("Execute billingAnOrder==>123");
	}
}
