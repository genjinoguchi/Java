public class Node{
	private int value;
	private int counter;
	private Node rightNode, leftNode;
	public Node(int value){
		setValue(value);
		counter = 1;
	}

	public void setValue(int value){
		this.value = value;
	}
	public int getData(){
		return value;
	}
	public int getCount(){
		return counter;
	}
	public void increaseCounter(){
		counter++;
	}
	public void setRight(Node n){
		rightNode = n;
	}
	public Node getRight(){
		return rightNode;
	}
	public void setLeft(Node n){
		leftNode = n;
	}
	public Node getLeft(){
		return leftNode;
	}
	public String toString(){
		return "" + getData();
	}


}