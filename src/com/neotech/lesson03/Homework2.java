package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends CommonMethods {

//	    HW2: OrangeHRM Add Employee:
//	    Open chrome browser
//	    Go to "https://hrm.neotechacademy.com/"
//	    Login into the application
//	    Click on Add Employee
//	    Verify labels: Employee Full Name*, Employee Id, Location* are displayed
//	    Provide Employee First and Last Name
//	    Select a Location
//	    Verify Employee has been added successfully
//	    Close the browser
//	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void loginValidation() {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));

		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(2);
	}

	@Test(dependsOnMethods = "loginValidation")
	public void labelValidation() {
		loginValidation();
		wait(2);

		click(driver.findElement(By.xpath("//span[text()='PIM']")));
		click(driver.findElement(By.xpath("//span[text()='Add Employee']")));

		String expectedEmployeeFullName = "Employee Full Name*";
		String actualEmployeeFullName = driver.findElement(By.xpath("//label[text()='Employee Full Name']")).getText();

		Assert.assertEquals(actualEmployeeFullName, expectedEmployeeFullName, "Employee full name doesn't Match");

		String expectedEmployeeID = "Employee Id";
		String actualemployeeID = driver.findElement(By.xpath("//label[text()='Employee Id']")).getText();

		Assert.assertEquals(actualemployeeID, expectedEmployeeID, "Employee Id doesn't Match");

		String expectedLocation = "Location*";
		String actualLocation = driver.findElement(By.xpath("//label[text()='Location']")).getText();

		Assert.assertEquals(actualLocation, expectedLocation, "Employee Location doesn't Match");

	}

	@Test(dependsOnMethods = "labelValidation")
	public void addEmployeeValidation() {
		labelValidation();
		sendText(driver.findElement(By.id("first-name-box")), "Burak");
		sendText(driver.findElement(By.id("last-name-box")), "Ingin");
		selectDropdown(driver.findElement(By.id("location")), "Sample Location");
		click(driver.findElement(By.id("modal-save-button")));
		wait(5);
		String expectedEmp = "Burak Ingin";
		String actualEmp = driver.findElement(By.id("pim.navbar.employeeName")).getText();

		Assert.assertEquals(actualEmp, expectedEmp, "Employee is NOT displayed!");

	}

}
