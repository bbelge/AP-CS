package library;

public class Database {
	private Item[] items;
	private int numItems;
	
	//constructor
	public Database(){ 
		items = new Item[15];
		numItems = 0;
	}
	 
	//add periodical
	public void addItem(String t, int i){
		if (i <= 0 || t.isEmpty())
			throw new IllegalArgumentException("Invalid input.");
		if (numItems >= 15)
			throw new ArrayIndexOutOfBoundsException("Maximum number of items has been reached.");
		items[numItems] = new Periodical(t, i);
		numItems++;
	}
	
	//add book
	public void addItem(String t, String a){
		if (a.isEmpty() || t.isEmpty())
			throw new IllegalArgumentException("Invalid input.");
		if (numItems >= 15)
			throw new ArrayIndexOutOfBoundsException("Maximum number of items has been reached.");
		items[numItems] = new Book(t, a);
		numItems++;
	}
	
	//print books
	public String printAllBooks(){
		Book[] books = new Book[15];
		int numBooks = 0;
		Book temp = null;
		for (int i=0; i < numItems; i++){
			if (items[i] instanceof Book){
				books[numBooks] = (Book) items[i];
				numBooks++;
			}	
		}

		for (int i=0; i < numBooks; i++){
			for (int j=i+1; j < numBooks; j++){
				if (books[i].compareTo(books[j]) < 0){
					temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				}
			}
		}
		
		String str = "";
		for (int i=0; i < numBooks; i++){
			str += books[i].print() + "\n";
		}
		
		return str;
	}
	
	//print periodicals
	public String printAllPeriodicals(){
		Periodical[] ps = new Periodical[15];
		int numPs = 0;
		Periodical temp = null;
		for (int i=0; i < numItems; i++){
			if (items[i] instanceof Periodical){
				ps[numPs] = (Periodical) items[i];
				numPs++;
			}	
		}
		
		for (int i=0; i < numPs; i++){
			for (int j=i+1; j < numPs; j++){
				if (ps[i].compareTo(ps[j]) < 0){
					temp = ps[i];
					ps[i] = ps[j];
					ps[j] = temp;
				}
			}
		}
		
		String str = "";
		for (int i=0; i < numPs; i++){
			str += ps[i].print() + "\n";
		}
		
		return str;
	}
	
}
