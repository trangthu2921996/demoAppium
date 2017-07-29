package demo_20140919;

import java.io.File;
//import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;                  
import org.openqa.selenium.remote.DesiredCapabilities;                
import org.openqa.selenium.remote.RemoteWebDriver;

public class Appium_demo {
	WebDriver driver = null;

	@Test
	public void f() {
//		Ở màn hình [Login], kiểm tra xem có:
//			1.	Title: Car Rental-Login
		WebElement title_Login = driver.findElement(By.id("com.logigear:id/txtTitleMain"));
		Assert.assertEquals("true", title_Login.getAttribute("enabled"));
		Assert.assertEquals("Car Rental-Login", title_Login.getText());
//			2.	Textbox: username
//				default: john
		WebElement txt_Username = driver.findElement(By.id("com.logigear:id/txtUserName"));
		Assert.assertEquals("true", txt_Username.getAttribute("enabled"));
		Assert.assertEquals("john", txt_Username.getText());
//			3.	Button: Login
		WebElement btn_Login = driver.findElement(By.id("com.logigear:id/btnLogin"));
		Assert.assertEquals("true", btn_Login.getAttribute("enabled"));
//			4.	Button: Clear
		WebElement btn_Clear = driver.findElement(By.id("com.logigear:id/btnCLear"));
		Assert.assertEquals("true", btn_Clear.getAttribute("enabled"));
//			5.	TH1_Click btn [Clear] -> textbox "username" = null
		//btn_Clear.click();
		//Assert.assertEquals("", txt_Username.getText());	
//			6.  TH2_click btn [Login]
		btn_Login.click();
//		    7.  click imagebtn_car
		//WebElement imagebtn_car = driver.findElement(By.id("com.logigear:id/imageButtonViewCar"));
		//Assert.assertEquals("true", title_Login.getAttribute("enabled"));
		//imagebtn_car.click();
//			8. 			
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		File appDir = new File("D://KhoaLuanTotNghiep//TaiLieu_Appium//Appium//");
		File app = new File(appDir, "CarRental_new.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "192.168.80.101:5555");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("app-package", "com.logigear");
		cap.setCapability("app", app.getAbsolutePath());

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
