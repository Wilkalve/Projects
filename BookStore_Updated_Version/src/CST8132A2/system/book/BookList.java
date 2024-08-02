package CST8132A2.system.book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import CST8132A2.system.exception.BookException;
import CST8132A2.system.exception.UserException;
import CST8132A2.system.user.User;
import CST8132A2.system.util.SystemUtil;

public class BookList {
    
private  ArrayList<Book> bestSellers;
    public BookList(){
    	this.bestSellers = new ArrayList<>();
    
    }

	// load the book list
	public void loadBookList(String csvFile) throws BookException {
		
		SystemUtil util = new SystemUtil();
		 String line;
		 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			   reader.readLine();
		      
			while ((line = reader.readLine()) != null) {
				 

				String[] parsedLine = util.lineReader(line);
			
				if (parsedLine.length == 6) {
					addToList(Book.createBook(parsedLine[0], parsedLine[1], parsedLine[2], parsedLine[3], parsedLine[4],
							parsedLine[5]));
				}
				
		
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~ Book successfully added to bestsellers......................");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			reader.close();
			
		} catch (FileNotFoundException fne) {
			throw new BookException(" The system cannot find the file specified" );
		} catch (IOException e) {
			
		}
     }

      // print book list
   public void printBookList() throws BookException{
	   
	   if(getBestSellers().isEmpty() || getBestSellers() == null){
           System.out.println("The bestsellers list is empty ");
       }
       else{
        
            for (Book book : getBestSellers()) {
                    getSizeBook();	
                    System.out.println(book);
                    break;
                }
       }
           
    }
     	// return arraylist size
	public void getSizeBook() throws BookException {
		
		for (int i = 0; i < getBestSellers().size(); i++) {

			System.out.println((i + 1) + ". " + getBestSellers().get(i).toStringBook());
		}
	}


    // search book by index
    public Book findBookByIndex(int index) throws BookException{

		if (index >= 0 || index < getBestSellers().size()) {
			getBestSellers().get(index);

		} else {
			throw new BookException(" Index out of bound for length " + index);

		}
		return getBestSellers().get(index);

    }
   
    // search for book
    public void searchBookList(String search) throws BookException{
        ArrayList<Book> result = new ArrayList<>();
      
		if (getBestSellers().isEmpty() || search.isEmpty()) {
			System.out.println("The search list cannot be empty or null.");
		} else {
			for (Book book : getBestSellers()) {
				try {
					if (book.getName().toLowerCase().contains(search.toLowerCase())
							|| book.getLanguage().toLowerCase().contains(search.toLowerCase())
							|| book.getAuthor().toLowerCase().contains(search.toLowerCase())) {

						result.add(book);
						System.out.println(book.toStringBook());
					}

				} catch (NumberFormatException nfe) {
					throw new BookException("" + nfe);
				}

			}

	}
	if (result.isEmpty() || result == null) {
		System.out.println("The BookList does not contain the specific search request, Please try again.");
	}

	System.out.println(".................................................................");

}
  	// search for year
    public void SearchYear(String year) throws BookException{
    	ArrayList<Book> find = new ArrayList<Book>();
    	
    	if(year.isEmpty() || year == null) {
    		System.out.println("The search list cannot be empty or null.");
    	}
			for (Book bk : getBestSellers()) {
				
				if(Integer.parseInt(year) == bk.getPublished()) {
					find.add(bk);
					System.out.println(bk.toStringBook());
				}
			}
		
		if (find.isEmpty() || find == null) {
			System.out.println("The BookList does not contain the specific search request, Please try again.");
		}

		System.out.println(".................................................................");
    }
		
    // Add book to list
    public void addToList(Book parsedLine){
        getBestSellers().add(parsedLine);
    }
    
	public ArrayList<Book> getBestSellers() {
		return bestSellers;
	}

	public void setBestSellers(ArrayList<Book> bestSellers) {
		this.bestSellers = bestSellers;
	}
    
   
    
}