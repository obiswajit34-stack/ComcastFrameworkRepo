package baseClass;
 
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtility.DataBaseUtility;
import genericUtility.ExcelUtility;

import genericUtility.JavaUtility;
import genericUtility.PropertyFile;
import genericUtility.UtilityClassObject;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.Loginpage;
import objectReprository.LoginPage;

public class BaseClass2 {
//Create Object
	public DataBaseUtility dlib = new DataBaseUtility();
	public static PropertyFile flib = new PropertyFile();
	// Utility classes PropertyFile flib = new PropertyFile();
	public static ExcelUtility elib = new ExcelUtility();
	public static JavaUtility jlib = new JavaUtility();
	public static WebDriverUtility wlib = new WebDriverUtility();

	public  WebDriver driver = null;//if i make this  static this variable is not execute in parallel execution

	public static WebDriver sdriver = null;
	
	
//	public ExtentTest test;
	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws SQLException {
		System.out.println("=====Connect to DB , Report config======");
		dlib.getDbconnection();
		
		
	}
	

	//parallel Execution
	
//		@Parameters("BROWSER")
//		@BeforeClass(groups ={"smokeTest","regressionTest"})
//		public void ConfigBC(String browser) throws IOException {
//			System.out.println("==Launch the Browser==");
//			String BROWSER=browser;
//					//flib.getDatafromPropertyFile("browser");
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			} else if (BROWSER.equalsIgnoreCase("edge")) {
//				driver = new EdgeDriver();
//			} else if (BROWSER.equalsIgnoreCase("firefox")) {
//				driver = new FirefoxDriver();
//			} else {
//				driver = new ChromeDriver();
//			}

	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void ConfigBC() throws IOException {
		System.out.println("==Launch the Browser==");
		String BROWSER = flib.getDatafromPropertyFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver=driver;

		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })

	public void configBM() throws IOException {
		System.out.println("Login");
		String URL = flib.getDatafromPropertyFile("url");
		String USERNAME = flib.getDatafromPropertyFile("username");
		String PASSWORD = flib.getDatafromPropertyFile("password");

		Loginpage lp = new Loginpage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.logout();

	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAc() {
		System.out.println("==Close the Browser==");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws SQLException {
		System.out.println("===close DB=====");
		dlib.closeDbconnection();
		//For SampleReport
	//	report.flush();
	}
}
