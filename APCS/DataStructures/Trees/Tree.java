import java.util.ArrayList;

public class Tree{
	private Node root;

	public static void main(String[] args) {
		
	}

	public Tree(){

	}

	public void insert(int value){
		if(root==null){
			root=new Node(value);
		}else{
			Node temp = root;
			while(true){
				if(temp.getData()==value){
					temp.increaseCounter();
					return;
				}else if(temp.getData()<value){
					if(temp.getRight()==null){
						temp.setRight(new Node(value));
						return;
					}else{
						temp = temp.getRight();
					} 	
				}else if(temp.getData()>value){
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
		if(root.getData()==value){
			if(root.getRight()!=null){
				Node temp = getAndRemoveMinChild(root);
				temp.setRight(root.getRight());
				temp.setLeft(root.getLeft());
				root = temp;
			}else if(root.getLeft()!=null){
				Node temp = getAndRemoveMaxChild(root);
				temp.setRight(root.getRight());
				temp.setLeft(root.getLeft());
				root = temp;
			}else{
				root = null;
			}
			return true;
		}else if(find(value)==null){
			System.out.println("Massive hur");
			return false;
		}
		return remove(root, value);
	}

	public boolean remove(Node n, int value){
		if(n==null){
			System.out.println("The hurr");
			return false;
		}
		else if(n.getData()==value){
			System.out.println("Hurr genji screwed up");
			return false;
		}else if(n.getData()<value){
			if(n.getRight().getData()==value){
				Node temp = n.getRight();
				n.setRight(getAndRemoveMinChild(n.getRight()));
				if(n.getRight()!=null){
					n.getRight().setRight(temp.getRight());
					n.getRight().setLeft(temp.getLeft());
				}
				return true;
			}else{
				return remove(n.getRight(),value);
			}
		}else if(n.getData()>value){
			if(n.getLeft().getData()==value){
				Node temp = n.getLeft();
				n.setLeft(getAndRemoveMaxChild(n.getLeft()));
				if(n.getLeft()!=null){	
					n.getLeft().setRight(temp.getRight());
					n.getLeft().setLeft(temp.getLeft());
				}
				return true;
			}else{
				return remove(n.getLeft(),value);
			}

		}
		System.out.println("What the hurr");
		return false;
	}

	public Node getAndRemoveMaxChild(Node n){ //get and remove. Assuming n has a right child.
		Node temp = n;
		if(n.getRight()==null){
			return null;
		}
		while(temp.getRight().getRight()!=null){
			temp = temp.getRight();
		} //Now temp should be the parent of the max.
		Node max = temp.getRight();
		temp.setRight(null);
		return max;
	}

	public Node getAndRemoveMinChild(Node n){ //Assuming n has a left child.
		Node temp = n;
		if(n.getLeft()==null){ return null; }
		while(temp.getLeft().getLeft()!=null){
			temp=temp.getLeft();
		} //Temp should now be the parent of the min.
		Node min = temp.getLeft();
		temp.setLeft(null);
		return min;
	}

	public Node find(int value){
		Node temp = root;
		if(root==null){
			System.out.println("Hurr.");
		}else{
			while(temp!=null){
				if(temp.getData()==value){
					break;
				}else if(temp.getData()<value){
					temp = temp.getRight();
				}else if(temp.getData()>value){
					temp = temp.getLeft();
				}
			}
		}
		return temp;
	}

	public String toString(){
		if(root==null){return "Empty tree.";}
		if(root.getRight()==null && root.getLeft()==null){
			return root.toString();
		}
		return toString(root);
	}
	public String toString(Node n){
		String toReturn = n.toString();
		String left = "";
		String right = "";
		if(n.getLeft()==null && n.getRight()==null){
			return "";
		}else{
			if(n.getLeft()!=null){
				toReturn = n.getLeft().toString()+"<"+toReturn;
				left = toString(n.getLeft());
				if(n.getLeft().getLeft()!=null || n.getLeft().getRight()!=null){
					left = "\n" + left;
				}
			}
			if(n.getRight()!=null){
				toReturn=toReturn+">"+n.getRight().toString();
				right = toString(n.getRight());
				if(n.getRight().getLeft()!=null || n.getRight().getRight()!=null){
					right = "\n" + right;
				}
			}
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






}