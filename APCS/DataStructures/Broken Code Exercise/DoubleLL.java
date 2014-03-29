public class DoubleLL<E>{
	private class Node<E> {
		E data;
		Node<E>next, prev;
		public Node(E d){
			this.data = d;
		}
		public String toString(){
			return ""+data;
		}
		public void setData(E d){ data = d;}
		public E getData(){ return data; }
		public void setNext(Node<E>n){ next = n;}
		public void setPrev(Node<E> p){ prev = p;}

	}

	private Node<E> current;

	public void insert(E d) { /*Replaces the node before current and replaces it with the new node.
								1 error- if current is the first node, then you're going to get some weird stuf.
	
							*/
		Node<E> n = new Node<E>(d);
		if (current==null) {
			current = n; //starts it off?
		}else{
			n.next = current;
			current.prev = n;
			current = n;
		}
	}

	public E getCurrent() {
		return current.getData();
	}
	public void forward() {
		if(current.getNext() != null)
			current = current.getNext();
	}
	public void back(){
		if(current.getPrev() != null)
			current = current.getPrev();
	}
}