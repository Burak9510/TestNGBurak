package com.neotech.lesson04;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.neotech.utils.Listener.class)
public class ListenerDemo {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test
	public void test1() {
	   System.out.println("This is test1");
	   // I am passing this test
	   Assert.assertTrue(true);
	}

	@Test
	public void test2() {
		System.out.println("This is test2");
		
		//I am failing this test
		Assert.assertTrue(false);
	}


}

//onStart(one time) -- when the TEST (not test method) starts executing

////////////////
//if we have a BeforeMethod - this is where it is executed

//onTestStart()
//test1()
//onTestSuccess()

//if we have a AfterMethod - this is where it is executed
////////////////

//BeforeMethod
//onTestStart()
//test1()
//onTestFailure()
//AfterMethod

//onFinish(one time)
