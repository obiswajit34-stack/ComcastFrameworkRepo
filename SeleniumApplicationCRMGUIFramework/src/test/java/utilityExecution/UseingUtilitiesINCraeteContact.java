package utilityExecution;



import java.io.IOException;

import java.time.Duration;



import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtility;

public class UseingUtilitiesINCraeteContact {
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
	//Utility classes
	PropertyFile flib = new PropertyFile();
	ExcelUtility elib =new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();

	
	//Read data from PropertyFile
	String URL = flib.getDatafromPropertyFile("url");
	
	String USERNAME =flib.getDatafromPropertyFile("username");
	
	String PASSWORD = flib.getDatafromPropertyFile("password");
   
	//ExcelUtility
		String lastName = elib.getDataFromExcel("Contact", 1, 2)+jlib.generateRandomNumber();
//        System.out.println(BROWSER);
//        System.out.println(URL);
//        System.out.println(USERNAME);
//        System.out.println(PASSWORD);
		
		
		
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Application
        driver.get(URL);

        // Login
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);

        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

        driver.findElement(By.id("submitButton")).click();

        // Create Organization
        driver.findElement(By.linkText("Contacts")).click();

        driver.findElement(
                By.xpath("//img[@title='Create Contact...']")
        ).click();

        Thread.sleep(1000);
        
        //JavaUtility class
       String startDate = jlib.generateCurrentDate();
     String endDate = jlib.generateSpecificDate(startDate, 30);
      
      
      driver.findElement(By.name("lastname"))
      .sendKeys(lastName);
        Thread.sleep(1000);
        driver.findElement(By.name("support_start_date")).clear();
        driver.findElement(By.name("support_start_date")).sendKeys(startDate);
        
        driver.findElement(By.name("support_end_date")).clear();
        driver.findElement(By.name("support_end_date")).sendKeys(endDate);
       
        driver.findElement(By.xpath("//input[@value='T']")).click();
        // Save
        driver.findElement(
                By.xpath("//input[@class='crmButton small save']")
        ).click();
        
        //Verify Header phone number info Expected Result
        String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	       if(actLastName.equals(lastName)) {
	    	   System.out.println(lastName +" information ====Pass");
	       }else {
	    	   System.out.println(lastName +" information =======fail");
	       }
        Thread.sleep(2000);
        //Take the ScreenShot of the Page using WebDriver Utility
       wlib.takeScreenshot(driver, "./Screenshot/vtiger.png");
		
		 Thread.sleep(2000);
		
        // Close browser
        driver.quit();
    }
}

