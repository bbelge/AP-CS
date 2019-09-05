// inheritance Program, Berke Belge, 11/30/2017
package inheritance;

import BreezySwing.Format;

public class Graduate extends Student{

	private String major; // instance variable
	
	public Graduate(){ // default constructor
		super();
		major = "";
	}
	
	public Graduate(String m, int d, String n){ // alternate constructor
		super(d, n);
		major = m;
	}
	
	public boolean equals(Object o){ // check if equal to another object
		if (((Graduate) o).getMajor() == major)
			return true;
		else
			return false;
	}
	
	public String getMajor(){
		return major;
	}
	
	public String print() { // print info
		String str = "";
		str += 	Format.justify('l', "graduate", 15) +
				Format.justify('l', name, 15) +
				Format.justify('l', ID , 8) +
				Format.justify('l', "", 13) +
				Format.justify('l', major, 12) + "\n";
		return str;
	}
}

