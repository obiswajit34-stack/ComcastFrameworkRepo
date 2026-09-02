package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
	//Initialize
	
			//Create a constructor
			//And "this" is refer to current class object
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name ="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNoEdt;
	
	//getters
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDD() {
		return industryDD;
	}
	
	public WebElement getPhoneEdt() {
		return phoneNoEdt;
	}
	
	
	public void createOrg(String  orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String  orgName, String industry ,String type) {
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(typeDD);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
	
	public void createOrg(String orgName , String phNO) {
		orgNameEdt.sendKeys(orgName);
		phoneNoEdt.sendKeys(phNO);
		saveBtn.click();
	}
	
	
}
