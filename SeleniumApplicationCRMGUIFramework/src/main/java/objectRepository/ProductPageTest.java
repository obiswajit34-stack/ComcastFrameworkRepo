package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageTest {
	
	//Create a constructor
		//And "this" is refer to current class object
	WebDriver driver;
	public  ProductPageTest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	//Declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproduct;
	
	//Getters
	public WebElement getCreateproduct() {
		return createproduct;
	}
}
