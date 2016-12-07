package gmailsite.page;

import org.openqa.selenium.WebDriver;

public class SignInPage extends GeneralPage{
	
	private String txtEmailLocator = "id=Email";
	private String txtPasswordLocator = "id=Passwd";
	private String btnNextLocator = "id=next";
	private String btnSignInLocator = "id=signIn";
	private String chkStaySignedInLocator = "id=PersistentCookie";

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void SignIn(String username, String password, String staySignedIn){
		
		enter(txtEmailLocator, username);
		click(btnNextLocator);
		enter(txtPasswordLocator, password);
		if(staySignedIn != null){
			if((staySignedIn.toLowerCase() == "yes" && getElement(chkStaySignedInLocator).isSelected() == false) || (staySignedIn.toLowerCase() == "no" && getElement(chkStaySignedInLocator).isSelected() == true) ){
				click(chkStaySignedInLocator);
			}
		}
		click(btnSignInLocator);
		
		
	}
	
	

	
}
