import java.util.*;

public class Calculator{
	private static Stack<Double> s = new Stack<Double>();
	private static Scanner sc = new Scanner(System.in);

	public void runCalculator(){
		while(true){
			calculate(sc.next());
		}
	}

	public void calculate(String str){
		try{
			Double tmp = 0.0;
			switch(str){
				case "+":
					s.push(modifiedPop()+modifiedPop());
					printOutput();
					break;
				case "-":
					tmp = modifiedPop();
					s.push(modifiedPop()-tmp);
					printOutput();
					break;
				case "/":
					tmp = modifiedPop();
					s.push(modifiedPop()/tmp);
					printOutput();
					break;
				case "*":
					s.push(modifiedPop()*modifiedPop());
					printOutput();
					break;
				default:
					s.push(Double.parseDouble(str));
					break;
			}
		}catch(ArithmeticException e){
			System.out.println("Awkward invalid operation.");
		}catch(NumberFormatException e){
			System.out.println("Not expected symbol.");
		}catch(Exception e){
			System.out.println("This should never happen.");
		}
	}

	public void printOutput(){
		System.out.println("\t\t\t"+s.peek());
	}

	public Double modifiedPop(){
		try{
			return s.pop();
		}catch(EmptyStackException e){
			return 0.0;
		}
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("\t\t\tOutput");
		c.runCalculator();
	}

}