import java.util.*;

public class Calculator{
	private static Stack<Double> s = new Stack<Double>();
	private static Scanner sc = new Scanner(System.in);

	public void runCalculator(){
		while(true){
			calculate(sc.next());
		}
	}

	public Double push(Double d){
		return s.push(d);
	}
	public Double peek(){
		return s.peek();
	}
	public Double modifiedPop(){
		try{
			return s.pop();
		}catch(EmptyStackException e){
			return 0.0;
		}
	}

	public String calculate(String str){
		String returnstuff = "";
		try{
			Double tmp = 0.0;
			switch(str){
				case "+":
					s.push(modifiedPop()+modifiedPop());
					returnstuff = returnOutput();
					break;
				case "-":
					tmp = modifiedPop();
					s.push(modifiedPop()-tmp);
					returnstuff = returnOutput();
					break;
				case "/":
					tmp = modifiedPop();
					s.push(modifiedPop()/tmp);
					returnstuff = returnOutput();
					break;
				case "*":
					s.push(modifiedPop()*modifiedPop());
					returnstuff = returnOutput();
					break;
				default:
					s.push(Double.parseDouble(str));
					break;
			}
		}catch(ArithmeticException e){
			System.out.println("Awkward invalid operation.");
		}catch(NumberFormatException e){
			
		}catch(Exception e){
			System.out.println("This should never happen.");
		}
		return returnstuff;
	}

	public String returnOutput(){
		return "\t\t\t"+s.peek();
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("\t\t\tOutput");
		c.runCalculator();
	}

}