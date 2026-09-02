 package practice_datadriventesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;


public class CreateOrgTest {
@Test
	public void createOrgtest(XmlTest test){
		
		
		
	
	String URL = test.getParameter("url");
	String BROWSER = test.getParameter("browser");
	String USERNAME =test.getParameter("username");
	String PASSWORD =test.getParameter("password");
	
	
		
	
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
			
		}
		        //browser
		else if (BROWSER.equals("firefox")) {
			driver =new FirefoxDriver();
		}
		        //browser
		else if (BROWSER.equals("edge")) {
			driver =new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		 //driver = new ChromeDriver();
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//driver.findElement(By.linkText("Organizations")).click();
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		driver.quit();
		
	}
}
