package gmailsite.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import gmailsite.page.InboxPage;;

public class ComposeEmailPage extends GeneralPage{

	InboxPage inboxPage = new InboxPage(driver);
	
	public ComposeEmailPage(WebDriver driver) {
		super(driver);
	}
	
	private String txtRecipientsLocator = "xpath=//div[@class='oL aDm']";
	private String txtToLocator = "xpath=//textarea[@name='to']";
//	private String lnkCCLocator = "id=:6a";
//	private String lnkBCCLocator = "id=:69";
//	private String txtCCLocator = "id=:9d";
//	private String txtBCCLocator = "id=:9e";
	private String txtSubjectLocator = "xpath=//input[@name='subjectbox']";
	private String txtComposeEmailLocator = "xpath=//div[@aria-label='Message Body']";
	private String btnSendLocator = "xpath=//div[@aria-label='Send ‪(Ctrl-Enter)‬']";
	private String btnDiscardLocator = "xpath=//div[@class='og T-I-J3']";
	
	public void composeEmail(String recipient, String subject, String content, String sendOptions){
		//click(txtRecipientsLocator);
		enter(txtToLocator, recipient);
		enter(txtSubjectLocator, subject);
		enter(txtComposeEmailLocator, content);
		String sendOption = sendOptions.toLowerCase();
		
		switch (sendOption) {
		case "yes":
			click(btnSendLocator);
			break;
			
		case "no":
			click(btnDiscardLocator);
			break;
	
		default:
			break;
		}
	
	}

}
