package gmailsite.page;

import org.openqa.selenium.WebDriver;

import gmailsite.action.WebDriverAction;

public class GeneralPage extends WebDriverAction{
	protected WebDriver driver;
	private String btnSignInElementXPath = "//a[contains(@class,'sign-in')]";
	
	public GeneralPage(WebDriver driver){
		super(driver);
	}

	public void openGmail(){
		open("https://www.google.com/gmail/about/");
	}
	
	public SignInPage navigateToSigninPage(){
		click("xpath=" + btnSignInElementXPath);
		return new SignInPage(driver);
	}
}
