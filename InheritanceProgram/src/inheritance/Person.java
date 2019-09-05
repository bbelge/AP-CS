// inheritance Program, Berke Belge, 11/30/2017
package inheritance;

import BreezySwing.Format;

public class Person {
	
	private static int count; // instance variable
	protected String name;
	
	public Person(){
		name = "";
	}
	
	public Person(String n){ // alternate constructor
		name = n;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public static void setCount(){ // increment count
		count++;
	}
	
	public static void resetCount(){
		count = 0;
	}
	
	// get methods
	public String getName(){
		return name;
	}
	
	public static int getCount() {
		return count;
	}
	
	public String print() { // print info
		String str = "";
		str +=  Format.justify('l', "person", 15) +
				Format.justify('l', name, 15) + "\n";
		return str;
	}

}

