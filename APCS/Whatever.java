import java.util.*;

public class Whatever{
	Integer n;

	public static void modify(ArrayList<Integer> n){
		n.set(0,5);
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(4);
		modify(a);
		System.out.println(a);
	}

}