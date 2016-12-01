package gmailsite.test;

import org.openqa.selenium.firefox.FirefoxDriver;

import gmailsite.action.WebDriverAction;
import gmailsite.object.Account;

public class TestReadProp2 {

	public static void main(String[] args) {
		
//		FirefoxDriver driver = new FirefoxDriver();
//		WebDriverAction action = new WebDriverAction(driver);
//		
//		String a = action.getPropertiesFileValue("StorefrontUrl");
//		
//		System.out.println(a);
		
		Account account = new Account.Builder()
				.username("Binh Nhu")
				.password("abc")
				.staySignedInOption("Yes")
				.build();
		
		System.out.println(account.getUsername());
		System.out.println(account.getPassword());
		System.out.println(account.getStaySignedInOption());

		Account account1 = new Account.Builder()
				.username("Binh Nhu")
				.password("abc")
				//.staySignedInOption("Yes")
				.build();
		
		System.out.println(account1.getUsername());
		System.out.println(account1.getPassword());
		System.out.println(account1.getStaySignedInOption());
	}

}
