package practice.contact.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass2;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;
/**
 * @author obisw
 */
public class CreateContactTest3 extends BaseClass2 {

	@Test(groups = "smokeTest")
	public void CreatContactTest3() throws IOException, InterruptedException {

		// ExcelUtility
		String lastName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();

		// Navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// click on create contact button
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
//	ccp.createContactWithOrg(lastName, lastName);////######################
		ccp.getLstName().sendKeys(lastName);
		ccp.getSaveBtn().click();

//###		
		String actHeader = cp.getHeaderMsg().getText();

		boolean status = actHeader.contains(lastName);
		Assert.assertTrue(status);
//##	
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();
//		if (actLastName.equals(lastName)) {
//			System.out.println(lastName + " information ====Pass");
//		} else {
//			System.out.println(lastName + " information =======fail");
//		}

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
		String lastName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();

		// step 2 : navigate to Contact module
		// Navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		// Step 4 : enter all the details & create new Contact
		String endDate = jlib.getRequiredDate(30);
		String startDate = jlib.generateCurrentDate();
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		// verify Header phone number info Expected Result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + "information is verified==PASS");
		} else {
			System.out.println(startDate + "information is not verified==FAIL");
		}

		// dtlview_Support End Date
		String actendDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actendDate.equals(endDate)) {
			System.out.println(endDate + "information is verified==PASS");
		} else {
			System.out.println(endDate + "information is not verified==FAIL");
		}

	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		String orgName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();
		String contactLastName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String headerInfo = oip.getHeadrMsg().getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "is created==PASS");
		} else {
			System.out.println(orgName + "is not created==FAIL");
		}

		hp.getContactLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithOrg(contactLastName, orgName);

		ContactInfoPage cip = new ContactInfoPage(driver);
		headerInfo = cip.getHeaderInfo().getText();
		if (headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName + "is created==PASS");
		} else {
			System.out.println(contactLastName + "is not created==FAIL");
		}

		String actOrgName = cip.getOrgName().getText().trim();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + "is created==PASS");
		} else {
			System.out.println(orgName + "is not created==FAIL");
		}

	}

}
