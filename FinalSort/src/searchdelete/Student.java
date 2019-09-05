package searchdelete;
//Berke Belge, Final Sort
public class Student implements Comparable{
	public String name;
	public double GPA;

	public Student(){ // default constructor
		GPA = 0;
		name = "";
	}
	
	public Student(String n, double a){ // alternate constructor
		GPA = a;
		name = n;
	}

	public void setName(String n) { // setter methods
		name = n;
	}

	public void setGPA(int x){
		GPA = x;
	}

	public String getName() { // getter methods
		return name;
	}

	public double getGPA(){
		return GPA;
	}
	
	@Override
	public boolean equals(Object o){
		if (this.getName().equals(((Student) o).getName())){
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		for(int i=0; i < (Math.min(((Student) o).getName().length(), getName().length())); i++){
			if ((((Student) o).getName().charAt(i) < getName().charAt(i)))
				return -1;
			else if ((((Student) o).getName().charAt(i) > getName().charAt(i)))
				return 1;
		}
		
		return 0;
	}
	
	public String toString() { // return string output
		return name + "	" + GPA;
	}

}



