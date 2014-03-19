import java.util.*;

public class Sorts{
	
	public static void msort(ArrayList<String> L){
		L = sort(L);
		System.out.println(L);
	}

	public static ArrayList<String> sort(ArrayList<String> L){
		//Split
		if(L.size()>1){

			ArrayList<String> firstHalf = new ArrayList<String>();
			ArrayList<String> secondHalf = new ArrayList<String>();
			for(int x=0;x<L.size()/2;x++){
				firstHalf.add(L.get(x));
			}
			for(int x=L.size()/2;x<L.size();x++){
				secondHalf.add(L.get(x));
			}
			firstHalf = sort(firstHalf);
			secondHalf = sort(secondHalf);

			L = merge(firstHalf, secondHalf);
		}
		return L;
	}


	public static ArrayList<String> merge(ArrayList<String>a, ArrayList<String>b){
		ArrayList<String> c = new ArrayList<String>();
		while(a.size()>0 && b.size()>0){
			if (a.get(0).compareTo(b.get(0))<0){
				c.add(a.remove(0));
			}else{
				c.add(b.remove(0));
			}
		}
		c.addAll(a);
		c.addAll(b);
		return c;
	}


	public static String name(){
		return "Noguchi,Genji";
	}


	/*
	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("Hello");
		l.add("World");
		l.add("A");
		l.add("WEI");
		l.add("WEOI");
		l.add("WOEIN");
		l.add("WOEIFNWOEIGNOWEING");
		l.add("WOENIFEW");
		l.add("ALFIENOFNWI");
		l.add("ADFJSLDKFNLSDK");
		l.add("DEF");
		l.add("BC");

		ArrayList<String> a = new ArrayList<String>();
		a.add("AAAA");
		a.add("NNNN");
		a.add("Z");

		msort(l);

	}
	*/


}