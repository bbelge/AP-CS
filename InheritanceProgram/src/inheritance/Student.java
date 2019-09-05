// inheritance Program, Berke Belge, 11/30/2017
package inheritance;

import BreezySwing.Format;

public class Student extends Person{

	protected int ID; // instance variable

	public Student(){ // default constructor
		super();
		ID = 0;
	}

	public Student(int d, String n){ // alternate constructor
		super(n);
		ID = d;
	}

	public int getID(){
		return ID;
	}

	public String print(){ // print info
		String str = "";
		str += Format.justify('l', "student", 15) +
				Format.justify('l', name, 15) +
				Format.justify('l', ID , 8) +"\n";
		return str;
	}

}
