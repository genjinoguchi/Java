import java.util.*;

public class Driver{
	


	public void test1(Random r){

	}



	public static void main(String[] args) {
		/*
		Test 1 nad test 2.
		Test 1 uses add and median.
		Test 2 uses add and remove.
		limit size to 30, print the steps (the added value and the new median)
		
		*/

		Heap h = new Heap(true);
		Random rand = new Random(100);
		for(int x=0;x<30;x++){
			h.add(rand.nextInt(100));
		}
	}


}

