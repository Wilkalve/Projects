package CST8132A2.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import CST8132A2.system.book.Book;
import CST8132A2.system.book.BookDownloader;
import CST8132A2.system.book.BookList;
import CST8132A2.system.book.BookReadable;
import CST8132A2.system.exception.BookException;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.user.User;
import CST8132A2.system.user.UserList;
import CST8132A2.system.user.UserPlan;
import CST8132A2.system.user.UserPlan.planType;
import CST8132A2.system.util.SystemUtil;


public class SystemManager {
	static final int OPTION_ONE_1 = 1;
	static final int OPTION_TWO_2 = 2;
	static final int OPTION_THREE_3 = 3;
	static final int OPTION_FOUR_4 = 4;
	static final int OPTION_FIVE_5 = 5;
	static final int OPTION_SIX_6 = 6;
	static final int OPTION_SEVEN_7 = 7;
	static final int OPTION_EIGHT_8 = 8;
	static final int OPTION_NINE_9 = 9;
	static final int OPTION_USER_10 = 10;
	static final int OPTION_USER_11 = 11;
	static final int OPTION_USER_12 = 12;
	static final int OPTION_USER_13 = 13;
	static final int OPTION_USER_14 = 14;
    static final int OPTION_USER_15 = 15;
	static final int OPTION_USER_16 = 16;
	
	private static Scanner input;

// Create booklist
	public static void createBookList(BookList bkList, String fileName) throws BookException {
		SystemUtil util = new SystemUtil();
		util.lineReader(fileName);

		try {
			bkList.loadBookList(fileName);
		} catch (BookException e) {
			throw new BookException("" + e);
		} catch (@SuppressWarnings("hiding") IOException e) {
			throw new BookException("" + e);
		}

	}

// Show book lists
	public static void showBookList(BookList blk) throws BookException, UserException {
		blk.printBookList();

	}

// Search in book list
	public static void searchInBookList(BookList srch, String searching) throws BookException {

		if (searching.matches("\\d+")) {
			srch.SearchYear(searching);
		} else {
			srch.searchBookList(searching);
		}
	}

// Create user
	public static void createUser(String email, String password) throws UserException {
		UserList list = new UserList();
		User usr = new User();

		usr.createUserList(email, password);
		list.addUser(usr);
	}

// Show User lists
	public static void showUserList(UserList user) throws UserException {
		System.out.println("Users:");
		user.printUserList();

	}

// save user list
	public static void saveUserList(UserList usr, String file) throws UserException {
		usr.saveUserList(file);
	}

// load user lists
	public static void loadUserList(UserList usrls, String fileName) throws UserException {
		usrls.loadUserList(fileName);
	}

// Login user
	public static void loginUser(User usrs, String emailAddress, String password) throws UserException {

	}

// Exit program
	public static void exit() {
		System.out.println("You have successfully exit the Admin system...");
	}

// Add book to user list
	public static void addBookInmyList(BookList bks, String name, String author, String published, String language,
			String milionSales, String genre) throws BookException, UserException {

		bks.addToList(Book.createBook(name, author, published, language, milionSales, genre));
	}

// Show user book list
	public static void showMyBookList(BookList usr) throws BookException {
		usr.printBookList();

	}

// Read book
	public static void readBook(BookReadable bk) throws BookException {

	}

// Download Book
	public static  void downloadBook(User dwn) throws BookException, UserException {
     BookDownloader.download(dwn);
	}

// Change password
	public static void changePassword(UserList pwssd, int index, String newPwrd) throws UserException {
       pwssd.updateUser(index, newPwrd);
	}

// Log out
	public static void logOff(User usr) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~ User [ " +usr.getEmail() + " ] successfully logOff from the system....)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	
		
	}
	// Show admin menu
	public void showMenu() {
	System.out.println("===================================");
	System.out.println("|| Menu  Mini-System: OOP/A2    |~|");
	System.out.println("|| Choose an option to proceed  |~|");
	System.out.println("===================================");
	System.out.println("1. Load BookList                |~|");
	System.out.println("2. Show BookList                |~|");
	System.out.println("3. Search in the list           |~|");
	System.out.println("4. Create Users                 |~|");
	System.out.println("5. Show Users                   |~|");
	System.out.println("6. Save Users                   |~|");
	System.out.println("7. Load Users                   |~|");
	System.out.println("8. Login Users                  |~|");
	System.out.println("9. Exit                         |~|");
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.print("Choose an option: ");
	
}
	// show user menu
	public static void userMenu() {
		
		System.out.println("===================================");
		System.out.println("|| Menu - User System ..........|~|");
		System.out.println("|| Choose an option to proceed  |~|");
		System.out.println("===================================");
		System.out.println("10. Show all book               |~|");
		System.out.println("11. Add book in my list         |~|");
		System.out.println("12. Show my BookList            |~|");
		System.out.println("13. Read Book                   |~|");
		System.out.println("14. Download Book               |~|");
		System.out.println("15. Change user infos & password|~|");
		System.out.println("16. LogOff                      |~|");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Choose an option: ");
		
	}
	
	public static void main(String[] args) throws BookException, UserException, FileNotFoundException {
		System.out.println("Hello, welcome to Mini bestseller book system.");
		System.out.println("---------------------------------------------");
		SystemManager manager = new SystemManager();
		BookList bookList = new BookList();
		User usr = new User();
		UserList listOfUser = new UserList();
		UserPlan plan = new UserPlan(false, null);
		Book blks = new Book();
		SystemUtil util = new SystemUtil();
		
		input = new Scanner(System.in);
		String number;

		while (true) {
			manager.showMenu();
			
			try {
				
				  number = input.next();
				  if(number.matches("[a-z]") || number.matches("[A-Z]") ) {
					  throw new BookException("Invalid! letter character not allow.");
				  }
				  
				  if(Integer.parseInt(number) ==  OPTION_ONE_1 ) {
					  System.out.print("Enter the file path name to creat the Booklist: ");
					  String path = input.next();
					  input.nextLine();
					  SystemManager.createBookList(bookList, path);  
				  }
				  else if(Integer.parseInt(number) ==  OPTION_TWO_2) {
					  SystemManager.showBookList(bookList);
				  }
				  else if(Integer.parseInt(number) ==  OPTION_THREE_3) {
					  System.out.print("Enter search request to proceed if you would to search for a specific book: ");
					  String search = input.next();
					  input.nextLine();
					  System.out.println();
					  
					  SystemManager.searchInBookList(bookList, search);
				  }
				  else if(Integer.parseInt(number) ==  OPTION_FOUR_4) {
					  
					  
					  System.out.println("Enter user basic informations:");
					  System.out.print("Email Address: ");
					  String email = input.next();
					  
					  if(!util.isValid(email)){
					        throw new UserException(" Email cannot be null, blank or empty.");
					    } 
					  
					    System.out.print("password: ");
					    String passwd = input.next();
					    input.nextLine();
					    
					    if(!util.isValid(passwd)){
					        throw new UserException(" Password cannot be null, blank or empty.");
					    }
						  
					  System.out.println("Plan type: Vip, Standard, Trial ");
					  System.out.print("Choose a plan type from the one above: ");
					  String planType = input.next();
					  
					  
					    System.out.print("Activation Mode: [1] actived, [2] desactivated: ");
						  String mode = input.next();
						  input.nextLine();
					  
					  int on = 1;  int off = 2;
					   
					   if(Integer.parseInt(mode) == on) {
						   plan.createPlan("true", planType.toUpperCase());
					   }
					   else if(Integer.parseInt(mode) == off){
						   plan.createPlan("false", planType.toUpperCase());
					   }
					
						  usr = new User (email, passwd, plan);
							 listOfUser.addUser(usr);
					  
					  
				  }
				  else if(Integer.parseInt(number) ==  OPTION_FIVE_5 ) {
					  SystemManager.showUserList(listOfUser);
				  } 
				  else if(Integer.parseInt(number) ==  OPTION_SIX_6) {
					  System.out.print("Enter a name to save users to the file: ");
					  String file = input.next();
					  input.nextLine();
					  
					  SystemManager.saveUserList(listOfUser, file);
				  }
				  else if(Integer.parseInt(number) ==  OPTION_SEVEN_7 ) {
					  System.out.print("Enter the file name to load: ");
					  String fileName = input.next();
					  input.nextLine();
					  SystemManager.loadUserList(listOfUser, fileName);
				  }
				  else if(Integer.parseInt(number) ==  OPTION_EIGHT_8) {
					  System.out.print("Enter user email: ");
					  String mail = input.next();
					  input.nextLine();
					  System.out.print("Enter user password: ");
					  String password = input.next();
					  input.nextLine();
					  
					  SystemManager.loginUser(usr, mail, password);
					  
					  if (mail.equalsIgnoreCase(usr.getEmail())) {

							if (password.equals(usr.getPassword())) {
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~ " + usr.getEmail() + " Successfully login to the system...");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								
					   Scanner user = new Scanner(System.in);
					   String newUsr;
					
					 
					 while(true) {
						 SystemManager.userMenu();
						 
						 try {
							 newUsr = input.next();
							 if(newUsr.matches("[a-z]") || newUsr.matches("[A-Z]") ) {
								  throw new BookException("Invalid! letter character not allow.");
							  }
							 
							 if(Integer.parseInt(newUsr) == OPTION_USER_10) {
								 SystemManager.showBookList(bookList);
							 }
							 else if(Integer.parseInt(newUsr) == OPTION_USER_11) {
								 
								 System.out.print("Enter book name: ");
								 String name = user.next();
								 user.nextLine();
								 if(!util.isValid(name)){
								        throw new UserException(" Name cannot be null, blank or empty.");
								    } 
								 System.out.print("Enter author name: ");
								 String author = user.next();
								 user.nextLine();
								 if(!util.isValid(author)){
								        throw new UserException(" Author cannot be null, blank or empty.");
								    } 
								 System.out.print("Enter language: ");
								 String language = user.next();
								 user.nextLine();
								 if(!util.isValid(language)){
								        throw new UserException(" Language cannot be null, blank or empty.");
								    } 
								 System.out.print("Enter the year published: ");
								 String year = user.next();
								 user.nextLine();
								 
								 if(!util.isValid(year)){
								        throw new UserException(" Published year cannot be null, blank or empty.");
								    } 
								 System.out.print("Enter milion of sales:");
								 String sales = user.next();
								 user.nextLine();
								 if(!util.isValid(sales)){
								        throw new UserException(" Milion sales cannot be null, blank or empty.");
								    } 
								 
								 System.out.print("Enter book genre: ");
								 String genre = user.next();
									user.nextLine();

									if (!util.isValid(genre)) {
										throw new UserException(" Genre cannot be null, blank or empty.");
									}

									if (plan.getIsActive() == true) {

										SystemManager.addBookInmyList(bookList, name, author, language, year, sales,
												genre);
									} else {
										System.out.println("Cannot add to booklist, account not active.");
										System.out.println();
									}

								} else if(Integer.parseInt(newUsr) == OPTION_USER_12) {
								 SystemManager.showMyBookList(bookList);
							 }
							 else if(Integer.parseInt(newUsr) == OPTION_USER_13) {
								 
								 SystemManager.readBook(blks);
								 
								 if(plan.getIsActive() == true) {
						        	 System.out.print("Enter book index: ");
									 int index = user.nextInt();
									 bookList.findBookByIndex(index);
						         } else {
						        	 System.out.println("Cannot read books because user account not active. ");
						        	 System.out.println("Option [15] can be selected to change user active state.");
						        	 System.out.println();
						         }
								 
							 }
							 else if(Integer.parseInt(newUsr) == OPTION_USER_14 ) {
								planType type = planType.VIP;
								 
									if ( plan.getPlan() == type) {
										
										SystemManager.downloadBook(usr);
										System.out.print("Enter book index: ");
										int index = user.nextInt();
										bookList.findBookByIndex(index);
										bookList.downloading(index);
									} 
									else{
										System.out.print("Book cannot be downloaded because plan is: " + plan.getPlan());
										System.out.println();
										
									}

								}
							 else if(Integer.parseInt(newUsr) == OPTION_USER_15 ) {
								final int num1 = 1; final int num2 = 2; final int num3 = 3; final int num_4 = 4;
								
								 Scanner pwd = new Scanner(System.in);
								 System.out.println("Enter which user infos to change: [1] password, [2] email address, [3] plan, [4] isActive.");
								 System.out.print("Option: ");
								 String enter = pwd.nextLine();
								 if(Integer.parseInt(enter) == num1) {
									 System.out.print("Enter user index in the system: ");
									 int pos = user.nextInt();
									 user.nextLine();
									 
									 System.out.print("Enter new password: ");
									 String pass = user.next();
									 SystemManager.changePassword(listOfUser, pos, pass);
									 
									 
								 } else if(Integer.parseInt(enter) == num2) {
									 System.out.print("Enter user index in the system: ");
									 int post = user.nextInt();
									 user.nextLine();
									 System.out.print("Enter new email address: ");
									 String email = user.next();
									 listOfUser.updater(post);
									 usr.setEmail(email);
									 System.out.println("Successfully change email address.");
								 }
								 else if(Integer.parseInt(enter) == num3) {
									 System.out.print("Enter user index in the system: ");
									 int index = user.nextInt();
									 user.nextLine();
									 System.out.print("Enter new plan: ");
									 String type = user.next();
									 
									 plan.createPlan("false", type.toUpperCase());
									 usr.setPlan(plan);
								 }
								 else if(Integer.parseInt(enter) == num_4) {
									 System.out.print("Activation Mode: [ON] activated, [OFF] desactivated: ");
									 String entr = user.next();
									 if(entr.equalsIgnoreCase("ON")) {
										 plan.setIsActive(true);
									 } 
									 else if(entr.equalsIgnoreCase("OFF")) {
										 plan.setIsActive(false);
									 }
								 }
							 }
							 else if(Integer.parseInt(newUsr) > 16 || Integer.parseInt(newUsr) < 10) {
								  throw new UserException(" The range for input number cannot be greater then <<16>> or less than <<10>>");
							  }
							 else if(Integer.parseInt(newUsr) == OPTION_USER_16) {
								 SystemManager.logOff(usr);
								 break;
							 }
 
							  
						 } catch(IOException e) {
							 throw new BookException("" + e);
						 }
					 }
					  
				  } 
				  else {
					  System.out.println("Incorrect password!");
				  }
				  
				} else {
					System.out.println("Incorrect email address!");
				}

			} else if (Integer.parseInt(number) > 9 || Integer.parseInt(number) <= 0) {
				throw new UserException(" The range for input number cannot be greater then <<9>> or less than <<1>>");
			} else if (Integer.parseInt(number) == OPTION_NINE_9) {
				SystemManager.exit();
				break;
			}

		} catch (IOException e) {
			System.err.println("" + e);
		} catch (InputMismatchException ime) {
			System.err.println("" + ime);
		}

		}
		
		input.close();
	}

}
