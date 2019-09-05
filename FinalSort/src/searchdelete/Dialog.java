package searchdelete;
// Berke Belge, Final Sort
import javax.swing.*;
import BreezySwing.*;

public class Dialog extends GBDialog{
	private JTextArea searchArea = addTextArea("",1,1,2,2);
    private JButton okBtn = addButton ("OK", 4,2,1,1);

	public Dialog(SearchGUI parent, int sortType, String n, int num, double g) {
		super(parent);
		setTitle("Edit Item");
		setDlgCloseIndicator("Cancel");
		setSize(300, 200);
		
        searchArea.setEditable(false);
        
        if (sortType == 1) {
        	searchArea.setText(SortSearch.linearSearch(n, num, g));
        }else {
        	searchArea.setText(SortSearch.binarySearch(n, num, g));
        }
    }

    public void buttonClicked(JButton buttonObj){
        if (buttonObj == okBtn){
            setDlgCloseIndicator ("OK");
        }
        dispose();
	}
}

