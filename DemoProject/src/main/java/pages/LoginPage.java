package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="loginform-username")WebElement username;
	@FindBy(id="loginform-password")WebElement password;
	@FindBy(xpath = "//button[@type='submit']")WebElement submit;
	@FindBy(xpath="//a[@href='/payrollapp/client/index']")WebElement home;
	@FindBy(xpath="//h1[text()='Login']")WebElement loginpage;
	
	public void enterUserNameField(String usernamefield)
	{
		username.sendKeys(usernamefield);
		
	}
	public void enterPasswordField(String passwordfield)
	{
		password.sendKeys(passwordfield);
		
	}
	
	public void loginButton()
	{
		submit.click();
	}
	public boolean isHomepageisloaded()
	{
		return home.isDisplayed();//checking assertion
		
	}
	
	public boolean isLoginpageloaded()
	{
		return loginpage.isDisplayed();
	}

}
