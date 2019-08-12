package fbwebpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookHomePage extends DriverPage{
	 public FacebookHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	By firstNameLoc = By.name("firstname");
	By lastNameLoc = By.name("lastname");
	By emailLoc = By.name("reg_email__");
	By reEnterEmailLoc = By.name("reg_email_confirmation__");
	By passwordLoc = By.name("reg_passwd__");
	By bithday_dayLoc = By.id("day");
	By bithday_monthLoc = By.id("month");
	By bithday_yearLoc = By.id("year");
	By femaleGenderLoc = By.xpath("//label[text()='Female']");
	By maleGenderLoc = By.xpath("//label[text()='Male']");
	By customGenderLoc = By.xpath("//label[text()='Custom']");
	By signUpBtnLoc = By.name("websubmit");
	
	By fbSignUpErrorTxtLoc = By.id("reg_error_inner");
	
	
	public void setFirstName(String fName){
		driver.findElement(firstNameLoc).sendKeys(fName);
	}
	
	public void setLastName(String lName){
		driver.findElement(lastNameLoc).sendKeys(lName);
	}
	public void setEmailOrMobile(String emailOrMobile){
		driver.findElement(emailLoc).sendKeys(emailOrMobile);
	}
		
	public void setReEnterEmail(String email){
		driver.findElement(reEnterEmailLoc).sendKeys(email);
	}
	public void setPassword(String pwd){
		driver.findElement(passwordLoc).sendKeys(pwd);
	}
	public void setBithday_Date(String day){
		Select dateSelectElement = new Select(driver.findElement(bithday_dayLoc));
		dateSelectElement.selectByVisibleText(day);
	}
	public void setBirthday_Month(String month){
		Select dateSelectElement = new Select(driver.findElement(bithday_monthLoc));
		dateSelectElement.selectByVisibleText(month);
	}
	public void setBirthday_Year(String year){
		Select dateSelectElement = new Select(driver.findElement(bithday_yearLoc));
		dateSelectElement.selectByVisibleText(year);
	}
	public void setGender(String genderValue){
		if(genderValue.equals("Female"))
			driver.findElement(femaleGenderLoc).click();
		else if(genderValue.equals("Male"))
			driver.findElement(maleGenderLoc).click();
		else
			driver.findElement(customGenderLoc).click();
	}
	public void pressSignUpBtn(){
		driver.findElement(signUpBtnLoc).click();
	}
	
	public String getSignUpErrorText(){

		//waitUntilElementPresent(fbSignUpErrorTxtLoc);
		return waitUntilElementPresent(fbSignUpErrorTxtLoc).getText();
	}
	
}
