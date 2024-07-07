package bestseller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Collections;

public class BookList {
	private ArrayList<Book> bestsellers;
	private final int NUMCOLS;
	private String[] title;
	private final String[] DEFAULT_TITLE;
	public BookList() {
		bestsellers = new ArrayList<Book>();
		this.NUMCOLS = 6;
		this.DEFAULT_TITLE = null;
	}

	// remove comma line
	public String[] lineReader(String line) {
		String[] str = new String[NUMCOLS];
		int index = 0;
		final char chComma = ',';
		final char chQuotes = '"';
		int start = 0;
		int end = line.indexOf(chComma);
		String value;
		while (start < end) {
			if (line.charAt(start) == chQuotes) {
				start++;
				end = line.indexOf(chQuotes, start + 1);
			}
			value = line.substring(start, end);
			value = value.trim();
			str[index++] = value;
			if (line.charAt(end) == chQuotes)
				start = end + 2;
			else
				start = end + 1;
			end = line.indexOf(chComma, start + 1);
		}
		if (start < line.length()) {
			value = line.substring(start);
			str[index++] = value;
		}
		return str;
	}

	// Create new Book list
	public void createList(String fileName) throws BookException  {
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			
			String line;

			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");

				try {
					if (values.length == 6) {
						
						String name = values[0];
						String author = values[1];
						String language = values[2];
						int year = Integer.parseInt(values[3]);
						float sale = Float.parseFloat(values[4]);
						String genre = values[5];
						Book newBook = new Book(name, author, language, year, sale, genre, 0);
						bestsellers.add(newBook);
						
					}
				} catch (NumberFormatException e) {
					System.err.println(" " + e);
				}
			}

		} catch(FileNotFoundException fnfe) {
			throw new BookException(" " + fnfe);
        	
		}catch (IOException e) {
			
		}
			
	}

	private String clean(String g) {
		return g;

	}

	// save file to the list
	public void saveList(String filePath) throws BookException {
		String title = "Output.csv";
		try{
			InputStream file = new FileInputStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			
			FileOutputStream output = new FileOutputStream(title);
			String line;
			
			while((line = reader.readLine()) != null) {
				output.write(line.getBytes());
				output.write(System.lineSeparator().getBytes());
			}
			  reader.close();
			  output.close();
			  
            System.out.println("Sucessfully save to file.");
            
        } catch(FileNotFoundException fnfe) {
        	System.err.println(" " + fnfe);
        }catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        } 
	}

	// print out the book list
	public void printList() throws BookException {
	
		for (Book book : bestsellers) {
			getSize();	
			break;
		}
	}

	// edit book
	public void edit(int pos, String name,String author,String language,int year,float sale, String genre,int star) throws BookException {
		
		try {
			Book updateBook = bestsellers.get(pos);
			updateBook.setName(name);
			updateBook.setAuthor(author);
			updateBook.setOriginalLanguage(language);
			updateBook.setFirstPubllished(year);
			updateBook.setMilionSales(sale);
			updateBook.setGenre(genre);
			updateBook.setStar(star);
			} catch(IndexOutOfBoundsException e) {
				throw new BookException("" + e);
			}
	}

	// return arraylist size
	public void getSize() throws BookException {
		
		for (int i = 0; i < bestsellers.size(); i++) {

			System.out.println((i + 1) + "." + bestsellers.get(i));
		}

	}

	// add book
	public void add(Book list) throws BookException {
		bestsellers.add(list);

	}

	// delete book
	public void delete(int pos) throws BookException {
		try {
			bestsellers.remove(pos);
			System.out.println("Book deleted successfully.");
		} catch (IndexOutOfBoundsException e) {
			throw new BookException("" + e);
		}
	}

	// search the the book name or author
	public ArrayList<Book> search(String search) throws BookException {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : bestsellers) {
			if (book.getName().toLowerCase().contains(search.toLowerCase())
					|| book.getAuthor().toLowerCase().contains(search.toLowerCase()) || book.getFirstPublished() == Integer.parseInt(search) 
					|| book.getStar() == Integer.parseInt(search)) {
				result.add(book);
			}
		}

		System.out.println(result);
		System.out.println("...................................");
		return result;
	}
	
	// Classify book with stars
	public void classify(int index, int newStar)throws BookException {
		try {
			
		bestsellers.get(index).setStar(newStar);
		} catch(IndexOutOfBoundsException e) {
			throw new BookException("" + e);
		}
		System.out.println("Successfully updated star review.");
		
	}
	
	// Switch book index
	public void changeIndex(int first, int second) throws BookException {
		try {
			
			Collections.swap(bestsellers, first, second);
		} catch (IndexOutOfBoundsException e) {
			throw new BookException("" + e);
		}
		System.out.println("Updated bookList.......");

	}
}
