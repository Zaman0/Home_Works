package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import PageObjects.LoginPage;
import PageObjects.LoginPagePF;

public class LoginTestPF {

	WebDriver driver;
	Properties prop;
	LoginPagePF fc;

	@BeforeMethod
	public void setup() throws IOException {
		prop = new Properties ();
		FileInputStream fis = new FileInputStream ("D:\\Work\\Java_Prac\\HWPageObject\\config.properties");
		prop.load(fis); 
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driver"));
		driver = new ChromeDriver();
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test (priority=1, description = "We login with correct name")
		public void login () throws IOException{
		fc = PageFactory.initElements(driver, LoginPagePF.class);
		fc.Login();
		
		//LoginPage lp = new LoginPage (driver);
		//lp.LoginPage1();
	}
	@AfterMethod
	public void teardown() { 	
		
	}
}

