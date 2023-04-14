package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class ThreeTest extends Base {

	
	public WebDriver driver;
	@Test
	public void title3() throws IOException {
		 driver = initializeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
		
	}
}