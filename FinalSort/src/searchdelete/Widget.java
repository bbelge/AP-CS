package searchdelete;
//Berke Belge, Final Sort
public class Widget implements Comparable{
	public int productNo;
	public int numberSold;

	public Widget(){ // default constructor
		productNo = 0;
		numberSold = 0;
	}
	
	public Widget(int n, int a){ // alternate constructor
		productNo = a;
		numberSold = n;
	}

	public void setNumberSold(int n) { // setter methods
		numberSold = n;
	}

	public void setProductNo(int x){
		productNo = x;
	}

	public int getNumberSold() { // getter methods
		return numberSold;
	}

	public int getProductNo(){
		return productNo;
	}
	
	@Override
	public boolean equals(Object o){
		if (this.numberSold == ((Widget)o).getNumberSold()){
			return true;
		}
		return false;
	}

	
	@Override
	public int compareTo(Object o){
		if ((((Widget) o).getNumberSold()) < numberSold)
			return -1;
		else if ((((Widget) o).getNumberSold()) > numberSold)
			return 1;
		else
			return 0;
	}

	public String toString() { // return string output
		return numberSold + "	" + productNo;
	}

}
