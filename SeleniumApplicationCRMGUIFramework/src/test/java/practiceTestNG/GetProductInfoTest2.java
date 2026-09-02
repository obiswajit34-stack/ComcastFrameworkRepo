package practiceTestNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;

public class GetProductInfoTest2 {

	@Test(dataProvider ="getData")
	public void getProductInfoTest2(String brandName , String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.com");
		
		
		//search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName ,Keys.ENTER);
		
		//Scroll to Element
//		Actions ac = new Actions(driver);
//		ac.scrollByAmount(0, 200);
//		
		
	//capture product info
		String x = "//span[text()='"+productName+"']/../../../../div[4]/div/div/div/div/div/a//span/span[2]/span[2]";
		String price =driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility elib = new ExcelUtility();
		int rowCount = elib.getRowcount("Sheet3");
		System.out.println(rowCount);
		
		Object [][]objArr = new Object[rowCount][2];
		for(int i=0;i<rowCount ;i++) {
			objArr[i][0]=elib.getDataFromExcel("Sheet3", i+1, 0);
			objArr[i][1]=elib.getDataFromExcel("Sheet3", i+1, 1);
		}
	
		return objArr;
		
	}
}
