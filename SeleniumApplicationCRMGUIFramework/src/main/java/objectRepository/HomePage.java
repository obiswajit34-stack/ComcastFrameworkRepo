package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//Initialize
	
	//Create a constructor
	//And "this" is refer to current class object
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Declaration
	@FindBy (linkText ="Organizations")
	private WebElement orgLink;
	
	@FindBy (linkText ="Contacts")
	private WebElement contactLink;
	
	@FindBy (linkText="Campaigns")
	private WebElement capmignLink;
	
	@FindBy (linkText ="More")
	private WebElement moreLink;

	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	
	//getter method //provide single element access means single action
	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getCapmignLink() {
		return capmignLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public  WebElement getProductLink() {
		return productLink;
	}
	
	public  WebElement getEmailLink() {
		return emailLink;
	}
	



//Business  method  => provide multiple action
	public void navigateToCampaignPage() {
		Actions act = new Actions(driver);
		
		act.moveToElement(moreLink).perform();
		capmignLink.click();
	}
	

	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLink.click();
	}
	
	
	
	
}
