package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	//Constructor
	WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	//Declaration
	@FindBy(name ="productname")
	public WebElement productName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	public WebElement saveBtn;
	
	//Declaration	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headrMsg;
	
	
	//Getters
	 public WebElement getHeadrMsg() {
		 return headrMsg;
	 }
	//Getters
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
