package library;

import java.util.Calendar;

public class Book extends Item implements Comparable{
	private String author, name;
	private Date date;
	
	//constructors
	public Book(){
		super();
		author = "";
		name = "";
		date = new Date();
	}
	
	public Book(String t, String a){
		super(t);
		author = a;
		name = "";
		date = new Date();
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setDate(String n) {
		date.borrow();
	}
	
	public void borrow(String n) {
		date.borrow();
		name = n;
	}
	
	public void returnBook() {
		date = new Date();
		name = "";
	}
	
	public boolean checkOverdue() {
		if (Calendar.getInstance().get(Calendar.YEAR) > date.getYear() || Calendar.getInstance().get(Calendar.DAY_OF_YEAR) > date.getDay())
			return true;
		else return false;
	}
	
	public boolean checkBorrowed() {
		if (date.getYear() != 100000000)
			return true;
		else return false;
	}
	
	 // get methods
	public String getAuthor(){
		return author;
	}
	
	public String getName(){
		return name;
	}
	
	public Date getDate() {
		return date;
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
		return super.getTitle() + "	" + author + "\n";
	}
	
}

