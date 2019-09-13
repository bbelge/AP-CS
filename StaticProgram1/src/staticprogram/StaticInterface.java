// Static methods program, Berke Belge, 11/6/2017
package staticprogram;

import BreezySwing.Format;

public class StaticInterface {

	private Student[] student; // instance variables
	private Employee[] employee;
	
	public StaticInterface(){ // default constructor
		student = new Student[40];
		employee = new Employee[40];
	}
	
	public void reset() { // reset static variables
		Employee.resetCount();
		Student.resetCount();
	}
	
	public void setNumStudents(){ // increment student count
		Student.setCount();
	}
	
	public void setNumEmployees(){ // increment employee count
		Employee.setCount();
	}
	
	public void setStudent(int a, String n, int g) { // add new student object
		Student.setCount();
		student[Student.getCount()-1] = new Student(a, n, g);
	}
	
	public void setEmployee(int a, String n) { // add new employee object
		Employee.setCount();
		employee[Employee.getCount()-1] = new Employee(a, n);
	}
	
	public int getNumStudents(){ // get student count
		return Student.getCount();
	}
	
	public int getNumEmployees(){ // get employee count
		return Employee.getCount();
	}
	
	public String namePeople(int age1){ // make string of names of given age
		String str = "";
		
			for (int i = 0; i < Student.getCount(); i++){ // check students for given age
				if (age1 == student[i].getAge())
						str += student[i].getName() + "\n";
			}

			for (int i = 0; i < Employee.getCount(); i++){ // check employees for given age
				if (age1 == employee[i].getAge())
						str += employee[i].getName() + "\n";
			}
			
		return str;
	}
	
	public String employeeInfo() { // return all employee info in a string
		String str = "";
		for (int i = 0; i < Employee.getCount(); i++){
			str += Format.justify('l', employee[i].getName(), 15) +
					Format.justify('l', employee[i].getAge(), 9) + "\n";
		}
		
		return str;
	}
	
	public String studentInfo() { // return all student info in a string
		String str = "";
		for (int i = 0; i < Student.getCount(); i++){
			str += Format.justify('l', student[i].getName(), 15) +
					Format.justify('l', student[i].getAge(), 7) +
					Format.justify('l', student[i].getGradeLevel(), 7) + "\n";
		}
		
		return str;
	}
	
	public static void checkStudentInput(int age1, String name, int grade){ // check input
		if (age1 > 21 || age1 < 1)
			throw new IllegalArgumentException("You have entered an invalid age.");
		if (name.isEmpty())
			throw new IllegalArgumentException("You have entered an invalid name.");
		if (grade < 1 || grade > 12)
			throw new IllegalArgumentException("You have entered an invalid grade.");
		if (Student.getCount() >= 40)
			throw new ArrayIndexOutOfBoundsException("You have reached the maximum number of Students");
	}
	
	public static void checkEmployeeInput(int age, String name){ // check input
		if (age < 16)
			throw new IllegalArgumentException("You have entered an invalid age.");
		if (name.isEmpty())
			throw new IllegalArgumentException("You have entered an invalid name.");
		if (Employee.getCount() >= 40)
			throw new ArrayIndexOutOfBoundsException("You have reached the maximum number of Employees");
	}
}
