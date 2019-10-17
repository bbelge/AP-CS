package complex;

public class Fraction implements number{
	private int Num; //private variables
	private int Den;
	
	public Fraction(){ //constructor
		Num = 0;
		Den = 0;
	}
	
	public Fraction(int n, int d){ //constructor
		Num = n;
		Den = d;
	}
	
	public number add(number num){
		int LCM = getLCM(Den, ((Fraction) num).getDen());
		
		number num1 = new Fraction(Num * (LCM / Den) + ((Fraction) num).getNum() * (LCM / ((Fraction) num).getDen()), LCM);
		
		int GCF = ((Fraction) num1).getGCF(((Fraction) num1).getDen(), ((Fraction) num1).getNum());
		
		((Fraction) num1).setNum(((Fraction) num1).getNum() / GCF);
		
		((Fraction) num1).setDen(((Fraction) num1).getDen() / GCF);
		
		return num1;
	}
	
	public number subtract(number num){
		int LCM = getLCM(Den, ((Fraction) num).getDen());
		
		number num1 = new Fraction(Num * (LCM / Den) - ((Fraction) num).getNum() * (LCM / ((Fraction) num).getDen()), LCM);
		
		int GCF = ((Fraction) num1).getGCF(((Fraction) num1).getDen(), ((Fraction) num1).getNum());
		
		((Fraction) num1).setNum(((Fraction) num1).getNum() / GCF);
		
		((Fraction) num1).setDen(((Fraction) num1).getDen() / GCF);
		
		return num1;
	}
	
	public number multiply(number num){
		int productNum = Num * ((Fraction) num).getNum() / getGCF(Den * ((Fraction) num).getDen(), Num * ((Fraction) num).getNum());
		int productDen = Den * ((Fraction) num).getDen() / getGCF(Den * ((Fraction) num).getDen(), Num * ((Fraction) num).getNum());
		number num1 = new Fraction(productNum, productDen);
		
		return num1;
		
	}
	
	public number divide(number num){
		int productNum = Num * ((Fraction) num).getDen() / getGCF(Den * ((Fraction) num).getNum(), Num * ((Fraction) num).getDen());
		int productDen = Den * ((Fraction) num).getNum() / getGCF(Den * ((Fraction) num).getNum(), Num * ((Fraction) num).getDen());
		number num1 = new Fraction(productNum, productDen);
		
		return num1;
		
	}
	
	public int getNum(){ //getter methods
		return Num;
	}
	
	public int getDen(){
		return Den;
	}
	
	public void setNum(int n){ //getter methods
		Num = n;
	}
	
	public void setDen(int d){
		Den = d;
	}
	
	public int getLCM(int a, int b) {
        int lcm;

        // maximum number between a and b is stored in lcm
        lcm = Math.max(a, b);

        while(true)
        {
            if( lcm % a == 0 && lcm % b == 0 )
            {
                return lcm;
            }
            ++lcm;
        }
	}
	
	public int getGCF(int a, int b){ //calculates GCF of 2 numbers
		int i;
		for (i = Math.max(a, b); i >= Math.min(a, b); i--){ //loop until all numbers tested
			if (a % i == 0 && b % i == 0) // if both numbers divisible, GCF is found
				return i;
			else
				continue;
		}
		return i;
	}
	
	public boolean checkDen(int x, int y){ // Check denominators for 0
		if (x == 0 || y == 0)
			return false;
		else
			return true;
	}
	
	public String toString() {
		return Num + "/" + Den;
	}
}


