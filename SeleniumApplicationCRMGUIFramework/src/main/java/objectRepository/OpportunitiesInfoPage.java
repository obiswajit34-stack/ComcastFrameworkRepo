package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpportunitiesInfoPage {

	// Initialize

	// Create a constructor
	// And "this" is refer to current class object
	WebDriver driver;

	public OpportunitiesInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(name="potentialname")
	private WebElement createOpporName;
	
	@FindBy(xpath="(//img[@align='absmiddle'])[3]")
	private WebElement relatedTo;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	
		
	//Getters
	public WebElement getCreateOpporName() {
		return createOpporName;
	}
	
	public WebElement getRelatedTo() {
		return relatedTo;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	
//	public void createOrg(String  orgName, String industry ,String type) {
//		orgNameEdt.sendKeys(orgName);
//		Select sel = new Select(industryDD);
//		sel.selectByVisibleText(industry);
//		Select sel1=new Select(typeDD);
//		sel1.selectByVisibleText(type);
//		saveBtn.click();
//	}
	
	
//	public void createOpportunities(String opporName) {
//		createOpporName.sendKeys(opporName);
//		
//	}
	
//	public void createOpportunities(String opporName ) {
//		createOpporName.sendKeys(opporName);
//		
//	}
}
