package library;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public Library() {
		books = new ArrayList<Book>();
	}
	
	public void reset() {
		books = new ArrayList<Book>();
	}
	
	public void addBook(String t, String a) {
		Book temp = new Book(t, a);
		books.add(temp);
		SortSearch.setBooks(books);
		SortSearch.selectionSort();
		books = new ArrayList<Book>();
		books.addAll(SortSearch.getBooks());
	}
	
	public void loanBook(String t, String n) {
		int index = SortSearch.binarySearch(t);
		if (index == -1) {
			throw new IllegalArgumentException("no book of such name");
		}
		
		books.get(index).borrow(n);
		SortSearch.setBooks(books);
		books = new ArrayList<Book>();
		books.addAll(SortSearch.getBooks());
	}
	
	public void returnBook(String t) {
		int index = SortSearch.binarySearch(t);
		if (index == -1) {
			throw new IllegalArgumentException("no book of such name");
		}
			
		books.get(index).returnBook();
		SortSearch.setBooks(books);
		books = new ArrayList<Book>();
		books.addAll(SortSearch.getBooks());
	}
	
	public String printAll() {
		String str = "Title	Author\n";
		for (int i = 0; i < books.size(); i++) {
			str += books.get(i).print();
		}
		return str;
	}
	
	public String printOverdue() {
		String str = "Title	Author\n";
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).checkOverdue())
				str += books.get(i).print();
		}
		return str;
	}
	
	public String printBorrowed() {
		String str = "Title	Author\n";
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).checkBorrowed())
				str += books.get(i).print();
		}
		return str;
	}
}
