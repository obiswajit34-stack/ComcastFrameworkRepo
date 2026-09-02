package practice.Homepage.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseClass2;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class InvoiceTest extends BaseClass2{

	//extends Baseclass2 for ListImpclass
	@Test
	public void createInvoiceTest() {
		System.out.println("excute createInvoiceTest");
		String actTitle =driver.getTitle();
		Assert.assertEquals("hh","uj");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoicewithContactTest() {
		System.out.println("excute createInvoiceContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	
//	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
//	public void activateSim() {
//		System.out.println("excute createInvoiceTest");
//		
//		Assert.assertEquals("hh","uj");
//		System.out.println("step-1");
//		System.out.println("step-2");
//		System.out.println("step-3");
//		System.out.println("step-4");
//	}
//	
}
