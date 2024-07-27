package org.junit.platform.suite.api;

public class TestSuite {

	static void printInitialMsg() {
		System.out.println("================================");
		System.out.println("||    Test Suite Validation   ||");
		System.out.println("================================");
	}


	static void initAll() {
		printInitialMsg();
	}

	void init() {
		
	}


	void succeedingTest() {
	}

	
	void failingTest() {
		//fail("a failing test");
	}

	
	
	void skippedTest() {
		// not executed
	}


	void abortedTest() {
		assumeTrue("abc".contains("Z"));
		fail("test should have been aborted");
	}

	
	private void fail(String string) {
		// TODO Auto-generated method stub
		
	}


	private void assumeTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}


	void tearDown() {
		
	}


	static void tearDownAll() {
	}
	
	; // Empty
}
