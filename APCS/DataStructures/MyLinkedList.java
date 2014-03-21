public class MyLinkedList<T>{
	private Node<T> prehead = new Node<T>("prehead");

	private int length;

	public void add(T t, int position){

	}
	public void remove(int position){

	}
	public T get(int position){

	}
	public Node<T> getNode(int position){
		Node<T> current = prehead;
		for(int x=-1;x<position;x++){
			current = current.getNext();
		}
		return current;
	}




}