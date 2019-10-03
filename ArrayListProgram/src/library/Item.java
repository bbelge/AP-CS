//Berke Belge, Library Program, 12/13/2017
package library;

public abstract class Item {
	private String title;
	
	//constructors
	public Item(){
		title = "";
	}
	
	public Item(String t){
		title = t;
	}
	
	//getters and setters
	public void setTitle(String t){
		title = t;
	}
	
	public String getTitle(){
		return title;
	}
	
	public abstract String print();
}

