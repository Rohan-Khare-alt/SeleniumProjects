package io.gmail.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Gmail_login {
	WebDriver driver;

	@Test
	@BeforeMethod(alwaysRun = true)

	void init() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test(priority = 1, groups = { "PositiveLogintest" })
	void login() throws InterruptedException {
		String url = "https://mail.google.com";
		driver.get(url);
		System.out.println(driver.getCurrentUrl());
		WebElement username = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
		username.clear();
		username.sendKeys("hjghj");
		WebElement NextButton = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		NextButton.click();
		Thread.sleep(30000);
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("ghjgjh");
		WebElement finalclick = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		finalclick.click();
		Thread.sleep(3000);
		String ExpectedURL = "https://mail.google.com/mail/u/0/#inbox";
		String ActualURl = driver.getCurrentUrl();
		assertEquals(ActualURl, ExpectedURL, "Login Successful");
	}

	@Test(priority = 2)
	@Parameters({ "username", "Expected" })
	public void Negatvelogintest(String username,String Expected) throws InterruptedException {
		String url = "https://mail.google.com";
		driver.get(url);
		System.out.println(driver.getCurrentUrl());

		/*
		 * String actualTitle = driver.getTitle();
		 * System.out.println(actualTitle+"......");
		 * assertTrue(actualTitle.equalsIgnoreCase("Gmail"), "web page opened");
		 */

		WebElement username1 = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
		username1.sendKeys(username);
		WebElement NextButton = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		NextButton.click();
		WebElement errormessage = driver.findElement(By.xpath(
				"//div[@id='view_container']/div[@class='zWl5kd']/div[@role='presentation']/div[@role='presentation']/div[@role='presentation']//form[@method='post']//section/div/div/div[@role='presentation']//div[@class='o6cuMc']"));
		String expectedErrorMessage = Expected;
		String actualErrorMessage = errormessage.getText();
		assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Login failed");
		Thread.sleep(2000);

	}

	@AfterMethod(alwaysRun = true)
	void driverclose() {
		driver.close();
		System.out.println("Test script executed successfully.");

//terminate the program
		System.exit(0);
	}
}
