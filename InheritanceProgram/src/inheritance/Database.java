// inheritance Program, Berke Belge, 11/30/2017
package inheritance;

import java.util.InputMismatchException;

import BreezySwing.Format;

public class Database {

	private Person persons[]; // person array

	public Database(){ // default contructor
		persons = new Person[10];
	}

	public String getFullComparison(String n) { // get comparison of object to all others
		String str = "";
		for (int i = 0; i < Person.getCount(); i++) {
			str += persons[getPerson(n)].getName() + getComparison(getPerson(n), i) + persons[i].getName()+"\n";
		}
		if (str.isEmpty()){
			throw new IllegalArgumentException("No graduate or undergraduate of this name.");
		}
		return str;
	}

	private int getPerson(String n) { // get object of person of same name
		for (int i = 0; i < Person.getCount(); i++) {
			if (persons[i].getName().equals(n))
				return i;
		}
		throw new IllegalArgumentException("No person of this name.");
	}

	private String getComparison(int n, int i){ // get one comparison
		String str = "";

		try {
			if (persons[n].equals(persons[i]))
				str = " is equal to ";
			else
				str = " is not equal to ";
		}catch(ClassCastException e) {
			str = " is not the same type as ";
		}

		return str;
	}

	public void addObject(String n, int d, String g, String m) { // add a person object
		if (Person.getCount() >= 10) // catch array index exception
			throw new ArrayIndexOutOfBoundsException("You have reached the maximum number of persons");
		
		if (!n.isEmpty() && d!=0 && !g.isEmpty() && !m.isEmpty())
			throw new IllegalArgumentException("Person cannot have both grade and major.");
		else if (!n.isEmpty() && d!=0 && !g.isEmpty()) {
			if (!g.equals("Freshman") && !g.equals("Sophomore") && !g.equals("Junior") && !g.equals("Senior"))
				{throw new IllegalArgumentException("Invalid grade level.");}
			else
				{addUndergraduate(g, d, n);}
		}
		else if (!n.isEmpty() && d!=0 && !m.isEmpty()) {
			addGraduate(m, d, n);
		}else if (!n.isEmpty() && d!=0) {
			addStudent(d, n);
		}else if (!n.isEmpty()) {
			addPerson(n);
		}else{
			throw new IllegalArgumentException("Invalid input.");
		}
	}

	private void addPerson(String n){ // add a person
		persons[Person.getCount()] = new Person(n);
		Person.setCount();
	}

	private void addStudent(int d, String n){ // add a student
		persons[Person.getCount()] = new Student(d, n);
		Person.setCount();
	}


	private void addUndergraduate(String g, int d, String n){ // add an undergraduate
		persons[Person.getCount()] = new Undergraduate(g, d, n);
		Person.setCount();
	}

	private void addGraduate(String m, int d, String n){ // add a graduate
		persons[Person.getCount()] = new Graduate(m, d, n);
		Person.setCount();
	}
	
	// print methods
	public String printUndergraduates() { 
		String str =	Format.justify('l', "type:", 15) +
				Format.justify('l', "name:", 15) +
				Format.justify('l', "ID:" , 8) +
				Format.justify('l', "grade level", 13) +
				Format.justify('l', "major:", 12) + "\n";

		for (int i = 0; i < Person.getCount(); i++) {
			try {
				((Undergraduate) persons[i]).getGradeLevel();
				str += persons[i].print();
			}catch(ClassCastException e) {}
		}

		return str;
	}
	
	public String printGraduates() {
		String str =	Format.justify('l', "type:", 15) +
				Format.justify('l', "name:", 15) +
				Format.justify('l', "ID:" , 8) +
				Format.justify('l', "grade level", 13) +
				Format.justify('l', "major:", 12) + "\n";

		for (int i = 0; i < Person.getCount(); i++) {
			try {
				((Graduate) persons[i]).getMajor();
				str += persons[i].print();
			}catch(ClassCastException e) {}
		}

		return str;
	}

	public String printStudents() {
		String str =	Format.justify('l', "type:", 15) +
				Format.justify('l', "name:", 15) +
				Format.justify('l', "ID:" , 8) +
				Format.justify('l', "grade level", 13) +
				Format.justify('l', "major:", 12) + "\n";

		for (int i = 0; i < Person.getCount(); i++) {
			if (persons[i] instanceof Student || persons[i] instanceof Undergraduate || persons[i] instanceof Graduate) {
				str += persons[i].print();
			}
		}

		return str;
	}

	public String printAll() {
		String str =	Format.justify('l', "type:", 15) +
				Format.justify('l', "name:", 15) +
				Format.justify('l', "ID:" , 8) +
				Format.justify('l', "grade level", 13) +
				Format.justify('l', "major:", 12) + "\n";

		for (int i = 0; i < Person.getCount(); i++) {
			str += persons[i].print();
		}

		return str;
	}
}

