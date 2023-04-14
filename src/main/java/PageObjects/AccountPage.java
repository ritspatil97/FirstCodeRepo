package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement userdetail;
	
	public WebElement userdetail() {
		return userdetail;
	}
	
	
}
