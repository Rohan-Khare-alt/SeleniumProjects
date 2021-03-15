package io.gmail.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Screenshot {
	static WebDriver driver;

	public static void main(String args[]) throws IOException, InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Sony\\eclipse-workspace\\Selenium_Project\\src\\main\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.instagram.com/mia_malkova/");
		takeScreenshot("Profile_mia7");

	}

	public static void takeScreenshot(String Filename) throws IOException, InterruptedException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Sony\\Pictures\\Saved Pictures\\" + Filename + ".jpg"));
System.out.println("Screenshot Captured");
Thread.sleep(2000);
System.out.println("Exiting App");
driver.close();
	}

}