package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ExtentReporter {
	

	WebDriver driver;
	static ExtentReports extentReport;

	
	
	public static ExtentReports getExtentReports() {

		String extentReportPath = System.getProperty("user.dir") + "\\reports\\extentReport.html"; // path of proj and file name
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);   // create obj for class "ExtentSparkReporter"

		reporter.config().setReportName("internet speed ");  // setting report name 
		reporter.config().setDocumentTitle("Title of report ");  // setting report title

		extentReport = new ExtentReports();       // creating object for ExtentReports

		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("OS system", "wind 11");
		extentReport.setSystemInfo("testd by ", "rushikesh");
		
		
		return extentReport;
		
	}

}
