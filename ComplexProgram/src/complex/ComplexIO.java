//Berke Belge, 12/21/2017
package complex;

import java.io.IOException;
import java.util.*;

import TerminalIO.KeyboardReader;
public class ComplexIO {

	public static void main(String args[]){
		KeyboardReader reader = new KeyboardReader();
		char choose;
		int op = 0;
		int quit = 0;
		String operation = "Enter:\n1 for add\n2 for subtract\n3 for multiply\n4 for divide\n";

		System.out.println("Complex Numbers and Fractions\n");
		while (quit != -1){
			number num, num1, num2;
			double real;
			double complex;
			int Num;
			int Den;

			try{
				System.out.print("Would you like to input complex numbers or fractions?(C/F): ");
				choose = reader.readChar();

				if (choose == 'C'){
					System.out.print("Enter real part of first complex number: ");
					real = reader.readDouble();
					System.out.print("Enter imaginary part of first complex number: i * ");
					complex = reader.readDouble();

					num = new ComplexNumber(real, complex);

					System.out.print("Enter real part of second complex number: ");
					real = reader.readDouble();
					System.out.print("Enter imaginary part of second complex number: i * ");
					complex = reader.readDouble();

					num1 = new ComplexNumber(real, complex);

					System.out.print(operation);
					op = reader.readInt();

					switch (op){
					case 1: num2 = num.add(num1); break;
					case 2: num2 = num.subtract(num1); break;
					case 3: num2 = num.multiply(num1); break;
					case 4: num2 = num.divide(num1); break;
					default: throw new IllegalArgumentException();
					}

					System.out.println("Solution: " + ((ComplexNumber) num2).getReal() + " + " + ((ComplexNumber) num2).getComplex() + "i");
					
				}else if (choose == 'F'){
					System.out.print("Enter numerator of first fraction: ");
					Num = reader.readInt();
					System.out.print("Enter denominator of first fraction: ");
					Den = reader.readInt();

					num = new Fraction(Num, Den);

					System.out.print("Enter numerator of second fraction: ");
					Num = reader.readInt();
					System.out.print("Enter denominator of second fraction: ");
					Den = reader.readInt();

					num1 = new Fraction(Num, Den);

					System.out.print(operation);
					op = reader.readInt();

					switch (op){
						case 1: num2 = (Fraction)num.add(num1); break;
						case 2: num2 = (Fraction)num.subtract(num1); break;
						case 3: num2 = (Fraction)num.multiply(num1); break;
						case 4: num2 = (Fraction)num.divide(num1); break;
						default: throw new IllegalArgumentException();
					}

					System.out.println("Solution: " + ((Fraction) num2).getNum() + "/" + ((Fraction) num2).getDen());

				}else{
					System.out.println("Invalid input, please try again.");
					continue;
				}
				
				System.out.print("Enter -1 to quit, otherwise enter any other integer: ");
				quit = reader.readInt();

			}catch(IllegalArgumentException e){
				System.out.println("Invalid input, please try again.");
				continue;
			}

		} //loop

	}

}


