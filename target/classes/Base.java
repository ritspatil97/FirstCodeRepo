package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	WebDriver driver;
	public Properties prop;
	
	
	
	public WebDriver initializeDriver() throws IOException {
		
		
		
		 prop = new Properties();
		//String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties";    to give specific path 
		FileInputStream file = new FileInputStream("data.properties");
		prop.load(file);
		
		String browserName = prop.getProperty("browser");		 	
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("edge")) {
		
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
			
	}
	public String takeScreenshot(String testName, WebDriver driver) throws IOException {
	File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destinationFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	FileUtils.copyFile(SourceFile,new File(destinationFilePath));
	
	return destinationFilePath;
	}

}
