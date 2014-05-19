import java.util.Arrays;

public class RunningMedian{
	public Heap minHeap,maxHeap;

	public RunningMedian(){
		minHeap = new Heap(false);
		maxHeap = new Heap(true);
	}

	public void checkSizes(){
		if(minHeap.size() + maxHeap.size() == 0){
			throw new IllegalStateException();
		}
	}

	public int size(){
		return maxHeap.size()+minHeap.size();
	}

	public void add(int value){
		if(minHeap.size() + maxHeap.size() == 0 || value>=median()){
			minHeap.add(value);
		}else{
			maxHeap.add(value);
		}
		//First, distribute the number to either the right or left side.

		if(minHeap.size()-maxHeap.size() >= 2){
			maxHeap.add(minHeap.remove());
		}
		else if(maxHeap.size()-minHeap.size() >=2){
			minHeap.add(maxHeap.remove());
		}
		System.out.println();
	}

	public double remove(){
		checkSizes();
		if(minHeap.size() == maxHeap.size()){
			return (minHeap.remove() + maxHeap.remove())/2;
		}else if(minHeap.size()>maxHeap.size()){
			return minHeap.remove();
		}else{
			return maxHeap.remove();
		}
	}

	public double median(){
		checkSizes();
		if(minHeap.size() == maxHeap.size()){
			return ((double)minHeap.getRoot() + (double)maxHeap.getRoot())/2;
		}else if(minHeap.size()>maxHeap.size()){
			return (double)minHeap.getRoot();
		}else{
			return (double)maxHeap.getRoot();
		}
	}

	public String toString(){
		String total = "";
		int counter = 0;
		int[]combine = new int[maxHeap.size()+minHeap.size()];
		for(int x : maxHeap.getArray()){
			combine[counter++]=x;
		}
		for(int x : minHeap.getArray()){
			combine[counter++]=x;
		}
		if(combine.length==0){
			return "[]";
		}

		Arrays.sort(combine);
		for(int x : combine){
			total+= "," + x;
		}

		return "["+total.substring(1)+"]";
	}
}