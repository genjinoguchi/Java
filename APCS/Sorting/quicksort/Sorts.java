import java.util.*;

public class Sorts{

    public static void main(String[]args){
	int[]a = {5,2,3,1,0};
	quicksort(a);
	for(int i:a){
	    System.out.println(i);
	}
    }

    public static String name(){
	return "Noguchi,Genji";
    }

    public static void quicksort(int[]L){
	quicksort(L,0,L.length-1);
    }

    public static void quicksort(int[]L,int left,int right){
	if(right-left<2){
	    return;
	}
	int pivotI = partition(L,left,right);
	quicksort(L,left,pivotI-1);
	quicksort(L,pivotI+1,right);
    }

    public static int partition(int[]L, int left, int right){ //Not in place.
	int pivot = left + (int)(Math.random() * (right-left+1)); //Pick random pivot. This is a random number.
	int iL=0,iR = right-left;
	int[]tmp = new int[right-left+1];
	for(int x=left;x<=right;x++){			//Fill in numbers from the left and right sides.
	    if(x!=pivot){
		if(x<L[pivot]){
		    tmp[iL] = x;
		    iL++;
		}if(x>L[pivot]){
		    tmp[iR] = x;
		    iR--;
		}
	    }
	}
	for(int x=iL;x<=iR;x++){ //Fill in the gaps.
	    tmp[x]=L[pivot];
	}
	for(int x=0;x<tmp.length;x++){	//Remap the temporary array back onto the original.
	    L[x+left] = tmp[x];
	}
	return pivot;

    }


    /*

      public static int partition(int[]L,int left, int right){ //try to have this done in place.
      int pivot = left + (int)(Math.random() * (right-left+1)); //Pick random pivot
      System.out.println(pivot + " ");
      int temp = 0; //Placeholder
      int last = right; //Another placeholder.

      temp = L[pivot]; //Put the pivot in the back
      L[pivot] = L[right];
      L[right] = temp;
      pivot = L[right]; //pivot is now the pivot number, not the index.
      System.out.println(pivot);
      right--;
      System.out.println();

      while(left!=right){
      if(L[left] < pivot){ //Move up the left position
      left++;
      System.out.println(true);
      }else{
      System.out.println(false);
      temp = L[left];
      L[left] = L[right];
      L[right] = temp;
      right--;
      }

      for(int x=0;x<L.length;x++){
      System.out.println(L[x]);
      }
      System.out.println();

			
      }
      if(L[left+1]>pivot){	//Put pivot in the right spot
      L[last] = L[left];
      L[left] = pivot;
      return left;
      }else{
      L[last] = L[left+1];
      L[left+1] = pivot;
      return left+1;
      }
      }
    */
    /*
      public static void main(String[] args) {
      int[] L = new int[Integer.parseInt(args[0])];
      for(int x=0;x<L.length;x++){
      L[x] = (int)(Math.random()*Integer.parseInt(args[1]));
      }
      long startTime = System.currentTimeMillis();
      //partition(L,0,9);
      quicksort(L);
      long endTime = System.currentTimeMillis();
      long total = endTime - startTime;
		
      //System.out.println();
      //for(int x=0;x<L.length;x++){
      //	System.out.println(L[x]);
      //}
		
      System.out.println("Time run: " + total);
		
      }
    */

}
