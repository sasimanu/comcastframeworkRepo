package practice.test;
/**
 * test class for contact module
 * @author sasi
 *
 */

import org.testng.annotations.Test;

import com.comcast.crm.baseclasstest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.LoginPage;


public class SearchcontactTest extends BaseClass {
	/**
	 * login()==>navigate contact==>create contact ==>verify
	 */
	@Test
	public void searchcontactTest() {
		/*step 1 :login to app*/
		LoginPage lp =new LoginPage(driver);
		lp.loginToApp("url", "username", "Password");
	}

}
