import java.util.*;

public class Driver{
    public static void main(String[]args){
	int[]aryA = new int[10];
	int[]aryB = new int[aryA.length];

	for(int i = 0;i<aryA.length;i++){
	    aryA[i]=(int)(Math.random()*400000000-200000000);
	    aryB[i]=aryA[i];
	}
 
	long start,end,duration,start2,end2;
	String name = Sorts.name();
	start=System.currentTimeMillis();
	Sorts.quicksort(aryA);
	end=System.currentTimeMillis();

	for(int i:aryA){
	    System.out.println(i);
	}

	start2=System.currentTimeMillis();
	Arrays.sort(aryB);
	end2=System.currentTimeMillis();

	if(Arrays.equals(aryA,aryB)){
	    System.out.println(name+" time to Quicksort  "+aryA.length+" integers: "+(end-start)/1000.0+"seconds. builtin took:"+(end2-start2)/1000.0);
	}else{
	    System.out.println("Not Sorted!");
	}
    }
}
