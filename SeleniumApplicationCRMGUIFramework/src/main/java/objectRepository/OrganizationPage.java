package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {      
	

	
	//Initialize
	
	//Create a constructor
	//And "this" is refer to current class object
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath ="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindBy(name ="search_text")
	private WebElement searchEdt;
	
	@FindBy(name ="search_field")
	private WebElement searchDD;
	
	
	@FindBy(xpath="(//input[@class='crmbutton small create'])[1]")
	private WebElement searchBtn;
	

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
}
