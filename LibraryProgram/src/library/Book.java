package library;

public class Book extends Item implements Comparable{
	private String author;
	
	//constructors
	public Book(){
		super();
		author = "";
	}
	
	public Book(String t, String a){
		super(t);
		author = a;
	}
	
	 //getter
	public String getAuthor(){
		return author;
	}
	
	@Override
	public int compareTo(Object o){
		
		for(int i=0; i < (Math.min(((Book) o).getAuthor().length(), author.length())); i++){
			if ((((Book) o).getAuthor().charAt(i) < author.charAt(i)))
				return -1;
			else if ((((Book) o).getAuthor().charAt(i) > author.charAt(i)))
				return 1;
		}
		
		for(int i=0; i < (Math.min(((Book) o).getTitle().length(), super.getTitle().length())); i++){
			if ((((Book) o).getTitle().charAt(i) < super.getTitle().charAt(i)))
				return -1;
			else if ((((Book) o).getTitle().charAt(i) > super.getTitle().charAt(i)))
				return 1;
		}
		
		return 0;
	}
	
	@Override
	public String print(){
		return super.getTitle() + "	" + author;
	}
	
}

