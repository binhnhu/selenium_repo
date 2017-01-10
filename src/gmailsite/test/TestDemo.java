package gmailsite.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gmailsite.action.WebDriverAction;
import gmailsite.object.Account;
import gmailsite.page.ComposeEmailPage;
//import gmailsite.action.WebDriverAction;
import gmailsite.page.GeneralPage;
import gmailsite.page.InboxPage;
import gmailsite.page.SignInPage;

public class TestDemo {
	
	WebDriver driver;
	GeneralPage generalPage;
	SignInPage signInPage;
	InboxPage inboxPage;
	ComposeEmailPage composeEmailPage;
	Account account;
	WebDriverAction action;
	WebDriverWait myWaitVar;
	
	String strShortWait = null;
	String strUsername = null;
	String strPassword = null;
	String strStaySignedIn = "No";
	
	String timeStamp;
	String emailSubject;
	String emailContent;
	String recipient = "binh.seleniumtesting@gmail.com";
	
	int waitTimeMilliseconds = 100000;
	
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		generalPage = new GeneralPage(driver);
		signInPage = new SignInPage(driver);
		inboxPage = new InboxPage(driver);
		composeEmailPage = new ComposeEmailPage(driver);
		action = new WebDriverAction(driver);
		myWaitVar = new WebDriverWait(driver, waitTimeMilliseconds);
		
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
		
		timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
		emailSubject = "Email Subject " + timeStamp;
		emailContent = "Email Content " + timeStamp;

	}
	
//	@AfterTest
//	public void end(){
//		driver.close();
//	}
	
	@Test
	public void test() throws InterruptedException{
		
		generalPage.openGmail();
		generalPage.navigateToSigninPage();
		signInPage.SignIn(account.getUsername(), account.getPassword(), account.getStaySignedInOption());
		inboxPage.clickOnComposeButton(myWaitVar);
		composeEmailPage.composeEmail(recipient, emailSubject, emailContent, "yes");
			
		
	}

//	emailSubjectLocator = "xpath=//table[@class="F cf zt"]//tr[1]//td[@class="xY a4W"]//b";
	
}
