package persistent.selMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetProperty {
	
	
	WebDriver driver = new FirefoxDriver();
	Properties prop = new Properties();
	
	
	@Test
	public void f() throws FileNotFoundException, IOException, BiffException {
		driver.get("http://wordpress.com/wp-login.php");
		prop.load(new FileInputStream("./src/test/ObjectRepository.properties"));
			
		/*
		 * String userLogin = prop.getProperty("userLogin_text.id"); String
		 * userPass = prop.getProperty("userLogin_pass.name"); String checkbox =
		 * prop.getProperty("userLogin_checkbox.id"); String submit =
		 * prop.getProperty("userLogin_submit.id"); String user =
		 * prop.getProperty("username"); String pass =
		 * prop.getProperty("password");
		 * driver.findElement(By.name(userLogin)).sendKeys(user);
		 * driver.findElement(By.name(userPass)).sendKeys(pass);
		 * driver.findElement(By.id(checkbox)).click();
		 * driver.findElement(By.id(submit)).click();
		 */

		By selector = selector("userLogin_text");
		Workbook book1 = Workbook.getWorkbook(new File("./src/test/Book1.xls"));
		Sheet sheetname = book1.getSheet("NameData");
		String name = sheetname.getCell(2,1).getContents();
		driver.findElement(selector).sendKeys(name);
	}

	/*
	 * public String getElementLocator(String elementType)
	 * 
	 * { String locatorType=elementType.substring(0, separator); return
	 * locatorType; }
	 */

	public By selector(String element) throws FileNotFoundException, IOException {
	//	Properties prop = new Properties();
	//	prop.load(new FileInputStream("./src/test/ObjectRepository.properties"));
		String tempValue= prop.getProperty(element);
		int separator =tempValue.indexOf('.');
		System.out.println("lets find locatorStrategy and its value");
		String elementLocator = tempValue.substring(0,separator);
		System.out.println("first locator found" +elementLocator);
		String propertyValue = tempValue.substring(separator+1);
		System.out.println("second locator found" +propertyValue);
		if (elementLocator.equals("css")) {
			return By.cssSelector(propertyValue);
		} else {
			if (elementLocator.equals("id")) {
				return By.id(propertyValue);
			} else {
				if (elementLocator.equals("name")) {
					return By.name(propertyValue);
				}
				return null;
			}
			
		}
		
	}
	@AfterTest
	// close all web driver instances
	public void cleanup() {
		driver.quit();
		
	}
}
