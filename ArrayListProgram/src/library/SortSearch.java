package library;

import java.util.ArrayList;

public class SortSearch {
	private static ArrayList<Book> books;
	
	public SortSearch(){ // constructor
		books = new ArrayList<Book>();
	}
	
	public static ArrayList getBooks() {
		return books;
	}
	
	public static void setBooks(ArrayList b) {
		books = new ArrayList<Book>();
		books.addAll(b);
		selectionSort();
	}
	
	public static void reset() { // reset private variables
		books = new ArrayList<Book>();
	}
	
	public static int binarySearch(String t){ // binary search
		int str = -1;
	        int l = 0, r = books.size()-1;
	        while (l <= r)
	        {
	            int m = l + (r-l)/2;
	 
	            if (books.get(m).getTitle().equals(t))
	            	str = m;
	            if (books.get(m).getTitle().compareTo(t) < 0)
	                l = m + 1;
	            else
	                r = m - 1;
	        }
		
		return str;
	}

	public static void selectionSort() { // selection sort methods
		for (int i = 0; i<books.size(); i++) {
			int minIndex=findMinimum(i);
			if (minIndex!=i)
				swap(i,minIndex);
		}
	}

	private static int findMinimum(int first) {
		int minIndex=first;
		for (int i = first+1; i<books.size(); i++)
			if(((Book) books.get(i)).compareTo(books.get(minIndex)) > 0)
				minIndex = i;
		return minIndex;
	}

	private static void swap(int x, int y) {
		Book temp = (Book) books.get(x);
		books.set(x, books.get(y));
		books.set(y, temp);
	}
}
