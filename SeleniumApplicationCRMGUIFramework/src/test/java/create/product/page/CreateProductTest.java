package create.product.page;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import baseClass.BaseClass2;
import objectRepository.HomePage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductPageTest;

public class CreateProductTest extends BaseClass2 {

	
	@Test
	public void CreateProductTest() throws EncryptedDocumentException, IOException {
		// read TestScript data from Excel file
		String product = elib.getDataFromExcel("Contact", 1, 2) + jlib.generateRandomNumber();
		
		// Step 2: navigate to Opportunities Page
				HomePage hp = new HomePage(driver);
				hp.getProductLink().click();
				
				//Step 3: Click on Create Product link
				ProductPageTest pp=new ProductPageTest(driver);
				pp.getCreateproduct().click();
				
				//Step 4: Fill all the valid detail in product module
				ProductInfoPage pi= new ProductInfoPage(driver);
				pi.getProductName().sendKeys(product);
				pi.getSaveBtn().click();
				
				String actProduct = pi.getHeadrMsg().getText().trim();
				System.out.println("Expected Opportunity Name : " +product );
				System.out.println("Actual Opportunity Name   : " + actProduct);
				if (actProduct.equals(product)) {
					System.out.println(product + " name is verified==PASS");
				} else {
					System.out.println(product + " name is not verified==FAIL");
				}
			}
}
