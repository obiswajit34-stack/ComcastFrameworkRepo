package practice.Homepage.Test;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class HomPageVerificationTest {

	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd.getName() +"Test Start");
		String expectedpage ="Home page";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
//		//Hard Assert
		Assert.assertEquals(actTitle, expectedpage);
		
		driver.close();
//		if(actTitle.trim().equals(expectedpage)){
//            System.out.println(expectedpage +"page is verified ===PASS");
//		}else {
//			System.out.println(expectedpage +"page is  not verified ===FAIL");
//		}
		System.out.println(mtd.getName() +"Test End");
	}
	
	
	@Test
	
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() +"Test Start");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
		Assert.assertTrue(status);
//		if(status) {
//			System.out.println("Logo verified==PASS");
//		}else {
//			System.out.println("Logo is not verified==FAIL");
//		}
		driver.close();
		System.out.println(mtd.getName() +"Test End");
	}
	
}
