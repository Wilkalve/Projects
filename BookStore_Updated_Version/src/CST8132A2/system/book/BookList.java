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

public class BookList {
    ArrayList<Book> bestSellers;
    public BookList(){
        this.bestSellers = new ArrayList<>();
    }

	// load the book list
	public void loadBookList(String csvFile) throws BookException {
		bestSellers = new ArrayList<Book>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");

				try {
					if (values.length == 6) {

						String title = String.join(",", values[0]);
						String author = String.join(",", values[1]);
						String language = String.join(",", values[2]);
						String year = String.join(",", values[3]);
						String sales = String.join(",", values[4]);
						String genre = String.join(",", values[5]);
						
						
						addToList(Book.createBook(title, author, language, year, sales, genre));

					}
				} catch (NumberFormatException nfe) {
					throw new BookException(" " + nfe);
				}
			}

            System.out.println("Book successfully added to bestsellers.");
            reader.close();
        } catch(FileNotFoundException fne){
            throw new BookException(" " + fne);
        } catch(IOException e){
            throw new BookException(" " + e);
        } 
     }

      // print book list
   public void printBookList() throws BookException{
	   
	   if(bestSellers.isEmpty() || bestSellers == null){
           System.out.println("The bestsellers list is empty ");
       }
       else{
        
            for (Book book : bestSellers) {
                    getSizeBook();	
                    System.out.println(book);
                    break;
                }
       }
           
    }
     	// return arraylist size
	public void getSizeBook() throws BookException {
		
		for (int i = 0; i < bestSellers.size(); i++) {

			System.out.println((i + 1) + ". " + bestSellers.get(i).toStringBook());
		}
	}


    // search book by index
    public void findBookByIndex(int index) throws BookException{
       
       try {
        if(index >= 0 || index < bestSellers.size()){
            Book book = bestSellers.get(index);
            System.out.println(index + ". " + book.toStringBook());
       }

     } catch (IndexOutOfBoundsException e) {
        throw new BookException(" " + e);
       }

    }
   
    // search for book
    public void searchBookList(String search) throws BookException{
        ArrayList<Book> result = new ArrayList<>();
      
        if(bestSellers.isEmpty() || search.isEmpty()){
			System.out.println("The search list cannot be empty or null.");
		} else {
			for (Book book : bestSellers) {
				try {
					if (book.getName().toLowerCase().contains(search.toLowerCase())
							|| book.getLanguage().toLowerCase().contains(search.toLowerCase())
							|| book.getAuthor().toLowerCase().contains(search.toLowerCase())
							|| book.getGenre().toLowerCase().contains(search.toLowerCase())) {
						
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
			for (Book bk : bestSellers) {
				
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
    public void addToList(Book book){
        bestSellers.add(book);
    }
    
    // download book
    public void downloading(int pos) throws UserException, BookException{
    	
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("UserDownloadBook.txt"))){
        
			
              for(Book bk: bestSellers) {
            	  
			if (bk == bestSellers.get(pos)) {
				String name = bk.getName();
				String author = bk.getAuthor();
				String language = bk.getLanguage();
				int year = bk.getPublished();
				float sale = bk.getMilionSales();
				String genre = bk.getGenre();
				
				writer.write("Title: " + name + ", Author: " + author + ", Language: " + language + ", Year published: " + year + ", Milion sales: " + sale + ", Genre: " + genre);
				writer.newLine();
		
			}
              }
             
              writer.close();
			
            System.out.println("Book list save successfully.");

        }catch(IOException e){
            throw new UserException("" + e);
        }

    }
    
}