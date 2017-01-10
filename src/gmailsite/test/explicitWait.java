package gmailsite.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import gmailsite.action.WebDriverAction;

public class explicitWait{
	
	WebDriver driver = new FirefoxDriver();
	//private String btnSignInLocator = "id=signIn";
	
	WebDriverAction action = new WebDriverAction(driver);
	String btnComposeLocator = "xpath=//a[contains(@class,'sign-in')]";
	
	@Test
	public void test1(){
		driver.get("https://www.google.com/gmail/about/");
		
//		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'sign-in')]")));
//		//WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(By.xpath("//a[contains(@class,'sign-in')]")));
//		
//		//driver.findElement(By.xpath("//a[contains(@class,'sign-in')]")).click();
//		myDynamicElement.click();
		
		
		
		WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
		myWaitVar.until(ExpectedConditions.elementToBeClickable(action.getElement(btnComposeLocator)));
		
		action.click(btnComposeLocator);

		
		
	}
	

}
