import java.util.*;

public class Driver2{

    public static void main(String[]args){
	System.out.println(Sorts.name());

	ArrayList<String>A1 = new ArrayList<String>();
	A1.add("1002");
	A1.add("2001");
	A1.add("3");
	System.out.println(A1.get(2).compareTo(A1.get(1)));
	System.out.println(A1.get(0).compareTo(A1.get(1)));
    }


}
