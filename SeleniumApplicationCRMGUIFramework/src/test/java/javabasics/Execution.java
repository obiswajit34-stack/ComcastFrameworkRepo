package javabasics;

import org.testng.annotations.Test;

public class Execution {

	public static void main(String[] args) {
		System.out.println("Main Method");
	}
	@Test
	public void testMethod() {
		System.out.println("Test Method Start");
		main(null);
		System.out.println("Test Method Ended");
	}
}
