import java.util.*;

public class MyStack<E>{
	Node<E>[] stack = (Node<E>[]) new Node[5];
	int size = 0;

	private static class Node<E>{
		E data;
		public Node(E data){
			this.data = data;
		}
	}
	public E pop(){
		E data = peek();
		size--;
		stack[size]=null;
		if(size==stack.length/4){
			resizeDown();
		}
		return data;
	}
	public E peek(){
		if(empty()){
			throw new EmptyStackException();
		}
		return stack[size-1].data;
	}
	public E push(E data){
		stack[size]=new Node<E>(data);
		size++;
		if(size==stack.length){
			resizeUp();
		}
		return data;
	}
	public boolean empty(){
		return size==0;
	}
	public int search(Object o){
		int x=1;
		for(int i=0;i<size;i++){
			if(stack[i].data.equals(o)){
				return x;
			}
			x++;
		}
		return -1;
	}

	public void resizeUp(){
		int x=0;
		Node<E>[] temp = (Node<E>[]) new Node[stack.length];
		//Copying contents
		for(Node n : stack){
			temp[x++]=n;
		}
		stack = (Node<E>[]) new Node[stack.length*2]; //Reset and resize stack
		x=0;
		for(Node n : temp){
			stack[x++] = n;
		}
	}
	public void resizeDown(){
		int i=0;
		Node<E>[] temp = (Node<E>[]) new Node[stack.length];
		//Copy contents
		for(Node n : stack){
			temp[i++] = n;
		}
		stack = (Node<E>[]) new Node[stack.length/2]; //Reset stack variable
		for(int x=0;x<stack.length;x++){
			stack[x]=temp[x];
		}
	}

	public static void main(String[] args) {
		MyStack<Integer> myStack= new MyStack<Integer>();
		for(int x=0;x<100;x++){
			System.out.println("Trying " + x);
			myStack.push(new Integer(x));
			System.out.println(myStack.peek());
		}

		System.out.println(myStack.search(new Integer(5)));

		for(int x=0;x<100;x++){
			System.out.println("Popped: "+ myStack.pop());
		}
	}
}