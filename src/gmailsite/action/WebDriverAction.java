package gmailsite.action;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverAction {
	public Logger log = Logger.getLogger("Logger");
	WebDriver driver = null;
	
	public WebDriverAction(WebDriver driver) {
		//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		this.driver = driver;
	}
	
	private By defineElement(String locator){
		By by = null;
		
		if (locator.startsWith("id=")){
			by = By.id(locator.substring(3));
		} else if(locator.startsWith("name=")){
			by = By.name(locator.substring(5));
		} else if (locator.startsWith("css=")){
			by = By.cssSelector(locator.substring(4));
		} else if (locator.startsWith("link=")){
			by = By.linkText(locator.substring(5));
		} else if (locator.startsWith("xpath=")){
			by = By.xpath(locator.substring(6));
		} else {
			log.debug("[info] Executing: | [>> ERROR <<] Format locators are supported by:\n * id\n * name\n * css\n * link\n * xpath |\n");
		}
		return by;
	}
	
	private WebElement getElement(String locator){
		return driver.findElement(defineElement(locator));
	}
	
	public void click(String locator){
		try{
			log.debug("[info] Executing: | Click | " + locator + " |");
			getElement(locator).click();
		} catch (Exception e){
			log.debug("[info] Executing: | [>> ERROR <<] " + locator + " not found to click | " + e.getMessage());
		}
	}
	
	public void sendKeys(String locator, String value){
		try{
			log.debug("[info] Executing: | SendKeys | " + locator + " | " + value + " |");
			getElement(locator).sendKeys(value);
		} catch (Exception e){
			log.debug("[info] Executing: | [>> ERROR <<] " + locator + " not found to sendKeys | " + e.getMessage());
		}
	}
	
	public String getText(String locator){
		String result = "";
		try{
			log.debug("[info] Executing: | Get Text from: " + locator + " |");
			result = getElement(locator).getText();
		} catch (Exception e){
			log.debug("[info] Executing: | [>> ERROR <<] " + locator + " not found to getText | " + e.getMessage());
		}
		return result;
	}
	
	public void closeBrowser(){
		log.debug("[info] Executing: | Close browser");
		driver.close();
	}
	
	public void open(String url){
		log.debug("[info] Executing: | Open URL: " + url + " |");
		driver.get(url);
	}

}
