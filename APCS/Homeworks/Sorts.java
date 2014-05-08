import java.util.*;

public class Sorts{

	public static void main(String[] args) {
		int[]aryA = new int[100000];
		int[]aryB = new int[aryA.length];

		for(int i = 0;i<aryA.length;i++){
		    aryA[i]=(int)(Math.random()*400000000-200000000);
		    aryB[i]=aryA[i];
		}
	}

	public static String name(){
		return "Noguchi,Genji";
	}

	public static void quicksort(int[]L){
		quicksort(L,0,L.length);
	}

	public static void quicksort(int[]L,int left,int right){
		if(right-left<2){
			return;
		}
		int pivotI = partitionInPlace(L,left,right);
		quicksort(L,left,pivotI);
		quicksort(L,pivotI+1,right);
	}

	public static void printArray(int[]L){
		for(int i:L){
			System.out.println(i);
		}
	}

	public static int partitionInPlace(int[]L,int left, int right){
		int temp = 0; //Placeholder

		int pivot = left + (int)(Math.random() * (right-left+1)); //Pick random pivot index.
		int pivotNumber = L[pivot];

		//Swapping shenanigans
		temp = left;
		for(int x=left;x<right;x++){
			if(L[x]<pivotNumber){
				changePlaces(L,temp,x); //Go from the left side and move anything out of place out of place.
				temp++; //increment the placeholder.
			}
		}
		int startingPivotIndex = temp; //The first pivot number.

		for(int x=left;x<right;x++){	//Layer the numbers equal to pivotNumber on top of the ones less than it.
			if(L[x]==pivotNumber){
				changePlaces(L,temp,x);
				temp++;
			}
		}

		return startingPivotIndex;
	}

	public static void changePlaces(int[]L,int a, int b){
		int temp = L[a];
		L[a]=L[b];
		L[b]=temp;
	}

	public static int partition(int[]L, int left, int right){ //Not in place.
		int pivot = left + (int)(Math.random() * (right-left+1)); //Pick random pivot index.
		int iL=0,iR = right-left;
		int[]tmp = new int[iR+1];
		for(int x=left;x<=right;x++){			//Fill in numbers from the left and right sides.
			if(x!=pivot){				
				if(L[x]<=L[pivot]){
					tmp[iL] = L[x];
					iL++;
				}if(L[x]>L[pivot]){
					tmp[iR] = L[x];
					iR--;
				}
			}
		}
		tmp[iL] = L[pivot];
		for(int x=0;x<tmp.length;x++){	//Remap the temporary array back onto the original.
			L[x+left] = tmp[x];
		}
		return iL + left;

	}

}