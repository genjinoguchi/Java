

public class RunningMedian{
	public Heap minHeap,maxHeap;

	public RunningMedian(){
		minHeap = new Heap(false);
		maxHeap = new Heap(true);
	}

	public static void main(String[] args) {
		RunningMedian rm = new RunningMedian();
		rm.add(3);
		rm.add(4);
		rm.add(5);
		System.out.println(rm.minHeap);
		System.out.println();
		System.out.println(rm.maxHeap);

		System.out.println("Hurr");

		rm.median();

		//System.out.println(rm.median());
	}

	public void checkSizes(){
		if(minHeap.size() + maxHeap.size() == 0){
			throw new IllegalStateException();
		}
	}

	public void add(int value){
		if(minHeap.size() + maxHeap.size() == 0 || value>=median()){
			minHeap.add(value);
		}else{
			maxHeap.add(value);
		}
		if(minHeap.size()-maxHeap.size() >= 2){
			maxHeap.add(minHeap.remove());
		}
		if(maxHeap.size()-minHeap.size() <=2){
			minHeap.add(maxHeap.remove());
		}
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
			System.out.println(minHeap.getRoot());
			return (double)minHeap.getRoot();
		}else{
			return (double)maxHeap.getRoot();
		}
	}
}