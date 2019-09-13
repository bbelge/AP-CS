// Berke Belge, Search Program
import javax.swing.*;
import BreezySwing.*;

public class Dialog extends GBDialog{
	private Search emp;
	private int index;
	
    JLabel nameLbl = addLabel ("Name", 1,1,1,1);
    JTextField nameFld = addTextField ("", 1,2,5,1);
    JLabel ageLbl = addLabel ("Age", 2,1,1,1);
    IntegerField ageFld = addIntegerField (0, 2,2,5,1);
    JButton okBtn = addButton ("OK", 4,2,1,1);
    JButton deleteBtn = addButton ("Delete", 4,3,1,1);
    JButton cancelBtn = addButton ("Cancel", 4,4,1,1);

	public Dialog(SelectionGUI parent, Search emp, int i) {
		super(parent);
		setTitle("Edit Person");
		setDlgCloseIndicator("Cancel");
		setSize(300, 200);
		
		index = i;
        this.emp = emp;
        nameFld.setText (emp.getName(index));
        ageFld.setNumber (emp.getAge(index));

    }

    public void buttonClicked(JButton buttonObj){
        if (buttonObj == okBtn){
            emp.setName (nameFld.getText(), index);
            emp.setAge (ageFld.getNumber(), index);
            setDlgCloseIndicator ("OK");
        }else if (buttonObj == deleteBtn){
        	emp.delete(index);
        	setDlgCloseIndicator ("OK");
        }

        dispose();
	}
}
