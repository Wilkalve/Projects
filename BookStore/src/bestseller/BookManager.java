package bestseller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManager {
	private final static int OPTION1_CRT = 1;
	private final static int OPTION2_LST = 2;
	private final static int OPTION3_ADD = 3;
	private final static int OPTION4_EDT = 4;
	private final static int OPTION5_DEL = 5;
	private final static int OPTION6_SAV = 6;
	private final static int OPTION7_SRC = 7;
	private final static int OPTION0_EXT = 0;
	private final static int OPTION8_CS = 8;
	private final static int OPTION9_SW = 9;
	private final String TITLE;
	private String fileName;
	private BookList booklist;
	private static Scanner input;

	public BookManager() {
		this.TITLE = "";
	}

	public void showMenu() {
		System.out.println("===================================");
		System.out.println("|| Menu  Best sellers OOP/A1     ||");
		System.out.println("|| Choose an option to proceed   ||");
		System.out.println("===================================");
		System.out.println("0. Exit program                  ");
		System.out.println("1. Create Booklist               ");
		System.out.println("2. Show BookList                 ");
		System.out.println("3. Add Book                      ");
		System.out.println("4. Edit Book                     ");
		System.out.println("5. Delete Book                   ");
		System.out.println("6. Save BookList                 ");
		System.out.println("7. Search in the list            ");
		System.out.println("8. Classify book with stars      ");
		System.out.println("9. Switch possitions             ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Choose an option: ");
	}

	public void exit() {
		System.out.println("Successfully exit the program...");
	}

	// Main method
	public static void main(String[] args) throws BookException {
		BookManager manager = new BookManager();
		BookList books = new BookList();
		input = new Scanner(System.in);
		String num;

		while (true) {
			manager.showMenu();
            
			try {
          
			  num = input.next();
			  if(num.matches("[a-z]") || num.matches("[A-Z]") ) {
				  throw new BookException("Invalid! letter character not allow.");
			  }
			 
			// create Booklist
				if (Integer.parseInt(num) == OPTION1_CRT) {
					System.out.print("Enter the File path name: ");
					String path = input.next();
					input.nextLine();
					books.lineReader(path);
					books.createList(path);
					System.out.println("New Book list successfully created...");

				}
				// show Book List
				else if (Integer.parseInt(num) == OPTION2_LST) {
					books.printList();
				}
				// Add new Book
				else if (Integer.parseInt(num) == OPTION3_ADD) {

					try {
						System.out.print("- Book Name: ");
						String name = input.next();
						input.nextLine();
						System.out.print("- Author: ");
						String author = input.next();
						input.nextLine();
						System.out.print("- Original Language: ");
						String language = input.next();
						input.nextLine();
						System.out.print("- Year Published: ");
						int year = input.nextInt();
						if(year <= 0 || year > 2024 ) {
							throw new BookException("- The year enter is invalid");
						}
						input.nextLine();
						System.out.print("- Milion of sales: ");
						float sale = input.nextFloat();
						if(sale < 0) {
							throw new BookException("- The number of sale enter is invalid.");
						}
						input.nextLine();
						System.out.print("- Genre: ");
						String genre = input.next();
						input.nextLine();
						System.out.print("- Number of star: ");
						int star = input.nextInt();
						if(star < 0 || star > 5 ) {
							throw new BookException("- The star number enter is invalid");
						}
						input.nextLine();
						
						Book b1 = new Book(name, author, language, year, sale, genre, star);
						books.add(b1);
						System.out.println(" Book added successfully.");
					} catch (InputMismatchException e) {
						throw new BookException("" + e);
					}

				}
				// Edit Book
				else if (Integer.parseInt(num) == OPTION4_EDT) {
					System.out.print("Enter the book position: ");
					int pos = input.nextInt();
					input.nextLine();
			
					System.out.print("- Book Name: ");
					String name = input.next();
					input.nextLine();
					System.out.print("- Author: ");
					String author = input.next();
					input.nextLine();
					System.out.print("- Original Language: ");
					String language = input.next();
					input.nextLine();
					System.out.print("- Year Published: ");
					int year = input.nextInt();
					if(year <= 0 || year > 2024 ) {
						throw new BookException("- The year enter is invalid");
					}
					input.nextLine();
					System.out.print("- Milion of sales: ");
					float sale = input.nextFloat();
					if(sale < 0) {
						throw new BookException("- The number of sale enter is invalid.");
					}
					input.nextLine();
					System.out.print("- Genre: ");
					String genre = input.next();
					input.nextLine();
					System.out.print("- Number of star: ");
					int star = input.nextInt();
					if(star < 0 || star > 5 ) {
						throw new BookException("- The star number enter is invalid");
					}
					input.nextLine();
					books.edit(pos, name, author, language, year, sale, genre, star);	
				}
				// Delete Book from the list
				else if ( Integer.parseInt(num) == OPTION5_DEL) {
					System.out.print("Enter the Book index number you want to delete: ");
					int delete = input.nextInt();
					books.delete(delete);
				}
				// save to file
				else if (Integer.parseInt(num) == OPTION6_SAV) {
					System.out.print("Enter file name to be save: ");
					String path = input.next();
					input.nextLine();
					books.lineReader(path);
					books.saveList(path);

				}
				// search for book
				else if (Integer.parseInt(num) == OPTION7_SRC) {
					System.out.print("Enter a search, can be <author name>,<review number>,<year publisbed>: ");
					String find = input.next();
					input.nextLine();
					books.search(find);
				}
				// Exit the program
				else if (Integer.parseInt(num) == OPTION0_EXT) {
					manager.exit();
					break;	
				} 
				// change star review
				else if (Integer.parseInt(num) == OPTION8_CS) {
					System.out.print("Enter the book index: ");
					int index = input.nextInt();
					input.nextLine();
					
					System.out.print("Enter new star review: ");
					int newStar = input.nextInt();
					if (newStar < 0 || newStar > 5) {
						throw new BookException("invalid! review number range from 1 to 5.");
					}
					
					books.classify(index, newStar);
				}
				// swap book index
				else if(Integer.parseInt(num) == OPTION9_SW) {
					System.out.print("Enter the first book index number to switch: ");
					int num1 = input.nextInt();
					input.nextLine();
					
					System.out.print("Enter the second book index number to swap with the first: ");
					int num2 = input.nextInt();
					
					books.changeIndex(num1, num2);
					
					
				}else if (Integer.parseInt(num) < 0 || Integer.parseInt(num) > 9) {

					throw new BookException(" Invalid input number. Choose option from range 1 to 8.");
				
		}

			} catch (BookException e) {
				System.err.println("" + e);
			}
		}
		
	}

}

