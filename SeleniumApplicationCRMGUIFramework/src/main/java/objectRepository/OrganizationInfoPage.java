package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	//Initialize
	
		//Create a constructor
		//And "this" is refer to current class object
		WebDriver driver;
		public OrganizationInfoPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
	//Declaration	
	@FindBy(className ="dvHeaderText")
	private WebElement headrMsg;
	
	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement industryName;

	@FindBy(xpath = "//span[@id='dtlview_Type']")
	private WebElement typeName;

	@FindBy(xpath = "//span[@id='dtlview_Phone']")
	private WebElement phoneNo;

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getTypeName() {
		return typeName;
	}

	//getters
	 public WebElement getHeadrMsg() {
		 return headrMsg;
	 }
	
	
	
	
}
