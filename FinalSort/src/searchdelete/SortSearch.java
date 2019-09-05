package searchdelete;
// Berke Belge, Selection Sort Program
public class SortSearch {
	private static Comparable[] students, widgets, employees, items, itemSearch;
	private static int numS, numW, numE;

	public SortSearch(){ // constructor
		students = new Student[20];
		widgets = new Widget[20];
		employees = new Employee[20];
		numS = 0;
		numE = 0;
		numW = 0;
	}
	
	public static void reset() { // reset private variables
		students = new Student[20];
		widgets = new Widget[20];
		employees = new Employee[20];
		numS = 0;
		numE = 0;
		numW = 0;
	}

	public static void addStudent(String n, double g){ // setter methods
		checkGPA(g);
		students[numS] = new Student(n, g);
		numS++;
	}
	
	public static void checkGPA(double g) {
		if (g < 0 || g > 5.0) {
			throw new IllegalArgumentException("invalid GPA");
		}
	}
	
	public static void addEmployee(String n, double s){
		checkEmployee(s);
		employees[numE] = new Employee(n, s);
		numE++;
	}
	
	public static void checkEmployee(double s) {
		if (s < 0) {
			throw new IllegalArgumentException("invalid salary");
		}
	}

	public static void addWidget(int n, int a){ 
		checkWidget(n, a);
		widgets[numW] = new Widget(n, a);
		numW++;
	}
	
	public static void checkWidget(int n, int a) {
		if (n < 0 || a < 0) {
			throw new IllegalArgumentException("invalid product number or number sold");
		}
	}
	
	public static String linearSearch(String n, int num, double g){ // sequential search
		String str = "";
		if(!n.equals("NA")){
			for (int i = 0; i < numS; i++) {
				if(n.equals(((Student) students[i]).getName())) {
					str += ((Student) students[i]).toString() + "\n";
				}
			}
		}
		else if(num != -1){
			for (int i = 0; i < numW; i++) {
				if(((Widget) widgets[i]).getNumberSold() == num) {
					str += ((Widget) widgets[i]).toString() + "\n";
				}
			}
		}
		else if(g != -1){
			for (int i = 0; i < numE; i++) {
				if(((Employee) employees[i]).getSalary() == g) {
					str += ((Employee) employees[i]).toString() + "\n";
				}
			}
		}
		
		if (str.equals("")) {
			str = "None";
		}
		
		return str;
	}
	
	public static String binarySearch(String n, int num, double g){ // binary search
		String str = "";
		if(!n.equals("NA")){
			selectionSort(1);
	        int l = 0, r = numS-1;
	        while (l <= r)
	        {
	            int m = l + (r-l)/2;
	 
	            if (((Student) students[m]).getName().equals(n))
	            	str += ((Student) students[m]).toString() + "\n";
	            if (((Student) students[m]).getName().compareTo(n) < 0)
	                l = m + 1;
	            else
	                r = m - 1;
	        }
		}
		else if(num != -1){
			selectionSort(2);
	        int l = 0, r = numW-1;
	        while (l <= r)
	        {
	            int m = l + (r-l)/2;
	 
	            if (((Widget) widgets[m]).getNumberSold() == num)
	            	str += ((Widget) widgets[m]).toString() + "\n";
	            if (((Widget) widgets[m]).getNumberSold() < num)
	                l = m + 1;
	            else
	                r = m - 1;
	        }
		}
		else if(g != -1){
			selectionSort(3);
	        int l = 0, r = numE-1;
	        while (l <= r)
	        {
	            int m = l + (r-l)/2;
	 
	            if (((Employee) employees[m]).getSalary() == g)
	            	str += ((Employee) employees[m]).toString() + "\n";
	            if (((Employee) employees[m]).getSalary() < g)
	                l = m + 1;
	            else
	                r = m - 1;
	        }
		}
		
		if (str.equals("")) {
			str = "None";
		}
		
		return str;
	}

	@SuppressWarnings("unchecked")
	public static void insertionSort(int type){ // insertion sort
		int numP = 0;
		if(type == 1){
			items = students;
			numP = numS;
		}
		else if(type == 2){
			items = widgets;
			numP = numW;
		}
		else if(type == 3){
			items = employees;
			numP = numE;
		}
		for (int i=0; i < numP; i++){
			for (int j=i; j > 0; j--){
				if (items[j].compareTo(items[j-1]) > 0){
					swap(j, j-1);
				}
			}
		}
	}

	public static void selectionSort(int type) { // selection sort methods
		int numP = 0;
		if(type == 1){
			items = students;
			numP = numS;
		}
		else if(type == 2){
			items = widgets;
			numP = numW;
		}
		else if(type == 3){
			items = employees;
			numP = numE;
		}

		for (int i = 0; i<numP; i++) {
			int minIndex=findMinimum(i, numP);
			if (minIndex!=i)
				swap(i,minIndex);
		}
	}

	@SuppressWarnings("unchecked")
	private static int findMinimum(int first, int numP) {
		int minIndex=first;
		for (int i = first+1; i<numP; i++)
			if(items[i].compareTo(items[minIndex]) > 0)
				minIndex = i;
		return minIndex;
	}

	private static void swap(int x, int y) {
		@SuppressWarnings("rawtypes")
		Comparable temp = items[x];
		items[x] = items[y];
		items[y] = temp;
	}

	public String toString() { // string output
		String str = "Students:\nname	GPA\n";
		for (int i = 0; i<numS; i++) {
			str += students[i].toString() + "\n";
		}
		
		str += "Employees:\nname	salary\n";
		for (int i = 0; i<numE; i++) {
			str += employees[i].toString() + "\n";
		}
		
		str += "Widgets:\nnum sold	product no\n";
		for (int i = 0; i<numW; i++) {
			str += widgets[i].toString() + "\n";
		}

		return str;
	}
}

