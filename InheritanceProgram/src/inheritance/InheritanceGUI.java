// inheritance Program, Berke Belge, 11/30/2017
package inheritance;

import BreezySwing.*;
import javax.swing.*;

public class InheritanceGUI extends GBFrame{

	private Database database = new Database(); // instance variables
	private IntegerField IDField;
	private JTextField nameField, majorField, gradeLevelField, compareField;
	private JButton inputButton, outputStudentsButton, compareButton, 
	outputUndergraduatesButton, outputGraduatesButton, outputPersonsButton, resetButton;
	private JTextArea printArea, comparisonArea;

	public InheritanceGUI(){ // default constructor
		addLabel("Inheritance Program",1,1,1,1);
		addLabel("name:",2,1,1,1);
		addLabel("student ID:",2,2,1,1);
		addLabel("grade level:",2,3,1,1);
		addLabel("major:",2,4,1,1);
		addLabel("print area:",5,1,2,1);
		addLabel("comparison area:",5,4,2,1);

		nameField = addTextField("",3,1,1,1);
		IDField = addIntegerField(0,3,2,1,1);
		gradeLevelField = addTextField("",3,3,1,1);
		majorField = addTextField("",3,4,1,1);
		compareField = addTextField("",5,5,1,1);

		inputButton = addButton("input person",2,5,1,1);
		outputStudentsButton = addButton("print students",4,1,1,1); 
		outputUndergraduatesButton = addButton("print undergraduates",4,2,1,1);
		outputGraduatesButton = addButton("print gaduates",4,3,1,1);
		outputPersonsButton = addButton("print persons",4,4,1,1);
		resetButton = addButton("reset",1,5,1,1);
		compareButton = addButton("compare:",4,5,1,1);

		printArea = addTextArea("",6,1,2,1);
		comparisonArea = addTextArea("",6,4,2,1);


		printArea.setEditable(false);
		comparisonArea.setEditable(false);
	}

	public void buttonClicked (JButton buttonObj){
		if (buttonObj == inputButton){ // input person
			try { // check for errors
				database.addObject(nameField.getText(), IDField.getNumber(), gradeLevelField.getText(), majorField.getText());
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				messageBox(e);
			}
			nameField.setText("");
			IDField.setNumber(0);
			gradeLevelField.setText("");
			majorField.setText("");
			compareField.setText("");
		}else if (buttonObj == outputStudentsButton){ // print buttons (prints data of specified objects)
			printArea.setText(database.printStudents());
		}else if (buttonObj == outputUndergraduatesButton){
			printArea.setText(database.printUndergraduates());
		}else if (buttonObj == outputGraduatesButton){
			printArea.setText(database.printGraduates());
		}else if (buttonObj == outputPersonsButton){
			printArea.setText(database.printAll());
		}else if (buttonObj == compareButton){ // get comparisons for a graduate or undergraduate
			try {comparisonArea.setText(database.getFullComparison(compareField.getText()));}
			catch(IllegalArgumentException e) {
				messageBox(e);
			}
		}else { // reset program
			database = new Database();
			printArea.setText("");
			comparisonArea.setText("");
			nameField.setText("");
			IDField.setNumber(0);
			gradeLevelField.setText("");
			majorField.setText("");
			compareField.setText("");
		}
	}

	public static void main(String args[]){
		InheritanceGUI GUI = new InheritanceGUI(); // initialize GUI object
		GUI.setSize(1500, 800); // set window size
		GUI.setVisible(true); // make window visible
	}
}

