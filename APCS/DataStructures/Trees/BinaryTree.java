import java.util.ArrayList;

public class BinaryTree{
	private Node root;

	public static void main(String[] args) {
		BinaryTree fred = new BinaryTree();
	}

	public BinaryTree(){
		insert(50);
		insert(75);
		insert(25);
		insert(36);
		insert(14);
		insert(85);
		insert(65);
		insert(100);

		System.out.println(this);

		System.out.println(find(15));

	}

	public void insert(int value){
		if(root==null){
			root=new Node(value);
		}else{
			Node temp = root;
			while(true){
				if(temp.getValue()==value){
					temp.increaseCounter();
					return;
				}else if(temp.getValue()>value){
					if(temp.getRight()==null){
						temp.setRight(new Node(value));
						return;
					}else{
						temp = temp.getRight();
					}
				}else if(temp.getValue()<value){
					if(temp.getLeft()==null){
						temp.setLeft(new Node(value));
						return;
					}else{
						temp = temp.getLeft();
					}
				}
			}
		}
	}

	public boolean remove(int value){
		Node temp = find(value);
		if(temp==null){ return false; }
		Node replacement=new Node(value);
		if(temp.getRight()!=null){
			replacement = getMaxChild(Node n);
		}else if(temp.getLeft()!=null){
			replacement = getMinChild(Node n);
		}else{
			
		}
	}

	public Node getMaxChild(Node n){
		Node temp = n;
		while(temp.getRight()!=null){
			temp = temp.getRight();
		}
		return temp;
	}

	public Node getMinChild(Node n){
		Node temp = n;
		while(temp.getLeft()!=null){
			temp = temp.getLeft();
		}
		return temp;
	}
	public Node find(int value){
		Node temp = root;
		if(root==null){
			System.out.println("Hurr.");
		}else{
			while(temp!=null){
				if(temp.getValue()==value){
					break;
				}else if(temp.getValue()>value){
					temp = temp.getRight();
				}else if(temp.getValue()<value){
					temp = temp.getLeft();
				}
			}
		}
		return temp;
	}

	public String toString(){
		if(root==null){return "Empty tree.";}
		return toString(root);
	}
	public String toString(Node n){
		String toReturn = n.toString();
		String left = "";
		String right = "";
		if(n.getLeft()==null && n.getRight()==null){
			toReturn="";
		}
		if(n.getLeft()!=null){
			toReturn = n.getLeft().toString()+"<"+toReturn;
			left = "\n"+toString(n.getLeft());
		}
		if(n.getRight()!=null){
			toReturn=toReturn+">"+n.getRight().toString();
			right = "\n"+toString(n.getRight());
		}
		return toReturn+left+right;
	}


	private class Node{
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
		public int getValue(){
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
			return "" + getValue();
		}


	}






}