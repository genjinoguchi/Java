import java.util.*;

public class MyLinkedList{
	private Node head;
	
	public int length(){
		if(head!=null){
			int length = 1;
			Node temp = head;
			while(temp.getNext()!=null){
				temp=temp.getNext();
				length++;
			}
			return length;
		}else{return 0;}
	}

	public void add(String s, int position){
		Node newNode = new Node(s);
		if(position==0){
			newNode.setNext(head);
			this.head = newNode;
		}else{
			if(position>length()){
				throw new IndexOutOfBoundsException();
			}
			Node temp = head;
			for(int x=1;x<position;x++){
						temp = temp.getNext();
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
	}

	public void remove(int position){
		if(position==0){
			this.head = head.getNext();
		}else{
			Node temp = head;
			for(int x=1;x<position;x++){
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
	}

	public String get(int position){
		Node temp = head;
		for(int x=0;x<position;x++){
			temp = temp.getNext();
		}
		return temp.getData();
	}

	public void set(int position, String newString){
		Node temp = head;
		for(int x=1;x<position;x++){
			temp = temp.getNext();
		}
		temp.setData(newString);
	}

	public int find(String s){
		for(int x=0;x<length();x++){
			System.out.println(get(x));
			if(get(x).equals(s)){
				return x;
			}
		}
		return -1;
	}

	public String toString(){
		Node temp = head;
		String total = "[ " + head.getData();
		while(temp.getNext()!=null){
			temp = temp.getNext();
			total += "," + " " + temp.getData();
		}
		total += "]";
		return total;
	}
}