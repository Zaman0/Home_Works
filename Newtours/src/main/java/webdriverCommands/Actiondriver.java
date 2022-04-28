package webdriverCommands;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browserconfig.BrowserSetup;

public class Actiondriver {

	WebDriver driver;

	public Actiondriver() {
		driver=BrowserSetup.driver;
	}
	/**
	 * This is used to navigate to application, url is retrived from object.properties
	 * @param url
	 */
	public void navigatetoapplication(String url) {
		try {
		driver.get(url);
		BrowserSetup.childtest.pass("Successfully navigated to url : "+url);
		}catch (Exception e) {
			BrowserSetup.childtest.fail("Unable to navigate to url : "+url);
			throw e;
		}
	}
	/**
	 * Used to perform click opassn button,links,radio buttons and check boxes
	 * @param locator --- get it from object repository
	 * @param elename ---name of the element
	 */
	public void click(By locator,String elename) {
		try {
			driver.findElement(locator).click();
			BrowserSetup.childtest.pass("Successfully clicked on : "+elename);
		} catch (Exception e) {
			BrowserSetup.childtest.fail("unable to perform click on : "+elename);
			BrowserSetup.childtest.info(e);
			throw e;
		}
	}
	/**
	 * used to perform type action in textbox and text area
	 * @param locator
	 * @param elename
	 * @param testdata
	 */
	public void type(By locator,String elename,String testdata) {
		try {
			driver.findElement(locator).sendKeys(testdata);
			BrowserSetup.childtest.pass("Successfully typed in : "+elename+ " with data :"+testdata);
		}catch (Exception e) {
			BrowserSetup.childtest.fail("unable to type in : "+elename+ " with data :"+testdata);
			BrowserSetup.childtest.info(e);
			throw e;
		}
	}
	/**
	 * used to retrive the text from webelement
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		try {
			String x=driver.findElement(locator).getText();
			BrowserSetup.childtest.pass("text is :"+ x);
			return x;
		} catch (Exception e) {
			BrowserSetup.childtest.fail("unable to return text");
			return null;
		}
	}
	/**
	 * perform mouse hover on given element
	 * @param locator --- get it from OR
	 * @param elename --- for reporting
	 */
	public void mousehover(By locator,String elename) {
		try {
			Actions a=new Actions(driver);
			WebElement mo=driver.findElement(locator);
			a.moveToElement(mo).build().perform();
			BrowserSetup.childtest.pass("Performed mouse hover on: "+ elename);

		} catch (Exception e) {
			BrowserSetup.childtest.fail("unable to  mosde hover on: "+ elename);
		}
	}
	
	public void verifybytext(By locator,String expText) {
		String actualtext=getText(locator);
		if(actualtext.equals(expText)) {
			BrowserSetup.childtest.pass("Actual text is equal to expected texr");
		}else {
			BrowserSetup.childtest.fail("Actual text is not equal to expected text");
		}
	}
	
	public void waitforelementvisible(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void selectbyindex(By locator,int index) {
		try {
			WebElement dd=driver.findElement(locator);
			Select s=new Select(dd);
			s.selectByIndex(index);
			BrowserSetup.childtest.pass("Selected "+index+" value from dropdown");
		} catch (Exception e) {
			BrowserSetup.childtest.pass("unable to select "+index+" value from dropdown");
		}

	}
	
	
	public void selectbyvisibletext(By locator,String data) {
		try {
			WebElement dd=driver.findElement(locator);
			Select s=new Select(dd);
			s.selectByVisibleText(data);
			BrowserSetup.childtest.pass("Selected "+data+" value from dropdown");
		} catch (Exception e) {
			BrowserSetup.childtest.pass("unable to select "+data+" value from dropdown");
		}

	}
	
	public String parentwindow() {
		return driver.getWindowHandle();
	}
	
	public void switchtochildwindow(By locator,String data){
		Set<String> windows=driver.getWindowHandles();
		try {
			for(String st: windows) {
				driver.switchTo().window(st);{
					if(getText(locator).equals(data)) {
						System.out.println("im in correct window");
					}
					else
					{
						System.out.println("Im in wrongwindow");
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String screenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
}
