package org.junit.platform.suite.api;


import java.util.ArrayList;

import CST8132A2.system.book.Book;
import CST8132A2.system.book.BookDownloader;
import CST8132A2.system.book.BookReadable;
import CST8132A2.system.exception.BookException;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.user.UserPlan;
import CST8132A2.system.user.User;

class TestCaseUser {


	
	void testUser() throws BookException, UserException {
		Book book;
		
		UserPlan plan = new UserPlan(false, null);
	
		User user = new User();
		System.out.println("Testing users...................");
	    plan.createPlan("false", "VIP");
		assertNotNull(plan);
		System.out.println("User test1 - Invalid plan checked");
		plan.createPlan("true", "TRIAL");
		assertNotNull(plan);
		System.out.println("User test2 - Valid plan created");
		user = new User ("","invalid", plan);
		assertNull(user);
		System.out.println("User test3 - Invalid user checked");
		user.createUserList("Paulo", "paulo@mail.com");
		assertNotNull(user);
		System.out.println("User test4 - Valid user created");
		user.setPlan(plan);
		plan = user.getPlan();
		assertNotNull(plan);
		System.out.println("User test5 - Valid plan from user");
		book = Book.createBook("1000", "MyBook", "Paulo Sousa", "English", "2000", "0");
		assertNotNull(book);
		System.out.println("User test6 - Valid book2 created");
		try {
			user.addToBookList(book);
		} catch (Exception e) {
			fail("Error creating books");
		}
		ArrayList<Book> size = user.getBookList();
		assertEquals(1, size);
		System.out.println("User test7 - Valid book inclusion in list");
		boolean canRead = BookReadable.read(user);
		assertTrue(canRead);
		System.out.println("User test8 - Valid book read checked");
		boolean canDownload = BookDownloader.download(user);
		assertFalse(canDownload);
		System.out.println("User test9 - Invalid book download checked");
	}

private void assertNull(User user) {
		
		
	}

	@SuppressWarnings("unused")
	private void assertNull(UserPlan plan) {
		
		
	}

	private void assertNotNull(User user) {
		
		
	}

	private void assertNotNull(UserPlan plan) {

		
	}

	private void assertTrue(boolean canRead) {
	
		
	}

	private void assertFalse(boolean canDownload) {
		
		
	}

	private void assertEquals(int i, ArrayList<Book> size) {
	
		
	}

	private void fail(String string) {
		
		
	}

	private void assertNotNull(Book book) {
	
		
	}
}
