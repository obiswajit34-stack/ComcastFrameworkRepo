package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom2 {

	//Declaration
	@FindBy(name="user_name")
	 WebElement ele1;
	
	@FindBy (xpath="//input[@type='password']")
	WebElement ele2;
	
	//any of this condition satisfy it give the result
	//if both the condition is not satisfy it give "No such Element Exception"
	@FindAll({@FindBy (id="sub"), @FindBy (xpath ="//input[@type='submit']")})
	 private WebElement ele3;
	
	
	
	
	
	//initialization
	 
//	public SampleTestWithPom(WebDriver driver)
//	{
//		PageFactory.initElements( driver , this);
//	}

//	public WebElement getEle1() {
//		return ele1;
//	}
//
//	public WebElement getEle2() {
//		return ele2;
//	}
//
//	public WebElement getEle3() {
//		return ele3;
//	}
	
	@Test
	
	public void smapleTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		SampleTestWithPom2 s = PageFactory.initElements(driver, SampleTestWithPom2.class);
		
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		
		driver.navigate().refresh();
		
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("admin");
		
		s.ele3.click();

	}
	
	
	
	
}
