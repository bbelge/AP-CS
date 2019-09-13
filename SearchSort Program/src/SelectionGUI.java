// Berke Belge, Search Program
import javax.swing.*;
import BreezySwing.*;
public class SelectionGUI extends GBFrame{
	JButton sortName, sortAge, reset, addPerson, search;
	JTextField name, searchField;
	IntegerField age;
	JTextArea outputArea;
	Search all = new Search();


	public SelectionGUI() { // default constructor
		sortName = addButton("Sort by Name",1,1,1,1);
		sortAge = addButton("Sort by Age",1,2,1,1);
		addPerson = addButton("Add Person",6,1,1,1);
		reset = addButton("Reset",7,1,1,1);
		search = addButton("Search by Name", 7,4,1,1);

		addLabel("Name:",2,1,1,1);
		addLabel("Age:",4,1,1,1);

		searchField = addTextField("",6,4,1,1);
		name = addTextField ("",3,1,1,1);
		age = addIntegerField (0,5,1,1,1);

		outputArea = addTextArea("",2,3,2,2);

		outputArea.setEditable(false);
	}

	public void buttonClicked(JButton buttonObj){ // provide action based on button clicked
		if (buttonObj == addPerson) {
			if (age.getNumber() < 0) {
				messageBox("Age is less than 0.");
			}else {
				try {
					all.addPerson(name.getText(), age.getNumber());
				}catch(ArrayIndexOutOfBoundsException e) {
					messageBox(e);
				}
			}
			name.setText("");
			age.setNumber(0);
		}else if (buttonObj == sortName) {
			all.sortName();
			outputArea.setText(all.toString());
			name.setText("");
			age.setNumber(0);
		}else if (buttonObj == sortAge) {
			all.sortAge();
			outputArea.setText(all.toString());
			name.setText("");
			age.setNumber(0);
		}else if (buttonObj == reset) {
			all = new Search();
			name.setText("");
			age.setNumber(0);
			outputArea.setText("");
		}else if (buttonObj == search) {
			int index = all.findPerson(searchField.getText());
			if (index == -1) {
				messageBox("No person with such name.");
			}else {
				Dialog dlg = new Dialog(this, all, index);
				dlg.setVisible (true);
				if (dlg.getDlgCloseIndicator().equals("OK"))
					outputArea.setText(all.toString());
			}
		}
	}

	public static void main(String args[]){
		SelectionGUI GUI = new SelectionGUI(); // initialize GUI object
		GUI.setSize(900, 600); // set window size
		GUI.setVisible(true); // make window visible
	}
}


