package practice.Homepage.Test;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class HomPageSampleTest {

	@Test
	public void homepageTest(Method mtd) {
//		System.out.println(mtd.getName() +"Test Start");
//		SoftAssert assertobj = new SoftAssert();
//		System.out.println("step-1");
//		System.out.println("step-2");
//		//Hard Assert
//		Assert.assertEquals("Home", "Home");
//		System.out.println("step-3");
//		assertobj.assertEquals("Title", "Title-1");
//		System.out.println("step-4");   
//		assertobj.assertAll();
//		System.out.println(mtd.getName() +"Test End");
		Reporter.log(mtd.getName()+"Test Start");
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		Reporter.log(mtd.getName()+"Test End");
	}
	
	
	@Test
	
	public void verifyLogoHomePageTest(Method mtd) {
//		System.out.println(mtd.getName() +"Test Start");
//		SoftAssert assertobj = new SoftAssert();
//		System.out.println("step-1");
//		System.out.println("step-2");
//		assertobj.assertTrue(true);
//		System.out.println("step-3");
//		System.out.println("step-4");
//		assertobj.assertAll();
//		System.out.println(mtd.getName() +"Test End");
		Reporter.log(mtd.getName()+"Test Start");
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Reporter.log("Step-3");
		Reporter.log("Step-4");
		Reporter.log(mtd.getName()+"Test End");
		
	}
	
}
