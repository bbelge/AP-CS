package searchdelete;
//Berke Belge, Final Sort
public class Employee implements Comparable{
	public String name;
	public double salary;

	public Employee(){ // default constructor
		salary = 0;
		name = "";
	}
	
	public Employee(String n, double a){ // alternate constructor
		salary = a;
		name = n;
	}

	public void setName(String n) { // setter methods
		name = n;
	}

	public void setSalary(int x){
		salary = x;
	}

	public String getName() { // getter methods
		return name;
	}

	public double getSalary(){
		return salary;
	}
	
	@Override
	public boolean equals(Object o){
		if (this.salary == ((Employee)o).getSalary()){
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o){
		if ((((Employee) o).getSalary()) < salary)
			return -1;
		else if ((((Employee) o).getSalary()) > salary)
			return 1;
		else
			return 0;
	}

	public String toString() { // return string output
		return name + "	" + salary;
	}

}

