package com.neotech.lesson03;

import org.testng.annotations.Test;

public class Homework1 {

	@Test(priority = 3, groups = "smoke")
	public void firstMethod() {
		System.out.println("First Method");
	}

	@Test(enabled = false)
	public void firstMethod1() {
		System.out.println("First Method1");
	}

	@Test(priority = 2)
	public void secondMethod() {
		System.out.println("Second Method");
	}

	@Test(priority = 1)
	public void thirdMethod() {
		System.out.println("Third Method");
	}

	@Test(priority = 0)
	public void fourthMethod() {
		System.out.println("Fourth Method");
	}

}
