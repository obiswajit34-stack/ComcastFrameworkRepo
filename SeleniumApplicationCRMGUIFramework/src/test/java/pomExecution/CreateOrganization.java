package pomExecution;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFile;
import genericUtility.WebDriverUtility;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.Loginpage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrganization {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		PropertyFile flib = new PropertyFile();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Read data from PropertyFile
		String URL = flib.getDatafromPropertyFile("url");

		String USERNAME = flib.getDatafromPropertyFile("username");

		String PASSWORD = flib.getDatafromPropertyFile("password");

		// ExcelUtility
		String orgName = elib.getDataFromExcel("Sheet2", 1, 2) + jlib.generateRandomNumber();
//        System.out.println(BROWSER);
//        System.out.println(URL);
//        System.out.println(USERNAME);
//        System.out.println(PASSWORD);

		// step 1 :Login to app
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

		Loginpage lp = new Loginpage(driver);

		// when i use loginpage all the element public and we are not using getter
		// method that time we can use this
//	lp.usernameTextField.sendKeys("admin");
//	lp.passwordTextField.sendKeys("admin");
//	lp.loginButton.click();

		// element is private and using getter method
//	lp.getUsernameTextField().sendKeys("admin");
//	lp.getPasswordTextField().sendKeys("admin");
//	lp.getLoginButton().click();

		// Using Method
		//lp.loginToapp("admin", "admin");#########################

		// step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3 : click on "create organization " Button
		OrganizationPage orgp = new OrganizationPage(driver);
		orgp.getCreateNewOrgBtn().click();

		// Step 4 : enter all the details & create new Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeadrMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "name is Verified ==pass");
		} else {
			System.out.println(orgName + "name is not verified ==fail");
		}

		// go back to Organization page

		hp.getOrgLink().click();
		// search for Organization
		orgp.getSearchEdt().sendKeys(orgName);
		wlib.selectByVisibleText(orgp.getSearchDD(), "Organization Name");

		orgp.getSearchBtn().click();

		// in pom we can't store dynamic element to handling dynamic element we have to
		// use findelement
		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();

		wlib.switchToAlert(driver);

		// In dynamic WebTable select & delete org

		// step 5:Logout
		hp.logout();

		driver.quit();
	}
}
