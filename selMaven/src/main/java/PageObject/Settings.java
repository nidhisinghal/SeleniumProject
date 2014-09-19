package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Settings {

	WebDriver driver;
	WebElement blogTextBox;
	WebElement saveSettingBtn;
	
	public Settings(WebDriver driver) {
		this.driver=driver;
	}
	
	public void updateBlogTitle(String title) {
		blogTextBox=driver.findElement(By.cssSelector("input#blogname"));
		saveSettingBtn=driver.findElement(By.cssSelector("input#submit"));
		blogTextBox.clear();
		blogTextBox.sendKeys(title);
		saveSettingBtn.submit();
		
	}
}
