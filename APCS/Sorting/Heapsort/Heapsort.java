import java.util.Arrays;

public class Heapsort{

	public static void heapsort(int[]arr){

	}

	public static void heapify(int[] arr){
		for(int x=0;x<arr.length;x++){
			if(arr[x]>arr[x/2]){
				swap(arr,x,x+1)
			}
		}
	}

	public static void pushUp(int[]arr,int index){

	}
	public static void pushDown(int[]arr,int index){

	}

	public static void swap(int[]arr,int i1, int i2){
		int temp = arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;
	}

	public static int remove(int[]arr){


	}

	public static void main(String[] args) {
		
	}

}