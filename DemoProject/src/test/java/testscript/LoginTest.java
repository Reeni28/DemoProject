package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base{
	//setting data provider
	@DataProvider(name="Credentials")
	public Object[][] testData()
	{
		Object data[][]= {{"carol","1q2w3e4r"},{"Reeni","1234"},{"Jan","gytyt"}};
		return data;
	}
	//test using data provider
  @Test(dataProvider = "Credentials" )
  public void verifyUserLoginWithValidCredentials(String username,String password) {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameField(username);
	  login.enterPasswordField(password);
	  login.loginButton();
	  
	  boolean homepageisloaded=login.isHomepageisloaded();
	  Assert.assertTrue(homepageisloaded,"Invalid credentials");
	  
	
	  
  }
  //Checking through xml file,values passing through xml file
  @Test
  @Parameters({"username","password"})
  public void verifyValidUserInvalidPassword(String username,String password)
  {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameField(username);
	  login.enterPasswordField(password);
	  login.loginButton();
	  
	  boolean loginpageisloaded=login.isLoginpageloaded();
	  Assert.assertTrue(loginpageisloaded,"Login page should not redirect to home page");
  }
  @Test
  public void verifyinvalidUserInvalidPassword()
  {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameField("Reeni");
	  login.enterPasswordField("123456");
	  login.loginButton();
	  
	  boolean loginpageisloaded=login.isLoginpageloaded();
	  
	  Assert.assertTrue(loginpageisloaded,"Login page should not redirect to home page");
  }
}
