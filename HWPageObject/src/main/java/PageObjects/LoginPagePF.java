package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagePF {

	WebDriver driver;
	@FindBy(id="txtUsername")
	WebElement user;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy (id="btnLogin")
	WebElement login;
	
	
	public LoginPagePF (WebDriver driver) {
		
		this.driver = driver;
	}
	
		public void Login() {
		user.sendKeys("Admin");
		password.sendKeys("admin123");
		login.click();
		
	}

}
	

