// Berke Belge, Selection Sort Program
public class AllStudents {
	people[] persons;
	int numP;
	
	public AllStudents(){
		persons = new people[20];
		numP = 0;
	}
	
	public void addPerson(String n, int a){ // setter methods
		persons[numP] = new people(n, a);
		numP++;
	}
	
	public void replacePerson(String n, int a){ 
		int i;
		for (i = 0; i < numP; i++) {
			if (n.compareTo(persons[i].getName()) < 0) {
				for (int j = numP+1; j > i; j--) {
					swap(j, j-1);
				}
				break;
			}
		}
		persons[i] = new people(n, a);
		numP++;
	}
	
	public void sortName() { // sort methods
		for (int i = 0; i<numP; i++) {
			int minIndex=findMinimumName(i);
			if (minIndex!=i)
				swap(i,minIndex);
		}
	}
	
	private int findMinimumName(int first) {
		int minIndex=first;
		for (int i = first+1; i<numP; i++)
			if(persons[i].getName().compareTo(persons[minIndex].getName()) == -1)
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
