package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test(groups = "smoke")
	public void titleValidation() throws Exception {
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Title Validation Passed!");
		} else {
			System.out.println("Title Validation Passed!");
			throw new Exception();
		}
		wait(3);
	}

	@Test
	public void logoValidation() throws Exception {
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']"));

		if (logo.isDisplayed()) {
			System.out.println("Logo Validation Passed!");
		} else {
			System.out.println("Logo Validation Failed!");
			throw new Exception();
		}
	}

	@Test
	public void loginValidation() throws Exception {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));

		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		WebElement userImg = driver.findElement(By.xpath("//div[@id='menu-profile']"));

		if (userImg.isDisplayed()) {
			System.out.println("We have logged in successfuly!!");
		} else {
			System.out.println("Login failed!!");
			throw new Exception();
		}

	}

}
