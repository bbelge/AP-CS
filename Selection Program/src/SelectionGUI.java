// Berke Belge, Selection Sort Program
import javax.swing.*;
import BreezySwing.*;
public class SelectionGUI extends GBFrame{
	JButton finalize, reset, addPerson;
	JTextField name;
	IntegerField age;
	JTextArea outputArea;
	AllStudents all = new AllStudents();


	public SelectionGUI() { // default constructor
		finalize = addButton("Finalize",1,1,1,1);
		addPerson = addButton("Add Person",6,1,1,1);
		reset = addButton("Reset",7,1,1,1);

		addLabel("Name:",2,1,1,1);
		addLabel("Age:",4,1,1,1);

		name = addTextField ("",3,1,1,1);
		age = addIntegerField (0,5,1,1,1);

		outputArea = addTextArea("",2,3,2,2);

		outputArea.setEditable(false);
	}

	public void buttonClicked(JButton buttonObj){ // provide action based on button clicked
		if (buttonObj == addPerson) {
			try {
				if (finalize.isEnabled()) {
					all.addPerson(name.getText(), age.getNumber());
				}else {
					all.replacePerson(name.getText(), age.getNumber());
					outputArea.setText(all.toString());
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				messageBox(e);
			}
			name.setText("");
			age.setNumber(0);
		}else if (buttonObj == finalize) {
			all.sortName();
			finalize.setEnabled(false);
			outputArea.setText(all.toString());
			name.setText("");
			age.setNumber(0);
		}else if (buttonObj == reset) {
			all = new AllStudents();
			name.setText("");
			age.setNumber(0);
			outputArea.setText("");
			finalize.setEnabled(true);
		}
	}

	public static void main(String args[]){
		SelectionGUI GUI = new SelectionGUI(); // initialize GUI object
		GUI.setSize(900, 600); // set window size
		GUI.setVisible(true); // make window visible
	}
}

