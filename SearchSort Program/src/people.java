// Berke Belge, Search Program
public class people {
	public String name;
	public int age;

	public people(){ // default constructor
		age = 0;
		name = "";
	}
	
	public people(String n, int a){ // alternate constructor
		age = a;
		name = n;
	}

	public void setName(String n) { // setter methods
		name = n;
	}

	public void setAge(int x){
		age = x;
	}

	public String getName() { // getter methods
		return name;
	}

	public int getAge(){
		return age;
	}

	public String toString() { // return string output
		return name + "	" + age;
	}

}


