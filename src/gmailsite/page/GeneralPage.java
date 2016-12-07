package gmailsite.page;

import org.openqa.selenium.WebDriver;

import gmailsite.action.WebDriverAction;

public class GeneralPage extends WebDriverAction{
	protected WebDriver driver;
	private String btnSignInElementXPath = "//a[contains(@class,'sign-in')]";
	private String storefrontUrlvalue = "Url";
	
	public GeneralPage(WebDriver driver){
		super(driver);
	}

	public void openGmail(){
		open(getPropertiesFileValue(storefrontUrlvalue));
	}
	
	public SignInPage navigateToSigninPage(){
		click("xpath=" + btnSignInElementXPath);
		return new SignInPage(driver);
	}
}
