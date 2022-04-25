package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	File file;
	XSSFWorkbook wb;
	
	
		public LoginPage ( WebDriver driver) {
			this.driver = driver;
		}
		
		public void LoginPage1 () throws IOException {
			file = new File ("D:\\Work\\Java_Prac\\TestNGNisha\\config.properties");
			fis= new FileInputStream(file);
			fis = new FileInputStream ("D:\\Work\\demodata.xlsx");
			wb = new XSSFWorkbook (fis);
			
			
		String username = wb.getSheet("Testdata").getRow(1).getCell(0).getStringCellValue();
		String password = wb.getSheet("Testdata").getRow(1).getCell(1).getStringCellValue();
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click(); 
		
		
		
		}
}

