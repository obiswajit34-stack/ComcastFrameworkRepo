package objectRepository;

/**
 * @author obisw
 * 
 * Contains Login page elements & business lib like login()
 * 
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class Loginpage extends WebDriverUtility {            //Rule -1 create a separate java class
          
	                              //rule 2 Object Creation
	 public WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements( driver, this );//this => is refer to current class object
	}
	//Declaration
		@FindBy(name="user_name")
		private WebElement usernameTextField;
		
		@FindBy (xpath="//input[@type='password']")
		private WebElement passwordTextField;
		
		@FindBy(id="submitButton")
		 private WebElement loginButton;
		                //rule 3: Object Initialization
		
		
	
		
		//Rule 4: Object Encapsulation
		public WebElement getUsernameTextField() {
			return usernameTextField;
		}

		public WebElement getPasswordTextField() {
			return passwordTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		/**
		 * login to app based on Un , password,url
		 * @param url
		 * @param username
		 * @param password
		 */
		//Rule 5: Provide action
		public void loginToapp( String url ,String  username, String password) {
			genericWait(driver);
			driver.get(url);
			driver.manage().window().maximize();
			usernameTextField.sendKeys(username);
			passwordTextField.sendKeys(password);
			loginButton.click();
		}
}
