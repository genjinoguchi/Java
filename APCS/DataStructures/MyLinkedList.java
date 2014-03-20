import java.util.*;

public class MyLinkedList{
	private static Node first;
	
	public int length(){
		int length = 0;
		Node temp = first;
		while(temp.getNext()!=null){
			temp=temp.getNext();
		}
	}

	public void add(String s, int position){
		if(position>getLength()){
			throw new IndexOutOfBoundsException();
		}
		Node temp = first;
		for(int x=1;x<position;x++){
			temp = temp.getNext();
		}
		n.setNext(temp.getNext());
		temp.setNext(new Node(s));
	}
	public String get(int position){
		Node temp = first;
		for(int x=1;x<position;x++){
			temp = temp.getNext();
		}
		return temp.getData();
	}
}