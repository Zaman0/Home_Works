package Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseInfo {

	WebDriver driver;
	
	public WebDriver initializeDriver () throws IOException {
		Properties prop = new Properties ();
		FileInputStream fis = new FileInputStream ("D:\\Work\\Java_Prac\\HWPageObject\\src\\main\\java\\Resource\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
			
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Work\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Work\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver ();
		}
	
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Work\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver ();
		}
	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}
	
	
}
