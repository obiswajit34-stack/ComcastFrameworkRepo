package javabasics;

import baseClass.BaseClass2;
import objectRepository.Loginpage;



/**
 * test class for contact module
 * @author obisw
 */
public class SearchContactTest extends BaseClass2 {

	public void searchcontactTest() {
		/*Step : 1 :Login to App*/
		Loginpage lp = new Loginpage(driver);
		lp.loginToapp("url", "username", "password");
		
	}
	
	
}
