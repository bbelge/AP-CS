package parse;

import TerminalIO.KeyboardReader;
public class ParseIO {

	public static void main(String[] args) {
		KeyboardReader reader = new KeyboardReader();
		Parse parse = new Parse();

		System.out.println("Enter an expression: ");
		parse.setExpression(reader.readLine());

		try{
			System.out.println(parse);
		}catch(IllegalArgumentException | StringIndexOutOfBoundsException e){
			System.out.println("Error");
		}
	}

}

