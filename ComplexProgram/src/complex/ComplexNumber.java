//Berke Belge, 12/21/2017
package complex;

public class ComplexNumber implements number{
	private double real;
	private double complex;
	
	public ComplexNumber(){
		real = 0;
		complex = 0;
	}
	
	public ComplexNumber(double r, double c){
		real = r;
		complex = c;
	}
	
	public number add(number num){
		number num1 = new ComplexNumber(real + ((ComplexNumber) num).getReal(), complex + ((ComplexNumber) num).getComplex());
		
		return num1;
	}
	
	public number subtract(number num){
		number num1 = new ComplexNumber(real - ((ComplexNumber) num).getReal(), complex - ((ComplexNumber) num).getComplex());
		
		return num1;
	}
	
	public number multiply(number num){
		double productReal = 0;
		double productComplex = 0;
		
		productReal = real * ((ComplexNumber) num).getReal() + -1 * complex * ((ComplexNumber) num).getComplex();
		productComplex = real * ((ComplexNumber) num).getComplex() + complex * ((ComplexNumber) num).getReal();
		
		number num1 = new ComplexNumber(productReal, productComplex);
		
		return num1;
	}
	
	public number divide(number num){
		double productReal = 0;
		double productComplex = 0;
		double conjugate = 0;
		
		productReal = real * ((ComplexNumber) num).getReal() + -1 * complex * ((ComplexNumber) num).getComplex();
		productComplex = real * ((ComplexNumber) num).getComplex() + complex * ((ComplexNumber) num).getReal();
		conjugate = ((ComplexNumber) num).getReal() * ((ComplexNumber) num).getReal() - -1 * ((ComplexNumber) num).getComplex() * ((ComplexNumber) num).getComplex();
		productReal /= conjugate;
		productComplex /= conjugate;
		
		number num1 = new ComplexNumber(productReal, productComplex);
		
		return num1;
	}
	
	public double getComplex(){
		return complex;
	}
	
	public void setComplex(double c){
		complex = c;
	}
	
	public double getReal(){
		return real;
	}
	
	public void setReal(double r){
		real = r;
	}
}

