package library;

import BreezySwing.*;
import javax.swing.*;

public class LibraryGUI extends GBFrame{

	private Database database = new Database(); // instance variables
	private IntegerField issueField;
	private JTextField bookTitleField, pTitleField, authorField;
	private JButton inputBookButton, inputPButton, outputBooksButton, outputPsButton, outputAllButton, resetButton;
	private JTextArea BookArea, PArea;

	public LibraryGUI(){ // default constructor
		addLabel("Library Program",1,1,1,1);
		addLabel("title:",2,1,1,1);
		addLabel("author:",2,2,1,1);
		addLabel("title:",4,1,1,1);
		addLabel("issue number:",4,2,1,1);

		bookTitleField = addTextField("",3,1,1,1);
		authorField = addTextField("",3,2,1,1);
		pTitleField = addTextField("",5,1,1,1);
		issueField = addIntegerField(0,5,2,1,1);

		inputBookButton = addButton("input book",2,3,1,1);
		inputPButton = addButton("input periodical",4,3,1,1);
		outputBooksButton = addButton("output books",6,1,2,1);
		outputPsButton = addButton("output periodicals",6,4,2,1);
		outputAllButton = addButton("output all",6,3,1,1);
		resetButton = addButton("reset",1,5,1,1);

		BookArea = addTextArea("",7,1,2,1);
		PArea = addTextArea("",7,4,2,1);


		BookArea.setEditable(false);
		PArea.setEditable(false);
	}

	public void buttonClicked (JButton buttonObj){
		if (buttonObj == inputBookButton){ // input book
			try {
				database.addItem(bookTitleField.getText(), authorField.getText());
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				messageBox(e);
				bookTitleField.setText("");
				authorField.setText("");
			}
			bookTitleField.setText("");
			pTitleField.setText("");
			authorField.setText("");
			issueField.setNumber(0);
		}else if (buttonObj == inputPButton) { // input periodical
			try {
				database.addItem(pTitleField.getText(), issueField.getNumber());
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				messageBox(e);
				pTitleField.setText("");
				issueField.setNumber(0);
			}
			bookTitleField.setText("");
			pTitleField.setText("");
			authorField.setText("");
			issueField.setNumber(0);
		}else if (buttonObj == outputBooksButton) { // output books
			BookArea.setText(database.printAllBooks());
		}else if (buttonObj == outputPsButton) { // input periodical
			PArea.setText(database.printAllPeriodicals());
		}else if (buttonObj == outputAllButton) { // input periodical
			BookArea.setText(database.printAllBooks());
			PArea.setText(database.printAllPeriodicals());
		}else { // reset
			database = new Database();
			bookTitleField.setText("");
			pTitleField.setText("");
			authorField.setText("");
			BookArea.setText("");
			PArea.setText("");
			issueField.setNumber(0);
		}
	}

	public static void main(String args[]){
		LibraryGUI GUI = new LibraryGUI(); // initialize GUI object
		GUI.setSize(1500, 800); // set window size
		GUI.setVisible(true); // make window visible
	}
}

