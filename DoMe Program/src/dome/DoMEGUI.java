package dome;

import BreezySwing.*;
import javax.swing.*;

public class DoMEGUI extends GBFrame{
	
	private Database database = new Database(); // instance variables
	private IntegerField numTracksField;
	private DoubleField CDPlayTimeField, DVDPlayTimeField;
	private JTextField titleField, trackField, artistField, directorField, DVDCommentField,
	CDCommentField, DVDGotitField, CDGotitField;
	private JButton addCDButton, addDVDButton, listAllButton;
	private JTextArea listAllArea;
	
	public DoMEGUI(){ // default constructor
		addLabel("DoME",1,1,1,1);
		addLabel("track:",4,1,1,1);
		addLabel("artist:",4,2,1,1);
		addLabel("comment:",4,3,1,1);
		addLabel("got it?(Y/N)",4,4,1,1);
		addLabel("number of tracks:",4,5,1,1);
		addLabel("play time in minutes(0.00):",4,6,1,1);
		
		addLabel("title:",2,1,1,1);
		addLabel("director:",2,2,1,1);
		addLabel("comment:",2,3,1,1);
		addLabel("got it?(Y/N)",2,4,1,1);
		addLabel("play time in minutes(0.00):",2,5,1,1);

		titleField = addTextField("",3,1,1,1);
		directorField = addTextField("",3,2,1,1);
		DVDCommentField = addTextField("",3,3,1,1);
		DVDGotitField = addTextField("",3,4,1,1);
		trackField = addTextField("",5,1,1,1);
		artistField = addTextField("",5,2,1,1);
		CDCommentField = addTextField("",5,3,1,1);
		CDGotitField = addTextField("",5,4,1,1);
		
		numTracksField = addIntegerField(0,5,5,1,1);
		
		CDPlayTimeField = addDoubleField(0,5,6,1,1);
		DVDPlayTimeField = addDoubleField(0,3,5,1,1);

		addCDButton = addButton("add CD",5,6,1,1);
		addDVDButton = addButton("add DVD",3,6,1,1);
		listAllButton = addButton("list all:",6,1,1,1);

		listAllArea = addTextArea ("",7,1,3,1);

		listAllArea.setEditable(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == addCDButton) {
			try{
				Database.checkCD(trackField.getText(), artistField.getText(), CDCommentField.getText(), CDPlayTimeField.getNumber(), CDGotitField.getText(), numTracksField.getNumber());
				database.addCD(trackField.getText(), artistField.getText(), CDCommentField.getText(), CDPlayTimeField.getNumber(), CDGotitField.getText(), numTracksField.getNumber());
				
				trackField.setText("");
				artistField.setText("");
				CDCommentField.setText("");
				CDPlayTimeField.setNumber(0);
				CDGotitField.setText("");
				numTracksField.setNumber(0);
				
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e){
				trackField.setText("");
				artistField.setText("");
				CDCommentField.setText("");
				CDPlayTimeField.setNumber(0);
				CDGotitField.setText("");
				numTracksField.setNumber(0);
				
				messageBox(e);
				
			}
		}else if (buttonObj == addDVDButton) {
			try{
				Database.checkDVD(titleField.getText(), directorField.getText(), DVDCommentField.getText(), DVDPlayTimeField.getNumber(), DVDGotitField.getText());
				database.addDVD(titleField.getText(), directorField.getText(), DVDCommentField.getText(), DVDPlayTimeField.getNumber(), DVDGotitField.getText());
			
				titleField.setText("");
				directorField.setText("");
				DVDCommentField.setText("");
				DVDPlayTimeField.setNumber(0);
				DVDGotitField.setText("");
				
			}catch(IllegalArgumentException | ArrayIndexOutOfBoundsException e){
				titleField.setText("");
				directorField.setText("");
				DVDCommentField.setText("");
				DVDPlayTimeField.setNumber(0);
				DVDGotitField.setText("");
				
				messageBox(e);
				
			}
		}else {
			listAllArea.setText(database.listAll());
		
		} 
	}

	public static void main(String[] args) {
		DoMEGUI GUI = new DoMEGUI(); // initialize GUI object
		GUI.setSize(1500, 800); // set window size
		GUI.setVisible(true); // make window visible
	}

}

