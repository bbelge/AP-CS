// Static methods program, Berke Belge, 11/6/2017
package staticprogram;

import javax.swing.*; 
import BreezySwing.*;

public class StaticGUI extends GBFrame{

	private StaticInterface sinterface = new StaticInterface(); // instance variables
	private JLabel programLabel, ageLabel, gradeLevelLabel,
	nameLabel;
	private IntegerField studentAgeField, employeeAgeField, gradeLevelField,
	numEmployeesField, numStudentsField, ageField;
	private JTextField studentNameField, employeeNameField;
	private JButton inputEmployeeButton, inputStudentButton, inputEmployeeStudentButton, ageButton,
	outputEmployeeButton, outputStudentButton, numStudentsButton, numEmployeesButton, resetButton;
	private JTextArea employeeArea, studentArea, ageArea;



	public StaticGUI(){ // default constructor
		programLabel = addLabel("Static Method Program",1,1,1,1);
		ageLabel = addLabel("age:",2,2,1,1);
		gradeLevelLabel = addLabel("grade level:",2,3,1,1);
		nameLabel = addLabel("name:",2,1,1,1);

		studentNameField = addTextField("",3,1,1,1);
		employeeNameField = addTextField("",5,1,1,1);

		ageField = addIntegerField(0,7,3,1,1);
		studentAgeField = addIntegerField(0,3,2,1,1);
		employeeAgeField = addIntegerField(0,5,2,1,1);
		gradeLevelField = addIntegerField(0,3,3,1,1);
		numEmployeesField = addIntegerField(0,6,4,1,1);
		numStudentsField = addIntegerField(0,4,4,1,1);

		inputStudentButton = addButton("input student",4,1,1,1);
		inputEmployeeStudentButton = addButton("input student & employee",4,2,1,1);
		inputEmployeeButton = addButton("input employee",6,1,1,1);
		numStudentsButton = addButton("output number of students",3,4,1,1);
		numEmployeesButton = addButton("output number of employees",5,4,1,1);
		outputStudentButton = addButton("output students:",7,1,1,1);
		outputEmployeeButton = addButton("output employees:",7,2,1,1);
		ageButton = addButton("search for people of given age:",6,3,1,1);
		resetButton = addButton("reset",1,4,1,1);

		studentArea = addTextArea ("",8,1,1,1);
		employeeArea = addTextArea ("",8,2,1,1);
		ageArea = addTextArea ("",8,3,1,1);

		studentArea.setText(Format.justify('l', "name", 15)
				+ Format.justify('l', "age", 7)
				+ Format.justify('l', "grade", 7) + "\n");
		employeeArea.setText(Format.justify('l', "name", 15)
				+ Format.justify('l', "age", 9) + "\n");
		studentArea.setEditable(false);
		employeeArea.setEditable(false);
		ageArea.setEditable(false);
	}

	public void buttonClicked (JButton buttonObj){
		if (buttonObj == inputEmployeeButton) { // input employee
			try{ // check for exceptions
				StaticInterface.checkEmployeeInput(employeeAgeField.getNumber(), employeeNameField.getText());
				sinterface.setEmployee(employeeAgeField.getNumber(), employeeNameField.getText());
				
				employeeAgeField.setNumber(0);
				employeeNameField.setText("");
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				employeeAgeField.setNumber(0);
				employeeNameField.setText("");
				messageBox(e);
			}
		}else if (buttonObj == inputStudentButton) { // input student
			try{ // check for exceptions
				StaticInterface.checkStudentInput(studentAgeField.getNumber(), studentNameField.getText(), gradeLevelField.getNumber());
				sinterface.setStudent(studentAgeField.getNumber(), studentNameField.getText(), gradeLevelField.getNumber());
				
				studentAgeField.setNumber(0);
				gradeLevelField.setNumber(0);
				studentNameField.setText("");
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				studentAgeField.setNumber(0);
				gradeLevelField.setNumber(0);
				studentNameField.setText("");
				messageBox(e);
			}
		}else if (buttonObj == inputEmployeeStudentButton) { // input employee and student 
			try{ // check for exceptions
				StaticInterface.checkEmployeeInput(studentAgeField.getNumber(), studentNameField.getText());
				StaticInterface.checkStudentInput(studentAgeField.getNumber(), studentNameField.getText(), gradeLevelField.getNumber());
				sinterface.setStudent(studentAgeField.getNumber(), studentNameField.getText(), gradeLevelField.getNumber());
				sinterface.setEmployee(studentAgeField.getNumber(), studentNameField.getText());
				
				studentAgeField.setNumber(0);
				gradeLevelField.setNumber(0);
				studentNameField.setText("");
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
				studentAgeField.setNumber(0);
				gradeLevelField.setNumber(0);
				studentNameField.setText("");
				messageBox(e);
			}
		}else if (buttonObj == ageButton) { // return names of people with given age
			if (sinterface.namePeople(ageField.getNumber()).equals(""))
				{messageBox("no people of this age");
				ageField.setNumber(0);}
			else
				{ageArea.setText(sinterface.namePeople(ageField.getNumber()));
				ageField.setNumber(0);}
		}else if (buttonObj == outputEmployeeButton) { // output employee info
			employeeArea.append(sinterface.employeeInfo()); 
		}else if (buttonObj == outputStudentButton) { // output student info
			studentArea.append(sinterface.studentInfo());
		}else if (buttonObj == numStudentsButton) { // output number of students
			numStudentsField.setNumber(sinterface.getNumStudents());
		}else if (buttonObj == numEmployeesButton) { // output number of employees
			numEmployeesField.setNumber(sinterface.getNumEmployees());
		}else { // reset window objects and re-instantiate objects and variables
			sinterface.reset();
			
			ageField.setNumber(0);
			studentAgeField.setNumber(0);
			employeeAgeField.setNumber(0);
			gradeLevelField.setNumber(0);
			numEmployeesField.setNumber(0);
			numStudentsField.setNumber(0);

			studentArea.setText(Format.justify('l', "name", 15)
					+ Format.justify('l', "age", 7)
					+ Format.justify('l', "grade", 7) + "\n");
			employeeArea.setText(Format.justify('l', "name", 15)
					+ Format.justify('l', "age", 9) + "\n");
			ageArea.setText("");
			studentNameField.setText("");
			employeeNameField.setText("");

			sinterface = new StaticInterface();
		}
	}

	public static void main(String[] args) {
		StaticGUI GUI = new StaticGUI(); // initialize GUI object
		GUI.setSize(1500, 800); // set window size
		GUI.setVisible(true); // make window visible
	}

}
