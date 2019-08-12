package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fbwebpages.EmailVerificationPage;
import fbwebpages.FacebookHomePage;
import utils.ExcelUtils;

public class FacebookSignUpTest {
	WebDriver driver ;

	@BeforeClass
	public void setUp() throws IOException, ParseException {
		
		System.setProperty("webdriver.chrome.driver" , "drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@AfterSuite(alwaysRun=true)
	public void tearDown() throws Exception{
		try{
			driver.close();
			driver.quit();
		}catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "FacebookSignUpData")
	public void facebookSignUpTestMethod(String fName, String lName, String email, String pwd, String dob, String gender){
		
		FacebookHomePage fbHomePG=new FacebookHomePage(driver);		
		fbHomePG.setFirstName(fName);
		fbHomePG.setLastName(lName);
		fbHomePG.setEmailOrMobile(email);
		fbHomePG.setReEnterEmail(email);
		fbHomePG.setPassword(pwd);
		fbHomePG.setBithday_Date("10");
		fbHomePG.setBirthday_Month("May");
		fbHomePG.setBirthday_Year("1986");
		fbHomePG.setGender(gender);
		fbHomePG.pressSignUpBtn();
		EmailVerificationPage evPgObject =new EmailVerificationPage(driver);
		//String actualErrorText=fbHomePG.getSignUpErrorText();
		//Assert.assertEquals(actualErrorText, "There was an error with your registration. Please try registering again.");
		
		Assert.assertTrue(evPgObject.isContinueBtnAvailable());
	}
	@DataProvider(name = "FacebookSignUpData")
	public Object[][] createData() throws Exception {
		ExcelUtils xUtil = new ExcelUtils("testdata\\FacebookSignUpData.xlsx");
		Object[][] retObjArr = xUtil.getXLDataByPOI("FacebookSignUpData");
		return (retObjArr);
	}
}
