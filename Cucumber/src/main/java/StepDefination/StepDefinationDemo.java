package StepDefination;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationDemo {
	WebDriver driver;
	
	@Before() 
	public void openTheBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
//	@Before 
//	public void BeforeM () {
//		System.out.println("Before Method");
//	}
	
	@After
	public void AfterM () {
		System.out.println("After Method");
	}
	
	@When ("^user enters the credentials \"([^\"]*) and \"([^\"]*) $ ")
	public void Credentials (String user, String pass) {
		driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id=\'txtPassword\']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();
		
		
	}
	
	@When ("user enters the wrong credentials")
	public void WrongCredentials () {
		driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\'txtPassword\']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();
		
	}
	@Then ("user should be display ed with the profile page")
	public void Navigate () {
		
		WebElement err = driver.findElement(By.id("spanMessage"));
		String error = err.getText();
		assertEquals("Invalid credentials", error);

		
		
	} 
	@Then ("user should be display with invalid credentials")
	public void InvalidNavigate () {
		System.out.println("Please put the correct credentials"); 
	}
}
