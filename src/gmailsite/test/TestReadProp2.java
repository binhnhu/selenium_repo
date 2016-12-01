package gmailsite.test;

import org.openqa.selenium.firefox.FirefoxDriver;

import gmailsite.action.WebDriverAction;

public class TestReadProp2 {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		WebDriverAction action = new WebDriverAction(driver);
		
		String a = action.getPropertiesFileValue("StorefrontUrl");
		
		System.out.println(a);
		

	}

}
