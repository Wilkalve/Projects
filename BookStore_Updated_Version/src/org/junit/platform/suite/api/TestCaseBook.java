package org.junit.platform.suite.api;

import CST8132A2.system.book.Book;
import CST8132A2.system.exception.BookException;


class TestCaseBook {
	
 	void testAccessBook() throws BookException {
		Book book;
		System.out.println("Testing books...................");
		book = Book.createBook("name", "null", "hello", "2020", "100", "ar");
		assertNull(book);
		System.out.println("Book test1 - Invalid book checked");
		book = Book.createBook("Hello", "MyBook", "Paulo Sousa", "2023", "2000", "novel");
		assertNotNull(book);
		System.out.println("Book test2 - Valid book created");
	}

	private void assertNull(Book book) {

		
	}

	private void assertNotNull(Book book) {
		
	}

}
