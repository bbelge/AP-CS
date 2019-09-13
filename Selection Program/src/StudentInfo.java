// Berke Belge, Selection Sort Program
public class StudentInfo {
	public String name;
	public int quizGrades[];
	public int testGrades[];
	public int numQuiz, numTest;
	public double HWAverage;
	
	public StudentInfo(){ // default constructor
		quizGrades = new int[8];
		testGrades = new int[5];
		HWAverage = 100;
		numQuiz = 0;
		numTest = 0;
		name = "";
	}
	
	public void setName(String n) { // setter methods
		name = n;
	}
	
	public void setHW(double x){
		HWAverage = x;
	}
	
	public void setQuiz(int grade){
		quizGrades[numQuiz] = grade;
		numQuiz++;
	}
	
	public void setTest(int grade){
		testGrades[numTest] = grade;
		numTest++;
	}
	
	public String getName() { // getter methods
		return name;
	}
	
	public double getFinalAverage(){
		return 0.5 * getTestAverage() + 0.3 * getQuizAverage() + 0.2 * HWAverage;
	}
	
	public double getQuizAverage(){
		int sum = 0;
		for (int i = 0; i < numQuiz; i++){
			sum += quizGrades[i];
		}
		
		return (double)sum / numQuiz;
	}
	
	public double getTestAverage(){
		int sum = 0;
		for (int i = 0; i < numTest; i++){
			sum += testGrades[i];
		}
		
		return (double)sum / numTest;
	}
	
	public String toString() { // return string output
		return name + "	" + getFinalAverage();
	}
	
}

