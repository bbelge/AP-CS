// Berke Belge, Character Program, 1/10/2018
public class CharOps {
	private String str;
	private String words[];
	private int numWords;
	private int wordsNum[];

	
	// default constructor
	public CharOps(){
		str = "";
		words = new String[30];
		numWords = 0;
		wordsNum = new int[30];
	}

	// set String
	public void setStr(String s){
		str = s.trim() + " ";
	}

	// Return total number of valid characters in String
	public int totalChars(){
		int numChar = 0;
		for (int i=0; i<str.length(); i++){
			if ((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122))
				numChar++;
		}
		return numChar;
	}

	// set words and number of words
	public void setWords(){
		numWords = 0;
		words = new String[30];
		wordsNum = new int[30];
		int begin = 0; // variable for begin index
		int numSingleWord = 0; // variable for number of times word occurs
		
		for (int i=0; i<str.length(); i++){ // loop through all chars
			if (!((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122))){
				if (((str.charAt(i-1) >= 48 && str.charAt(i-1) <= 57) || (str.charAt(i-1) >= 65 && str.charAt(i-1) <= 90) || (str.charAt(i-1) >= 97 && str.charAt(i-1) <= 122))) {
					for (int j = 0; j < numWords; j++){ // check if word has already been stored
						if (words[j].equalsIgnoreCase(str.substring(begin, i).trim())){
							numSingleWord++;
							wordsNum[j]++;
						}
					}
					if (numSingleWord == 0){ // add new word if word is not yet stored
						words[numWords] = str.substring(begin, i).trim();
						numWords++;
					}
				}
				begin = i+1;
			}
			numSingleWord = 0;
		}
		
	}

	@Override
	public String toString(){
		String str = "\n" + totalChars() + " characters\n" + numWords + " words\n";

		for (int i = 0; i < numWords; i++){
			str += words[i] + "		" + (wordsNum[i] + 1) + "\n";
		}

		return str;

	}
}

