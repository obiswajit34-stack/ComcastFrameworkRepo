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

import baseClass.BaseClass;


public class CreateOrgTest extends BaseClass {
	
	
	@Test
	public void createContact() {
		System.out.println("excute createOrgTest & Verify");
	}
	@Test
	public void createContactWithDate() {
		System.out.println("execute createOrgWithIndustry & Verify");
	}
	
//	@BeforeSuite
//	public void beforeSuite() {
//		Reporter.log("Database connectivity estalished - beforeSuite",true);
//	}
//	@AfterSuite
//	public void afterSuite() {
//		Reporter.log("Database connectivity terminated - afterSuite",true);
//	}
//	
//	
//	@BeforeClass
//	public void beforeClass() {
//		Reporter.log("Launch Browser - beforeClass",true);
//	}
//	
//	@BeforeMethod
//	public void beforeMehod() {
//		Reporter.log("login to application - beforeMethod",true);
//	}
//	
//	@Test
//	public void createOrgTest() {
//		System.out.println("purchase book - test");
//	
//	}
//	@Test
//	public void createOrgWithIndustry() {
//		System.out.println("execute craeteOrgWithIndustries - test");
//	}
//	@AfterMethod
//	public void afterMethod() {
//		Reporter.log("Logout from the application - afterMethod",true);
//	}
//	
//	
//	@AfterClass
//	public void afterclass() {
//		Reporter.log("Close Browser - afterClass",true);
//	}
//	@BeforeTest
//	public void beforeTest() {
//		Reporter.log("Reports intialized - beforetest",true);
//		
//	}
//	@AfterTest
//	public void afterTest() {
//		Reporter.log("Reporter backup - aftertest",true);
//		
//	}
//	
}
