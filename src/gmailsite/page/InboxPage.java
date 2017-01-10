package gmailsite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends GeneralPage{

	public InboxPage(WebDriver driver) {
		super(driver);
	}
	
	private String btnComposeLocator = "xpath=//div[contains(@class,'T-I J-J5-Ji T-I-KE L3')]";
	
	public ComposeEmailPage clickOnComposeButton(WebDriverWait myWaitVar){
		myWaitVar.until(ExpectedConditions.elementToBeClickable(getElement(btnComposeLocator)));
		log.debug("[info] Executing: | Click Compose button |");
		click(btnComposeLocator);
		return new ComposeEmailPage(driver);
	}

	
}
