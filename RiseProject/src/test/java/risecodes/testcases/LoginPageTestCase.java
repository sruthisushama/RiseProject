package risecodes.testcases;

import org.testng.annotations.Test;

import risecodes.constant.Constant;
import risecodes.elementrepository.LoginPage;
import risecodes.elementrepository.ProductsPage;

import org.testng.Assert;

public class LoginPageTestCase extends BaseClass {
	
	LoginPage lp;
	ProductsPage pp;
	
  @Test(dataProvider="login", dataProviderClass=testDataProvider.class)
  public void testCase01VerifyLoginFunctionality(String username, String password) {
	  
	  lp = new LoginPage(driver);
	  
	  lp.enterUserName(username);
	  lp.enterPassword(password);
	  
	  String url1 = lp.getCurrentPageUrl();
	  lp.clickLoginButton();
	  String url2 = lp.getCurrentPageUrl();
	  
	  String expected; 
	  String actual ;
	  if(!url1.equals(url2))
	  {
		  pp = new ProductsPage(driver);
		   expected = "PRODUCTS";
		   actual = pp.getPageTitle() ;
	  }
	  else
	  {
		   expected = "Epic sadface: Sorry, this user has been locked out.";
		   actual = lp.lockedUserMessage();
	  }
	  
	 Assert.assertEquals(actual, expected, Constant.ASSERT_MESSAGE);

  }
}
