package CST8132A2.system.book;

import java.util.HashSet;

public class BookGenreSet {
HashSet<String> genreSet = new HashSet<>();
BookList list = new BookList();
Book blk = new Book();
// populate the the hashSet list
public void addGenre(String genre){
    genreSet.add(genre);
    for( Book book: list.getBestSellers()){
      genreSet.add(book.getGenre()); 
  
    }
}
// print out the genre set list
public void printGenreSet(){
   for(String bk: genreSet){
      System.out.println(bk);
   }
}

}
