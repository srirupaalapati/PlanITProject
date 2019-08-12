package fbwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class EmailVerificationPage extends DriverPage{


	public EmailVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By continueBtnLoc=By.name("confirm");
	public boolean isContinueBtnAvailable() {
		// TODO Auto-generated method stub
		boolean continueBtnAvail=false;
		try{
			
			continueBtnAvail=waitUntilElementPresent(continueBtnLoc).isDisplayed();
		}
		
		catch(NoSuchElementException e){
			
		}
	
		return continueBtnAvail;
	}
}
