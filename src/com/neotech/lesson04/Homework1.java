package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Homework1 extends CommonMethods {
//		TC 1: OrangeHRM Add Employee:
//			1. Open chrome browser
//			2. Go to "https://hrm.neotechacademy.com/"
//			3. Login to the application
//			4. Add 3 different Employees and Create Login Details by
//			providing:
//			○ First Name
//			○ Last Name
//			○ Username
//			○ Password
//			5. Verify Employee has been added successfully and take
//			screenshot (you must have 3 different screenshots)
//			6. Close the browser
//			Specify a group for this test case, add it into specific suite and
//			execute from the xml file.

		@Test(dataProvider = "excelData", groups = {"smoke", "homework"})
		public void addEmployee(String firstName, String lastName, String username, String password) {
			System.out.println(firstName + " - " + lastName + " - " + password);
			// login
			sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
			sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
			click(driver.findElement(By.xpath("//button[@type='submit']")));
			wait(3);
			// navigate to PIM menu
			click(driver.findElement(By.xpath("//span[text()='PIM']")));
			click(driver.findElement(By.xpath("//span[text()='Add Employee']")));
			
			wait(2);
			
			// click on Add Employee
			sendText(driver.findElement(By.id("first-name-box")), firstName);
			sendText(driver.findElement(By.id("last-name-box")), lastName);
			
			String empID = driver.findElement(By.id("employeeId")).getAttribute("value");
			
			WebElement dropdown = driver.findElement(By.id("location")); 
			Select sel = new Select(dropdown);
			sel.selectByVisibleText("New York Sales Office");
			
			
			//Selenium click didnt work, we used JavascriptExecuter
			jsClick(driver.findElement(By.id("hasLoginDetails")));
			wait(1);
			
			//Provide the username and password for the new Employee
			sendText(driver.findElement(By.id("username")),username);
			sendText(driver.findElement(By.id("password")), password);
			sendText(driver.findElement(By.id("confirmPassword")),password);
			wait(1);
			
			//Clicking on Save Button
			click(driver.findElement(By.id("modal-save-button")));

			// send employee data: first name, last name, location
			waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));
			
			//Validation
			String actualID =driver.findElement(By.id("employeeId")).getAttribute("value");
			Assert.assertEquals(actualID, empID, "Employee Id's do NOT match!");

	        //Take Screenshot
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//			try {
//				FileUtils.copyFile(sourceFile, new File("screenshots/" + firstName + "_"+ lastName + ".png"));
//			} catch (IOException e) {
//				System.out.println("Screenshot was not saved...");
//			}

//			2nd way
			takeScreenshot(firstName + "_" + lastName);
		

		}

		@DataProvider(name = "getData")
		public Object[][] createData() {

			// {"name1", "lastname1", {"lastname2}, {"lastname2}, .... }

			Object[][] data = { { "Megan", "Fox", "meganfox", "Megan@1234" }, 
					            { "Jim", "Carry","jimcarry", "Jim@12345" },
					            { "Paul", "Tom", "paultom", "Paul@1234" } 
					            };

			return data;

		}

	    @DataProvider (name = "excelData")
	    public Object[][] getExcelData(){
	    	return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testdata/Excel.xlsx", "Employee");
	    			
	    }
	}
