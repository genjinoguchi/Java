import java.util.EmptyStackException;

public class StackOfHeaven<E>{
	private Pancake<E> pancakeWithButterSquare;

	public static void main(String[] args) {
		StackOfHeaven<String> myStack = new StackOfHeaven<String>();
		myStack.push("Hello");
		myStack.push("World");

		System.out.println(myStack.peek());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}

	public boolean empty(){
		if(pancakeWithButterSquare==null){
			return true;
		}return false;
	}
	public E peek(){
		if(empty()){
			throw new EmptyStackException();
		}
		return pancakeWithButterSquare.getFlavor();
	}
	public E pop(){
		E temp = peek();
		pancakeWithButterSquare = pancakeWithButterSquare.getNextPancake();
		return temp;
	}
	public E push(E flavor){
		Pancake<E> p = new Pancake<E>(flavor);
		p.setNextPancake(pancakeWithButterSquare);
		pancakeWithButterSquare = p;
		return p.getFlavor();
	}

	private class Pancake<E>{
		E flavor;
		Pancake<E> nextPancake;
		public Pancake(E flavor){
			this.flavor = flavor;
		}
		public Pancake<E> getNextPancake(){
			return nextPancake;
		}
		public E getFlavor(){
			return flavor;
		}
		public void addFlavor(E flavor){
			this.flavor = flavor;
		}
		public E setNextPancake(Pancake<E> p){
			nextPancake = p;

			return p.getFlavor();
		}
	}

}