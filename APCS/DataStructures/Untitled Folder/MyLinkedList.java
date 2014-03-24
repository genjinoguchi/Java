public class MyLinkedList<T>{
	private Node<T>prehead; //The -1'st node. Used to make the code 
							//a lot more intuitive by making the first
							//no different than all of the others.
	private int length;

	public MyLinkedList(){
		prehead = new Node<T>(null);
	}

	public int length(){
		return length;
	}
	public void add(T t, int position){
		if(position>length || position<-1){
			throw new IndexOutOfBoundsException();
		}else{
			Node<T>n = new Node<T>(t);
			n.setNext(getNode(position-1).getNext());
			getNode(position-1).setNext(n);
			length++;
		}
	}
	public void add(T t){
		add(t,0);
	}
	public void remove(int position){
		if(position>=length || position<0){
			throw new IndexOutOfBoundsException();
		}else if(position == length-1){
			getNode(position-1).setNext(null);
		}else{
			getNode(position-1).setNext(getNode(position+1));
			length--;
		}
	}
	public void set(int position, T data){
		getNode(position).setData(data);
	}

	public T get(int position){
		return getNode(position).getData();
	}
	public Node<T> getNode(int position){
		if(position>=length){
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = prehead;
		for(int x=-1;x<position;x++){
			current = current.getNext();
		}
		return current;
	}
	public int find(T data){
		try{
			int currentPlace = 0;
			while(true){
				if(get(currentPlace).equals(data)){
					return currentPlace;
				}else{
					currentPlace++;
				}
			}
		}catch(IndexOutOfBoundsException e){
			return -1;
		}
	}
	public String toString(){
		try{
			Node<T>current = prehead.getNext();
			String total = "[" + current.toString();
			while(current.getNext()!=null){
				current = current.getNext();
				total+= ", ";
				total+= current.toString();
			}
			return total + "]";
		}catch(NullPointerException e){
			return "[]";
		}
	}
}