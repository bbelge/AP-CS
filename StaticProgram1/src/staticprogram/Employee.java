// Static methods program, Berke Belge, 11/6/2017
package staticprogram;

public class Employee {

	private static int count;
	
	private int age; // instance variables
	private String name;
	
	public Employee(){ // default constructor
		age = 0;
		name = "";
	}
	
	public Employee(int a, String n){ // alternate constructor
		age = a;
		name = n;
	}
	
	public static void setCount(){ // increment count
		count++;
	}
	
	public static void resetCount(){ // reset count
		count = 0;
	}
	
	// get methods
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public static int getCount() {
		return count;
	}
}
