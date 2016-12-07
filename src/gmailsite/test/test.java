package gmailsite.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {
	
	WebDriver driver = new FirefoxDriver();
	
	@Test
	public void test1(){
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
		
		driver.findElement(By.id("Email")).sendKeys("aadd");
		
	}
	

}
