package Browserconfig;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BrowserSetup {
	public static WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parenttest;
	public static ExtentTest childtest;

@BeforeTest
public void report() {
	htmlreporter=new ExtentHtmlReporter("Reports/MyReport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlreporter);
}
	
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize(); 
  }

  @BeforeMethod
  public void method(Method method) {
	  parenttest=extent.createTest(method.getName());
  }
  @AfterClass
  public void afterClass() {
	 // driver.close();
	  extent.flush();
  }

}
