package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {

	@Test(priority = 0)
	public void firstTest() {
		System.out.println("First Test Method");
	}

	@Test(priority = 1)
	public void secondTest() {
		System.out.println("Second Test Method");
	}

	@Test
	public void thirdTest() {
		System.out.println("Third Test Method");
	}

	@Test(priority = 10)
	public void fourthTest() {
		System.out.println("Fourth Test Method");
	}

}
