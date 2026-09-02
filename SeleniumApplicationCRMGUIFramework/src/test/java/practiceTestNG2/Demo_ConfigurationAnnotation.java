package practiceTestNG2;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_ConfigurationAnnotation {

	@BeforeMethod
	public void beforeMehod() {
	
		System.out.println("login to application - beforeMethod");
	}
	
	@Test
	public void test() {
		Reporter.log("purchase book - test",true);
	
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Logout from the application - afterMethod");
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Launch Browser - beforeClass");
	}
	
	@AfterClass
	public void afterclass() {
		Reporter.log("Close Browser - afterClass");
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("Reports intialized - beforetest");
		
	}
	@AfterTest
	public void afterTest() {
		Reporter.log("Reporter backup - aftertest");
		
	}
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Database connectivity estalished - beforeSuite");
	}
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Database connectivity terminated - afterSuite");
	}
	
}

