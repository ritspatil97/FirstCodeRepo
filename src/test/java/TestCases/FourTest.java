package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class FourTest extends Base {

	public WebDriver driver;
	System.out.println("using test ng test ");
	@Test
	public void title4() throws IOException {
		
		 driver = initializeDriver();
		
		driver.get("https://fast.com/");
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertTrue(false);
		
		
	}
	
	@AfterMethod()
	public void closingBrowser()
	{
		driver.close();
	}
}
