package practice.Opportunities.Test;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseClass.BaseClass2;
import objectRepository.HomePage;
import objectRepository.OpportunitiesInfoPage;
import objectRepository.OpportunitiesPage;
import objectRepository.OpportunitiesVerify;

public class CreateOpportunitiesTest extends BaseClass2 {

	@Test
	public void createOpportunities() throws EncryptedDocumentException, IOException {
		// read TestScript data from Excel file
		String opporName = elib.getDataFromExcel("Contact", 10, 2) + jlib.generateRandomNumber();
		String relate = elib.getDataFromExcel("Contact", 1, 2);
		// Step 2: navigate to Opportunities Page
		HomePage hp = new HomePage(driver);
		hp.getOpportunitiesLink().click();

		// Step 3: Click on "Create Opportunities" Button
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getCreateOpportinities().click();

		// step 4 : Enter all the details and create an Opportunities

		OpportunitiesInfoPage opin = new OpportunitiesInfoPage(driver);
		opin.getCreateOpporName().sendKeys(opporName);

		// Step 5: Click Related To
		String parentWindow = driver.getWindowHandle();
		opin.getRelatedTo().click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		// Step 7: Select the related record
		driver.findElement(By.linkText(relate)).click();

		// Step 8: Switch back to parent window
		driver.switchTo().window(parentWindow);

		// Step 9: Click Save
		opin.getSaveBtn().click();

//		
		OpportunitiesVerify opv = new OpportunitiesVerify(driver);

		String actOpport = opv.getHeadrMsg().getText().trim();
		System.out.println("Expected Opportunity Name : " + opporName);
		System.out.println("Actual Opportunity Name   : " + actOpport);
		if (actOpport.equals(opporName)) {
			System.out.println(opporName + " name is verified==PASS");
		} else {
			System.out.println(opporName + " name is not verified==FAIL");
		}
	}

}
