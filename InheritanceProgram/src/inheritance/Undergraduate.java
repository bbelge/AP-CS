// inheritance Program, Berke Belge, 11/30/2017
package inheritance;

import BreezySwing.Format;

public class Undergraduate extends Student{
	
	private String gradeLevel; // instance variable
	
	public Undergraduate(){ // default constructor
		super();
		gradeLevel = "";
	}
	
	public Undergraduate(String g, int d, String n){ // alternate constructor
		super(d, n);
		gradeLevel = g;
	}
	
	public boolean equals(Object o){ // check if equal to another object
		if (((Undergraduate) o).getGradeLevel() == gradeLevel)
			return true;
		else
			return false;
	}
	
	public String getGradeLevel(){
		return gradeLevel;
	}	
	
	public String print(){ // print info
		String str = "";
		str += 	Format.justify('l', "undergraduate", 15) +
				Format.justify('l', name, 15) +
				Format.justify('l', ID , 8) +
				Format.justify('l', gradeLevel, 13) + "\n";
		return str;
	}
	
}

