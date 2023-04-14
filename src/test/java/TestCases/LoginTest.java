package TestCases;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LoginPage;
import Resources.Base;

public class LoginTest extends Base{
	
	public WebDriver driver;
	Logger log;
	
	
	@Test(dataProvider="getLoginData")
	public void login(String demail, String dpassword, String dstatus) throws IOException, InterruptedException {
		
		 log = LogManager.getLogger(LoginTest.class.getName());
		
		LoginPage loginpage = new LoginPage(driver);
		//Thread.sleep(3000);
		//loginpage.email().sendKeys(prop.getProperty("email"));  // email from properties file
		loginpage.email().sendKeys((demail));    // demail from dataprovider method 
		log.debug("email entered");
		
		
		//loginpage.password().sendKeys(prop.getProperty("password"));
		loginpage.password().sendKeys((dpassword));
		log.debug("password entered");
		
		loginpage.submitButton().click();
		log.debug("clicked on submit button");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		log.debug("actual title captured");
		
		AccountPage accountPage = new AccountPage(driver);
		//Assert.assertTrue(accountPage.userdetail().isDisplayed());
		//System.out.println(accountPage.userdetail().isDisplayed());
		
		String actualResult=null;
		String ExpTitle = prop.getProperty("ExpTitle");
		
		try {
			if(accountPage.userdetail().isDisplayed()){
				actualResult = "success";
				log.debug("logged in ");
			}
		}catch(Exception e)
		{
			actualResult = "fail";
		}
		
		
		
		/*if(actualResult.equals(ExpTitle))
		{
			log.info("login passed");
		}
		else {
			log.error("login failed");
		}
		
		//Assert.assertEquals(actualResult, ExpTitle);*/
	}
	
	@BeforeMethod
	public void browserOpening () throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		//log.info("browser and url launched");
	}
	

	@AfterMethod
	public void closure() // tearDown can also be used instaed of closure()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object [][] data = {{"Admin","admin123","success"}};
		//Object [][] data = {{"Admin","admin123","success"},{"Admin","admin@123","fail"}};
		return data;
	}
	
}
