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
	
	/*@When ("^user enters the credentials \"(.*)\" and \"(.*)\" $ ")
	public void Credentials (String user, String pass) {
		driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id=\'txtPassword\']")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();*/
		
		
	/*@When("^user enters the credentials (.*) and (.*)$")
	public void user_enters_the_credentials_admin_and_admin123(String username, String password) {
	   	    
	   	driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\'txtPassword\']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();
	   	    
	}*/
	
	
	@When ("user enters the credentials")
	public void Credentials (DataTable Credentials) {
		List<String> data = Credentials.row(0);
	
		driver.findElement(By.xpath("//*[@id=\'txtUsername\']")).sendKeys(data.get(0));
		driver.findElement(By.xpath("//*[@id=\'txtPassword\']")).sendKeys(data.get(1));
		driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();
	}
	@Then ("user should be displayed with the profile page")
	public void Navigate () {
		
		System.out.println("This is my Home Page");
		
//		WebElement err = driver.findElement(By.id("spanMessage"));
//		String error = err.getText();
//		assertEquals("Invalid credentials", error);
			
	} 
//	@Then ("user should be display with invalid credentials")
//	public void InvalidNavigate () {
//		System.out.println("Please put the correct credentials"); 
//	}
}
