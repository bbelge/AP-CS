package searchdelete;
// Berke Belge, Final Sort Program
import javax.swing.*; 
import BreezySwing.*;
public class SearchGUI extends GBFrame{
	private int type;
	private JButton studentButton, reset, widgetButton, empButton, binary, linear, insertion, selection, addPerson;
	private JTextField input1, searchField, input2;
	private JTextArea outputArea;
	private SortSearch all = new SortSearch();
	private JLabel label1, label2;


	public SearchGUI() { // default constructor
		setTitle("Final Sort");
		
		addPerson = addButton("Add Person",6,1,1,1);
		reset = addButton("Reset",7,1,1,1);
		insertion = addButton("Insertion Sort",2,2,1,1);
		selection = addButton("Selection Sort",3,2,1,1);
		studentButton = addButton("Student",5,2,1,1);
		widgetButton = addButton("Widget",6,2,1,1);
		empButton = addButton("Employee",7,2,1,1);
		binary = addButton("Binary Search",7,3,1,1);
		linear = addButton("Linear Search",7,4,1,1);

		label1 = addLabel("Name:",2,1,1,1);
		label2 = addLabel("GPA:",4,1,1,1);

		searchField = addTextField("", 6,3,4,1);
		input1 = addTextField ("",3,1,1,1);
		input2 = addTextField ("",5,1,1,1);

		outputArea = addTextArea("",2,3,4,2);

		studentButton.setEnabled(false);
		outputArea.setEditable(false);
		type = 1;
	}

	public void buttonClicked(JButton buttonObj){ // provide action based on button clicked
		if (buttonObj == addPerson) { // check and add item to database
			try {
				if (type == 1) {
					SortSearch.addStudent(input1.getText(), Double.parseDouble(input2.getText()));
				}else if (type == 3) {
					SortSearch.addEmployee(input1.getText(), Double.parseDouble(input2.getText()));
				}else if (type == 2) {
					SortSearch.addWidget(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
				}
			}catch(ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
				messageBox(e);
			}
			input1.setText("");
			input2.setText("");
		}else if (buttonObj == studentButton) { // set focus to student
			type = 1;
			addPerson.setText("Add Student");
			studentButton.setEnabled(false);
			empButton.setEnabled(true);
			widgetButton.setEnabled(true);
			label1.setText("Name:");
			label2.setText("GPA:");
		}else if (buttonObj == widgetButton) { // set focus to widget
			type = 2;
			addPerson.setText("Add Widget");
			studentButton.setEnabled(true);
			empButton.setEnabled(true);
			widgetButton.setEnabled(false);
			label1.setText("Number Sold:");
			label2.setText("Product Number:");
		}else if (buttonObj == empButton) { // set focus to employee
			addPerson.setText("Add Employee");
			type = 3;
			studentButton.setEnabled(true);
			empButton.setEnabled(false);
			widgetButton.setEnabled(true);
			label1.setText("Name:");
			label2.setText("Salary:");
		}else if (buttonObj == insertion) { // insertion sort
			SortSearch.insertionSort(1);
			SortSearch.insertionSort(2);
			SortSearch.insertionSort(3);
			outputArea.setText(all.toString());
		}else if (buttonObj == selection) { // selection sort
			SortSearch.selectionSort(1);
			SortSearch.selectionSort(2);
			SortSearch.selectionSort(3);
			outputArea.setText(all.toString());
		}else if (buttonObj == linear) { // linear search
			if (type == 1) {
				Dialog dlg = new Dialog(this, 1, searchField.getText(), -1, -1);
				dlg.setVisible (true);
			}else if (type == 2) {
				Dialog dlg = new Dialog(this, 1, "NA", Integer.parseInt(searchField.getText()), -1);
				dlg.setVisible (true);
			}else if (type == 2) {
				Dialog dlg = new Dialog(this, 1, "NA", -1, Double.parseDouble(searchField.getText()));
				dlg.setVisible (true);
			}
		}else if (buttonObj == binary) { // binary search
			if (type == 1) {
				Dialog dlg = new Dialog(this, 2, searchField.getText(), -1, -1);
				dlg.setVisible (true);
			}else if (type == 2) {
				Dialog dlg = new Dialog(this, 2, "NA", Integer.parseInt(searchField.getText()), -1);
				dlg.setVisible (true);
			}else if (type == 2) {
				Dialog dlg = new Dialog(this, 2, "NA", -1, Double.parseDouble(searchField.getText()));
				dlg.setVisible (true);
			}
		}else if (buttonObj == reset) { // reset program
			SortSearch.reset();
			input1.setText("");
			input2.setText("");
			searchField.setText("");
			searchField.setText("");
			outputArea.setText("");
		}
	}

	public static void main(String args[]){
		SearchGUI GUI = new SearchGUI(); // initialize GUI object
		GUI.setSize(1100, 800); // set window size
		GUI.setVisible(true); // make window visible
	}
}


