package risecodes.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import risecodes.constant.Constant;
import risecodes.elementrepository.LoginPage;
import risecodes.elementrepository.ProductsPage;
import risecodes.elementrepository.YourCartPage;
import risecodes.utilities.ExcelUtility;

public class ProductPageTestCase extends BaseClass {
	
	LoginPage lp;
	ProductsPage pp;
	YourCartPage yp;
	ExcelUtility read;
	
  @Test(dataProvider="login", dataProviderClass=testDataProvider.class)
  public void testCase01VerifyThreeItemsSelectedRandomly(String username, String password) {
	  
	  lp = new LoginPage(driver);
	  read = new ExcelUtility();
	  
	  lp.enterUserName(username);
	  lp.enterPassword(password);
	  lp.clickLoginButton();
	  
	  pp = new ProductsPage(driver);
	  
	  pp.selectThreeItemsRandomly();
	  pp.clickOnCartLink();
	  
	  yp = new YourCartPage(driver);
	  int expected = 3;
	  int actual =  yp.getCartListCount();
	 
	  Assert.assertEquals(actual, expected, Constant.ASSERT_MESSAGE);
	  
  }
  
  
}
