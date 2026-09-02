package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesVerify {

	
	//Initialize
	
			//Create a constructor
			//And "this" is refer to current class object
			WebDriver driver;
			public OpportunitiesVerify(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
			//Declaration	
			@FindBy(className ="dvHeaderText")
			private WebElement headrMsg;
			
			
			//Getters
			 public WebElement getHeadrMsg() {
				 return headrMsg;
			 }
			
}
