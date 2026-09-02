package create.Org.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.listenerutility.ListImpClass;

import baseClass.BaseClass2;
import genericUtility.UtilityClassObject;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass2 {

	@Test(groups ="smokeTest")
	public void createOrganizationTest() throws Throwable {

		
	UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		// read TestScript data from Excel file
		String orgName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();

		// step 2 : navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
//		hp.navigateToCampaignPage();

		// step 3 : click on "Create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Create Org page");
		OrganizationPage onp = new OrganizationPage(driver);
		onp.getCreateNewOrgBtn().click();

		// step 4 : Enter all the details and create an Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName +"======>Create a new Org");
		// verify Header message Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeadrMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " name is verified==PASS");
		} else {
			System.out.println(orgName + " name is not verified==FAIL");
		}

	}

	@Test(groups="regressionTest")
	public void createOrganizationWithIndustryTest() throws Throwable {
		// read TestScript data from Excel file
		String orgName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();
		String industry = elib.getDataFromExcel("Contact", 1, 3);
		String type = elib.getDataFromExcel("Contact", 4, 3);

		// step 2 : navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3 : click on "Create Organization" Button
		OrganizationPage onp = new OrganizationPage(driver);
		onp.getCreateNewOrgBtn().click();

		// step 4 : Enter all the details and create an Organization
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrg(orgName, industry, type);

		// Verify the industries and type info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actIndustries = oip.getIndustryName().getText().trim();
		if (actIndustries.equals(industry)) {
			System.out.println(industry + " information is verified==PASS");
		} else {
			System.out.println(industry + " information is not verified==FAIL");
		}

		String actType = oip.getTypeName().getText().trim();
		if (actType.equals(type)) {
			System.out.println(type + " information is verified==PASS");
		} else {
			System.out.println(type + " information is not verified==FAIL");
		}
	}

	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		String orgName = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();
		String phoneNumber = elib.getDataFromExcel("Contact", 7, 3);

		// step 2 : navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3 : click on "Create Organization" Button
		OrganizationPage onp = new OrganizationPage(driver);
		onp.getCreateNewOrgBtn().click();

		// step 4 : Enter all the details and create an Organization
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createOrg(orgName, phoneNumber);

		// Verify PhoneNumber Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhoneNo = oip.getPhoneNo().getText().trim();
		if (actPhoneNo.equals(phoneNumber)) {
			System.out.println(phoneNumber + " information is verified==PASS");
		} else {
			System.out.println(phoneNumber + " information is not verified==FAIL");
		}

	}
}