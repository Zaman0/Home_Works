package resuablefunctions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Browserconfig.BrowserSetup;
import objectRepository.Homepage;
import objectRepository.Loginpage;
import util.ExcelReader;
import webdriverCommands.Actiondriver;

public class Commonfunctions {
	WebDriver driver;
	Actiondriver adriver;
	
	public Commonfunctions() {
		driver=BrowserSetup.driver;
		adriver=new Actiondriver();
	}
	
	public void login() {
		BrowserSetup.childtest=BrowserSetup.parenttest.createNode("Login");
		adriver.navigatetoapplication("https://demo.guru99.com/test/newtours/");
		adriver.type(Loginpage.txtusername, "username text box", "kiruba17");
		adriver.type(Loginpage.txtpassword, "password text box", "agaran");
		adriver.click(Loginpage.signinbutton, "signin button");
	}
	
	
}
