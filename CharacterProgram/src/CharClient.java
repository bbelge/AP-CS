// Berke Belge, Character Program, 1/10/2018
import TerminalIO.KeyboardReader;
public class CharClient {
	public static void main(String args[]){
		int quit = 0; // declare and instantiate variables
		KeyboardReader reader = new KeyboardReader();
		CharOps chars = new CharOps();
		
		while (quit!=-1){
			System.out.println("Enter a string of characters: ");
			chars.setStr(reader.readLine());
			
			chars.setWords(); // set values in chars
			
			System.out.println(chars); // print output
			
			System.out.print("\nEnter -1 to quit, otherwise enter any other integer: "); // allow user to quit
			quit = reader.readInt();
		}
	}
}

