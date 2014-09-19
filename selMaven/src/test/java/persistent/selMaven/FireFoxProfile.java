package persistent.selMaven;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class FireFoxProfile {
	FirefoxDriver driver;
  @Test
  public void f() {
	    FirefoxProfile profile = new FirefoxProfile();
	    FirefoxBinary bin = new FirefoxBinary(new File("C:/ProgramFiles (x86)/Mozilla Firefox/firefox.exe"));
	    WebDriver dd =new FirefoxDriver(bin,profile);
		profile.setPreference("network.http.phishy-userpass-length",255);
		//driver = new FirefoxDriver(profile);
		//driver.get("http://wordpress.com/wp-login.php");
  }
}
