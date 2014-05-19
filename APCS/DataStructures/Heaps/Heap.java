import java.util.Arrays;

public class Heap{ //Heap class
	public boolean greaterThan;
	public int[] heap;

	public static void main(String[] args) {
		Heap h = new Heap(true);
	}

	public Heap(boolean greaterThan){
		this.greaterThan = greaterThan;
		heap = new int[40];
	}

	public int[] getArray(){
		int[]toReturn = new int[heap[0]];
		for(int x=1;x<=heap[0];x++){
			toReturn[x-1]=heap[x];
		}
		return toReturn;
	}
	public int size(){
		return heap[0];
	}
	public void manuallySetArray(int[] ary){
		int index = 0;
		heap = new int[ary.length];
		for(int x : ary){
			heap[index++]=x;
		}
	}

	public void resizeUp(){
		int[] temp = new int[heap.length*2];
		int index = 0;
		for(int x : heap){
			heap[index++]=x;
		}
		manuallySetArray(temp);
	}

	public void setCompareSigns(boolean bool){
		greaterThan = bool;
	}
	public int getRoot(){
		return heap[1];
	}

	public void add(int x){
		if(heap[0]==heap.length){
			resizeUp();
		}
		heap[0]++;
		heap[heap[0]]=x;
		pushUp(heap[0]);
	}

	public int remove(){
		if(heap[0]==0){
			throw new IllegalStateException();
		}
		int temp = heap[1];
		heap[1]=heap[ heap[0] ]; //Last digit
		pushDown(1);
		heap[heap[0]]=0;
		heap[0]--;
		return temp;
	}

	public void heapify(){
		for(int x=1;x<heap[0];x++){
			pushDown(x);
			pushUp(x);
		}
	}

	public void pushDown(int i){
		try{
			while(i<=heap[0] && (compareTo(2*i,i) || compareTo((2*i)+1,i))){ //Check if either of the children break rules.
				if(compareTo(2*i,2*i+1) && 2*i<=heap[0]){
					swap(i,2*i);
					i=2*i;
				}else if(compareTo(2*i+1,2*i) && (2*i)+1 <=heap[0]){
					swap(i,2*i+1);
					i=2*i+1;
				}else{
					break;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}

	public void pushUp(int i){
		while(true){
			if(i==1){
				break;
			}else{
				try{
					if(compareTo(i,i/2)){
						swap(i,i/2);
						i = i/2;
					}else{
						break;
					}
				}catch(ArrayIndexOutOfBoundsException e){
					e.printStackTrace();
				}
			}
		}

	}
	public void swap(int a, int b){
		int temp = heap[a];
		heap[a]=heap[b];
		heap[b]=temp;
	}

	public boolean compareTo(int first, int second){ //With indexes
		try{
			if(greaterThan){
				return heap[first]>=heap[second];
			}else{
				return heap[first]<=heap[second];
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		return false;
	}

	public String toString(){
		String toReturn = "";

		for(int x=1;x<=heap[0];x++){
			toReturn += ","+heap[x];
		}
		if(toReturn.length()<2){
			return toReturn;
		}
		return toReturn.substring(1);
	}

}