package CST8132A2.system.book;

import CST8132A2.system.exception.BookException;
import CST8132A2.system.util.SystemUtil;

public class Book implements BookDownloader, BookReadable{
    private int index;
    private String name;
    private String author;
    private String language;
    private int published;
    private float milionSales;
    private String genre;

    public Book(String name, String author, String language, int published, float milionSales,
    String genre) throws BookException{
        this.name = name;
        this.author = author;
        this.language = language;
        this.published = published;
        this.milionSales = milionSales;
        this.genre = genre; 
    }
    public Book(){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getLanguage(){
        return language;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public int getPublished(){
        return published;
    }
    public void setPublished(int published){
        this.published = published;
    }
    public float getMilionSales(){
        return milionSales;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    // toString method
    public String toStringBook(){
        return "Name: " + name + ", Author: " + author + ", Language: " + language + ", Year published: " + published +
         ", Milion of Sales: " + milionSales + ", Genre: " + genre + "\n";
         
    }

// Method for a creating book
public static Book createBook(String name, String author, String language, String published, String milionSales, String genre)throws BookException{
    SystemUtil util = new SystemUtil();
    
   
    int year = 1;
    float sales = 0;
   
    if(!util.isValid(name)){
        throw new BookException("Name cannot be empty, null or blank.");
    }
    if(!util.isValid(author)){
        throw new BookException("author cannot be empty, null or blank.");
    }
    if(!util.isValid(language)){
        throw new BookException("Language cannot be empty, null or blank.");
    }
    if(!util.isValid(published)){
        throw new BookException("Year published cannot be empty, null or blank.");
    }

    try{
     year = Integer.parseInt(published);
    } catch (NumberFormatException e) {
    System.err.println(" " + e);
   }

    if(!util.isValid(milionSales)){
        throw new BookException("Milion of sales cannot be empty, null or blank.");
    }
    try{
     sales = Float.parseFloat(milionSales);
    } catch (NumberFormatException e) {
    System.err.println(" " + e);
    }
    if(!util.isValid(genre)){
        throw new BookException("Genre cannot be empty, null or blank.");
    }
    
		return new Book(name, author, language, year, sales, genre);
	

}
// Search if the book is contain in the book list
public boolean containSearch(String search) {
    return name.contains(search) || author.contains(search) || language.contains(search)
    	|| genre.contains(search) || published == Integer.parseInt(search) ;
}

}

