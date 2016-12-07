package gmailsite.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gmailsite.object.Account;
//import gmailsite.action.WebDriverAction;
import gmailsite.page.GeneralPage;
import gmailsite.page.SignInPage;

public class TestDemo {
	
	WebDriver driver;
	GeneralPage generalPage;
	SignInPage signInPage;
	Account account;
	
	String strShortWait = null;
	String strUsername = null;
	String strPassword = null;
	String strStaySignedIn = "No";
	
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		generalPage = new GeneralPage(driver);
		signInPage = new SignInPage(driver);
		
		strShortWait = generalPage.getPropertiesFileValue("shortWait");
		int iShortWait = Integer.parseInt(strShortWait);
		strUsername = generalPage.getPropertiesFileValue("username");
		strPassword = generalPage.getPropertiesFileValue("password");
		
		driver.manage().timeouts().implicitlyWait(iShortWait, TimeUnit.SECONDS);
		account = new Account.Builder()
				.username(strUsername)
				.password(strPassword)
				.staySignedInOption(strStaySignedIn)
				.build();
	}
	
//	@AfterTest
//	public void end(){
//		driver.close();
//	}
	
	@Test
	public void test(){
		generalPage.openGmail();
		generalPage.navigateToSigninPage();
		signInPage.SignIn(account.getUsername(), account.getPassword(), account.getStaySignedInOption());
	}
	
	
	
	

//	public static void main(String [] agrs) throws Exception{
//		WebDriver driver = new FirefoxDriver();
//			
//		WebDriverAction myAction = new WebDriverAction(driver);
//		
//		myAction.open("http://google.com");
//		//myAction.click("xpath=//input[@name='btnI']");
//		myAction.click("name=btnIlll");
//	}
}
