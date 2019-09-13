// Static methods program, Berke Belge, 11/6/2017
package staticprogram;

public class Student {

	private static int count; // instance variables
	
	private int age; 
	private int gradeLevel;
	private String name;
	
	public Student(){ // default constructor
		age = 0;
		gradeLevel = 0;
		name = "";
		count = 0;
	}
	
	public Student(int a, String n, int g){ // alternate constructor
		age = a;
		name = n;
		gradeLevel = g;
	}
	
	public static void setCount(){ // increment count
		count++;
	}
	
	public static void resetCount(){
		count = 0;
	}
	
	// get methods
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public int getGradeLevel() {
		return gradeLevel;
	}

	public static int getCount() {
		return count;
	}
	

}
