import java.util.*;

public class Recursion{

	public static long fact(long n){
		if(n==0){
			return 1;
		}
		return n*fact(n-1);
	}

	public static int fib(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		for(int x=2;x<n;x++){
			list.add(list.get(x-2)+list.get(x-1));
		}
		System.out.println(list);
		return 1;
	}

	public static fibIter(int n){
		int total=1,prev=1;
		for(int x=2;x<n;x++){
			fibHelp()
		}
	}

	public static void main(String[]args){
		try{
			int x = Integer.parseInt(args[0]);	
			//System.out.println(fact(x));
			fib(x);

		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}



}