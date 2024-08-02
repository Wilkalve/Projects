package CST8132A2.system.user;

import java.util.ArrayList;
import java.io.*;
import CST8132A2.system.book.Book;
import CST8132A2.system.book.BookList;
import CST8132A2.system.exception.BookException;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.util.SystemUtil;

public class User {
private String email;
private String password;
private ArrayList<Book> bookList;

UserPlan plan;


public User(String email, String password, UserPlan plan){
    this.email = email;
    this.password = password;
    this.plan = plan;
    this.bookList = new ArrayList<>();
}

public User(){
    this.bookList = new ArrayList<>();
}

// Create user
public  User createUserList(String mail, String paswrd) throws UserException{
    SystemUtil util = new SystemUtil();
    
		if(!util.isValid(email)){
		    throw new UserException(" Email cannot be null, blank or empty.");
		}
    if(!util.isValid(password)){
        throw new UserException(" Password cannot be null, blank or empty.");
    } 
   
   return new User(email, password, plan);
}


public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
public String getPassword(){
    return password;
}
public void setPassword(String password){
    this.password = password;
}

// Add book 
public void addToBookList(Book userBook){
		if(plan.getIsActive() == true) {
		 bookList.add(userBook);	
		}
		else {
			System.out.println("User account not active.");
		}

}
// Search book by index
public void findBookByIndex(int index) throws BookException{
    try {
        if(index >= 0 || index < bookList.size()){
            Book book = bookList.get(index);
            System.out.println(index + ". " + book.toStringBook());
       }

     } catch (IndexOutOfBoundsException e) {
        throw new BookException(" " + e);
       }
}

// Load book list
@SuppressWarnings("unchecked")
public void loadBookList(String load) throws BookException, IOException{
   try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(load))){
    bookList = (ArrayList<Book>) ois.readObject();
    System.out.println("Book list loaded successfully.");

   } catch(FileNotFoundException fne){
    throw new UserException("" + fne);
   } catch(IOException | ClassNotFoundException ie){
    throw new UserException("" + ie);
   }

}

public ArrayList<Book> getBookList(){
    return bookList;
   }
   
// Save the book list
public void saveBookList() throws UserException, BookException{
	
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"))){
        oos.writeObject(bookList);
        System.out.println("Book list save successfully.");

    }catch(IOException e){
        throw new UserException("" + e);
    }

}

public UserPlan getPlan() {
    return plan;

}
public void setPlan(UserPlan myPlan) {
    this.plan = myPlan;
}


// Create book 
public Book createUserBook(String name, String author, String language, String year, String sales, String genre) throws BookException{
	
	     return Book.createBook(name, author, language, year, sales, genre);
 
}

public void displayBookList() throws UserException, BookException{
    
	if(bookList == null || bookList.isEmpty()){
        System.out.println("The BookList list is empty ");
    }
    
        for (Book book : bookList) {
                getSize();	
                System.out.println(book);
               break;
            }
}

// return arraylist size
public void getSize() throws BookException {
		
    for (int i = 0; i < bookList.size(); i++) {

        System.out.println((i + 1) + ". " + bookList.get(i).toStringBook());
    }
}

//toString method
public String tostringUser(){
 return "email: " + email + plan.toStringPlan();
}


//download book
public void downloading(int pos) throws UserException, BookException{
	
	 Book book = bookList.get(pos);
    try(BufferedWriter writer = new BufferedWriter(new FileWriter("UserDownloadBook.txt"))){
               
		if (book == bookList.get(pos)) {
			
			for(Book bk : bookList) {
			String name = bk.getName();
			String author = bk.getAuthor();
			String language = bk.getLanguage();
			int year = bk.getPublished();
			float sale = bk.getMilionSales();
			String genre = bk.getGenre();

			writer.write("Title: " + name + ", Author: " + author + ", Language: " + language + ", Year published: "
					+ year + ", Milion sales: " + sale + ", Genre: " + genre);
			writer.newLine();
			
		 
			}
		
          }
         
          writer.close();
		
        System.out.println("Book Downloaded successfully.");

    }catch(IOException e){
        throw new UserException("" + e);
    }
    
}


}
