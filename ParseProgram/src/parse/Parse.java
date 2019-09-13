package parse;

public class Parse {
	private String expression;
	private double num1;
	private double num2;

	public Parse(){
		num1 = 1;
		num2 = 1;
		expression = "";
	}

	public void setExpression(String e){
		expression = e;
	}

	private double multiply(){
		return num1 * num2;
	}

	private double divide(){
		return num1 / num2;
	}

	private double add(){
		return num1 + num2;
	}

	private double subtract(){
		return num1 - num2;
	}

	private double getAnswer(){
		boolean temp = false;
		int op = 0;
		if (expression.charAt(1) == '-')
			num1*=-1;

		for (int i = 0; i < expression.length(); i++){
			if (expression.charAt(i) >= 48 && expression.charAt(i) <= 57){
				for (int j = i; j < expression.length(); j++){
					if (!(expression.charAt(j) >= 48 && expression.charAt(j) <= 57 || expression.charAt(j) == 46) && temp == false && (expression.charAt(j+1) >= 48 && expression.charAt(j+1) <= 57 || expression.charAt(j+1) == 46)){
						temp = true;
						op = expression.charAt(j);
						num1 = Double.parseDouble(expression.substring(i, j));
						i = j+1;
					}else if(j == expression.length()-1){
						num2 = Double.parseDouble(expression.substring(i, j));
						i = j;
					}
				}
			}
		}

		switch (op){
		case 42: return multiply();
		case 43: return add();
		case 45: return subtract();
		case 47: return divide();
		default: throw new IllegalArgumentException();

		}
	}

	public String toString(){
		if (expression.charAt(0) == '='){
			expression = expression.replaceAll("\\s+", "");
			expression += " ";
			return "Output\n" + getAnswer();
		}
		return expression;
	}


}

