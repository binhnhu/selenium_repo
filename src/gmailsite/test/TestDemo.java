package gmailsite.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import gmailsite.action.WebDriverAction;
import gmailsite.page.GeneralPage;
import gmailsite.page.SignInPage;

public class TestDemo {
	
	WebDriver driver;
	GeneralPage generalPage;
	SignInPage signInPage;
	
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		generalPage = new GeneralPage(driver);
		signInPage = new SignInPage(driver);
	}
	
	@AfterTest
	public void end(){
		driver.close();
	}
	
	@Test
	public void test(){
		generalPage.openGmail();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generalPage.navigateToSigninPage();
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
