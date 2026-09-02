package pomExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithOutPOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888/");
		
		WebElement el1 = driver.findElement(By.name("user_name"));
		
		WebElement el2 = driver.findElement(By.xpath("//input[@type='password']"));
		
		WebElement el3 = driver.findElement(By.id("submitButton"));
		
		el1.sendKeys("admin");
		el2.sendKeys("admin");
		
		driver.navigate().refresh();
		
		el1.sendKeys("admin");
		el2.sendKeys("admin");
		
		el3.click();
		
	}
}
