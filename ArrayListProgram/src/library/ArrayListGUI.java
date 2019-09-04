package library;

import java.util.Calendar;

import javax.swing.*; 
import BreezySwing.*;

public class ArrayListGUI extends GBFrame{
	private JButton addBook, reset, loanBook, returnBook, printAll, printOverdue, printBorrowed;
	private JTextField newTitle, newAuthor, titleBorrowed, nameBorrowed;
	private JTextArea outputArea;
	private Library all = new Library();


	public ArrayListGUI() { // default constructor
		setTitle("ArrayList Program");

		addBook = addButton("Add Book",1,3,1,1);
		loanBook = addButton("Loan Book",4,3,1,1);
		returnBook = addButton("Return Book",5,3,1,1);
		printAll = addButton("Print All",6,6,1,1);
		printOverdue = addButton("Print Overdue",7,6,1,1);
		printBorrowed = addButton("Print Borrowed",8,6,1,1);
		reset = addButton("Reset",1,6,1,1);

		addLabel("Title:",1,1,1,1);
		addLabel("Author:",1,2,1,1);
		addLabel("Title to be Borrowed:",4,1,1,1);
		addLabel("Name of Borrower:",4,2,1,1);

		newTitle = addTextField("", 2,1,1,1);
		newAuthor = addTextField ("",2,2,1,1);
		titleBorrowed = addTextField ("",5,1,1,1);
		nameBorrowed = addTextField ("",5,2,1,1);

		outputArea = addTextArea("",6,1,4,3);

		outputArea.setEditable(false);
	}

	public void buttonClicked(JButton buttonObj){ // provide action based on button clicked
		if (buttonObj == addBook) { // check and add item to database
			try {
				all.addBook(newTitle.getText(), newAuthor.getText());
			}catch(IllegalArgumentException e) {
				messageBox(e);
			}
			newTitle.setText("");
			newAuthor.setText("");
		}else if (buttonObj == loanBook) {
			try {
				all.loanBook(titleBorrowed.getText(), nameBorrowed.getText());
			}catch(IllegalArgumentException e) {
				messageBox(e);
			}
			nameBorrowed.setText("");
			titleBorrowed.setText("");
		}else if (buttonObj == returnBook) { 
			try {
				all.returnBook(titleBorrowed.getText());
			}catch(IllegalArgumentException e) {
				messageBox(e);
			}
			nameBorrowed.setText("");
			titleBorrowed.setText("");
		}else if (buttonObj == printAll) { 
			outputArea.setText(all.printAll());
		}else if (buttonObj == printOverdue) { 
			outputArea.setText(all.printOverdue());
		}else if (buttonObj == printBorrowed) { 
			outputArea.setText(all.printBorrowed());
		}else if (buttonObj == reset) { // reset program
			SortSearch.reset();
			all.reset();
			newTitle.setText("");
			newAuthor.setText("");
			titleBorrowed.setText("");
			nameBorrowed.setText("");
			outputArea.setText("");
		}
	}

	public static void main(String args[]){
		System.out.print(Calendar.getInstance().get(Calendar.YEAR) + "");
		ArrayListGUI GUI = new ArrayListGUI(); // initialize GUI object
		GUI.setSize(1100, 800); // set window size
		GUI.setVisible(true); // make window visible
	}
}
