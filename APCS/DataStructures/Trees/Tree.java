import java.util.ArrayList;

//Binary-sorted tree.

public class Tree{
	public Node root;

	public static void main(String[] args) {
		Tree fred = new Tree();
		fred.insert(2);
		fred.insert(5);
		System.out.println(fred.root);
	}

	/*
	public Node find(int x){

	}
	*/

	public void insert(int value){
		if(root==null){
			root = new Node(value);
			return;
		}
		Node current = root;
		while(true){
			if(current.getData()==value){
				current.increaseCount();
				break;
			}else if(current.getData()>value){
				if(current==null){
					current.setNextRight(new Node(value));
					break;
				}
				current = current.getRight();
			}else{
				if(current.getLeft()==null){
					current.setNextLeft(new Node(value));
					break;
				}
				current = current.getLeft();
			}
		}
	}

	public String toString(Node n){
		if(n==null){
			return "";
		}
		String toReturn = n.getLeft().toString()+"<-"+n.toString()+"->"+n.getRight().toString();
		toReturn+= "\n"+toString(n.getLeft());
		toReturn+= "\n"+toString(n.getRight());
		return toReturn;
	}

	public String toString(){
		return toString(root);
	}

	private class Node{
		int data;
		int count;
		Node nextLeft, nextRight;
		public Node(int data){
			this.data = data;
			count = 1;
		}
		public int getCount(){
			return count;
		}
		public void increaseCount(){
			count++;
		}
		public int getData(){
			return data;
		}
		public void setData(int data){
			this.data = data;
		}
		public ArrayList<Node> getChildren(){
			ArrayList<Node> nodes = new ArrayList<Node>();
			nodes.add(nextLeft);
			nodes.add(nextRight);
			return nodes;
		}
		public void setNextLeft(Node n){
			nextLeft = n;
		}
		public void setNextRight(Node n){
			nextRight = n;
		}
		public Node getRight(){
			return nextRight;
		}
		public Node getLeft(){
			return nextLeft;
		}
		public String toString(){
			return "" + getData();
		}
	}
}