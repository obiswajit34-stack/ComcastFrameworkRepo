package practice_datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assignmenet1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//step1: create an object for fileinputStraem class
		FileInputStream fis = new FileInputStream("./src/test/resources/commondataForVtiger.properties");
		
		//step2: create object for properties class
		
		Properties prop = new Properties();
		//step3:call load () and fis reference
		prop.load(fis);
		
		//step4: read data with the help of getProperty() | call getProperty and pass key
		String URL=prop.getProperty("url");
		
		String USERNAME =prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		String ORG = prop.getProperty("org");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
            driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		Thread.sleep(1000);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(2000);
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORG);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='TekPyramid']")).isDisplayed();
		
		Thread.sleep(1000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File temp = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screenshot/vtiger.png");
		
		FileHandler.copy(temp, dest);
		
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
	}
}
