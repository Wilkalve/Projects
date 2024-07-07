package bestseller;

public class Book {
	private int index;
	private String name;
	private String author;
	private String originalLanguage;
	private int firstPublished;
	private float milionSales;
	private String genre;
	private String title;
	private int star;

	// Overloaded constructor
	public Book(String name, String author, String originalLanguage, int firstPublished, float milionsales,
			String genre, int star) throws BookException{
		
		if (name == null || name.isEmpty() || author == null || author.isEmpty() || originalLanguage == null || originalLanguage.isEmpty() || firstPublished <= 0 || firstPublished > 2024 || milionsales < 0
					|| genre == null) {
			 throw new BookException(" Invalid book data input ");
			} else {
				this.name = name;
				this.author = author;
				this.originalLanguage = originalLanguage;
				this.firstPublished = firstPublished;
				this.milionSales = milionsales;
				this.genre = genre;
				this.star = star;
			}
	}

	public Book(String title) {
		this.title = title;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public int getFirstPublished() {
		return firstPublished;
	}

	public void setFirstPubllished(int firstPublished) {
		this.firstPublished = firstPublished;
	}

	public float getMilionSales() {
		return milionSales;
	}

	public void setMilionSales(float milionSales) {
		this.milionSales = milionSales;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getStar() {
		return star;
	}
  public void setStar(int star) {
	  this.star = star;
  }
	// return a string for a specific book search
	public boolean containSearch(String search) {
		return name.contains(search) || author.contains(search) || originalLanguage.contains(search)
				|| genre.contains(search);
	}

	// return a toString of Book parameters
	public String toString() {
		
		return " Book [Title = " + name + ", Author = " + author + ", Original Language = " + originalLanguage
				+ ", Year Published = " + firstPublished + ", Milion sales = " + milionSales + ", Genre = " + genre
				+ ", Number of Start: " + star + "]";
	}



}
