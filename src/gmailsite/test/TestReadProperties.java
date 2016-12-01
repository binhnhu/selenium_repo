package gmailsite.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestReadProperties {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Binh\\workspace\\GmailSite\\src\\gmailsite\\datafile\\config.properties");
		
		FileInputStream fileInput = null;
		try{
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		//load properties file
		try{
			prop.load(fileInput);
		} catch(IOException e){
			e.printStackTrace();
		}
		
		String storefrontUrl = prop.getProperty("StorefrontUrl");
		
		System.out.println(storefrontUrl);
		 System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));

	}

}
