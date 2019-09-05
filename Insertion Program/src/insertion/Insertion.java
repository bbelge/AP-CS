// Berke Belge, 2/13/2018, Insertion Sort
package insertion;

public class Insertion {
	private int[] nums;
	private int numInts;
	
	public Insertion(){ // default constructor
		nums = new int[25];
		numInts = 0;
	}
	
	public void setNums(int n){ // add value
		nums[numInts] = n;
		numInts++;
		sortNums();
	}
	
	private void sortNums(){ // sort values in numerical order
		int temp = 0;
		
		for (int i=0; i < numInts; i++){
			for (int j=i+1; j < numInts; j++){
				if (nums[i] > nums[j]){
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
	
	public double getMedian(){ // get median of values
		if (numInts%2 == 0)
			{return (nums[numInts/2] + nums[numInts/2-1])/2.0;}
		return nums[numInts/2];
	}
	
	public double getAverage(){ // get mean of values
		int sum = 0;
		for(int i : nums)
			sum+=i;
		return (double)sum / (double)numInts;
	}
	
	public String getMode(){ // get mode of values
		String str = "";
		int start = 0;
		int num = 1;
		int temp = 1;
		int numModes = 1;
		int[] modes = new int[20];
		
		for (int i = 0; i < numInts; i++){
			for (int j = i+1; j < numInts; j++) {
				if (nums[i] == nums[j]){
					temp++;
				}
				
				if (temp > num) {
					num = temp;
					modes[0] = nums[j];
					start = j+1;
				}
				
				if (nums[j] != nums [j+1])
					temp = 1;
			}
		}
		
		if (num == 1) {
			return "None";
		}
		
		temp = 1;
		
		for (int i = start; i < numInts; i++){
			for (int j = i+1; j < numInts; j++) {
				if (nums[i] == nums[j]){
					temp++;
				}
				
				if (temp == num) {
					modes[numModes] = nums[j];
					numModes++;
				}	
				
				if (nums[j] != nums [j+1])
					temp = 1;
			}
		}
		
		for (int i = 0; i<numModes; i++) {
			str+= modes[i] + " ";
		}
		return str;
		
	}
	
	public String toString() { // create output string
		String str = "";
		
		for (int i = 0; i<numInts; i++) {
			str += nums[i] + " ";
		}
		
		str += "\nMean: " + getAverage() + "\nMedian " + getMedian() + "\nMode: " + getMode();
		
		return str;
				
	}
	
}

