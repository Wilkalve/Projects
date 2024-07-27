package org.junit.platform.suite.api;

import CST8132A2.system.exception.BookException;
import CST8132A2.system.exception.UserException;

public record SelectClasses() {
 @SuppressWarnings("static-access")
public static void main(String[] args) throws BookException, UserException {
	 TestSuite test = new TestSuite();
	 test.printInitialMsg();
	 
	 TestCaseBook bk = new TestCaseBook();
	 bk.testAccessBook();
	 
   TestCaseBook books = new TestCaseBook();
	 
	 books.testAccessBook();
	 
	 TestCaseUser  users = new TestCaseUser ();
	 users.testUser();
	 
	

	 
 }
}
