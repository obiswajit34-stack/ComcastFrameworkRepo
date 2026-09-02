package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {

	

	//Initialize
	
	//Create a constructor
	//And "this" is refer to current class object
	WebDriver driver;
	public OpportunitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Declaration
	@FindBy(xpath ="//img[@title='Create Opportunity...']")
	private WebElement createOpportinities;
	
	
	
	
	//Getters
	public WebElement getCreateOpportinities() {
		return createOpportinities;
	}
}
