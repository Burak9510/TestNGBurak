package com.neotech.lesson03;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AddEmployeeWithDataProvider extends CommonMethods {

	@Test(dataProvider = "addEmployee")
	public void addEmployee(String firstName, String lastName) {
		System.out.println(firstName + lastName);
		// login

		// navigate to PIM menu

		// click on Add Employee

		// send employee data: first name, last name, location

		// save employee

	}

	@DataProvider(name = "addEmployee")
	public Object[][] create2DArray() {

		// {"name1", "lastname1", {"lastname2}, {"lastname2}, .... }

		Object[][] data = { { "Murad", "Bayramov" }, { "Emine", "Karakaya" }, { "Vugar", "AliSultanov" } };

		return data;

	}

}
