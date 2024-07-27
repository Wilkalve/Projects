package CST8132A2.system.user;

import java.util.ArrayList;
import java.io.*;
import CST8132A2.system.book.Book;
import CST8132A2.system.exception.BookException;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.util.SystemUtil;

public class User {
private String email;
private String password;
ArrayList<Book> bookList;
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
public void addToBookList(Book usr){

	if (plan.getIsActive() == true) {
		
		bookList.add(usr);
	} else {
		System.out.println("Cannot add to booklist, account not active.");
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
    
	if(bookList.isEmpty()){
        System.out.println("The bestsellers list is empty ");
    }
    else{
        for (Book book : bookList) {
                getSize();	
                System.out.println(book);
                break;
            }
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

}
