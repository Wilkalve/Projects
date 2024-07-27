package CST8132A2.system.book;

import java.util.HashSet;

public class BookLanguageSet {
HashSet<String> languageSet = new HashSet<>();
BookList lists = new BookList();
public void addLanguage(String language){
    languageSet.add(language);
    for(Book book: lists.bestSellers){
        languageSet.add(book.getLanguage());
     }
}

public void printLanguageSet(){
    
    for(String lg: languageSet){
        System.out.println(lg);
    }
    
}
}
