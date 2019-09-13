// Berke Belge, Search Program
public class Search {
	people[] persons;
	int numP;
	
	public Search(){
		persons = new people[20];
		numP = 0;
	}
	
	public void delete(int in) {
		persons[in] = new people();
		for (int i = in; i < numP; i++) {
			swap(i, i+1);
		}
		persons[numP-1] = new people();
		numP--;
	}
	
	public String getName(int i) {
		return persons[i].getName();
	}
	
	public int getAge(int i) {
		return persons[i].getAge();
	}
	
	public void setName(String n, int i) {
		persons[i].setName(n);;
	}
	
	public void setAge(int a,int i) {
		persons[i].setAge(a);
	}
	
	public void addPerson(String n, int a){ // setter methods
		persons[numP] = new people(n, a);
		numP++;
	}
	
	public int findPerson(String n){ 
		int i;
		for (i = 0; i < numP; i++) {
			if (persons[i].getName().equals(n)) 
				return i;
		}
		return -1;
	}
	
	public void sortAge() { // sort methods
		for (int i = 0; i<numP; i++) {
			int minIndex=findMinimumAge(i);
			if (minIndex!=i)
				swap(i,minIndex);
		}
	}
	
	private int findMinimumAge(int first) {
		int minIndex=first;
		for (int i = first+1; i<numP; i++)
			if(persons[i].getAge() < persons[minIndex].getAge())
				minIndex = i;
		return minIndex;
	}
	
	public void sortName() {
		for (int i = 0; i<numP; i++) {
			int minIndex=findMinimumName(i);
			if (minIndex!=i)
				swap(i,minIndex);
		}
	}
	
	private int findMinimumName(int first) {
		int minIndex=first;
		for (int i = first+1; i<numP; i++)
			if(persons[i].getName().compareTo(persons[minIndex].getName()) < 1)
				minIndex = i;
		return minIndex;
	}
	
	private void swap(int x, int y) {
		people temp = persons[x];
		persons[x] = persons[y];
		persons[y] = temp;
	}
	
	public String toString() { // string output
		String str = "Name	Age\n";
		
		for (int i = 0; i < numP; i++) {
			str += persons[i].toString() + "\n";
		}
		
		return str;
	}
}

