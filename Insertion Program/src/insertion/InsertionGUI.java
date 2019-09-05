// Berke Belge, 2/13/2018, Insertion Sort
package insertion;

import javax.swing.*;
import BreezySwing.*;
public class InsertionGUI extends GBFrame{
	Insertion insertion;
	JButton inputButton, resetButton;
	JTextArea outputArea;
	IntegerField inputField;

	public InsertionGUI(){
		insertion = new Insertion();

		addLabel("Insertion Program",1,1,1,1);
		inputField = addIntegerField(0,1,2,1,1);
		inputButton = addButton("Input Number",1,3,1,1);
		resetButton = addButton("Reset",1,5,1,1);
		outputArea = addTextArea("",1,4,1,1);
		
		inputField.requestFocus();
		inputField.selectAll();
		
	}

	public void buttonClicked(JButton buttonObj){
		if (buttonObj == inputButton) {
			try {
				insertion.setNums(inputField.getNumber());
				outputArea.setText(insertion.toString());
			}catch(ArrayIndexOutOfBoundsException e) {
				messageBox("You have reached the maximum number of values.");
			}
			inputField.requestFocus();
			inputField.selectAll();
		}else {
			inputField.setNumber(0);
			outputArea.setText("");
			insertion = new Insertion();
			inputField.requestFocus();
			inputField.selectAll();
		}
	}

	public static void main(String args[]){
		InsertionGUI GUI = new InsertionGUI(); // initialize GUI object
		GUI.setSize(900, 400); // set window size
		GUI.setVisible(true); // make window visible
	}
}
